package com.example.proyecto_final_di.Images;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_final_di.R;

public class GeneralImage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Añadimos esta linea antes del setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_general_image);

        // Indicar animación de entrada en este caso Fade
        Fade explodeAnimation = new Fade();
        explodeAnimation.setDuration(1000);
        getWindow().setEnterTransition(explodeAnimation);


        // Obtén la imagen seleccionada del Intent
        int selectedImage = getIntent().getIntExtra("selected_image", 0);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(selectedImage);


        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

        ActionBar actionBar = getSupportActionBar();

    }
}