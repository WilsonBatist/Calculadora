package com.example.calculadoradeinvestimento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class JurosCompostos extends AppCompatActivity {
    private Button btnvoutar, btncalcular, btnLimpar;

    private EditText aporteInicial, aporteMensal, taxadeJuros, tempodeAplicacao;

    private TextView montante, jurosTxt, totalInvestidoTxt;

    private Spinner spinnerTaxadeJuros, spinnerTempoAplicacao;

    private double juros;
    private int tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juros_compostos);
        aporteInicial = findViewById(R.id.editTextValorInicial);
        aporteMensal = findViewById(R.id.editTextAporteMensal);
        taxadeJuros = findViewById(R.id.editTextJuros);
        tempodeAplicacao = findViewById(R.id.editTextTempo);
        btncalcular = findViewById(R.id.btnCalcular);
        btnvoutar = findViewById(R.id.btnRetornar);
        btnLimpar = findViewById(R.id.btnLimpar);
        montante = findViewById(R.id.txtMontante);
        jurosTxt = findViewById(R.id.txtJuros);
        totalInvestidoTxt = findViewById(R.id.txtTotalInvestido);
        spinnerTaxadeJuros = (Spinner) findViewById(R.id.spinnerJuros);
        spinnerTempoAplicacao = (Spinner) findViewById(R.id.spinnerTempo);

        //spinnerExec();
        botoes();
    }

    private void spinnerExec() {
        /*
        ArrayAdapter<CharSequence> adapterJuro = ArrayAdapter.createFromResource(this,
                R.array.taxaAplicacao, android.R.layout.simple_spinner_dropdown_item);
        adapterJuro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTaxadeJuros.setAdapter(adapterJuro);

        ArrayAdapter<CharSequence> adapterTempo = ArrayAdapter.createFromResource(this,
                R.array.tempoAplicacao, android.R.layout.simple_spinner_dropdown_item);
        adapterTempo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTempoAplicacao.setAdapter(adapterTempo);
         */

    }

    private void botoes() {
        btnvoutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornar = new Intent(JurosCompostos.this, MainActivity.class);
                startActivity(retornar);
            }
        });
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logicaJurosCompostos();
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aporteInicial.setText("");
                aporteInicial.setHint("" + "0.00");
                aporteMensal.setText("");
                aporteMensal.setHint("" + "0,00");
                taxadeJuros.setText("");
                taxadeJuros.setHint("" + "%");
                tempodeAplicacao.setText("");
                tempodeAplicacao.setHint("" + 0);
            }
        });
        //AlertDialog.Builder cxMensagem = new AlertDialog.Builder(null);
        //cxMensagem.setMessage("Parametros invalidos").show();

    }

    private void logicaJurosCompostos() {
        try {
            // Verificação dos Spinners
            //0 = anos
            //1 = mes
            int ano = 12;
            if (spinnerTaxadeJuros.getSelectedItemPosition() == 0 && spinnerTempoAplicacao.getSelectedItemPosition() == 0) {
                juros = (Double.parseDouble(taxadeJuros.getText().toString())/100);
                tempo = (Integer.parseInt(tempodeAplicacao.getText().toString()));

            } else if (spinnerTaxadeJuros.getSelectedItemPosition() == 0 && spinnerTempoAplicacao.getSelectedItemPosition() == 1) {
                juros = ((Double.parseDouble(taxadeJuros.getText().toString())/100)/12);
                tempo = (Integer.parseInt(tempodeAplicacao.getText().toString()));
            } else if (spinnerTaxadeJuros.getSelectedItemPosition() == 1 && spinnerTempoAplicacao.getSelectedItemPosition() == 0) {
                juros = ((Double.parseDouble(taxadeJuros.getText().toString()) /100));
                tempo = (Integer.parseInt(tempodeAplicacao.getText().toString()) * ano);
            } else if (spinnerTaxadeJuros.getSelectedItemPosition() == 1 && spinnerTempoAplicacao.getSelectedItemPosition() == 1) {
                juros = (Double.parseDouble(taxadeJuros.getText().toString())/100);
                tempo = (Integer.parseInt(tempodeAplicacao.getText().toString()));
            }

                    /*
                     M = C * (1 + J)^t
                     */

            double AporteMensalcomJuros = 0;
            int contador = spinnerTempoAplicacao.getSelectedItemPosition() == 0 ? ano * Integer.parseInt(tempodeAplicacao.getText().toString()) : Integer.parseInt(tempodeAplicacao.getText().toString());
            double AporteUnitario = spinnerTaxadeJuros.getSelectedItemPosition() == 0 ? Double.parseDouble(aporteInicial.getText().toString()) * Math.pow(1 + (juros / 12), contador): Double.parseDouble(aporteInicial.getText().toString()) * Math.pow(1 + juros, contador);
            System.out.println("Contador = " + contador);
            System.out.println("Aporte unitario = " + AporteUnitario); int conta = 0;
            for (int contar = contador - 2; contar >= 0; contar--) {
                conta++;
                AporteMensalcomJuros += Double.parseDouble(aporteMensal.getText().toString()) * Math.pow(1 + juros, contar);
            }

            System.out.println("Juros = " + juros);

            System.out.println("Aporte mensal = " + AporteMensalcomJuros);

            System.out.println("O for correu = " + conta);

            if (!(TextUtils.isEmpty(aporteInicial.getText()))) {
                if (!(TextUtils.isEmpty(aporteMensal.getText()))) {
                    montante.setText("" + new DecimalFormat("##.##").format(AporteUnitario + AporteMensalcomJuros));
                    totalInvestidoTxt.setText("" + new DecimalFormat("##.##").format(Double.parseDouble(aporteInicial.getText().toString()) + (Double.parseDouble(aporteMensal.getText().toString()) * contador)));
                    jurosTxt.setText("" + new DecimalFormat("##.##").format((AporteUnitario + AporteMensalcomJuros) - (Double.parseDouble(aporteInicial.getText().toString()) + (Double.parseDouble(aporteMensal.getText().toString()) * contador))));
                }
            } else if (!(TextUtils.isEmpty(aporteInicial.getText()))) {
                if (TextUtils.isEmpty(aporteMensal.getText())) {
                    montante.setText("" + new DecimalFormat("##.##").format(AporteUnitario));
                    totalInvestidoTxt.setText("" + new DecimalFormat("##.##").format(Double.parseDouble(aporteInicial.getText().toString())));
                    jurosTxt.setText("" + new DecimalFormat("##.##").format(AporteUnitario - (Double.parseDouble(aporteInicial.getText().toString()))));
                }
            } else if (TextUtils.isEmpty(aporteInicial.getText())) {
                if (!(TextUtils.isEmpty(aporteMensal.getText()))) {
                    montante.setText("" + new DecimalFormat("##.##").format(AporteMensalcomJuros));
                    totalInvestidoTxt.setText("" + new DecimalFormat("##.##").format(Double.parseDouble(aporteMensal.getText().toString()) * contador));
                    jurosTxt.setText("" + new DecimalFormat("##.##").format(AporteMensalcomJuros - (Double.parseDouble(aporteMensal.getText().toString()) * contador)));
                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Campos obrigatorios em branco ", Toast.LENGTH_SHORT).show();
        }
    }
}