package com.example.appejemplo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appejemplo01.db.DbContactos;

import java.security.PrivateKey;

public class NuevoActivity extends AppCompatActivity {
    EditText txtdni, txtnombre, txtapellido, txtemail, txtdireccion;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtdni = findViewById(R.id.txtdni);
        txtnombre = findViewById(R.id.txtnombre);
        txtapellido = findViewById(R.id.txtapellido);
        txtemail = findViewById(R.id.txtemail);
        txtdireccion = findViewById(R.id.txtdireccion);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContacto(txtdni.getText().toString(), txtnombre.getText().toString(), txtapellido.getText().toString(), txtemail.getText().toString(), txtdireccion.getText().toString());

                if (id > 0) {
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtemail.setText("");
        txtdireccion.setText("");
    }
}