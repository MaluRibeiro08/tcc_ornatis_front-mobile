package com.example.ornatis_tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PesquisarFiltrar extends AppCompatActivity {

//    ListView list;
////    ListViewAdapter adapter;
//    SearchView editsearch;
//    String[] servicoList;
//    ArrayList<ServicoList> arraylist = new ArrayList<ServicoList>();

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_filtrar);

        bottomNavigationView = findViewById(R.id.bottom_navigation_sem_cadastro);
        bottomNavigationView.setSelectedItemId(R.id.menu_pesquisar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_pesquisar:{
                        return true;
                    }
                    case R.id.menu_home:{
                        startActivity(new Intent(getApplicationContext(), HomeSemCadastroSemLogin.class));
                    }
                    case R.id.menu_perfil:{
                        startActivity(new Intent(getApplicationContext(), IdentificacaoPrestadorOuConsumidor.class));
                    }
                }

                return false;
            }
        });


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