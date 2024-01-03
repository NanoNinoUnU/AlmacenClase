/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.AlmacenClase.Entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "salidas")
@NamedQueries({
    @NamedQuery(name = "Salidas.findAll", query = "SELECT s FROM Salidas s"),
    @NamedQuery(name = "Salidas.findById", query = "SELECT s FROM Salidas s WHERE s.id = :id"),
    @NamedQuery(name = "Salidas.findBySku", query = "SELECT s FROM Salidas s WHERE s.sku = :sku"),
    @NamedQuery(name = "Salidas.findByFecha", query = "SELECT s FROM Salidas s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Salidas.findByCantidad", query = "SELECT s FROM Salidas s WHERE s.cantidad = :cantidad")})
public class Salidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sku")
    private String sku;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;

    public Salidas() {
    }

    public Salidas(Integer id) {
        this.id = id;
    }

    public Salidas(Integer id, String sku, String fecha, int cantidad) {
        this.id = id;
        this.sku = sku;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidas)) {
            return false;
        }
        Salidas other = (Salidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.AlmacenClase.Entidades.Salidas[ id=" + id + " ]";
    }
    
}
