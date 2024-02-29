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


public class nav_cinturones extends Fragment {

    private BisuteriaAdapter adapter;
    private RecyclerView recyclerView;
    private List<ItemGeneral> datosCinturones = new ArrayList<>();


    public nav_cinturones() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nav_cinturones, container, false);

        recyclerView = root.findViewById(R.id.recyclerCinturones);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializar los elementos ItemGeneral y agregarlos a la lista de datos
        initializeData();

        // Configurar y establecer el adaptador en el RecyclerView
        setupAdapter();

        return root;
    }

    private void initializeData() {
        datosCinturones = new ArrayList<>();
        datosCinturones.add(new ItemGeneral(R.drawable.belt1, "Cinturon mariposa", 8.99));
        datosCinturones.add(new ItemGeneral(R.drawable.belt2, "Cinturon cruces", 14.99));
        datosCinturones.add(new ItemGeneral(R.drawable.belt3, "Cinturon brillo", 9.99));
        datosCinturones.add(new ItemGeneral(R.drawable.belt4, "Cinturon Cowboy", 29.99));
        datosCinturones.add(new ItemGeneral(R.drawable.belt5, "Cinturon basic", 9.99));
        datosCinturones.add(new ItemGeneral(R.drawable.belt6, "Cinturon D Rojo", 14.99));
    }

    private void setupAdapter() {
        adapter = new BisuteriaAdapter(datosCinturones);
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
        }else if (id == R.id.action_button2) {
            Intent intent = new Intent(getActivity(), Favoritos.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}