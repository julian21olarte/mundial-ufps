/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.controller;

import com.ufps.mundial.dao.equipoDAO.EquipoDAOImpl;
import com.ufps.mundial.dao.jugadorDAO.JugadorDAOImpl;
import com.ufps.mundial.model.Jugador;
import com.ufps.mundial.model.JugadorPK;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian Olarte Torres
 */
@WebServlet(name = "JugadorController", urlPatterns = {"/Jugador"})
public class JugadorController extends HttpServlet {

   private final JugadorDAOImpl jugadorImpl = new JugadorDAOImpl();
   private final EquipoDAOImpl equipoImpl = new EquipoDAOImpl();

   
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("action");
        if(param != null && param.equals("delete")) {
            int equipo = Integer.parseInt(request.getParameter("equipo"));
            int numero = Integer.parseInt(request.getParameter("numero"));
            this.deletePlayer(equipo, numero);
        }
        this.showPlayers(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("action");
        try {
            if(param != null && param.equals("save")) {
                this.insertPlayer(request);
            }
            else if(param != null && param.equals("update")) {
                this.updatePlayer(request);
            }
        } catch (ParseException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.showPlayers(request, response);
    }

    
    /**
     * Show All players
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void showPlayers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jugadores", this.jugadorImpl.findAll());
        request.setAttribute("equipos", this.equipoImpl.findAll());
        request.setAttribute("controller", "Jugador");
        request.getRequestDispatcher("/jugador.jsp").forward(request, response);
    }
    
    /**
     * insert a new Player
     * @param request 
     */
    private void insertPlayer(HttpServletRequest request) throws ParseException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        int equipo = Integer.parseInt(request.getParameter("equipo"));
        Jugador jugador = new Jugador(new JugadorPK(equipo, numero));
        
        jugador.setNombre(request.getParameter("nombre"));
        jugador.setEmail(request.getParameter("email"));
        jugador.setPosicion(request.getParameter("posicion"));
        jugador.setFechanacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")));
        this.jugadorImpl.save(jugador);
    }

    /**
     * Update a Player
     * @param request 
     */
    private void updatePlayer(HttpServletRequest request) throws ParseException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        int equipo = Integer.parseInt(request.getParameter("equipo"));
        Jugador jugador = new Jugador(new JugadorPK(equipo, numero));
        
        jugador.setNombre(request.getParameter("nombre"));
        jugador.setEmail(request.getParameter("email"));
        jugador.setPosicion(request.getParameter("posicion"));
        jugador.setFechanacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")));
        this.jugadorImpl.update(jugador);
    }

    /**
     * Delete a Player
     * @param id 
     */
    private void deletePlayer(int equipo, int numero) {
        this.jugadorImpl.deleteById(new JugadorPK(equipo, numero));
    }

}
