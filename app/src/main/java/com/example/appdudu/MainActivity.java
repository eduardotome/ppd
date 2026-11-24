package com.example.appdudu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnProximo, btnVoltar;
    ImageView img;
    //lista das imagens
    Integer[] imagens = new Integer[]{
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho,
            R.drawable.porquinho
    };
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnProximo = findViewById(R.id.btnProximo);
        img = findViewById(R.id.imageView);
        TextView txResultado = findViewById(R.id.txResultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnProximo.setOnClickListener(v -> {
            if(pos > imagens.length) pos = 0;
            img.setImageResource(imagens[pos]);
            pos++;

            //pegar peso e altura
            EditText edPeso = findViewById(R.id.edPeso);
            float peso = Float.parseFloat(edPeso.getText().toString());

            EditText edAltura = findViewById(R.id.edAltura);
            float altura = Float.parseFloat(edAltura.getText().toString());

            //calcular o imc
            float imc = peso / (altura * altura);

            if(imc < 18.5) {
                img.setImageResource(R.drawable.abaixopeso);
            }
            if(imc >= 18.5 && imc < 25) {
                img.setImageResource(R.drawable.normal);
            }
            if(imc >= 25 && imc < 30) {
                img.setImageResource(R.drawable.obesidade1);
            }
            if(imc >= 30 && imc < 35) {
                img.setImageResource(R.drawable.obesidade2);
            }
            if(imc > 40) {
                img.setImageResource(R.drawable.obesidade3);
            }

            txResultado.setText(String.valueOf(imc));
        });

        btnVoltar.setOnClickListener(v -> {
            img.setImageResource(imagens[pos]);
            pos--;
            if(pos < 0) pos = imagens.length - 1;
        });
    }
}