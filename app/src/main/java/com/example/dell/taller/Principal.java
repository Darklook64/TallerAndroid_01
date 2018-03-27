package com.example.dell.taller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
    private int numero;

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
        //sonido de exito

        JugarDeNuevo();
    }

    public void Subir(){
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("¡Sube un poco mas!");
        //musica de subir

    }

    public void Bajar(){
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("¡Baja un poco mas!");
        //musica de bajar
    }

    public void compararNumero(){
        numero = Integer.parseInt(String.valueOf(txtNumero.getText()));

        if(numero == numeroR){
            recompensarUsuario();
        }else if (numero < numeroR){
            Subir();
        }else if(numero > numeroR){
            Bajar();
        }
    }
public void Limpiar(){
        lblMensaje.setText("");
        txtNumero.setText("");

}
    public void JugarDeNuevo() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Mensaje");
        dialogo1.setMessage("¿Quieres volver a jugar?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Si!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Aceptar();
            }
        });
        dialogo1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Cancelar();
            }
        });
        dialogo1.show();

    }

    public void Aceptar() {
        Limpiar();
        Reload
    }

    public void Cancelar() {
        finish();
        //imagen triste
    }

}

