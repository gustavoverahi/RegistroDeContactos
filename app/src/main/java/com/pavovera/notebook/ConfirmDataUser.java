package com.pavovera.notebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ConfirmDataUser extends AppCompatActivity {

    private TextInputEditText fullNameTxt, phoneNumberTxt,
            emailTxt, descriptionUserTxt;
    private TextView txtBirthDate;

    private String name, birth, phone, email, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_data_user);

        TextView fullNameUser = (TextView) findViewById(R.id.userNameContact);
        TextView birthDateUser = (TextView) findViewById(R.id.birthDateUser);
        TextView phoneNumberUser = (TextView) findViewById(R.id.phoneUser);
        TextView emailUser = (TextView) findViewById(R.id.emailUser);
        TextView descriptionUser = (TextView) findViewById(R.id.descriptionUser);

        Button btnEditData = (Button) findViewById(R.id.editDatabtn);

        fullNameTxt = (TextInputEditText) findViewById(R.id.inputTxtFullName);
        txtBirthDate = (TextView) findViewById(R.id.inputTxtBirthDate);
        phoneNumberTxt = (TextInputEditText) findViewById(R.id.inputTxtTelephone);
        emailTxt = (TextInputEditText) findViewById(R.id.inputTxtEmail);
        descriptionUserTxt = (TextInputEditText) findViewById(R.id.inputTxtDescription);

        final User user = new User(name, birth, phone, email, description);

        Bundle params = getIntent().getExtras();

        user.setFullName(params.getString(getResources().getString(R.string.input_nombre)));
        user.setBirthDate(params.getString(getResources().getString(R.string.select_date)));
        user.setPhoneNumber(params.getString(getResources().getString(R.string.telephone)));
        user.setEmail(params.getString(getResources().getString(R.string.email)));
        user.setDescriptionUser(params.getString(getResources().getString(R.string.description_user)));

        fullNameUser.setText(user.getFullName());
        birthDateUser.setText(user.getBirthDate());
        phoneNumberUser.setText(user.getPhoneNumber());
        emailUser.setText(user.getEmail());
        descriptionUser.setText(user.getDescriptionUser());


        btnEditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmDataUser.this, MainActivity.class);
                user.setFullName(fullNameTxt.getText().toString());
                user.setBirthDate(txtBirthDate.getText().toString());
                user.setPhoneNumber(phoneNumberTxt.getText().toString());
                user.setEmail(emailTxt.getText().toString());
                user.setDescriptionUser(descriptionUserTxt.getText().toString());

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
