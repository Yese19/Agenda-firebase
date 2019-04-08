package com.example.contactagenda;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Contact> Contacts = new ArrayList<>();
    public static void Save(Contact c){ Contacts.add(c);}
    public static ArrayList<Contact> Get(){return Contacts;}
}

