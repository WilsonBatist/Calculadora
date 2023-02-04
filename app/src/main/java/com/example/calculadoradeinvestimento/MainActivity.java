package com.example.calculadoradeinvestimento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import ApiDados.ConversorMoedas;

public class MainActivity extends AppCompatActivity {
    private TextView txtLnbusDolar;
    private TextView txtLnbusEuro;
    private TextView txtLnbIpca;
    private Button botaoRendaFixa;
    private Button botaoRendaVariavel;
    private Button botaoJurosSimples;
    private Button botaoJurosCompostos;
    private Button botaoRegradetres;
    private ConversorMoedas obterMoeda = new ConversorMoedas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        txtLnbusDolar = findViewById(R.id.lnbusDolar);
        txtLnbusEuro = findViewById(R.id.lnbbusEuro);
        botaoRendaFixa = findViewById(R.id.botaoRendaFixa);
        botaoRendaVariavel = findViewById(R.id.botaoRendaVariavel);
        botaoJurosCompostos = findViewById(R.id.botaoJurosCompostos);

        mostraValorMoedas();
        requisitaPermissoes();
        botoes();


    }
    private void botoes(){
        botaoRendaFixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rendaFixa = new Intent(MainActivity.this, Renda_Fixa.class);
                startActivity(rendaFixa);
            }
        });

        botaoRendaVariavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rendaVariavel = new Intent(MainActivity.this, RendaVariavel.class);
                startActivity(rendaVariavel);
            }
        });

        botaoJurosCompostos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jurosCompostos = new Intent(MainActivity.this , JurosCompostos.class);
                startActivity(jurosCompostos);
            }
        });
    }

    private void requisitaPermissoes(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.INTERNET},0);
    }
    private void mostraValorMoedas(){
        DecimalFormat formatar = new DecimalFormat("0.00");
        double valorEuro;
        double valorDolar;
        valorDolar = Double.parseDouble(this.obterMoeda.getMoedaDolar());
        txtLnbusDolar.setText(formatar.format(valorDolar));
        valorEuro = Double.parseDouble(this.obterMoeda.getMoedaEuro());
        txtLnbusEuro.setText(formatar.format(valorEuro));
        //valorDolar = String.format("%.2f" , Double.parseDouble(this.obterMoeda.getMoedaDolar()));
        //txtLnbusEuro.setText(valorDolar);
    }

}