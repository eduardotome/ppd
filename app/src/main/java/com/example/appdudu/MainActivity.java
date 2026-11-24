package com.example.appdudu;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase banco;

    EditText edTitulo;
    Button btnSalvar;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //abre o banco ou cria se nao existir
        banco = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, conteudo VARCHAR)");

        edTitulo = findViewById(R.id.edTitulo);
        btnSalvar = findViewById(R.id.btnSalvar);
        lista = findViewById(R.id.lista);

        btnSalvar.setOnClickListener(view -> {
            String titulo = edTitulo.getText().toString();
            ContentValues valores = new ContentValues();
            valores.put("titulo", titulo);
            int id = (int) banco.insert("notas", null, valores);
            if(id > 0){
                Toast.makeText(getApplicationContext(),
                        "Nota salva",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Erro ao salvar",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}