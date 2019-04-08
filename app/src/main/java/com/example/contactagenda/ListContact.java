package com.example.contactagenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListContact extends AppCompatActivity {
    private ListView LV;
    private ArrayList<Contact> Contacts = new ArrayList<>();
    private ArrayList<String> ContactNames;
    private Intent In;
    private TextView TxtNoResults;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        LV = (ListView)findViewById(R.id.LVContacts);
        TxtNoResults = (TextView)findViewById(R.id.TxtNoResult);
        ContactNames = new ArrayList<String>();
        ref = database.getReference("contacts");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                           Contact contact = snap.getValue(Contact.class);
                    Contacts.add(contact);
                    Data.Save(contact);

                }


                TxtNoResults.setVisibility(View.VISIBLE);
                LV.setVisibility(View.INVISIBLE);

                if (Contacts.size() > 0){
                    LV.setVisibility(View.VISIBLE);
                    TxtNoResults.setVisibility(View.INVISIBLE);

                    for (Contact contact2:  Contacts){
                        ContactNames.add(contact2.getName() + " " + contact2.getLastName());
                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, ContactNames);
                LV.setAdapter(adapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });







        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                In = new Intent(ListContact.this, ContactDetail.class);
                In.putExtra("position", position);
                startActivity(In);
            }
        });
    }





}
