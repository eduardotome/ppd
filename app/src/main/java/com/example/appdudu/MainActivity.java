package com.example.appdudu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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
    //lista que comeca vazia
    ArrayList<String> nomes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);
        EditText edNome = findViewById(R.id.edNome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lista = findViewById(R.id.listView);

        ArrayAdapter <String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.item_lista,R.id.textView,nomes);
        lista.setAdapter(adapter);

        //quando clicar no nome mostra ele embaixo
        lista.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),nomes.get(position),Toast.LENGTH_LONG).show();
        });

        //adicionar o nome digitado na lista
        btnAdd.setOnClickListener(v -> {
            nomes.add(edNome.getText().toString());
            edNome.setText("");
            adapter.notifyDataSetChanged();
        });
    }
}