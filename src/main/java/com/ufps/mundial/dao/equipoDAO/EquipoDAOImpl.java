/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.dao.equipoDAO;

import com.ufps.mundial.dao.AbstractDAO;
import com.ufps.mundial.model.Equipo;
import com.ufps.mundial.model.Jugador;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public class EquipoDAOImpl extends AbstractDAO implements EquipoDAO {

    public EquipoDAOImpl() {
        super(Jugador.class);
    }

    @Override
    public List<Equipo> findAll() {
        return (List<Equipo>) super.findAll();
    }

    @Override
    public Equipo findById(Integer id) {
        return (Equipo) super.findByKey(id);
    }

    @Override
    public Equipo save(Equipo equipo) {
        super.save(equipo);
        return (Equipo) super.findByKey(equipo.getId());
    }

    @Override
    public void delete(Equipo equipo) {
        super.delete(equipo);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Override
    public Equipo update(Equipo equipo) {
        return (Equipo) super.update(equipo);
    }
    
}
