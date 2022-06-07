package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

public class PesquisarFiltrar extends AppCompatActivity {

//    ListView list;
////    ListViewAdapter adapter;
//    SearchView editsearch;
//    String[] servicoList;
//    ArrayList<ServicoList> arraylist = new ArrayList<ServicoList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_filtrar);

//        SearchView simpleSearchView = (SearchView) findViewById(R.id.simpleSearchView ); // inicia uma visualização de pesquisa
//        CharSequence query = simpleSearchView.getQuery(); // obtém a string de consulta atualmente no campo de texto

//        SearchView simpleSearchView = (SearchView) findViewById(R.id.simpleSearchView);
//        CharSequence queryHint = simpleSearchView . getQueryHint ();


//        servicoList = new String[]{
//                "Cabelos cacheados",
//                "Cabelos liso",
//                "Cabelos ondulados",
//                "Cabelos curtos",
//                "Cabelos longos"
//        };
//
//        list = (ListView) findViewById(R.id.listView);
//
//
//        for(int i = 0; i < servicoList.length; i++) {
//            ServicoList servicosListagem = new ServicoList(servicoList[i]);
//            // Binds all strings into an array
//            arraylist.add(servicosListagem);
//    }
//
//        // Pass results to ListViewAdapter Class
//        adapter = new ListViewAdapter(this, arraylist);
//
//        // Binds the Adapter to the ListView
//        list.setAdapter(adapter);
//
//        // Locate the EditText in listview_main.xml
//        editsearch = (SearchView) findViewById(R.id.search);
//        editsearch.setOnQueryTextListener(this);
    }
}