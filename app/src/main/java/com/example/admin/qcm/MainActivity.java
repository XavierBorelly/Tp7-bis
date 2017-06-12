package com.example.admin.qcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //Création du questionnaire interne à l'application
    private Quizz[] quizz = new Quizz[]{
            new Quizz("Ciel?", "bleu", "rouge"),
            new Quizz("citron?", "jaune", "rouge"),
            new Quizz("sang?", "rouge", "maron"),
            new Quizz("pomme?", "jaune", "noir"),
            new Quizz("orange?", "orange", "blanc")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //récupération de l'état de la partie
        Intent i = getIntent();
        int reponse = i.getIntExtra("Reponse", 0);
        int bonneReponse = i.getIntExtra("BonneReponse", 0);

        //choix aléatoire
        Random rand = new Random();
        int nbAlea = rand.nextInt(quizz.length-1);

        //choix de la question avec le choix aléatoire et écriture dans le TextView
        String texte = quizz[nbAlea].getQuestion();
        TextView editText = (TextView) findViewById(R.id.text);
        editText.setText(texte);

        //récupération des deux bouton
        Button bouton1 = (Button) findViewById(R.id.bouton1);
        Button bouton2 = (Button) findViewById(R.id.bouton2);

        //choix aléatoire pour la position des réponses
        int positionAlea = rand.nextInt(2);

        //écriture des réponse dans une variabble
        String reponse1 = quizz[nbAlea].getReponse1();
        String reponse2 = quizz[nbAlea].getReponse2();

        //on converti les int en final int pour les Intent
        final int reponseF = reponse;
        final int bonneReponseF = bonneReponse;

        //La bonne réponse placer en haut
        if(positionAlea ==1){

            //on ecrit les réponse sur les boutons
            bouton1.setText(reponse1);
            bouton2.setText(reponse2);

            //et on change de page en envoyant les valeurs
            bouton1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, reponse.class);
                    intent.putExtra("param", true);
                    intent.putExtra("BonneReponse", bonneReponseF);
                    intent.putExtra("Reponse", reponseF);
                    startActivity(intent);
                    finish();
                }
            });

            bouton2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, reponse.class);
                    intent.putExtra("param", false);
                    intent.putExtra("BonneReponse", bonneReponseF);
                    intent.putExtra("Reponse", reponseF);
                    startActivity(intent);
                    finish();
                }
            });
        }
        //La bonne réponse placer en bas
        else {

            //on ecrit les réponse sur les boutons
            bouton1.setText(reponse2);
            bouton2.setText(reponse1);

            //et on change de page en envoyant les valeurs
            bouton1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, reponse.class);
                    intent.putExtra("param", false);
                    intent.putExtra("BonneReponse", bonneReponseF);
                    intent.putExtra("Reponse", reponseF);
                    startActivity(intent);
                    finish();
                }
            });

            bouton2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, reponse.class);
                    intent.putExtra("param", true);
                    intent.putExtra("BonneReponse", bonneReponseF);
                    intent.putExtra("Reponse", reponseF);
                    startActivity(intent);
                    finish();
                }
            });
        }



    }
}
