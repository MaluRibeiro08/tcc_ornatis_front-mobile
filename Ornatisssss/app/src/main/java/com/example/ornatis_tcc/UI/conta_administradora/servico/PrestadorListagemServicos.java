package com.example.ornatis_tcc.UI.conta_administradora.servico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ornatis_tcc.R;

public class PrestadorListagemServicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestador_listagem_servicos);

//        RecyclerView recyclerViewServicos
    }

//    /** ADAPTER - RECYCLERVIEW **/
//    private class ServicoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//        ArrayList<Funcionarios> funcionario;
//
//        public FuncionarioAdapter(ArrayList<Funcionarios> funcionario) {
//            this.funcionario = funcionario;
//        }
//
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
//
//        @Override
//        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    /** DADOS DE FUNCIONÁRIO **/
//            if (getItemViewType(position) == 0){
//                Funcionarios funcionarios = (Funcionarios) funcionario.get(position).getObject();
//                ((FuncionarioAdapter.FuncionarioViewHolder) holder).setFuncionarioData(funcioanrio);
//            }
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//
//
//        class FuncionarioViewHolder extends RecyclerView.ViewHolder {
//            public FuncionarioViewHolder(View inflate) {
////                super();
//            }
//        } /** FIM DA CLASSE VIEWHOLDER **/
//
//    } /****** FIM DA CLASSE ADAPTER ******/
//
//
//
//        public FuncionarioAdapter(ArrayList<Funcionarios> funcionarios){
//            this.funcionarios = funcionarios;
//        }
//
//    }
}