package com.example.appdudu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] nomes = {"Ana", "Bruno", "Carla", "Daniel", "Eduarda", "Fernando"};
    int[] idades = {19, 22, 20, 25, 18, 21};
    String[] cidades = {"Florianopolis", "Joinville", "Blumenau", "Chapeco", "Itajai", "Lages"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(MainActivity.this, DetalheActivity.class);
            i.putExtra("nome", nomes[position]);
            i.putExtra("idade", idades[position]);
            i.putExtra("cidade", cidades[position]);
            startActivity(i);
        });
    }
}