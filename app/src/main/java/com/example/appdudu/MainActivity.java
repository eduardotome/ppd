package com.example.appdudu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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

        //pegar os componentes da tela
        EditText edMin, edMax;
        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);

        TextView tx = findViewById(R.id.textView);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(v -> {

            Random r = new Random();
            String smin = edMin.getText().toString();
            String smax = edMax.getText().toString();

            if(smin.trim().equals("")){
                edMin.setError("Digite um valor");
                edMin.requestFocus();
                return;
            }
            if(smax.trim().equals("")){
                edMax.setError("Digite um valor");
                edMax.requestFocus();
                return;
            }

            int min = Integer.parseInt(smin);
            int max = Integer.parseInt(smax);

            if(min > max){
                edMax.setError("O maximo tem que ser maior que o minimo");
                return;
            }

            int numero = r.nextInt(max - min) + min;
            tx.setText(Integer.toString(numero));
        });
    }
}