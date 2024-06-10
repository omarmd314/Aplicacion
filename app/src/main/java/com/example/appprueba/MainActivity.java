package com.example.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView usuario;
    TextView psswd;

    String curso;

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
        usuario = findViewById(R.id.txtUsuario);
        psswd = findViewById(R.id.txtPsswd);

        curso = getIntent().getStringExtra("curso");
    }

    public void Mostrar(View view){

        Intent i = new Intent(this, Registro.class);
        if(curso == null){
            Toast.makeText(this, "No hay un curso registrado!!!", Toast.LENGTH_SHORT).show();

        }
        else if(usuario.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su nombre de usuario!!!", Toast.LENGTH_SHORT).show();
        } else if (psswd.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese su contraseña!!!", Toast.LENGTH_SHORT).show();
        } else if(usuario.getText().toString().equals("omar") && psswd.getText().toString().equals("1996")){
            i.putExtra("nombre",usuario.getText().toString());
            i.putExtra("curso", curso);
            startActivity(i);
            finish();
        } else {

            Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }

    }

    public void Registrar(View view) {
        Intent i = new Intent(this, Formulario.class);

        startActivity(i);
        finish();
    }
}