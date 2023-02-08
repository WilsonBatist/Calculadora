package com.example.calculadoradeinvestimento.conexaoDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoBd extends SQLiteOpenHelper {
    //Nome do banco e versão
    private static final String nome = "CALCULADORA";
    private static final int VERSAO = 1;

    //construtor da classe gerado automaticamente
    public ConexaoBd(Context context,String name, int version,SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS fundoImobiliario (" +
                "id integer primary key AUTOINCREMENT," +
                "nome varchar(50)," +
                "sigra vacahr (7)," +
                "valorPago double(3,2)," +
                "quantidadeCota integer," +
                "dataCompra varchar(11) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
