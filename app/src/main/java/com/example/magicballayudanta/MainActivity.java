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
    private TextView respuesta, textAboveBall, changeUsage;
    private String[] respuestasPosibles={"Es cierto", "Definitivamente es así", "Sin duda", "Sí definitivamente", "Puede confiar en él", "Como yo lo veo, sí",
            "Lo más probable", "Perspectiva buena", "Sí", "Las señales apuntan a sí", "Respuesta confusa intente de nuevo", "Pregunte de nuevo más tarde",
            "Mejor no decirte ahora", "No puedo predecir ahora", "Concéntrate y pregunta de nuevo", "No cuentes con eso",
            "Mi respuesta es no", "Mis fuentes dicen que no", "Outlook no es tan bueno", "Muy dudoso"};
    private String[] respuestasPosibles1 = {"1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9",
            "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3",
            "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7",
            "4.8", "4.9", "5.0", "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8", "5.9", "6.0", "6.1",
            "6.2", "6.3", "6.4", "6.5", "6.6", "6.7", "6.8", "6.9", "7.0"};
    private String mensaje[] = {"Sabía que volverías!", "Tu destino era volver :)", "La bola nos dijo que volverías!", "Todos vuelven :)"};
    //Métodos
    //Al abrir la app por primera vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.boton);
        respuesta = findViewById(R.id.respuesta);
        textAboveBall = findViewById(R.id.conoce);
        changeUsage = findViewById(R.id.notas);

        ball.setOnClickListener(this);
        changeUsage.setOnClickListener(this);
        if(timesAppIsResumed < 1) {
            Toast.makeText(MainActivity.this, "Buscando tu destino...", Toast.LENGTH_SHORT).show();
        }

    }
    //Al resumir la app
    @Override
    protected void onResume(){
        super.onResume();
        timesAppIsResumed += 1;
        int aleatorio = new Random().nextInt(mensaje.length);
        if(timesAppIsResumed >= 1){
            Toast.makeText(this, mensaje[aleatorio], Toast.LENGTH_SHORT).show();
        }
    }

    //Al hacer click en imagen
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.boton){
            int numRandom = new Random().nextInt(respuestasPosibles.length);
            respuesta.setText(respuestasPosibles[numRandom]);
        }else if(v.getId() == R.id.notas){
            String aux = (String) changeUsage.getText();
            String[] aux1 = respuestasPosibles;

            changeUsage.setText(textAboveBall.getText());
            textAboveBall.setText(aux);
            respuesta.setText("Toca la bola 8");
            respuestasPosibles = respuestasPosibles1;
            respuestasPosibles1 = aux1;

        }
    }
}
