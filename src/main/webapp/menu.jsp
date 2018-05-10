<%-- 
    Document   : menu
    Created on : 10/05/2018, 12:24:08 PM
    Author     : Julian Olarte Torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="index.jsp">Mundial</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item ${controller.equals("Equipo") ? "active" : ""}">
                    <a class="nav-link" href="Equipo">Equipos</a>
                </li>
                <li class="nav-item ${controller.equals("Jugador") ? "active" : ""}">
                    <a class="nav-link" href="Jugador">Jugadores</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
