package com.example.appdudu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView txLuz;
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
        txLuz = findViewById(R.id.txLuz);

        //pegar o sensor de luz do celular
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor luz = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this, luz, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    //roda toda vez que a luz muda
    @Override
    public void onSensorChanged(SensorEvent event) {
        float valor = event.values[0];
        txLuz.setText(Float.toString(valor));
    }
}
