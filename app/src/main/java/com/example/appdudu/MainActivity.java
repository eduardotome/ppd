package com.example.appdudu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //lista das imagens
    Integer[] imagens = new Integer[]{
            R.drawable.perfil,
            R.drawable.abaixopeso,
            R.drawable.normal,
            R.drawable.obesidade1,
            R.drawable.obesidade2,
            R.drawable.obesidade3
    };

    int pos = 0;

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

        ImageView img = findViewById(R.id.imageView);
        Button btnProximo = findViewById(R.id.btnProximo);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnProximo.setOnClickListener(v -> {
            pos++;
            if (pos >= imagens.length) {
                pos = 0;
            }
            img.setImageResource(imagens[pos]);
        });

        btnVoltar.setOnClickListener(v -> {
            pos--;
            if (pos < 0) {
                pos = imagens.length - 1;
            }
            img.setImageResource(imagens[pos]);
        });
    }
}