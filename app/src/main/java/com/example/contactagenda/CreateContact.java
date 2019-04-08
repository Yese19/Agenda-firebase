package com.example.contactagenda;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CreateContact extends AppCompatActivity {
    private EditText Name, LastName, Phone, Cellphone;
    private Resources Resources;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate (Bundle SavedInstaceState){
        super.onCreate(SavedInstaceState);
        setContentView(R.layout.create_contact);

        Name = (EditText)findViewById(R.id.TxtName);
        LastName = (EditText)findViewById(R.id.TxtLasName);
        Phone = (EditText)findViewById(R.id.TxtPhone);
        Cellphone = (EditText)findViewById(R.id.TxtCellphone);

        Resources = this.getResources();
        contacts = Data.Get();

    }

    public void Save(View View){
        String  id, nameV, lastNameV, phoneV, cellphoneV;
        id = (String.valueOf(contacts.size()+1));
        nameV = Name.getText().toString();
        lastNameV = LastName.getText().toString();
        phoneV = Phone.getText().toString();
        cellphoneV = Cellphone.getText().toString();

        if (!id.equals("") && !lastNameV.equals("")&& !phoneV.equals("") && !cellphoneV.equals("")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("contacts");
            Contact C = new Contact(id, nameV, lastNameV, phoneV, cellphoneV);


            myRef.child(nameV + " " + lastNameV).setValue(C);
            Toast.makeText(this, R.string.done, Toast.LENGTH_LONG).show();
            clear();

        }
        else{
            Toast.makeText(this, R.string.fiel_empty,Toast.LENGTH_LONG).show();
        }



    }


    public void clear(){
        Name.setText("");
        LastName.setText("");
        Phone.setText("");
        Cellphone.setText("");

    }
}


