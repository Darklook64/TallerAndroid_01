package com.example.dell.taller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Principal extends AppCompatActivity {
    private EditText txtNumero;
    private TextView lblMensaje;
    private ImageView imgVictoria;
    private int numeroR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        generarNumero();
    }

    public void generarNumero(){
        // Genera un número random con un límite de 1000.
        Random r = new Random();
        numeroR = r.nextInt(1001);

        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("El número generado es: "+numeroR);


    }

    // Cuando gana, se pone la imagen y un label de felicidades.
    // Cargar este método cuando el usuario
    public void recompensarUsuario(){
        imgVictoria = (ImageView) findViewById(R.id.imgVictoria);
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);

        lblMensaje.setText("¡Felicidades, ha ganado!");
        imgVictoria.setImageResource(R.drawable.oraora);


    }
}
