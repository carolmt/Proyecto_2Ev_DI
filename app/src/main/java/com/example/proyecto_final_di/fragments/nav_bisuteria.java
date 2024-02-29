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

import com.example.proyecto_final_di.Compras;
import com.example.proyecto_final_di.Favoritos;
import com.example.proyecto_final_di.R;
import com.example.proyecto_final_di.adapters.BisuteriaAdapter;
import com.example.proyecto_final_di.items.ItemGeneral;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class nav_bisuteria extends Fragment {

    private BisuteriaAdapter adapter;
    private RecyclerView recyclerView;
    private List<ItemGeneral> datosBisuteria = new ArrayList<>();


    public nav_bisuteria() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nav_bisuteria, container, false);

        recyclerView = root.findViewById(R.id.recyclerBisuteria);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializar los elementos ItemGeneral y agregarlos a la lista de datos
        initializeData();

        // Configurar y establecer el adaptador en el RecyclerView
        setupAdapter();

        return root;
    }

    private void initializeData() {
        datosBisuteria = new ArrayList<>();
        datosBisuteria.add(new ItemGeneral(R.drawable.chain1, "Collares corazon", 12.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.chain2, "Collar cruz", 15));
        datosBisuteria.add(new ItemGeneral(R.drawable.chain3, "Collar araña", 14.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.chain4, "Collar tribal", 19.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.earring1, "Pendientes brillo", 5));
        datosBisuteria.add(new ItemGeneral(R.drawable.earring2, "Pendientes bara", 8));
        datosBisuteria.add(new ItemGeneral(R.drawable.earring3, "Pendientes cruz", 10));
        datosBisuteria.add(new ItemGeneral(R.drawable.earring4, "Pendientes corazon", 9.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring1, "Anillo flor", 19.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring2, "Anillo gema", 29.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring3, "Anillo araña", 19.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring4, "Anillo enredadera", 34.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring5, "Anillo BK heart", 19.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring6, "Anillo WT heart", 19.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring7, "Anillo Gema GR", 19.99));
        datosBisuteria.add(new ItemGeneral(R.drawable.ring8, "Anillo Gema ESM", 24.99));
    }

    private void setupAdapter() {
        adapter = new BisuteriaAdapter(datosBisuteria);
        recyclerView.setAdapter(adapter);
    }
    public void onItemClick(ItemGeneral itemHotel) {
        showToast(itemHotel.getNombre());
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