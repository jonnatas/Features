package com.example.recyclerview;

public class Contact {
    private String nome;
    private String phone;
    private int photo;

    public Contact(String nome, String phone, int photo) {
        this.nome = nome;
        this.phone = phone;
        this.photo = photo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
