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
import java.math.BigDecimal;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "inventario")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdproducto", query = "SELECT i FROM Inventario i WHERE i.idproducto = :idproducto"),
    @NamedQuery(name = "Inventario.findBySku", query = "SELECT i FROM Inventario i WHERE i.sku = :sku"),
    @NamedQuery(name = "Inventario.findByNombreproducto", query = "SELECT i FROM Inventario i WHERE i.nombreproducto = :nombreproducto"),
    @NamedQuery(name = "Inventario.findByDescripcionproducto", query = "SELECT i FROM Inventario i WHERE i.descripcionproducto = :descripcionproducto"),
    @NamedQuery(name = "Inventario.findByCategoriaproducto", query = "SELECT i FROM Inventario i WHERE i.categoriaproducto = :categoriaproducto"),
    @NamedQuery(name = "Inventario.findByPrecioproducto", query = "SELECT i FROM Inventario i WHERE i.precioproducto = :precioproducto"),
    @NamedQuery(name = "Inventario.findByExistenciasproducto", query = "SELECT i FROM Inventario i WHERE i.existenciasproducto = :existenciasproducto")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @Column(name = "SKU")
    private String sku;
    @Basic(optional = false)
    @Column(name = "nombreproducto")
    private String nombreproducto;
    @Basic(optional = false)
    @Column(name = "descripcionproducto")
    private String descripcionproducto;
    @Basic(optional = false)
    @Column(name = "categoriaproducto")
    private String categoriaproducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precioproducto")
    private BigDecimal precioproducto;
    @Basic(optional = false)
    @Column(name = "existenciasproducto")
    private int existenciasproducto;

    public Inventario() {
    }

    public Inventario(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Inventario(Integer idproducto, String sku, String nombreproducto, String descripcionproducto, String categoriaproducto, BigDecimal precioproducto, int existenciasproducto) {
        this.idproducto = idproducto;
        this.sku = sku;
        this.nombreproducto = nombreproducto;
        this.descripcionproducto = descripcionproducto;
        this.categoriaproducto = categoriaproducto;
        this.precioproducto = precioproducto;
        this.existenciasproducto = existenciasproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public String getCategoriaproducto() {
        return categoriaproducto;
    }

    public void setCategoriaproducto(String categoriaproducto) {
        this.categoriaproducto = categoriaproducto;
    }

    public BigDecimal getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(BigDecimal precioproducto) {
        this.precioproducto = precioproducto;
    }

    public int getExistenciasproducto() {
        return existenciasproducto;
    }

    public void setExistenciasproducto(int existenciasproducto) {
        this.existenciasproducto = existenciasproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.AlmacenClase.Entidades.Inventario[ idproducto=" + idproducto + " ]";
    }
    
}
