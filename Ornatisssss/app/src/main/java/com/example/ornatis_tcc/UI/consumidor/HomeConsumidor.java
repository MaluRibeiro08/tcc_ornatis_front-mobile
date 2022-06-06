package com.example.ornatis_tcc.UI.consumidor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ornatis_tcc.R;

public class HomeConsumidor extends AppCompatActivity {

    TextView tv_id_consumidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_consumidor);

//        tv_id_consumidor = findViewById(R.id.tv_id_consumidor);

//        tv_id_consumidor.setText(String.valueOf(getIntent().getExtras().getInt("id_consumidor")));

    }
}