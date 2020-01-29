package com.example.muebles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity{

    Button nextButton, shareButton;

    private String filename = "Datos_ordenes.txt";
    private String filepath = "Datos_Muebles";
    File myExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            nextButton.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

        StringBuffer datax = new StringBuffer("");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            InputStreamReader isr = new InputStreamReader ( fis ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine( ) ;
            while ( readString != null ) {
                datax.insert(0,readString);
                readString = buffreader.readLine ( ) ;
            }

            isr.close( ) ;

        }catch (IOException e){
            try {
                FileOutputStream fos = new FileOutputStream(myExternalFile, true);
                fos.write(("No. de OP\tVendedor\tCliente\tTelefono\tDireccion\tFecha de entrega\t" +
                        "Tiene Alcoba?\tReferencia alcoba\tTamaño cama\tColor alcoba\tNro de mesas\tPeinador?\tSemanario?\tColchon\tReferencia colchon\tOtras especificaciones alcoba\t" +
                        "Tiene Comedor?\tNro de puestos\tReferencia base\tReferencia sillas\tReferencia Tapizado\tColor Comedor\tOtras especificaciones comedor\t" +
                        "Tiene Sala?\tReferencia sala\tTela sala\tMesa de centro?\tReferencia mesa de centro\tCojines?\tCantidad cojines\tOtras especificaciones sala").getBytes());
            } catch (IOException err) {
                err.printStackTrace();
            }
        }

        nextButton =  (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent preg1 = new Intent(getApplicationContext(), nuevaOrden.class);
                startActivity(preg1);
            }
        });

        shareButton =  (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                compartirArchivo();
            }
        });
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
    private void compartirArchivo(){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/*");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + myExternalFile.getAbsolutePath()));
        startActivity(Intent.createChooser(sharingIntent, "share file with"));
    }
}
