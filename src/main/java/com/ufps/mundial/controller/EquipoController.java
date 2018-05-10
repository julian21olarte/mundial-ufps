/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufps.mundial.controller;

import com.ufps.mundial.dao.equipoDAO.EquipoDAOImpl;
import com.ufps.mundial.model.Equipo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian Olarte Torres
 */
@WebServlet(name = "EquipoController", urlPatterns = {"/Equipo"})
public class EquipoController extends HttpServlet {

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
            this.deleteTeam(Integer.parseInt(request.getParameter("id")));
        }
        this.showTeams(request, response);
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
        if(param != null && param.equals("save")) {
            this.insertTeam(request);
        }
        else if(param != null && param.equals("update")) {
            this.updateTeam(request);
        }
        this.showTeams(request, response);
    }

    
    /**
     * Show All teams
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void showTeams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equipo> equipos = this.equipoImpl.findAll();
        request.setAttribute("equipos", equipos);
        request.setAttribute("controller", "Equipo");
        request.getRequestDispatcher("/equipo.jsp").forward(request, response);
    }
    
    /**
     * insert a new Team
     * @param request 
     */
    private void insertTeam(HttpServletRequest request) {
        Equipo equipo = new Equipo();
        equipo.setNombre(request.getParameter("nombre"));
        equipo.setPresidente(request.getParameter("presidente"));
        this.equipoImpl.save(equipo);
    }

    /**
     * Update a Team
     * @param request 
     */
    private void updateTeam(HttpServletRequest request) {
        Equipo equipo = new Equipo();
        equipo.setId(Integer.parseInt(request.getParameter("id")));
        equipo.setNombre(request.getParameter("nombre"));
        equipo.setPresidente(request.getParameter("presidente"));
        this.equipoImpl.update(equipo);
    }

    /**
     * Delete a Team
     * @param id 
     */
    private void deleteTeam(int id) {
        this.equipoImpl.deleteById(id);
    }

}
