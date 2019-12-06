package com.example.postuleroymerlin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.postuleroymerlin.Model.OffreDetails;
import com.example.postuleroymerlin.Model.OffrePreface;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class OffreActivity extends AppCompatActivity {

    private TextView postuler;
    private TextView salaire;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offre_activity);

        postuler = findViewById(R.id.postuler);
        salaire = findViewById(R.id.salaire);

        postuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.google.fr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        salaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Questions.class);
                startActivity(intent);
            }
        });
    }

    private OffreDetails parserXMLOnOneElement() throws IOException, SAXException, ParserConfigurationException {
        OffreDetails offre = null;

        int position = getIntent().getIntExtra("position", -1);

        InputStream inputFile = getResources().getAssets().open("offre.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("offre");

        for(int i = 0; i < list.getLength(); i++) {
            if(i == position){
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    String contrat = eElement.getElementsByTagName("contrat").item(0).getTextContent();
                    String lieu = eElement.getElementsByTagName("lieu").item(0).getTextContent();
                    String experience = eElement.getElementsByTagName("experience").item(0).getTextContent();
                    String filiere = eElement.getElementsByTagName("filiere").item(0).getTextContent();
                    String publication = eElement.getElementsByTagName("publication").item(0).getTextContent();
                    String p1 = eElement.getElementsByTagName("p1").item(0).getTextContent();
                    String p2 = eElement.getElementsByTagName("p2").item(0).getTextContent();
                    String profil = eElement.getElementsByTagName("profil").item(0).getTextContent();
                    String lien = eElement.getElementsByTagName("lien").item(0).getTextContent();
                    offre = new OffreDetails(new OffrePreface(title, contrat, lieu, experience, filiere, publication), p1, p2, profil, lien);
                }
            }
        }
        return offre;
    }
}
