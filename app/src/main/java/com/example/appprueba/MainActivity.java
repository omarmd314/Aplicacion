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
    String usureg;
    String passreg;


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

        usureg = getIntent().getStringExtra("user");
        passreg = getIntent().getStringExtra("psswd");
        curso = getIntent().getStringExtra("curso");
    }

    public void Mostrar(View view){

        Intent i = new Intent(this, Registro.class);
        if(curso == null && usureg==null && passreg==null){
            Toast.makeText(this, "No hay usuario registrado!!!", Toast.LENGTH_SHORT).show();

        }
        else if(usuario.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su nombre de usuario!!!", Toast.LENGTH_SHORT).show();
        } else if (psswd.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese su contraseña!!!", Toast.LENGTH_SHORT).show();
        } else if(usuario.getText().toString().equals(usureg) && psswd.getText().toString().equals(passreg)){
            i.putExtra("nombre",usureg);
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