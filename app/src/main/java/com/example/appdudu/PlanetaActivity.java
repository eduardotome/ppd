package com.example.appdudu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planeta);

        TextView txNome = findViewById(R.id.txNome);
        ImageView img = findViewById(R.id.imgPlaneta);
        TextView txInfo = findViewById(R.id.txInfo);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        txNome.setText(getIntent().getStringExtra("nome"));
        img.setImageResource(getIntent().getIntExtra("imagem", 0));
        txInfo.setText(getIntent().getStringExtra("info"));

        btnVoltar.setOnClickListener(v -> finish());
    }
}