package com.example.proyecto_final_di;

import android.os.Bundle;

import com.example.proyecto_final_di.items.ItemGeneral;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

public class Compras extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_compras);

        // Recibir el ItemGeneral desde el intent
        if (getIntent().hasExtra("item_general")) {
            ItemGeneral item = getIntent().getParcelableExtra("item_general");
            // Mostrar el nombre del ItemGeneral en un TextView
            TextView nombreTextView = findViewById(R.id.nombre);
            nombreTextView.setText(item.getNombre());
            ImageView img = findViewById(R.id.generalImg);
            img.setImageResource(item.getImg());
            TextView precioTextView = findViewById(R.id.precio);
            precioTextView.setText(String.valueOf(item.getPrecio()));
        }
    }
}