package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btnCalculate, btnExit, btnClear;
        TextView lblIMC;
        EditText txtHeight, txtWeight;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate =  findViewById(R.id.btnCalculate);
        btnExit =  findViewById(R.id.btnExit);
        btnClear =  findViewById(R.id.btnClear);
        lblIMC =  findViewById(R.id.lblIMC);
        txtHeight =  findViewById(R.id.txtHeight);
        txtWeight =  findViewById(R.id.txtWeight);

        btnCalculate.setOnClickListener(view -> {
            if(txtHeight.getText().toString().matches("")){
                Toast.makeText(MainActivity.this, "Favor de ingresar la altura", Toast.LENGTH_SHORT).show();
                return;
            }

            if(txtWeight.getText().toString().matches("")){
                Toast.makeText(MainActivity.this, "Favor de ingresar el peso", Toast.LENGTH_SHORT).show();
                return;
            }

            float height = Float.parseFloat(txtHeight.getText().toString());
            float weight = Float.parseFloat(txtWeight.getText().toString());
            height = (float) Math.pow(height, 2);
            float imc = weight / height;
            String strImc = "El IMC es: " + imc;

            lblIMC.setText(strImc);
        });

        btnClear.setOnClickListener(view -> {
            txtHeight.setText("");
            txtWeight.setText("");
            lblIMC.setText("");
            txtHeight.requestFocus();
        });

        btnExit.setOnClickListener(view -> finish());
    }
}