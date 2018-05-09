/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.dao.jugadorDAO;

import com.ufps.mundial.model.Jugador;
import com.ufps.mundial.model.JugadorPK;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface JugadorDAO {
    List<Jugador> findAll();
    
    Jugador findById(JugadorPK id);
    
    Jugador save(Jugador jugador);
    
    void delete(Jugador jugador);
    
    void deleteById(JugadorPK id);
    
    Jugador update(Jugador jugador);
}
