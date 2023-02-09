<%-- 
    Document   : index
    Created on : 09/02/2023, 01:55:03 AM
    Author     : rseba
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div>
            <h3>PLATAFORMA CENTRAL DE ADMISION</h3>
            <br>
            <form action="Controlador" method="POST">
                <input type="submit" name="accion" value="Modo Administrador">
                <input type="submit" name="accion" value="Modo Postulante">
            </form>
        </div>
        <br>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>CORREO</th>
                        <th>TELEFONO</th>
                        <th>CARRERA</th>
                        <th>CONDICION</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "dato" items= "${datos}">
                        <tr>
                            <td>${dato.getDni()}</td>
                            <td>${dato.getNombres()}</td>
                            <td>${dato.getCorreo()}</td>
                            <td>${dato.getTelefono()}</td>
                            <td>${dato.getCarrera()}</td>
                            <td>${dato.getCondicion()}</td>
                            <td>
                                <form action="Controlador" method="POST">
                                    <input type="hidden" name="dni" value="${dato.getDni()}">
                                    <input type="submit" name ="accion" value="Actualizar">
                                    <input type="submit" name="accion" value="Eliminar">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </center>
    </body>
</html>
