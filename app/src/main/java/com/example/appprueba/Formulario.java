package com.example.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
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

    RadioButton rb1,rb2;
    CheckBox cb1,cb2;

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
        rb1 = findViewById(R.id.rdb1);
        rb2 = findViewById(R.id.rdb2);
        cb1 = findViewById(R.id.cbx1);
        cb2 = findViewById(R.id.cbx2);

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

    public void Registrar(View view){

        Intent i = new Intent(this, MainActivity.class);
        String usu = user.getText().toString();
        String pwd = user.getText().toString();
        String curso = spinner.getSelectedItem().toString();
        String sexo = "";
        String ciclo="";
        if(rb1.isChecked())
            sexo = "Masculino";
        else
            sexo = "Femenino";

        if(cb1.isChecked())
            ciclo = "CICLO I";
        if (cb1.isChecked())
            ciclo = "CICLO II";

        Toast.makeText(this, "Usuario: "+usu+"\n"+
                       "Contraseña:" + pwd +"\n"+
                        "Curso:" + curso + "\n"+
                        "Sexo:" + sexo + "\n"+
                        "Ciclo:" + ciclo + "\n", Toast.LENGTH_SHORT).show();

        i.putExtra("user", usu);
        i.putExtra("psswd", pwd);
        startActivity(i);
        finish();
    }


    public void Mostrar(View view){
        Intent i = new Intent(this, MainActivity.class);
        String sp_curso = spinner.getSelectedItem().toString();
        String usu = user.getText().toString();
        String pwd = user.getText().toString();
        i.putExtra("curso", sp_curso);
        i.putExtra("user", usu);
        i.putExtra("psswd", pwd);
        startActivity(i);
        finish();
        // Toast.makeText(this, str , Toast.LENGTH_SHORT).show();
    }
}