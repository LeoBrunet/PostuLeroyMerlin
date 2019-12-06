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
        try {
            chargerRecyclerView(parserXML());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return root;

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

    private List<Avis> parserXML() throws IOException, SAXException, ParserConfigurationException {
        List<Avis> result = new ArrayList<>();

        InputStream inputFile = getResources().getAssets().open("avis.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("avis");

        Log.e("LA", list.getLength()+"");
        for(int i = 0; i < list.getLength(); i++) {
            Avis avis = null;
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                String subtitle = eElement.getElementsByTagName("subTitle").item(0).getTextContent();
                String note = eElement.getElementsByTagName("note").item(0).getTextContent();
                String text = eElement.getElementsByTagName("text").item(0).getTextContent();
                avis = new Avis(title, subtitle, text, note);
            }
            result.add(avis);
        }
        return result;
    }
}
