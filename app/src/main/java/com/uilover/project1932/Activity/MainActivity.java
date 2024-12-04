package com.uilover.project1932.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.uilover.project1932.Adapter.WorkoutAdapter;
import com.uilover.project1932.Domain.Lession;
import com.uilover.project1932.Domain.Workout;
import com.uilover.project1932.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hacer que la barra de estado se superponga al diseño
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Configuración del RecyclerView
        binding.view1.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        binding.view1.setAdapter(new WorkoutAdapter(getData()));

        // Acción para el botón de chat
        binding.chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp("+524493123965");
            }
        });

        // Acción para el botón de Routine
        binding.routineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la pantalla del escáner
                Intent intent = new Intent(MainActivity.this, EscanerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openWhatsApp(String phoneNumber) {
        String url = "https://wa.me/" + phoneNumber;
        try {
            // Intent para abrir WhatsApp si está instalado
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("whatsapp://send?phone=" + phoneNumber));
            startActivity(intent);
        } catch (Exception e) {
            // Si WhatsApp no está instalado, abrir en navegador
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }

    // Datos de ejemplo para la lista
    private ArrayList<Workout> getData() {
        ArrayList<Workout> list = new ArrayList<>();

        list.add(new Workout("Running", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ", "pic_1", 160, "9 min", getLession_1()));
        list.add(new Workout("Stretching", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ", "pic_2", 230, "85 min", getLession_2()));
        list.add(new Workout("Yoga", "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ", "pic_3", 180, "65 min", getLession_3()));

        return list;
    }

    private ArrayList<Lession> getLession_1() {
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lesson 1", "03:46 ", "HBPMvFkpNgE", "pic_1_1"));
        list.add(new Lession("Lesson 2", "03:41 ", "K6I24WgiiPw", "pic_1_2"));
        list.add(new Lession("Lesson 3", "01:57 ", "Zc08v4YYOeA", "pic_1_3"));
        return list;
    }

    private ArrayList<Lession> getLession_2() {
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lesson 1", "20:23 ", "L3eImBAXT7I", "pic_3_1"));
        list.add(new Lession("Lesson 2", "18:27 ", "47ExgzO7FlU", "pic_3_2"));
        list.add(new Lession("Lesson 3", "32:25 ", "OmLx8tmaQ-4", "pic_3_3"));
        list.add(new Lession("Lesson 4", "07:52 ", "w86EalEoFRY", "pic_3_4"));
        return list;
    }

    private ArrayList<Lession> getLession_3() {
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lesson 1", "23:00 ", "v7AYKMP6rOE", "pic_3_1"));
        list.add(new Lession("Lesson 2", "27:00 ", "Eml2xnoLpYE", "pic_3_2"));
        list.add(new Lession("Lesson 3", "25:00 ", "v7SN-d4qXx0", "pic_3_3"));
        list.add(new Lession("Lesson 4", "21:00 ", "LqXZ628YNj4", "pic_3_4"));
        return list;
    }
}
