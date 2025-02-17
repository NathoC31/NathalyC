/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp.Modelo;
/**
 * UNIVERSIDAD DE LAS FUERZAS ARMADAS - ESPE
 * DEPARTAMENTO DE CIENCIAS DE LA COMPUTACIÓN
 * ASIGNATURA: PROGRAMACIÓN ORIENTADO A OBJETOS
 * DOCENTE: MGRT. JARAMILLO L.
 * TEMA: TRABAJO PRÁCTICO
 * INTEGRANTES: 
 *  GRANADA DAVID
 * 
 */
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int inventario;
    
    // constructor vacio
    public Producto() {
        
    }

    // constructor agregar
    public Producto(String id, String nombre, double precio, int inventario) {
        this.id=id;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
      
    //getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }   
}