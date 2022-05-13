package com.example.ornatis_tcc.UI.conta_administradora.funcionario;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.model.Funcionarios;
import com.example.ornatis_tcc.model.Item;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

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




//        Call<ArrayList<Funcionarios>> call = routerInterface.getFuncionario();
////
//        call.enqueue(new Callback<ArrayList<Funcionarios>>() {
//                         @Override
//                         public void onResponse(Call<ArrayList<Funcionarios>> call, Response<ArrayList<Funcionarios>> response) {
//                             if (response.isSuccessful()){
//                                 ArrayList<Funcionarios> funcionarios = new ArrayList<>();
//
//                                 //RECEBE OS DADOS DA API
//                                 ArrayList<Funcionarios> arrayList = new ArrayList<Funcionarios>();
//                                 arrayList = response.body();
//
//                                 for (int i = 0; i < arrayList.size(); i++){
//                                     funcionarios.add(new Funcionarios());
//                                     //o que ser colocado dentro desse ultimo parenteses de Funcionarios()
//                                 }
//
//                                 RecyclerView recyclerView = findViewById(R.id.recyclerViewFuncionarios);
//                                 recyclerView.setAdapter(new FuncionarioAdapter(funcionarios)); //funcionarios -> colocar dentro desse parenteses?
//                             }
//                         }
//
//                         @Override
//                         public void onFailure(Call<ArrayList<Funcionarios>> call, Throwable t) {
//
//                         }
//                     });




             //MUDAR DE TELA AO CLICAR NO +
                adicionando_novo_funcionario.setOnClickListener(view -> {
                    startActivity(new Intent(PrestadorListagemFuncionarios.this, PrestadorCadastrarFuncionario.class));
                });


    }//fim do método onCreate



    /** ADAPTER - RECYCLERVIEW **/
//    private class FuncionarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//        ArrayList<Funcionarios> funcionarios;
//
//        public FuncionarioAdapter(ArrayList<Funcionarios> funcionarios) {
//            this.funcionarios = funcionarios;
//        }

//        @NonNull
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//            return new FuncionarioAdapter.FuncionarioViewHolder(
//                    LayoutInflater.from(
//                            parent.getContext()).inflate(
//                                R.layout.item_container_listagem_funcionario,
//                                parent,
//                                false
//                            ));
//        }

//        @Override
//        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//            /** DADOS DE FUNCIONÁRIO **/
//                if (getItemViewType(position) == 0){
//                Funcionarios funcionarios = (Funcionarios) funcionarios.get(position);
//                ((FuncionarioAdapter.FuncionarioViewHolder) holder).setFuncionarioDados(funcionarios);
//            }
//        }
//
//        @Override
//        public int getItemCount() {
//            return funcionarios.size();
//        }





        /** CLASSE DE VIEWHOLDER DA RECYCLERVIEW **/
//        class FuncionarioViewHolder extends RecyclerView.ViewHolder {
//
//            private TextView tv_nome_do_funcionario;
//            private ImageView iv_foto_perfil_funcionario;
//            private int id_funcionario;
//
//            public FuncionarioViewHolder(View itemViewFuncionario) {
//                super(itemViewFuncionario);
//
//                tv_nome_do_funcionario = findViewById(R.id.tv_nome_do_funcionario);
//
//
//                itemViewFuncionario.setOnClickListener(view -> {
//                    /**
//                     setMessage -> Título da caixa de alerta
//                     PARÂMETROS:
//                     1- Título
//
//                     setPositiveButton -> Define uma opção de ação
//                     PARÂMETROS:
//                     1- Título
//                     2- Ação a ser executada
//
//                     setNegativeButton -> Define uma opção de ação
//                     PARÂMETROS:
//                     1- Título
//                     2- Ação a ser executada
//                     **/
//                });
//
//                itemFuncionario.setOnClickListener(view -> {
//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(PrestadorListagemFuncionarios.this)
//                            .setMessage("Escolha a ação que deseja executar")
//                            .setPositiveButton("EDITAR", (dialog, witch)->{
//
//                                //1
//                                Intent intent = new Intent(PrestadorListagemFuncionarios.this, PrestadorEditarFuncionario.class);
//
//                                //3 - passando o codigo
//                                intent.putExtra("cod_funcionario", id_funcionario);
//
//                                //2
//                                startActivity(intent);
//
//                            })
//                            .setNegativeButton("EXCLUIR", (dialog, witch)->{
//
//                                routerInterface = APIUtil.getEmpresaInterface();
//
//                                Call<Funcionarios> call = routerInterface.deleteLivro(id_funcionario);
//
//                                //retornando a chamada
//                                call.enqueue(new Callback<Funcionarios>() {
//                                    @Override
//                                    public void onResponse(Call<Funcionarios> call, Response<Funcionarios> response) {
//                                        //tratar a resposta
//                                        Toast.makeText(PrestadorListagemFuncionarios.this, "FUNCIONÁRIO EXCLUÍDO COM SUCESSO!", Toast.LENGTH_SHORT).show();
//
//                                        startActivity(new Intent(PrestadorListagemFuncionarios.this, PrestadorListagemFuncionarios.class));
//
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<Funcionarios> call, Throwable t) {
//                                        //tratar um problema que não há nenhuma resposta
//                                    }
//                                });
//
//                            });
//                });
//
//
//            } //FIM DO CONSTRUTOR DA CLASSE FuncionarioViewHolder



//            public void setFuncionarioDados(ArrayList<Funcionarios> funcionario) {
//                tv_nome_do_funcionario.setText(funcionario.getNome_funcionario);
//                id_funcionario = funcionario.getId_funcionario;
//            }


//        } /** FIM DA CLASSE VIEWHOLDER **/



//    } /****** FIM DA CLASSE ADAPTER ******/



//        public FuncionarioAdapter(ArrayList<Funcionarios> funcionarios){
//            this.funcionarios = funcionarios;
//        }

//    }


}






