package com.example.juanesteban.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edt1, edt2, edt3, edt4;
    Button bGuardar;
    String nombre, Contraseña, Con_contraseña, Correo, Perfil, Sexo, Pais, Dia, Mes,Año,hobbies="",hobbies_1="";
    CheckBox check_1, check_2, check_3;
    TextView Texto;
    DatePicker Fecha_Nacimiento;
    Spinner spinner;
    ArrayList<String> Hobbies = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        bGuardar = findViewById(R.id.bGuardar);
        check_1 = findViewById(R.id.check_1);
        check_2 = findViewById(R.id.check_2);
        check_3 = findViewById(R.id.check_3);
        Texto = findViewById(R.id.Texto);
        spinner =  findViewById(R.id.spinner);
        Fecha_Nacimiento = findViewById(R.id.Fecha_Nacimiento);

             // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Pais_origen, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        Pais = parent.getItemAtPosition(i).toString();
        //Toast.makeText(parent.getContext(),CharSequence , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void OnClickSave(View view) {

        int id = view.getId();

        if (id == R.id.bGuardar) {
            nombre = edt1.getText().toString();
            edt1.setText(nombre);
            Correo = edt2.getText().toString();
            edt2.setText(Correo);
            Contraseña = edt3.getText().toString();
            edt3.setText(Contraseña);
            Con_contraseña = edt4.getText().toString();
            edt4.setText(Con_contraseña);

            int day = Fecha_Nacimiento.getDayOfMonth();
            int month = Fecha_Nacimiento.getMonth() + 1;
            int year = Fecha_Nacimiento.getYear();

            Dia = Integer.toString(day);
            Mes = Integer.toString(month);
            Año = Integer.toString(year);


            String idList = Hobbies.toString();
            hobbies = idList.substring(1, idList.length() - 1).replace(", ", ",");


            if (nombre.equals("") || Correo.equals("") || Contraseña.equals("") || Con_contraseña.equals("")) {
                Texto.setText("Faltan espacios por llenar");
                return;
            }


            if (Contraseña.equals(Con_contraseña)) {
                Perfil = "Login:" + nombre + "\n" + "Correo: " + Correo + "\n" + "Password :" + Contraseña + "\n" + Sexo + "\n" + "Hobbies: " + hobbies + "\n" + "Fecha de Nacimiento:" + Dia + "/" + Mes + "/" + Año + "\n" + "Pais: " + Pais + "\n";
                Texto.setText(Perfil);
            } else {
                Texto.setText("Las contraseñas no coinciden");
                return;
            }


        }
    }



    public void RadioGroup(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.sMasculino:
                  Sexo = "Sexo:Masculino";
                break;
            case R.id.sFemenino:
                   Sexo = "Sexo:Femenino";
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.check_1:
                if (checked) {
                    Hobbies.add("Cine");
                } else {
                    Hobbies.remove("Cine");
                }
                break;
            case R.id.check_2:
                if (checked) {
                    Hobbies.add("Nadar");
                } else {
                    Hobbies.remove("Nadar");
                }
                break;
            case R.id.check_3:
                if (checked) {
                    Hobbies.add("Correr");
                } else {
                    Hobbies.remove("Correr");
                }
                break;
            case R.id.check_4:
                if (checked) {
                    Hobbies.add("Leer");
                } else {
                    Hobbies.remove("Leer");
                }
                break;

        }


    }

}



