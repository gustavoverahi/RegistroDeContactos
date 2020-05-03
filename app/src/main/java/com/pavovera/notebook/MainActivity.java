package com.pavovera.notebook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText fullNameTxt,
            phoneNumberTxt, emailTxt, descriptionUserTxt;

    private TextView txtBirthDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    private String userName, birth, phone, email, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Enlazando los InputTextEditTex con el codigo Java
        fullNameTxt = findViewById(R.id.inputTxtFullName);
        txtBirthDate = findViewById(R.id.inputTxtBirthDate);
        phoneNumberTxt = findViewById(R.id.inputTxtTelephone);
        emailTxt = findViewById(R.id.inputTxtEmail);
        descriptionUserTxt = findViewById(R.id.inputTxtDescription);

        //Enlazando el Button con el codigo java
        Button nextBtn = findViewById(R.id.nextBtn);

        final User user = new User(userName, birth, phone, email, description);


        //Metodo donde abre una pequeña ventana para seleccionar fecha
        txtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener, year, month, day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;

                String date = dayOfMonth + "/" + month + "/" + year;
                txtBirthDate.setText(date);
            }
        };

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFullName(fullNameTxt.getText().toString());
                user.setBirthDate(txtBirthDate.getText().toString());
                user.setPhoneNumber(phoneNumberTxt.getText().toString());
                user.setEmail(emailTxt.getText().toString());
                user.setDescriptionUser(descriptionUserTxt.getText().toString());

                Intent intent = new Intent(MainActivity.this, ConfirmDataUser.class);

                intent.putExtra(getResources().getString(R.string.input_nombre), user.getFullName());
                intent.putExtra(getResources().getString(R.string.select_date), user.getBirthDate());
                intent.putExtra(getResources().getString(R.string.telephone), user.getPhoneNumber());
                intent.putExtra(getResources().getString(R.string.email), user.getEmail());
                intent.putExtra(getResources().getString(R.string.description_user), user.getDescriptionUser());
                startActivity(intent);
            }
        });
    }
}
