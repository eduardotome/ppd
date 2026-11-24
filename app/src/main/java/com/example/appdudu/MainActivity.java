package com.example.appdudu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] nomes = {"Sol", "Mercurio", "Venus", "Terra", "Marte", "Jupiter", "Saturno", "Urano", "Netuno"};

    int[] imagens = {R.drawable.sun, R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars,
            R.drawable.jupter, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune};

    String[] infos = {
            "Estrela que fica no centro do Sistema Solar",
            "Planeta mais perto do Sol e o menor do Sistema Solar",
            "Planeta mais quente do Sistema Solar",
            "Unico planeta conhecido com vida",
            "Conhecido como planeta vermelho",
            "Maior planeta do Sistema Solar",
            "Famoso pelos seus aneis",
            "Gira praticamente deitado",
            "Planeta mais longe do Sol"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_planeta, R.id.txNome, nomes) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ImageView img = v.findViewById(R.id.imgPlaneta);
                img.setImageResource(imagens[position]);
                return v;
            }
        };
        lista.setAdapter(adapter);

        lista.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(MainActivity.this, PlanetaActivity.class);
            i.putExtra("nome", nomes[position]);
            i.putExtra("imagem", imagens[position]);
            i.putExtra("info", infos[position]);
            startActivity(i);
        });
    }
}