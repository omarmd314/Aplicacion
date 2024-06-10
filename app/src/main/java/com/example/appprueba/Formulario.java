package com.example.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Formulario extends AppCompatActivity {

    Spinner spinner;
    TextView user;

    TextView psswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        user = findViewById(R.id.txtUser);
        psswd = findViewById(R.id.txtPassw);
        spinner = (Spinner) findViewById(R.id.spCursos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.cursos_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    public void Volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        String curso = spinner.getSelectedItem().toString();

        i.putExtra("curso", curso);
        startActivity(i);
        finish();
    }

    public void Mostrar(View view){
        String str = spinner.getSelectedItem().toString();
        Toast.makeText(this, str , Toast.LENGTH_SHORT).show();
    }
}