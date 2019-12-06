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

import com.example.postuleroymerlin.Adapter.OffreAdapter;
import com.example.postuleroymerlin.Model.Offre;

import java.util.ArrayList;
import java.util.List;

public class OffreFragment extends Fragment {
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Offre> offres;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.offres_fragment, null);
        recyclerview = (RecyclerView) root.findViewById(R.id.recyclerOffres);

        offres = new ArrayList<>();
        chargerRecyclerView(chargerOffres());

        return root;
    }

    private List<Offre> chargerOffres(){
        Offre offre = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre1 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre2 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre3 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre4 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre5 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre6 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre7 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        Offre offre8 = new Offre("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");

        offres.add(offre);
        offres.add(offre1);
        offres.add(offre2);
        offres.add(offre3);
        offres.add(offre4);
        offres.add(offre5);
        offres.add(offre6);
        offres.add(offre7);
        offres.add(offre8);

        Log.e("testest", "offres "+offres.size());
        return offres;
    }

    private void chargerRecyclerView(List<Offre> offres){
        adapter = new OffreAdapter(offres);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerview.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
        recyclerview.setAdapter(adapter);
    }
}
