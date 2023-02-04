package com.example.calculadoradeinvestimento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RendaVariavel extends AppCompatActivity {
    private Button retornaMainActivity;
    private Button botaofundoImobiliario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renda_variavel);
        retornaMainActivity = findViewById(R.id.botaoRetornar);
        botaofundoImobiliario = findViewById(R.id.btnfundoImobiliario);

        botoes();

    }
    private void botoes(){
        retornaMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornarActivity = new Intent(RendaVariavel.this, MainActivity.class);
                startActivity(retornarActivity);
            }
        });

        botaofundoImobiliario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acessarFundoImobiliario = new Intent(RendaVariavel.this,FundoImobiliario.class);
                startActivity(acessarFundoImobiliario);
            }
        });
    }
}