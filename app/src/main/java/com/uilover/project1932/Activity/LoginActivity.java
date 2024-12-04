package com.uilover.project1932.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uilover.project1932.R;
import com.uilover.project1932.databinding.LoginActivityBinding;

public class LoginActivity extends AppCompatActivity {
    LoginActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Se establece el binding para acceder a las vistas
        binding = LoginActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener referencias a los campos de entrada y al botón
        EditText username = binding.username;
        EditText password = binding.contraseA;
        Button loginBtn = binding.loginbtn;

        // Establecer el OnClickListener para el botón de login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();

                // Verificar las credenciales
                if (enteredUsername.equals("Francisco") && enteredPassword.equals("Admin")) {
                    // Si las credenciales son correctas, mostrar el mensaje
                    Toast.makeText(LoginActivity.this, "Usuario correcto", Toast.LENGTH_SHORT).show();

                    // Crear el Intent para redirigir a IntroActivity
                    Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
                    startActivity(intent);
                    finish(); // Cerrar LoginActivity después de la redirección
                } else {
                    // Si las credenciales son incorrectas, mostrar un mensaje de error
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


