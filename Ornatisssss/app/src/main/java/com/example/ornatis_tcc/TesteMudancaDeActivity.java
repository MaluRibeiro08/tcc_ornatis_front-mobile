package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TesteMudancaDeActivity extends AppCompatActivity {

    private LinearLayout container1;
    private TextView arrow_forward_container1;

    private LinearLayout container3;
    private TextView arrow_back_container3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_mudanca_de);

        container1 = findViewById(R.id.container1);
        arrow_forward_container1 = findViewById(R.id.arrow_forward_container1);

        container3 = findViewById(R.id.container3);
        arrow_back_container3 = findViewById(R.id.arrow_back_container3);


//        arrow_forward_container1.setOnClickListener(view -> {
//            if (container1.getVisibility() == View.VISIBLE){
//                container1.getVisibility(View.GONE);
//            } else{
//                container1.setVisibility(View.VISIBLE);
//            }
//        });


    }
}