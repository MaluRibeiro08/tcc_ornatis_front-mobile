package com.example.ornatis_tcc.UI.conta_administradora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ornatis_tcc.IdentificacaoPrestadorOuConsumidor;
import com.example.ornatis_tcc.MainActivity;
import com.example.ornatis_tcc.PesquisarFiltrar;
import com.example.ornatis_tcc.UI.conta_administradora.manutencao_conta.PrestadorConfiguracaoConta;
import com.example.ornatis_tcc.R;
import com.example.ornatis_tcc.UI.conta_administradora.servico.PrestadorCadastroServico;
import com.example.ornatis_tcc.model.Servico;
import com.example.ornatis_tcc.remote.APIUtil;
import com.example.ornatis_tcc.remote.RouterInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePrestador extends AppCompatActivity {
    RouterInterface routerInterface;
    private ImageView engrenagem;
    private ImageView menu_hambuguer;
    private int id_empresa = 2;
    private ImageView imgv_add_servico;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_prestador);

        imgv_add_servico = findViewById(R.id.imgv_add_servico);
        engrenagem = findViewById(R.id.engrenagem);
        menu_hambuguer = findViewById(R.id.menu_hambuguer);

        bottomNavigationView = findViewById(R.id.bottom_navigation_cadastrado);

        bottomNavigationView.setSelectedItemId(R.id.menu_home_cadastrado);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home_cadastrado:{
                        return true;
                    }
//                    case R.id.menu_agenda:{
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                    }
                    case R.id.menu_profile_cadastrado:{
                        startActivity(new Intent(getApplicationContext(), PrestadorVizualizacaoPerfil.class));
                    }
                }

                return false;
            }
        });

        engrenagem.setOnClickListener(view -> {

            startActivity(new Intent(
                    HomePrestador.this,
                    PrestadorConfiguracaoConta.class
            ));
        });

        //clique para abrir menu
        menu_hambuguer.setOnClickListener(view -> {
            abrindoMenu();
        });

        imgv_add_servico.setOnClickListener(
            view ->
            {
                startActivity(new Intent(
                        HomePrestador.this,
                        PrestadorCadastroServico.class
                ));
            }
        );
        

        getDadosServicosEstabelecimento(id_empresa);

    }

    public void abrindoMenu(){
        menu_hambuguer.setOnClickListener(view -> {
//            if (menu_hambuguer.isClickable()){
                menu_hambuguer.setVisibility(View.VISIBLE);
//            }
        });


    }

    public ArrayList<Servico> getDadosServicosEstabelecimento (int id_empresa)
    {
        ArrayList<Servico> arr_servicos = null;
        routerInterface = APIUtil.getEmpresaInterface(); //criamos a conexAo com a API

        Call<ArrayList<Servico>> call = routerInterface.getServicos(id_empresa); //executando a chamada para a rota de servicos

        call.enqueue(new Callback<ArrayList<Servico>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Servico>> call, Response<ArrayList<Servico>> response) {
                if (response.isSuccessful())
                {
                    Log.d("SERVICOS-ONRESPONSE-SUCESS", String.valueOf(response.body()));

                    //recebe os dados da API
                    List<Servico> list = new ArrayList<Servico>();

                    list = response.body(); //o que veio no corpo da resposta  | DADOS

                    Log.d("SERVICOS-ONRESPONSE-SUCESS", String.valueOf(list.get(0).getId_especialidade()));

                    RecyclerView recyclerView = findViewById(R.id.recyclerViewServicosHome);//  RECYCLERVIEW
                    recyclerView.setAdapter(new HomePrestador.ServicoAdapter(list)); //passando os dados para a adapter

                    Log.d("servicos00", String.valueOf(list));

                }
                else
                {
                    Log.d("SERVICOS-ONRESPONSE-NAO-SUCESS", "deu bom não");

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Servico>> call, Throwable t)
            {
                Log.d("SERVICOS-ON-FAILURE", t.getMessage());
            }
        });


        return arr_servicos;
    }

    private class ServicoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> // vai "abrir" o pacote de conteúdo criado pela viewholder. Ao ser criada, a ServicoAdapter procura uma viewHoolder no seu corpo
    {
        List<Servico> servicos;

        public ServicoAdapter(List<Servico> servicos)
        {
            this.servicos = servicos; //passa a response para a variavel da classe
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) //depois de passar os dados, cria a viewHolder (ela roda o construtor da classe livroViewHolder alí em baixo)
        {//renderiza
            return new HomePrestador.ServicoAdapter.ServicoViewHolder
            (
                LayoutInflater.from
                (
                        parent.getContext() //vai fazer um inflate a partir do pai
                )
                .inflate
                (
                        R.layout.item_container_servico_listagem_home,parent, false //representa o layout que será usado, diz onde vai acontecer (no pai)
                )
            );//
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) //passa os dados para a viewHolder colocar nos lugares certos
        {
            Servico servico = servicos.get(position); //retorna um servico - pega o object de item e converte para servico
            ((HomePrestador.ServicoAdapter.ServicoViewHolder) holder).setServicoData(servico); //converte a variavel holder para um ServicoAdapter.ServicoViewHolder para que chamemos o método que passa os dados dando a elas esses dados
        }

        @Override
        public int getItemCount() // controla a quantidade de servicos passados
        {
            return servicos.size();
        }


        //a classe item recebe os tipos de item que eu tenho no app. Depois que buscamos no banco, jogamos no item pra classificar.

        class ServicoViewHolder extends RecyclerView.ViewHolder//monta a estrutura em si. Junta os dados ao fragmento de layout
        {
            //atributos da classe livroviewholder - eles quem vao receber dados lá na view holder
            private TextView tv_nome_servico, tv_valor_servico;
            private ImageView imv_foto_servico_listagem_home;
            private LinearLayout ln_foto_servico_listagem_home;
            private int id_servico;

            public ServicoViewHolder(@NonNull View itemView) //elemento gráfico - no nosso caso o itemContainerServico
            {
                super(itemView);//método construtor de viewHolder recebe o modelo de elemento gráfico que ele vai ter que construir

                tv_nome_servico = itemView.findViewById(R.id.tv_nome_servico_listagem_home);
                tv_valor_servico = itemView.findViewById(R.id.tv_preco_servico_listagem_home);
                imv_foto_servico_listagem_home = itemView.findViewById(R.id.imv_foto_servico_listagem_home);
                ln_foto_servico_listagem_home = itemView.findViewById(R.id.ln_foto_servico_listagem_home);

                itemView.setClipToOutline(true);
                ln_foto_servico_listagem_home.setClipToOutline(true);
                imv_foto_servico_listagem_home.setClipToOutline(true);

                //acao de click para editar servico e excluir servico
                itemView.setOnClickListener
                (
                        view ->
                        {
                            Log.d("SERVICO_LISTENER_CARD", "Clicou no serviço" + id_servico + " :)") ;

                            Intent intent = new Intent(HomePrestador.this, PrestadorVizualizacaoPerfil.class);
                            intent.putExtra("acao", "visualizar_servicos" );
                            startActivity(intent);
                        }
                );
            }

            //metodo que carrega os dados nos elementos de view
            public void setServicoData (Servico servico)
            {
                tv_nome_servico.setText(servico.getNome_servico());
                tv_valor_servico.setText("R$ " + String.valueOf(servico.getPreco()).replace(".", ","));
                id_servico = servico.getId_servico();
            }
        }


    }


}