package com.example.postuleroymerlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Questions extends AppCompatActivity {

    private Button btnsalaire;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;

    private  TextView tvsalaire;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qcommerce);

        btnsalaire = findViewById(R.id.btn);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        cb1 = findViewById(R.id.c1);
        cb2 = findViewById(R.id.c2);
        cb3 = findViewById(R.id.c3);
        cb4 = findViewById(R.id.c4);
        tvsalaire = findViewById(R.id.tvsalaire);

        btnsalaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int salaire = 1200;
                if(rb1.isChecked()){
                    salaire += 100;
                }
                if(rb2.isChecked()){
                    salaire += 100;
                }
                if(rb3.isChecked()){
                    salaire += 100;
                }
                if(cb1.isChecked()){
                    salaire += 100;
                }
                if(cb2.isChecked()){
                    salaire += 100;
                }
                if(cb3.isChecked()){
                    salaire += 100;
                }
                if(cb4.isChecked()){
                    salaire += 100;
                }



                tvsalaire.setText(salaire+" €");

                btnsalaire.setClickable(false);
            }
        });


    }
}
