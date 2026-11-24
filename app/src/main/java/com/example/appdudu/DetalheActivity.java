package com.example.appdudu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        TextView txNome = findViewById(R.id.txNome);
        TextView txIdade = findViewById(R.id.txIdade);
        TextView txCidade = findViewById(R.id.txCidade);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        txNome.setText(getIntent().getStringExtra("nome"));
        txIdade.setText("Idade: " + getIntent().getIntExtra("idade", 0));
        txCidade.setText("Cidade: " + getIntent().getStringExtra("cidade"));

        btnVoltar.setOnClickListener(v -> finish());
    }
}