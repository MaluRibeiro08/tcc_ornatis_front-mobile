package com.example.ornatis_tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeSemCadastroSemLogin extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sem_cadastro_sem_login);

        Log.d("TESTE NAVEGACAO", "onNavigationItemSelected: testeeee2");

        bottomNavigationView = findViewById(R.id.bottom_navigation_sem_cadastro_teste);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.menu_home:{
                       return true;
                   }
                   case R.id.menu_pesquisar:{
                       Log.d("TESTE NAVEGACAO", "onNavigationItemSelected: testeeee");
                       startActivity(new Intent(getApplicationContext(), PesquisarFiltrar.class));
                       break;

                   }
                   case R.id.menu_perfil:{
                       startActivity(new Intent(getApplicationContext(), IdentificacaoPrestadorOuConsumidor.class));
                       break;
                   }
               }

                return false;
            }
        });
    }
}