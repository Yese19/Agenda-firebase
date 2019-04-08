package com.example.contactagenda;

public class Contact {

    private String id;
    private String name;
    private String lastName;
    private String phone;
    private String cellphone;

    public Contact() {

    }

    public Contact(String id, String name, String lastName, String phone, String cellphone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.cellphone = cellphone;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }




    public void SaveContact(){ Data.Save(this);}

}
