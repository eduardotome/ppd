package com.example.appdudu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BancoHelper extends SQLiteOpenHelper {

    public BancoHelper(Context context) {
        super(context, "notas.db", null, 1);
    }

    //cria a tabela quando o banco eh criado
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, texto TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notas");
        onCreate(db);
    }

    //salvar uma nota no banco
    public long inserir(Nota nota) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("titulo", nota.getTitulo());
        valores.put("texto", nota.getTexto());
        long id = db.insert("notas", null, valores);
        db.close();
        return id;
    }

    //pegar todas as notas do banco
    public ArrayList<Nota> listar() {
        ArrayList<Nota> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM notas", null);

        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String titulo = c.getString(1);
                String texto = c.getString(2);
                lista.add(new Nota(id, titulo, texto));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return lista;
    }
}