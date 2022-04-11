package com.example.ornatis_tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Teste2 extends AppCompatActivity {

    private LinearLayout container1;
    private LinearLayout container2;
    private TextView arrow_back;
    private TextView arrow_forward;

    int divAtual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);

//        int divAtual = 1;

        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container1);
//        arrow_back - findViewById(R.id.arrow_back);
        arrow_forward = findViewById(R.id.arrow_forward);

    }


    public void clickProximaTela(){
        mostrarDiv(divAtual+1);
    }

//    public void mostrarDiv(divQueQueroIr){
//        container${divQueQueroIr}
//    }

    public void mostrarDiv()

//        arrow_forward.setOnClickListener()


}