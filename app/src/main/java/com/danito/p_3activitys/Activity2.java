package com.danito.p_3activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.danito.p_3activitys.R;

public class Activity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        TextView t = findViewById(R.id.textview);

        Intent datosRecibidos = getIntent();
        t.setText(datosRecibidos.getStringExtra("activity"));

        Toast.makeText(getApplicationContext(),
                datosRecibidos.getStringExtra("activity") + "<- Mensaje desde la activity principal",
                Toast.LENGTH_LONG).show();

        Intent datosEnviar = new Intent();
        datosEnviar.putExtra("mensaje", "Finalizada activity 2");
        setResult(RESULT_OK, datosEnviar);
    }
}
