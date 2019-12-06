package com.example.postuleroymerlin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    private SpaceNavigationView spaceNavigationView;
    private Button btnQuestions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnQuestions = findViewById(R.id.btnQuestions);

        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_tag));
        spaceNavigationView.addSpaceItem(new SpaceItem("SEARCH", R.drawable.ic_care_about_environment));

        spaceNavigationView.showIconOnly();
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.vertleroy));
        spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.black));
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.grey));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                if (itemIndex==0){
                    loadFragement(new OffreFragment());
                }
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }


        });

        btnQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Questions.class);
                startActivity(intent);
            }
        });


    }
    private boolean loadFragement(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();

            return true;
        }
        return false;
    }


}
