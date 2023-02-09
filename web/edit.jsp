<%-- 
    Document   : edit
    Created on : 09/02/2023, 08:24:09 AM
    Author     : rseba
--%>

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
            <h3>Registro de postulación</h3>
        </div>
        <hr>
        <div>
            <form action="Controlador" method="POST">
                DNI:<br>
                <input type="text" name="txtdni" value="${postulante.getDni()}" readonly><br>
                NOMBRES:<br>
                <input type="text" name="txtnom" value="${postulante.getNombres()}" readonly><br>
                CORREO:<br>
                <input type="text" name="txtcorreo" value="${postulante.getCorreo()}"readonly><br>
                TELEFONO:<br>
                <input type="text" name="txttelefono" value="${postulante.getTelefono()}" readonly><br>
                CARRERA:<br>
                <input type="text" name="txtcarrera" value="${postulante.getCarrera()}" readonly><br>
                CONDICION:<br>
                <input type="text" name="txtcondicion" value="${postulante.getCondicion()}"><br><br>
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
    </body>
</html>
