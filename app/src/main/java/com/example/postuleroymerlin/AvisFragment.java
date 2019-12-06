package com.example.postuleroymerlin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postuleroymerlin.Adapter.AvisAdapter;
import com.example.postuleroymerlin.Model.Avis;

import java.util.ArrayList;
import java.util.List;

public class AvisFragment extends Fragment {

    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Avis> avis;

    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.avis_fragment, null);
        recyclerview = (RecyclerView) root.findViewById(R.id.recyclerAvis);


        avis = new ArrayList<>();
        chargerRecyclerView(chargerAvis());

        return root;

    }

    private List<Avis> chargerAvis(){
        Avis avis1 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis2 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis3 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis4 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis5 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis6 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis7 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");
        Avis avis8 = new Avis(5,"Le titre", "Jean Laval 06/12/19","L'avis de la personne");

        avis.add(avis1);
        avis.add(avis2);
        avis.add(avis3);
        avis.add(avis4);
        avis.add(avis5);
        avis.add(avis6);
        avis.add(avis7);
        avis.add(avis8);

        Log.e("testest", "avis "+avis.size());

        return avis;
    }

    private void chargerRecyclerView(List<Avis> avis){
        adapter = new AvisAdapter(avis, this.getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerview.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
        recyclerview.setAdapter(adapter);
    }
}
