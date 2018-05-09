/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Olarte Torres
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByEquipo", query = "SELECT j FROM Jugador j WHERE j.jugadorPK.equipo = :equipo")
    , @NamedQuery(name = "Jugador.findByNumero", query = "SELECT j FROM Jugador j WHERE j.jugadorPK.numero = :numero")
    , @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jugador.findByEmail", query = "SELECT j FROM Jugador j WHERE j.email = :email")
    , @NamedQuery(name = "Jugador.findByPosicion", query = "SELECT j FROM Jugador j WHERE j.posicion = :posicion")
    , @NamedQuery(name = "Jugador.findByFechanacimiento", query = "SELECT j FROM Jugador j WHERE j.fechanacimiento = :fechanacimiento")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JugadorPK jugadorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "posicion")
    private String posicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @JoinColumn(name = "equipo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo1;

    public Jugador() {
    }

    public Jugador(JugadorPK jugadorPK) {
        this.jugadorPK = jugadorPK;
    }

    public Jugador(JugadorPK jugadorPK, String nombre, String email, String posicion, Date fechanacimiento) {
        this.jugadorPK = jugadorPK;
        this.nombre = nombre;
        this.email = email;
        this.posicion = posicion;
        this.fechanacimiento = fechanacimiento;
    }

    public Jugador(int equipo, int numero) {
        this.jugadorPK = new JugadorPK(equipo, numero);
    }

    public JugadorPK getJugadorPK() {
        return jugadorPK;
    }

    public void setJugadorPK(JugadorPK jugadorPK) {
        this.jugadorPK = jugadorPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadorPK != null ? jugadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.jugadorPK == null && other.jugadorPK != null) || (this.jugadorPK != null && !this.jugadorPK.equals(other.jugadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufps.mundial.model.Jugador[ jugadorPK=" + jugadorPK + " ]";
    }
    
}
