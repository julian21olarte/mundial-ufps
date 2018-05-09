/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.dao.jugadorDAO;

import com.ufps.mundial.dao.AbstractDAO;
import com.ufps.mundial.model.Jugador;
import com.ufps.mundial.model.JugadorPK;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public class JugadorDAOImpl extends AbstractDAO implements JugadorDAO {

    public JugadorDAOImpl() {
        super(Jugador.class);
    }

    @Override
    public List<Jugador> findAll() {
        return (List<Jugador>) super.findAll();
    }

    @Override
    public Jugador findById(JugadorPK id) {
        return (Jugador) super.findByKey(id);
    }

    @Override
    public Jugador save(Jugador jugador) {
        super.save(jugador);
        return (Jugador) super.findByKey(jugador.getJugadorPK());
    }

    @Override
    public void delete(Jugador jugador) {
        super.delete(jugador);
    }

    @Override
    public void deleteById(JugadorPK id) {
        super.deleteByKey(id);
    }

    @Override
    public Jugador update(Jugador jugador) {
        return (Jugador) super.update(jugador);
    }
    
}
