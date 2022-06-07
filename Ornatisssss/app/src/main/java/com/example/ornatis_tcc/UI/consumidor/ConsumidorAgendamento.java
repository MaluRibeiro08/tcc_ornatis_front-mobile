package com.example.ornatis_tcc.UI.consumidor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ornatis_tcc.R;

public class ConsumidorAgendamento extends AppCompatActivity {

    private ImageView proxima_div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumidor_agendamento);

        proxima_div = findViewById(R.id.proxima_div);
    }
}