package com.example.proyecto_final_di.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto_final_di.Compras;
import com.example.proyecto_final_di.Favoritos;
import com.example.proyecto_final_di.R;
import com.example.proyecto_final_di.adapters.BisuteriaAdapter;
import com.example.proyecto_final_di.items.ItemGeneral;

import java.util.ArrayList;
import java.util.List;


public class nav_zapatos extends Fragment {

    private BisuteriaAdapter adapter;
    private RecyclerView recyclerView;
    private List<ItemGeneral> datosZapatos = new ArrayList<>();


    public nav_zapatos() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nav_zapatos, container, false);

        recyclerView = root.findViewById(R.id.recyclerZapatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializar los elementos ItemGeneral y agregarlos a la lista de datos
        initializeData();

        // Configurar y establecer el adaptador en el RecyclerView
        setupAdapter();

        return root;
    }

    private void initializeData() {
        datosZapatos = new ArrayList<>();
        datosZapatos.add(new ItemGeneral(R.drawable.boots1, "Botas Naked Wolfe", 99.99));
        datosZapatos.add(new ItemGeneral(R.drawable.boots2, "Botas doble M", 49.99));
        datosZapatos.add(new ItemGeneral(R.drawable.boots3, "Botas plataforma CR", 59.90));
        datosZapatos.add(new ItemGeneral(R.drawable.shoes1, "Tacón cadenas", 35));
        datosZapatos.add(new ItemGeneral(R.drawable.shoes2, "Tacón redVelvet", 45));
        datosZapatos.add(new ItemGeneral(R.drawable.shoes4, "Tacón CH Marron", 40));
        datosZapatos.add(new ItemGeneral(R.drawable.shoes3, "Tacón CH Rojo", 40));
    }

    private void setupAdapter() {
        adapter = new BisuteriaAdapter(datosZapatos);
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick(ItemGeneral itemGeneral) {
        showToast(itemGeneral.getNombre());
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_button) {
            // Código para manejar el clic en el ícono del carrito
            Intent intent = new Intent(getActivity(), Compras.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_button2) {
            Intent intent = new Intent(getActivity(), Favoritos.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}