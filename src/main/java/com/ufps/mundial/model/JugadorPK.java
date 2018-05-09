/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Julian Olarte Torres
 */
@Embeddable
public class JugadorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "equipo")
    private int equipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;

    public JugadorPK() {
    }

    public JugadorPK(int equipo, int numero) {
        this.equipo = equipo;
        this.numero = numero;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) equipo;
        hash += (int) numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorPK)) {
            return false;
        }
        JugadorPK other = (JugadorPK) object;
        if (this.equipo != other.equipo) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufps.mundial.model.JugadorPK[ equipo=" + equipo + ", numero=" + numero + " ]";
    }
    
}
