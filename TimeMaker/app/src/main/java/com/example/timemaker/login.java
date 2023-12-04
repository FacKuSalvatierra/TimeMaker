package com.example.timemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    String role = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        findViewById(R.id.confirmLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidEmail(email) && isValidPassword(password)) {
                    if (role.equals("administrador") || role.equals("usuario")) {
                        // Lógica para administradores o usuarios
                        Toast.makeText(login.this, "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();

                        // Iniciar la actividad de Home
                        Intent intent = new Intent(login.this, home.class);
                        startActivity(intent);
                        finish(); // Opcional: finalizar la actividad actual para que no se pueda regresar con el botón de atrás
                    } else {
                        Toast.makeText(login.this, "Rol no reconocido", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(login.this, "Error en la validación. Por favor, revisa los datos ingresados.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // Función para validar el formato del email utilizando la clase Patterns de Android
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Función para validar la contraseña (por ejemplo, longitud mínima)
    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
}