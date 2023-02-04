package com.example.calculadoradeinvestimento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Renda_Fixa extends AppCompatActivity {
    private Button retornaMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renda_fixa);

        retornaMainActivity = findViewById(R.id.botaoRetornar);

        retornaMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornarActivity = new Intent(Renda_Fixa.this, MainActivity.class);
                startActivity(retornarActivity);
            }
        });
    }
}