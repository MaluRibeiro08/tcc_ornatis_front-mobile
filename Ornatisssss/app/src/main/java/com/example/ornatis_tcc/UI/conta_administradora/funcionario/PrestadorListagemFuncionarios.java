package com.example.ornatis_tcc.UI.conta_administradora.funcionario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.model.Funcionario;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestadorListagemFuncionarios extends AppCompatActivity {

    RouterInterface routerInterface;
    private TextView adicionando_novo_funcionario;
    private ImageView iv_foto_perfil_funcionario;
    private String tv_nome_do_funcionario, tv_profissao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_listagem_funcionarios);

        adicionando_novo_funcionario = findViewById(R.id.adicionando_novo_funcionario);

        routerInterface = APIUtil.getEmpresaInterface();


        Call<ArrayList<Funcionario>> call = routerInterface.getFuncionarios(19);

        call.enqueue(new Callback<ArrayList<Funcionario>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Funcionario>> call, Response<ArrayList<Funcionario>> response) {
//                            Log.d("listagem", "teste2222");

                            if (response.isSuccessful()){
//                                 Log.d("listagem", "onResponse: chegou");
                                 ArrayList<Funcionario> funcionarios = new ArrayList<>();

                                 //RECEBE OS DADOS DA API
                                 ArrayList<Funcionario> arrayList = new ArrayList<Funcionario>();
                                 arrayList = response.body();

                                 Log.d("listagem", String.valueOf(arrayList.get(0).getNome_funcionario()));

                                 for (int i = 0; i < arrayList.size(); i++){
                                     funcionarios.add(arrayList.get(i));
                                 }

                                 RecyclerView recyclerView = findViewById(R.id.recyclerViewFuncionarios);
                                 recyclerView.setAdapter(new FuncionarioAdapter(funcionarios)); //funcionarios -> colocar dentro desse parenteses?
                             }
                         }

                         @Override
                         public void onFailure(Call<ArrayList<Funcionario>> call, Throwable t) {
                             Log.d("listagem", "onResponse: ops");
                         }
                     });




             //MUDAR DE TELA AO CLICAR NO +
                adicionando_novo_funcionario.setOnClickListener(view -> {
                    startActivity(new Intent(PrestadorListagemFuncionarios.this, PrestadorCadastrarFuncionario.class));
                });


    }//fim do método onCreate



    /** ADAPTER - RECYCLERVIEW **/
    private class FuncionarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        ArrayList<Funcionario> funcionarios;

        public FuncionarioAdapter(ArrayList<Funcionario> funcionarios) {
            this.funcionarios = funcionarios;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new FuncionarioAdapter.FuncionarioViewHolder(
                    LayoutInflater.from(
                            parent.getContext()).inflate(
                                R.layout.item_container_listagem_funcionario,
                                parent,
                                false
                            ));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            /** DADOS DE FUNCIONÁRIO **/

                Funcionario funcionario = (Funcionario) this.funcionarios.get(position);
            Log.d("listagem", funcionario.getNome_funcionario());
                ((FuncionarioAdapter.FuncionarioViewHolder) holder).setFuncionarioDados(funcionario);

        }

        @Override
        public int getItemCount() {
            return funcionarios.size();
        }


        /** CLASSE DE VIEWHOLDER DA RECYCLERVIEW **/
        class FuncionarioViewHolder extends RecyclerView.ViewHolder {

            private TextView tv_nome_do_funcionario_card;
//            private ImageView iv_foto_perfil_funcionario;
            private ImageView excluir_funcionario;
            private int id_funcionario;


            public FuncionarioViewHolder(@NonNull View itemViewFuncionario) {
                super(itemViewFuncionario);

                tv_nome_do_funcionario_card = itemViewFuncionario.findViewById(R.id.tv_nome_do_funcionario_card);
                excluir_funcionario = itemViewFuncionario.findViewById(R.id.excluir_funcionario);


                //AÇÃO DE CLIQUE NA LIXEIRA
                excluir_funcionario.setOnClickListener(view -> {

                    routerInterface = APIUtil.getEmpresaInterface();

                    Funcionario funcionario = new Funcionario();
                    funcionario.setAcao("desabilitarFuncionario");
                    funcionario.setId_funcionario(1);

                    Call<Funcionario> call = routerInterface.deleteFuncionario(funcionario);

                    call.enqueue(new Callback<Funcionario>() {
                        @Override
                        public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {
                            Toast.makeText(PrestadorListagemFuncionarios.this,
                                            "O funcionário foi excluído da sua lista",
                                            Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(PrestadorListagemFuncionarios.this, PrestadorListagemFuncionarios.class));
                        }

                        @Override
                        public void onFailure(Call<Funcionario> call, Throwable t) {
                            Log.d("exclusao", "FALHOU!");


                            Toast.makeText(PrestadorListagemFuncionarios.this,
                                    "FALHA AO EXCLUIR FUNCIONÁRIO",
                                    Toast.LENGTH_SHORT).show();

                        }
                    });
                });


            } //FIM DO CONSTRUTOR DA CLASSE FuncionarioViewHolder

//                itemFuncionario.setOnClickListener(view -> {

//                });

                public void setFuncionarioDados(Funcionario funcionario) {
                    tv_nome_do_funcionario_card.setText(funcionario.getNome_funcionario());
                    id_funcionario = funcionario.getId_funcionario();
                }

            } /** FIM DA CLASSE VIEWHOLDER **/

        } /****** FIM DA CLASSE FUNCIONÁRIO ADAPTER ******/

    }
