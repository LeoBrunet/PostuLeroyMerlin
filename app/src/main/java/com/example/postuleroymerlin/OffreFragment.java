package com.example.postuleroymerlin;

import android.content.Intent;
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
import com.example.postuleroymerlin.Model.OffrePreface;
import com.example.postuleroymerlin.Utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class OffreFragment extends Fragment {
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<OffrePreface> offres;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.offres_fragment, null);
        recyclerview = (RecyclerView) root.findViewById(R.id.recyclerOffres);

        recyclerview.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerview ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), OffreActivity.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        offres = new ArrayList<>();
        chargerRecyclerView(chargerOffres());

        return root;
    }

    private List<OffrePreface> chargerOffres(){
        OffrePreface offre = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre1 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre2 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre3 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre4 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre5 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre6 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre7 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");
        OffrePreface offre8 = new OffrePreface("CHEF DE SECTEUR COMMERCE - MANAGER BUSINESS UNIT - H/F", "CDI", "BRIVE", "1-2","Commerce", "4/12/2019");

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

    private void chargerRecyclerView(List<OffrePreface> offres){
        adapter = new OffreAdapter(offres, this.getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerview.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
        recyclerview.setAdapter(adapter);
    }
}
