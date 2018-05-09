/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.dao.equipoDAO;

import com.ufps.mundial.model.Equipo;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface EquipoDAO {
    List<Equipo> findAll();
    
    Equipo findById(Integer id);
    
    Equipo save(Equipo jugador);
    
    void delete(Equipo equipo);
    
    void deleteById(Integer id);
    
    Equipo update(Equipo equipo);
}
