package com.uilover.project1932.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.uilover.project1932.R;
import com.uilover.project1932.databinding.EscanerActivityBinding;

public class EscanerActivity extends AppCompatActivity {
    private EscanerActivityBinding binding;

    Button btn_scan, btn_next;
    EditText txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EscanerActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializamos los componentes
        btn_scan = findViewById(R.id.btn_scan);
        txtResultado = findViewById(R.id.txtResultado);
        btn_next = findViewById(R.id.btnnext);

        // Al iniciar, ocultamos el botón de "Next"
        btn_next.setVisibility(View.INVISIBLE);  // El botón no será visible al principio

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrador = new IntentIntegrator(EscanerActivity.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Lector- CDP");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
            }
        });

        // Configurar el botón "Next" para redirigir a MainActivity
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscanerActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar esta actividad
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Lectora cancelada", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                txtResultado.setText(result.getContents());

                // Cuando se obtiene el resultado, mostramos el botón de "Next"
                btn_next.setVisibility(View.VISIBLE);  // Hacemos visible el botón
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
