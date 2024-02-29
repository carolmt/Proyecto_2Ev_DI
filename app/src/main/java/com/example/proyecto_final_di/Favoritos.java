package com.example.proyecto_final_di;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.proyecto_final_di.R;
import com.example.proyecto_final_di.items.ItemGeneral;

public class Favoritos extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favoritos);

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