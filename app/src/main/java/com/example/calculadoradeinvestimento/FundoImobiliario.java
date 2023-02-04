package com.example.calculadoradeinvestimento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FundoImobiliario extends AppCompatActivity {
    private EditText txtNomedofundo;
    private EditText textSigradofundo;
    private EditText txtValorpagoemcadacota;
    private EditText txtQuantidadedecotasadquiridas;
    private EditText txtDatadeaquisicao;

    private Button btnRetornar;
    private Button btnVoutarparaatelainicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fundo_imobiliario);
        txtNomedofundo = findViewById(R.id.txtNomedoFundo);
        textSigradofundo = findViewById(R.id.txtSigradofundo);
        txtValorpagoemcadacota = findViewById(R.id.txtValorpagoemcadacota);
        txtQuantidadedecotasadquiridas = findViewById(R.id.txtQuantidadedecotascomprados);
        txtDatadeaquisicao = findViewById(R.id.txtDatadacompra);

        btnRetornar = findViewById(R.id.btnRetornar);
        btnVoutarparaatelainicial = findViewById(R.id.btnTelaPrincipal);
    }
}