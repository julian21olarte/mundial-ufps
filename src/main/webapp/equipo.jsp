<%-- 
    Document   : equipo.jsp
    Created on : 9/05/2018, 07:56:15 AM
    Author     : Julian Olarte Torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <title>Equipos</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Equipo</h1>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <form action="Equipo?action=save" method="post">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="presidente">Presidente</label>
                                    <input type="text" class="form-control" id="presidente" placeholder="Presidente" name="presidente">
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
                    <h4 class="text-primary">Todos los equipos</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    Id
                                </th>
                                <th>
                                    Nombre
                                </th>                                     
                                <th>
                                    Presidente
                                </th>                                     
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${equipos}" var="equipo">
                                <tr>
                                    <td>
                                        ${equipo.getId()}
                                    </td>
                                    <td>
                                        ${equipo.getNombre()}
                                    </td>
                                    <td>
                                        <c:out value = "${equipo.getPresidente()}"/>
                                    </td>
                                    <td>
                                        <a href="Equipo?action=delete&id=${equipo.getId()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${equipo.getId()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${equipo.getId()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Equipo ${equipo.getId()} - ${equipo.getNombre()}</p>

                                                        <form action="Equipo?action=update" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="id">Id</label>
                                                                        <input type="text" value=${equipo.getId()} class="form-control" id="id" placeholder="Id" name="id" readonly="readonly">
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="nombre">Nombre</label>
                                                                        <input type="text" value="${equipo.getNombre()}" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                                                                    </div>

                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="presidente">Presidente</label>
                                                                        <input type="text" class="form-control"value="${equipo.getPresidente()}" id="presidente" placeholder="Presidente" name="presidente">
                                                                    </div>

                                                                </div>

                                                                <div class="col-4 offset-4">
                                                                    <input type="submit" value="Editar" class="btn btnf btn-primary">
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