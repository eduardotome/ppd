package com.example.appdudu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edTitulo, edTexto;
    Button btnSalvar;
    ListView lista;

    BancoHelper banco;
    NotaAdapter adapter;
    ArrayList<Nota> notas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edTitulo = findViewById(R.id.edTitulo);
        edTexto = findViewById(R.id.edTexto);
        btnSalvar = findViewById(R.id.btnSalvar);
        lista = findViewById(R.id.listView);

        banco = new BancoHelper(this);

        adapter = new NotaAdapter(this, notas);
        lista.setAdapter(adapter);

        carregar();

        btnSalvar.setOnClickListener(v -> {
            String titulo = edTitulo.getText().toString();
            String texto = edTexto.getText().toString();

            if (titulo.equals("") && texto.equals("")) {
                Toast.makeText(MainActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (titulo.equals("")) {
                titulo = "Sem titulo";
            }

            long id = banco.inserir(new Nota(titulo, texto));

            if (id != -1) {
                Toast.makeText(MainActivity.this, "Nota salva!", Toast.LENGTH_SHORT).show();
                edTitulo.setText("");
                edTexto.setText("");
                carregar();
            } else {
                Toast.makeText(MainActivity.this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
            }
        });

        //quando clicar na nota mostra ela
        lista.setOnItemClickListener((parent, view, position, id) -> {
            Nota n = notas.get(position);
            Toast.makeText(getApplicationContext(), n.getTitulo() + "\n" + n.getTexto(), Toast.LENGTH_LONG).show();
        });
    }

    //busca as notas no banco e atualiza a lista
    void carregar() {
        notas.clear();
        notas.addAll(banco.listar());
        adapter.notifyDataSetChanged();
    }
}