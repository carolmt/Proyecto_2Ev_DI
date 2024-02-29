package com.example.proyecto_final_di.fragments;

import android.annotation.SuppressLint;
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
import com.example.proyecto_final_di.adapters.BolsosAdapter;
import com.example.proyecto_final_di.items.ItemGeneral;

import java.util.ArrayList;
import java.util.List;

public class nav_bolsos extends Fragment {

    private BolsosAdapter bolsosAdapter;
    private RecyclerView recyclerView;
    private List<ItemGeneral> datosBolsos = new ArrayList<>();

    public nav_bolsos() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_nav_bolsos, container, false);

        recyclerView = root.findViewById(R.id.recyclerBolsos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializar los elementos ItemGeneral y agregarlos a la lista de datos
        initializeData();

        // Configurar y establecer el adaptador en el RecyclerView
        setupAdapter();

        return root;
    }

    private void initializeData() {
        datosBolsos = new ArrayList<>();
        datosBolsos.add(new ItemGeneral(R.drawable.bag1, "Bolso negro Ch", 12));
        datosBolsos.add(new ItemGeneral(R.drawable.bag2, "Bolso M CH", 15));
        datosBolsos.add(new ItemGeneral(R.drawable.bag3, "Bolso G night", 30));
        datosBolsos.add(new ItemGeneral(R.drawable.bag4, "Bolso rojo f", 30));
        datosBolsos.add(new ItemGeneral(R.drawable.bag5, "Bolso B&W", 15));
        datosBolsos.add(new ItemGeneral(R.drawable.bag6, "Bolso CowBoy G", 18.75));
        datosBolsos.add(new ItemGeneral(R.drawable.bag7, "Bolso PRADA MC", 359.99));
        datosBolsos.add(new ItemGeneral(R.drawable.bag8, "Bolso silver", 22.99));
        datosBolsos.add(new ItemGeneral(R.drawable.bag9, "Bolso BALENCIAGA BK", 400));
        datosBolsos.add(new ItemGeneral(R.drawable.bag10, "Bolso BALENCIAGA WT", 400));
        datosBolsos.add(new ItemGeneral(R.drawable.bag11, "Bolso JUICY", 120));
        datosBolsos.add(new ItemGeneral(R.drawable.bag12, "Bolso heart shape", 35.99));
        datosBolsos.add(new ItemGeneral(R.drawable.bag13, "Bolso PRADa GR", 35.99));
    }

    private void setupAdapter() {
        bolsosAdapter = new BolsosAdapter(datosBolsos);
        recyclerView.setAdapter(bolsosAdapter);
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