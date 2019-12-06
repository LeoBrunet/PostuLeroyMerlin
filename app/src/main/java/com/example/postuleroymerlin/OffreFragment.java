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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
        try {
            chargerRecyclerView(parserXML());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return root;
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

    private List<OffrePreface> parserXML() throws IOException, SAXException, ParserConfigurationException {
        List<OffrePreface> result = new ArrayList<>();

        InputStream inputFile = getResources().getAssets().open("offre.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("offre");

        Log.e("LA", list.getLength()+"");
        for(int i = 0; i < list.getLength(); i++) {
            OffrePreface offre = null;
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                String contrat = eElement.getElementsByTagName("contrat").item(0).getTextContent();
                String lieu = eElement.getElementsByTagName("lieu").item(0).getTextContent();
                String experience = eElement.getElementsByTagName("experience").item(0).getTextContent();
                String filiere = eElement.getElementsByTagName("filiere").item(0).getTextContent();
                String publication = eElement.getElementsByTagName("publication").item(0).getTextContent();
                offre = new OffrePreface(title, contrat, lieu, experience, filiere, publication);
            }
            result.add(offre);
        }
        return result;
    }
}
