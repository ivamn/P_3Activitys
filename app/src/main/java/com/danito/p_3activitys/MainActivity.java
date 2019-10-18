package com.danito.p_3activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int codActivity1 = 1;
    int codActivity2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.boton1);
        b1.setOnClickListener(this);
        Button b2 = findViewById(R.id.boton2);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.boton1:
                Intent i1 = new Intent(this, Activity1.class);
                i1.putExtra("activity", "Activity 1 iniciada desde la actividad principal");
                startActivityForResult(i1, codActivity1);
                break;
            case R.id.boton2:
                Intent i2 = new Intent(this, Activity2.class);
                i2.putExtra("activity", "Activity 1 iniciada desde la actividad principal");
                startActivityForResult(i2, codActivity2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (
                requestCode == codActivity1 &&
                resultCode == RESULT_OK &&
                data != null) {
            TextView t = findViewById(R.id.textview);
            t.setText("Retorno de activity 1 con mensaje " + data.getStringExtra("mensaje"));
        } else if (
                requestCode == codActivity2 &&
                resultCode == RESULT_OK &&
                data != null) {
            TextView t = findViewById(R.id.textview);
            t.setText("Retorno de activity 2 con mensaje " + data.getStringExtra("mensaje"));
        }
    }
}
