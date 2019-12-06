package com.example.postuleroymerlin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
    private OffreDetails offreDetails;

    private TextView titreOffre;
    private TextView publi;
    private TextView typeContrat;
    private TextView lieu;
    private TextView experience;
    private TextView filiere;
    private TextView descpara1;
    private TextView descpara2;
    private TextView profil;
    private TextView lienComplet;
    private TextView salaire;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offre_activity);

        int position = getIntent().getIntExtra("position", -1);

        titreOffre = findViewById(R.id.titreOffre);
        publi = findViewById(R.id.titre);
        typeContrat = findViewById(R.id.create);
        lieu = findViewById(R.id.description);
        experience = findViewById(R.id.experience);
        filiere = findViewById(R.id.filiere);
        descpara1 = findViewById(R.id.descpara1);
        descpara2 = findViewById(R.id.descpara2);
        profil = findViewById(R.id.profil);
        lienComplet = findViewById(R.id.lienComplet);
        salaire = findViewById(R.id.salaire);

        postuler = findViewById(R.id.postuler);
        postuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(offreDetails.getUri());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        salaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Questions.class);
                startActivity(i);
            }
        });

        lienComplet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(offreDetails.getLien());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        try {
            offreDetails = parserXMLOnOneElement(position);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        titreOffre.setText(offreDetails.getOffrePreface().getTitre());
        publi.setText("Publiée le : "+offreDetails.getOffrePreface().getPublication());
        typeContrat.setText(offreDetails.getOffrePreface().getContrat());
        lieu.setText(offreDetails.getOffrePreface().getLieu());
        experience.setText(offreDetails.getOffrePreface().getExperience());
        filiere.setText(offreDetails.getOffrePreface().getFiliere());
        descpara1.setText(offreDetails.getParagraphe1());
        descpara2.setText(offreDetails.getParagraphe2());
        profil.setText(offreDetails.getProfil());
    }

    private OffreDetails parserXMLOnOneElement(int position) throws IOException, SAXException, ParserConfigurationException {
        OffreDetails offre = null;

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
                    String lien2 = eElement.getElementsByTagName("lien1").item(0).getTextContent();
                    offre = new OffreDetails(new OffrePreface(title, contrat, lieu, experience, filiere, publication), p1, p2, profil, lien, lien2);
                }
            }
        }
        return offre;
    }
}