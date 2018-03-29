package com.example.dell.taller;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class Principal extends AppCompatActivity {
    private EditText txtNumero;
    private TextView lblMensaje;
    private TextView lblUltimoNumero;
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
        lblUltimoNumero = (TextView) findViewById(R.id.lblUltimoNumero);
        imgVictoria = (ImageView) findViewById(R.id.imgVictoria);
        btnJugar = (Button) findViewById(R.id.btnJugar);
        btnVolverAJugar = (Button) findViewById(R.id.btnVolverAJugar);
        btnVolverAJugar.setVisibility(View.INVISIBLE);


        // Llama al método que genera el número aleatorio.
        generarNumero();
    }

    public void btnJugarOnClick(View v) {
        int numero;

        // Verifica que la casilla de texto no esté vacía.
        if (txtNumero.getText().toString().equals(null) || txtNumero.getText().toString().equals("")) {
            Toast.makeText(this, "No puede dejar este campo vacío.", Toast.LENGTH_LONG).show();
        } else {
            numero = Integer.parseInt(String.valueOf(txtNumero.getText()));
            if (numero == numeroR) {
                declararVictoria();
            } else if (numero < numeroR) {
                subir(numero);
            } else if (numero > numeroR) {
                bajar(numero);
            }
            lblUltimoNumero.setText("Último número ingresado: " + numero);
        }
    }

    public void generarNumero() {
        // Genera un número random con un límite de 10000.
        Random r = new Random();
        numeroR = r.nextInt(10001);
    }

    // Cuando gana, se pone la imagen y un label de felicidades.
    // Cargar este método cuando el usuario
    public void declararVictoria() {
        // Carga imagen y label.
        lblMensaje.setText("¡Felicidades, ha ganado!");
        imgVictoria.setImageResource(R.drawable.oraora);


        // Reproducir sonido de victoria.
        try {
            final MediaPlayer victoria = MediaPlayer.create(this, R.raw.victoria);
            victoria.setVolume(50,50);
            victoria.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Deshabilita botón "Jugar".
        txtNumero.setEnabled(false);
        btnJugar.setEnabled(false);

        // Muestra botón "Volver a Jugar".
        btnVolverAJugar.setVisibility(View.VISIBLE);
    }

    public void subir(int numero) {
        String mensaje;
        int calculo = numeroR - numero;

        if (calculo >= 1 && calculo <= 100) {
            mensaje = "¡MUY CERCA! SUBE un poquito más. (1+ ~ 100+)";

            try {
                final MediaPlayer muy_cerca = MediaPlayer.create(this, R.raw.muy_cerca);
                muy_cerca.setVolume(50,50);
                muy_cerca.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (calculo >= 101 && calculo <= 1000) {
            mensaje = "¡Estás cerca, SUBE un poco más! (100+ ~ 1000+)";
        } else if (calculo >= 1001 && calculo <= 2000) {
            mensaje = "¡Estás cerca, SUBE más! (1000+ ~ 2000+)";
        } else {
            mensaje = "Lejos. SUBE más. (2000+)";
        }


        Toast mSubir =
                Toast.makeText(getApplicationContext(),
                        mensaje, Toast.LENGTH_SHORT);

        mSubir.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);

        mSubir.show();
    }

    public void bajar(int numero) {
        String mensaje;
        int calculo = numero - numeroR;

        if (calculo >= 1 && calculo <= 100) {
            mensaje = "¡MUY CERCA! BAJA un poquitín más (-1 ~ -100)";

            try {
                final MediaPlayer muy_cerca = MediaPlayer.create(this, R.raw.muy_cerca);
                muy_cerca.setVolume(50,50);
                muy_cerca.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (calculo >= 101 && calculo <= 1000) {
            mensaje = "¡Estás cerca, BAJA un poco más! (-100 ~ -1000)";
        } else if (calculo >= 1001 && calculo <= 2000) {
            mensaje = "¡Estás cerca, BAJA más! (-1000 ~ -2000)";
        } else {
            mensaje = "Lejos. BAJA más.";
        }

        Toast mBajar =
                Toast.makeText(getApplicationContext(),
                        mensaje, Toast.LENGTH_SHORT);

        mBajar.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);

        mBajar.show();
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
        lblUltimoNumero.setText("");
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
        btnVolverAJugar.setVisibility(View.INVISIBLE);

    }

}

