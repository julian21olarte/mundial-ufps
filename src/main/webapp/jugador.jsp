<%-- 
    Document   : jugador.jsp
    Created on : 9/05/2018, 07:56:44 AM
    Author     : Julian Olarte Torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <title>Jugadores</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Jugador</h1>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <form action="Jugador?action=save" method="post">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="email" placeholder="Email" name="email">
                                </div>
                                <div class="form-group">
                                    <label for="equipo">Equipo</label>
                                    <select class="custom-select" id="equipo" name="equipo">
                                        <c:forEach items="${equipos}" var="equipo">
                                            <option selected value="${equipo.getId()}">${equipo.getId()} - ${equipo.getNombre()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="posicion">Posicion</label>
                                    <select class="custom-select" id="posicion" name="posicion">
                                        <option selected value="Arquero">Arquero</option>
                                        <option selected value="Delantero">Delantero</option>
                                        <option selected value="Centrocampista">Centrocampista</option>
                                        <option selected value="Defensa">Defensa</option>
                                        <option selected value="Lateral">Lateral</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="fecha">Fecha de nacimiento</label>
                                    <input type="date" class="form-control" id="fecha" placeholder="Fecha" name="fecha">
                                </div>
                                <div class="form-group">
                                    <label for="numero">Numero</label>
                                    <input type="text" class="form-control" id="numero" placeholder="Numero" name="numero">
                                </div>
                            </div>
                            <div class="col-12">
                                <input type="submit" value="registrar" class="btn btnf btn-primary float-right">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row mt-5">
                <div class="col-12">
                    <h4 class="text-primary">Todos los jugadores</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    Nombre
                                </th>                                     
                                <th>
                                    Email
                                </th>                                     
                                <th>
                                    Fecha de nac.
                                </th>                                     
                                <th>
                                    Numero
                                </th>                                     
                                <th>
                                    Equipo
                                </th>                                     
                                <th>
                                    Posicion
                                </th>                                     
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${jugadores}" var="jugador">
                                <tr>
                                    <td>
                                        ${jugador.getNombre()}
                                    </td>
                                    <td>
                                        <c:out value = "${jugador.getEmail()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${jugador.getFechanacimiento()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${jugador.getJugadorPK().getNumero()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${jugador.getEquipo1().getNombre()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${jugador.getPosicion()}"/>
                                    </td>
                                    <td>
                                        <a href="Jugador?action=delete&equipo=${jugador.getJugadorPK().getEquipo()}&numero=${jugador.getJugadorPK().getNumero()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${jugador.getJugadorPK().getEquipo()}-${jugador.getJugadorPK().getNumero()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${jugador.getJugadorPK().getEquipo()}-${jugador.getJugadorPK().getNumero()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Equipo ${equipo.getId()} - ${equipo.getNombre()}</p>

                                                        <form action="Jugador?action=update" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="nombre">Nombre</label>
                                                                        <input type="text" value="${jugador.getNombre()}" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="email">Email</label>
                                                                        <input type="email" value="${jugador.getEmail()}" class="form-control" id="email" placeholder="Email" name="email">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="equipo">Equipo</label>
                                                                        <input type="text" value="${jugador.getEquipo1().getNombre()}" readonly class="form-control" id="equipo" placeholder="Equipo" name="equipo">
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="posicion">Posicion</label>
                                                                        <select class="custom-select" id="posicion" name="posicion">
                                                                            <option selected="${jugador.getPosicion().equals("Arquero") ? selected : false}" value="Arquero">Arquero</option>
                                                                            <option selected="${jugador.getPosicion().equals("Delantero") ? selected : false}" value="Delantero">Delantero</option>
                                                                            <option selected="${jugador.getPosicion().equals("Centrocampista") ? selected : false}" value="Centrocampista">Centrocampista</option>
                                                                            <option selected="${jugador.getPosicion().equals("Defensa") ? selected : false}" value="Defensa">Defensa</option>
                                                                            <option selected="${jugador.getPosicion().equals("Lateral") ? selected : false}" value="Lateral">Lateral</option>
                                                                        </select>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="fecha">Fecha de nacimiento</label>
                                                                        <input type="date" value="${jugador.getFechanacimiento}" class="form-control" id="fecha" placeholder="Fecha" name="fecha">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="numero">Numero</label>
                                                                        <input type="text" value="${jugador.getJugadorPK().getNumero()}" class="form-control" id="numero" placeholder="Numero" name="numero">
                                                                    </div>
                                                                </div>
                                                                <div class="col-12">
                                                                    <input type="submit" value="registrar" class="btn btnf btn-primary float-right">
                                                                </div>
                                                            </div>
                                                        </form>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    </body>
</html>