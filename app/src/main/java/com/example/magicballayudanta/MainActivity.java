package com.example.magicballayudanta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Variables
    private int timesAppIsResumed = -1;
    private ImageView ball;
    private TextView respuesta;
    private String[] respuestasPosibles={"Es cierto", "Definitivamente es así", "Sin duda", "Sí definitivamente", "Puede confiar en él", "Como yo lo veo, sí",
            "Lo más probable", "Perspectiva buena", "Sí", "Las señales apuntan a sí", "Respuesta confusa intente de nuevo", "Pregunte de nuevo más tarde",
            "Mejor no decirte ahora", "No puedo predecir ahora", "Concéntrate y pregunta de nuevo", "No cuentes con eso",
            "Mi respuesta es no", "Mis fuentes dicen que no", "Outlook no es tan bueno", "Muy dudoso"};

    //Métodos
    //Al abrir la app por primera vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.boton);
        respuesta = findViewById(R.id.respuesta);

        ball.setOnClickListener(this);
        if(timesAppIsResumed < 1) {
            Toast.makeText(MainActivity.this, "Buscando tu destino...", Toast.LENGTH_SHORT).show();
        }

    }
    //Al resumir la app
    @Override
    protected void onResume(){
        super.onResume();
        timesAppIsResumed += 1;
        if(timesAppIsResumed >= 1){
            Toast.makeText(this, "Sabía que volverías!", Toast.LENGTH_SHORT).show();
        }
    }

    //Al hacer click en imagen
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.boton){
            int numRandom = new Random().nextInt(respuestasPosibles.length);
            respuesta.setText(respuestasPosibles[numRandom]);
        }
    }
}
