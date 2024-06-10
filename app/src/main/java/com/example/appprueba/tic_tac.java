package com.example.appprueba;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class tic_tac extends AppCompatActivity {
    TextView val;

    int[][] a = {{1,0,0},{1,0,0},{1,0,0}};
    int[][] b = {{1,2,3},{1,2,3},{1,2,3}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tic_tac);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        val = findViewById(R.id.tictac);
    }

    public void Cambiar(View view){

        if (val.getText().toString().equals("x")){
            val.setText("o");
        }
        else {
            val.setText("x");
        }

        if(Arrays.deepEquals(a, b)){
            Toast.makeText(this, "a es igual a b", Toast.LENGTH_SHORT).show();
        }

    }
}