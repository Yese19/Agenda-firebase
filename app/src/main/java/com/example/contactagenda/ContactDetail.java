package com.example.contactagenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactDetail extends AppCompatActivity {
    private Intent In;
    private ArrayList<Contact> Contacts;
    private TextView Name, Phone, Cellphone;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        In = getIntent();
        Contacts = Data.Get();

        int Position = In.getIntExtra("position", 0);

        Name = (TextView)findViewById(R.id.TxtContactName);
        Phone = (TextView)findViewById(R.id.TxtPhone);
        Cellphone = (TextView)findViewById(R.id.TxtCellphone);

        loadData(Contacts.get(Position));
    }

    private void loadData(Contact Contact){
        Name.setText(Contact.getName() + " " + Contact.getLastName());
        Phone.setText(Contact.getPhone());
        Cellphone.setText(Contact.getCellphone());
    }
}
