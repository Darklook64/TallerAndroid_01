package com.example.dell.taller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Principal extends AppCompatActivity {
    private EditText txtNumero;
    private TextView lblMensaje;
    private ImageView imgVictoria;
    private Button btnJugar;
    private Button btnVolverAJugar;
    private int numeroR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cargarComponentes();
    }

    public void cargarComponentes() {
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        imgVictoria = (ImageView) findViewById(R.id.imgVictoria);
        btnJugar = (Button) findViewById(R.id.btnJugar);
        btnVolverAJugar = (Button) findViewById(R.id.btnVolverAJugar);

        // Llama al método que genera el número random.
        generarNumero();
    }

    public void btnJugarOnClick(View v) {
        int numero;
        numero = Integer.parseInt(String.valueOf(txtNumero.getText()));

        if (numero == numeroR) {
            declararVictoria();
        } else if (numero < numeroR) {
            subir();
        } else if (numero > numeroR) {
            bajar();
        }
    }

    public void generarNumero() {
        // Genera un número random con un límite de 10000.
        Random r = new Random();
        numeroR = r.nextInt(10001);

        // Muestra el número random por ahora, BORRARLO después:
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("El número generado es: " + numeroR);
    }

    // Cuando gana, se pone la imagen y un label de felicidades.
    // Cargar este método cuando el usuario
    public void declararVictoria() {
        // Carga imagen y label.
        lblMensaje.setText("¡Felicidades, ha ganado!");
        imgVictoria.setImageResource(R.drawable.oraora);

        // Reproducir sonido de victoria.
        // !!

        // Deshabilita botón "Jugar".
        txtNumero.setEnabled(false);
        btnJugar.setEnabled(false);

        // Muestra botón "Volver a Jugar".
        // !!
    }

    public void subir() {
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("¡Sube un poco más!");

        // Reproducir sonido de 'subir'.
        // !!

    }

    public void bajar() {
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("¡Baja un poco más!");

        // Reproducir sonido de 'bajar'.
        // !!
    }

    public void btnVolverAJugarOnClick(View v) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Mensaje");
        dialogo1.setMessage("¿Quieres volver a jugar?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                dialogo1.dismiss();
            }
        });
        dialogo1.show();

    }

    public void limpiar() {
        // Limpia los componentes.
        lblMensaje.setText("");
        txtNumero.setText("");
        imgVictoria.setImageResource(0);

        // Vuelve a habilitar los componentes.
        txtNumero.setEnabled(true);
        btnJugar.setEnabled(true);
    }

    public void aceptar() {
        // Vuelve a generar un número aleatorio.
        generarNumero();

        // Limpia y re-habilita los componentes.
        limpiar();

        // Vuelve a ocultar el botón "Volver a Jugar".
        // !!

    }

}

