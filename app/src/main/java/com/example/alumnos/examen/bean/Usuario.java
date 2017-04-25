package com.example.alumnos.examen.bean;

/**
 * Created by Alumnos on 25/04/2017.
 */

public class Usuario {

    private int id;
    private String name;
    private String lastNames;
    private String usuario;
    private String clave;



    public Usuario(){}

    public Usuario(int id, String name, String lastNames, String usuario, String clave) {
        this.id = id;
        this.name = name;
        this.lastNames = lastNames;
        this.usuario = usuario ;
        this.clave = clave;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return name + " " + lastNames +" " + usuario+" - "+clave  ;
    }

}
