package com.example.muebles;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class detalleOrden extends AppCompatActivity {

    Button endOrderButton;
    private String filename = "Datos_ordenes.txt";
    private String filepath = "Datos_Muebles";
    File myExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_orden);

        String[] siNo = new String[] {
                "N/A", "Sí", "No"
        };
        String[] ceroAlDos = new String[] {
                "0", "1", "2"
        };

        Spinner ans4 = (Spinner) findViewById(R.id.ans4);
        ArrayAdapter<String> adapterAns4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ceroAlDos);
        adapterAns4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans4.setAdapter(adapterAns4);

        Spinner ans5 = (Spinner) findViewById(R.id.ans5);
        ArrayAdapter<String> adapterAns5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans5.setAdapter(adapterAns5);

        Spinner ans6 = (Spinner) findViewById(R.id.ans6);
        ArrayAdapter<String> adapterAns6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans6.setAdapter(adapterAns6);

        Spinner ans7 = (Spinner) findViewById(R.id.ans7);
        ArrayAdapter<String> adapterAns7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans7.setAdapter(adapterAns7);

        Spinner ans17 = (Spinner) findViewById(R.id.ans17);
        ArrayAdapter<String> adapterAns17 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans17.setAdapter(adapterAns17);

        Spinner ans18 = (Spinner) findViewById(R.id.ans18);
        ArrayAdapter<String> adapterAns18 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18.setAdapter(adapterAns18);

        CheckBox tieneAlcoba = findViewById(R.id.tieneAlcoba);
        CheckBox tieneComedor = findViewById(R.id.tieneComedor);
        CheckBox tieneSala = findViewById(R.id.tieneSala);

        tieneAlcoba.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox tieneAlcoba = findViewById(R.id.tieneAlcoba);
                TextView ques1 = findViewById(R.id.ques1);
                TextView ques2 = findViewById(R.id.ques2);
                TextView ques3 = findViewById(R.id.ques3);
                TextView ques4 = findViewById(R.id.ques4);
                TextView ques5 = findViewById(R.id.ques5);
                TextView ques6 = findViewById(R.id.ques6);
                TextView ques7 = findViewById(R.id.ques7);
                EditText ans1 = findViewById(R.id.ans1);
                EditText ans2 = findViewById(R.id.ans2);
                EditText ans3 = findViewById(R.id.ans3);
                EditText ans8 = findViewById(R.id.ans8);
                Spinner ans4 = findViewById(R.id.ans4);
                Spinner ans5 = findViewById(R.id.ans5);
                Spinner ans6 = findViewById(R.id.ans6);
                Spinner ans7 = findViewById(R.id.ans7);

                if(tieneAlcoba.isChecked()){
                    ques1.setVisibility(View.VISIBLE);
                    ques2.setVisibility(View.VISIBLE);
                    ques3.setVisibility(View.VISIBLE);
                    ques4.setVisibility(View.VISIBLE);
                    ques5.setVisibility(View.VISIBLE);
                    ques6.setVisibility(View.VISIBLE);
                    ques7.setVisibility(View.VISIBLE);
                    ans1.setVisibility(View.VISIBLE);
                    ans2.setVisibility(View.VISIBLE);
                    ans3.setVisibility(View.VISIBLE);
                    ans4.setVisibility(View.VISIBLE);
                    ans5.setVisibility(View.VISIBLE);
                    ans6.setVisibility(View.VISIBLE);
                    ans7.setVisibility(View.VISIBLE);
                    ans8.setVisibility(View.VISIBLE);
                } else {
                    ques1.setVisibility(View.GONE);
                    ques2.setVisibility(View.GONE);
                    ques3.setVisibility(View.GONE);
                    ques4.setVisibility(View.GONE);
                    ques5.setVisibility(View.GONE);
                    ques6.setVisibility(View.GONE);
                    ques7.setVisibility(View.GONE);
                    ans1.setVisibility(View.GONE);
                    ans2.setVisibility(View.GONE);
                    ans3.setVisibility(View.GONE);
                    ans4.setVisibility(View.GONE);
                    ans5.setVisibility(View.GONE);
                    ans6.setVisibility(View.GONE);
                    ans7.setVisibility(View.GONE);
                    ans8.setVisibility(View.GONE);
                }
            }
        });

        ans7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans7 = (Spinner) findViewById(R.id.ans7);
                EditText ans7other = (EditText) findViewById(R.id.ans7other);
                if(ans7.getSelectedItemPosition()==1) {
                    ans7other.setVisibility(View.VISIBLE);
                }else{
                    ans7other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tieneComedor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox tieneComedor = findViewById(R.id.tieneComedor);
                TextView ques9 = findViewById(R.id.ques9);
                TextView ques10 = findViewById(R.id.ques10);
                TextView ques11 = findViewById(R.id.ques11);
                TextView ques12 = findViewById(R.id.ques12);
                TextView ques13 = findViewById(R.id.ques13);
                TextView ques14 = findViewById(R.id.ques14);
                EditText ans9 = findViewById(R.id.ans9);
                EditText ans10 = findViewById(R.id.ans10);
                EditText ans11 = findViewById(R.id.ans11);
                EditText ans12 = findViewById(R.id.ans12);
                EditText ans13 = findViewById(R.id.ans13);
                EditText ans14 = findViewById(R.id.ans14);

                if(tieneComedor.isChecked()){
                    ques9.setVisibility(View.VISIBLE);
                    ques10.setVisibility(View.VISIBLE);
                    ques11.setVisibility(View.VISIBLE);
                    ques12.setVisibility(View.VISIBLE);
                    ques13.setVisibility(View.VISIBLE);
                    ques14.setVisibility(View.VISIBLE);
                    ans9.setVisibility(View.VISIBLE);
                    ans10.setVisibility(View.VISIBLE);
                    ans11.setVisibility(View.VISIBLE);
                    ans12.setVisibility(View.VISIBLE);
                    ans13.setVisibility(View.VISIBLE);
                    ans14.setVisibility(View.VISIBLE);
                } else {
                    ques9.setVisibility(View.GONE);
                    ques10.setVisibility(View.GONE);
                    ques11.setVisibility(View.GONE);
                    ques12.setVisibility(View.GONE);
                    ques13.setVisibility(View.GONE);
                    ques14.setVisibility(View.GONE);
                    ans9.setVisibility(View.GONE);
                    ans10.setVisibility(View.GONE);
                    ans11.setVisibility(View.GONE);
                    ans12.setVisibility(View.GONE);
                    ans13.setVisibility(View.GONE);
                    ans14.setVisibility(View.GONE);
                }
            }
        });

        tieneSala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox tieneSala = findViewById(R.id.tieneSala);
                TextView ques15 = findViewById(R.id.ques15);
                TextView ques16 = findViewById(R.id.ques16);
                TextView ques17 = findViewById(R.id.ques17);
                TextView ques18 = findViewById(R.id.ques18);
                TextView ques19 = findViewById(R.id.ques19);
                EditText ans15 = findViewById(R.id.ans15);
                EditText ans16 = findViewById(R.id.ans16);
                EditText ans17other = findViewById(R.id.ans17other);
                EditText ans18other = findViewById(R.id.ans18other);
                EditText ans19 = findViewById(R.id.ans19);
                Spinner ans17 = findViewById(R.id.ans17);
                Spinner ans18 = findViewById(R.id.ans18);

                if(tieneSala.isChecked()){
                    ques15.setVisibility(View.VISIBLE);
                    ques16.setVisibility(View.VISIBLE);
                    ques17.setVisibility(View.VISIBLE);
                    ques18.setVisibility(View.VISIBLE);
                    ques19.setVisibility(View.VISIBLE);
                    ans15.setVisibility(View.VISIBLE);
                    ans16.setVisibility(View.VISIBLE);
                    ans17.setVisibility(View.VISIBLE);
                    ans18.setVisibility(View.VISIBLE);
                    ans19.setVisibility(View.VISIBLE);
                } else {
                    ques15.setVisibility(View.GONE);
                    ques16.setVisibility(View.GONE);
                    ques17.setVisibility(View.GONE);
                    ques18.setVisibility(View.GONE);
                    ques19.setVisibility(View.GONE);
                    ans15.setVisibility(View.GONE);
                    ans16.setVisibility(View.GONE);
                    ans17.setVisibility(View.GONE);
                    ans17other.setVisibility(View.GONE);
                    ans18.setVisibility(View.GONE);
                    ans18other.setVisibility(View.GONE);
                    ans19.setVisibility(View.GONE);
                }
            }
        });

        ans17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans17 = (Spinner) findViewById(R.id.ans17);
                EditText ans17other = (EditText) findViewById(R.id.ans17other);
                if(ans17.getSelectedItemPosition()==1) {
                    ans17other.setVisibility(View.VISIBLE);
                }else{
                    ans17other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans18 = (Spinner) findViewById(R.id.ans18);
                EditText ans18other = (EditText) findViewById(R.id.ans18other);
                if(ans18.getSelectedItemPosition()==1) {
                    ans18other.setVisibility(View.VISIBLE);
                }else{
                    ans18other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        endOrderButton =  (Button) findViewById(R.id.endOrderButton);
        endOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                escribir();
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {

        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

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

    private void escribir(){
        try {

            CheckBox tieneAlcoba = findViewById(R.id.tieneAlcoba);
            CheckBox tieneComedor = findViewById(R.id.tieneComedor);
            CheckBox tieneSala = findViewById(R.id.tieneSala);

            EditText ans1 = findViewById(R.id.ans1);
            EditText ans2 = findViewById(R.id.ans2);
            EditText ans3 = findViewById(R.id.ans3);
            EditText ans8 = findViewById(R.id.ans8);
            EditText ans7other = findViewById(R.id.ans7other);
            EditText ans9 = findViewById(R.id.ans9);
            EditText ans10 = findViewById(R.id.ans10);
            EditText ans11 = findViewById(R.id.ans11);
            EditText ans12 = findViewById(R.id.ans12);
            EditText ans13 = findViewById(R.id.ans13);
            EditText ans14 = findViewById(R.id.ans14);
            EditText ans15 = findViewById(R.id.ans15);
            EditText ans16 = findViewById(R.id.ans16);
            EditText ans17other = findViewById(R.id.ans17other);
            EditText ans18other = findViewById(R.id.ans18other);
            EditText ans19 = findViewById(R.id.ans19);

            Spinner ans4 = findViewById(R.id.ans4);
            Spinner ans5 = findViewById(R.id.ans5);
            Spinner ans6 = findViewById(R.id.ans6);
            Spinner ans7 = findViewById(R.id.ans7);
            Spinner ans17 = findViewById(R.id.ans17);
            Spinner ans18 = findViewById(R.id.ans18);

            FileOutputStream fos = new FileOutputStream(myExternalFile,true);

            fos.write("\t".getBytes());
            if(tieneAlcoba.isChecked()){
                fos.write("Sí".getBytes());
            } else {
                fos.write("No".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(ans1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans4.getItemAtPosition(ans4.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans5.getItemAtPosition(ans5.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans6.getItemAtPosition(ans6.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans7.getItemAtPosition(ans7.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans7other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(tieneComedor.isChecked()){
                fos.write("Sí".getBytes());
            } else {
                fos.write("No".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write((ans9.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans10.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans11.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans12.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans13.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans14.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            if(tieneSala.isChecked()){
                fos.write("Sí".getBytes());
            } else {
                fos.write("No".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write((ans15.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans16.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans17.getItemAtPosition(ans17.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write((ans17other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans18.getItemAtPosition(ans18.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write((ans18other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write((ans19.getText().toString()).getBytes());
            fos.write("\t".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
