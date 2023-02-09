<%-- 
    Document   : add
    Created on : 09/02/2023, 03:15:56 AM
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
            <h3>Registro a examen regular 2023</h3>
        </div>
        <hr>
        <div>
            <form action="Controlador" method="POST">
                DNI:<br>
                <input type="text" name="txtdni"><br>
                NOMBRES:<br>
                <input type="text" name="txtnom"><br>
                CORREO:<br>
                <input type="email" name="txtcorreo"><br>
                TELEFONO:<br>
                <input type="text" name="txttelefono"><br>
                CARRERA:<br>
                <input type="text" name="txtcarrera"><br><br>
                <input type="submit" name="accion" value="Registrarse">
            </form>
        </div>
    </center>
    </body>
</html>
