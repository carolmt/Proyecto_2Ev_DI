package com.example.proyecto_final_di.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final_di.Images.GeneralImage;
import com.example.proyecto_final_di.R;
import com.example.proyecto_final_di.items.ItemGeneral;

import java.util.List;

public class BolsosAdapter extends RecyclerView.Adapter<BolsosAdapter.ViewHolder> {

    private List<ItemGeneral> datosBolsos;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreTextView;
        private final ImageView img;
        private final TextView precioTextView;
        private final TextView monedaTextView;
        private final ImageButton botonCarrito;
        private final ImageButton botonFavoritos;

        public ViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.generalImg);
            nombreTextView = (TextView) view.findViewById(R.id.nombre);
            precioTextView = (TextView) view.findViewById(R.id.precio);
            botonCarrito = (ImageButton) view.findViewById(R.id.botonCarrito);
            monedaTextView = (TextView) view.findViewById(R.id.moneda);
            botonFavoritos = (ImageButton) view.findViewById(R.id.botonFavorito);

            botonCarrito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombre = nombreTextView.getText().toString();
                    Toast.makeText(itemView.getContext(), nombre + " se ha añadido al carrito.", Toast.LENGTH_SHORT).show();
                }
            });

            botonFavoritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombre = nombreTextView.getText().toString();
                    Toast.makeText(itemView.getContext(), nombre + " se ha añadido a favoritos.", Toast.LENGTH_SHORT).show();
                }
            });
        }


        public TextView getNombreTextView() {
            return nombreTextView;
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getPrecioTextView() {
            return precioTextView;
        }
    }

    public BolsosAdapter(List<ItemGeneral> datosBolsos) {
        this.datosBolsos = datosBolsos;
    }


    @NonNull
    @Override
    public BolsosAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_general, viewGroup, false);

        return new BolsosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BolsosAdapter.ViewHolder viewHolder, final  int position) {

        ItemGeneral item = datosBolsos.get(position);
        Context context = viewHolder.itemView.getContext();

        viewHolder.img.setImageResource(item.getImg());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad ImagePalette con la información necesaria
                Intent intent = new Intent(context, GeneralImage.class);

                // Agregar la transición compartida
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                        viewHolder.img, // ImageView de origen
                        "tranphoto" // Nombre de la transición compartida
                );

                intent.putExtra("selected_image", item.getImg());  // Pasa la información necesaria a ImagePalette
                context.startActivity(intent, options.toBundle());
            }
        });


        viewHolder.getImg().setImageResource(datosBolsos.get(position).getImg());
        viewHolder.getNombreTextView().setText(datosBolsos.get(position).getNombre());
        viewHolder.getPrecioTextView().setText(String.valueOf(datosBolsos.get(position).getPrecio()));


        ItemGeneral item2 = datosBolsos.get(position);
        viewHolder.nombreTextView.setText(item2.getNombre());
        viewHolder.precioTextView.setText(String.valueOf(item2.getPrecio()));
        viewHolder.img.setImageResource(item2.getImg());

    }


    @Override
    public int getItemCount() {
        return datosBolsos.size();
    }
}

