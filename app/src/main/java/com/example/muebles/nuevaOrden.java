package com.example.muebles;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class nuevaOrden extends AppCompatActivity implements View.OnClickListener {

    EditText nroOrdenText;
    EditText vendedorText;
    EditText clienteText;
    EditText telefonoText;
    EditText direccionText;
    EditText fechaText;
    Button nextButtonPedido, fechaButton;
    private int day, month, year;
    private String filename = "Datos_ordenes.txt";
    private String filepath = "Datos_Muebles";
    File myExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_orden);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {

        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

        nroOrdenText = (EditText) findViewById(R.id.nroOrdenText);
        vendedorText = (EditText) findViewById(R.id.vendedorText);
        clienteText = (EditText) findViewById(R.id.clienteText);
        telefonoText = (EditText) findViewById(R.id.telefonoText);
        direccionText = (EditText) findViewById(R.id.direccionText);
        fechaText = (EditText) findViewById(R.id.fechaText);

        vendedorText.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        fechaButton = (Button) findViewById(R.id.fechaButton);
        fechaButton.setOnClickListener(this);

        nextButtonPedido =  (Button) findViewById(R.id.nextButtonPedido);
        nextButtonPedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            try {
                FileOutputStream fos = new FileOutputStream(myExternalFile,true);
                fos.write(("\n" +
                        "").getBytes());
                fos.write(nroOrdenText.getText().toString().getBytes());
                fos.write("\t".getBytes());
                fos.write(vendedorText.getText().toString().getBytes());
                fos.write("\t".getBytes());
                fos.write(clienteText.getText().toString().getBytes());
                fos.write("\t".getBytes());
                fos.write(telefonoText.getText().toString().getBytes());
                fos.write("\t".getBytes());
                fos.write(direccionText.getText().toString().getBytes());
                fos.write("\t".getBytes());
                fos.write(fechaText.getText().toString().getBytes());
                fos.close();

                Intent detalle = new Intent(getApplicationContext(), detalleOrden.class);
                startActivity(detalle);

            } catch (IOException e) {
                e.printStackTrace();
            }

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
    @Override
    public void onClick(View v) {
        if (v==fechaButton){
            final Calendar myCalendar = Calendar.getInstance();
            day=myCalendar.get(Calendar.DAY_OF_MONTH);
            month=myCalendar.get(Calendar.MONTH);
            year=myCalendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    , year, month, day);
            datePickerDialog.show();
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
