package com.example.admin.qcm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class reponse extends AppCompatActivity {

    //Nombre maximal de question a donner
    final int SCORE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reponse);


        //on récupére le fond et l'état de la partie (aussi que le résulta de la réponse donner)
        LinearLayout fond = (LinearLayout) findViewById(R.id.fond);
        Intent i = getIntent();
        boolean test = i.getBooleanExtra("param", false);
        int reponse = i.getIntExtra("Reponse", 0) +1;
        int bonneReponse = i.getIntExtra("BonneReponse", 0);

        //Si la réponse est bonne
        if(test)
        {
            //on augmente le compteur de bonne réponse
            bonneReponse ++;

            //Et si il n'y a pas encore 20 réponses donnés on met le fond en vert
            if(reponse != SCORE){
                fond.setBackgroundResource(R.color.colorTrue);
            }
        }
        else{
            //Si la réponse est fausse on met le fond en rouge
            fond.setBackgroundResource(R.color.colorFalse);
        }


        //on converti les int en final int pour les Intent
        final int reponseF = reponse;
        final int bonneReponseF = bonneReponse;

        //Si il n'y a pas encore 20 réponses donnés on relance
        if(reponse != SCORE){
        fond.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(reponse.this, MainActivity.class);
                    intent.putExtra("BonneReponse", bonneReponseF);
                    intent.putExtra("Reponse", reponseF);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else {
        //Si il y a 20 question donner on affiche le score
            String texte = bonneReponse + "/" + SCORE;
            TextView editText = (TextView) findViewById(R.id.text2);
            editText.setText(texte);

        }
    }
}
