/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Postulante;
import Modelo.PostulanteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rseba
 */
public class Controlador extends HttpServlet {
    PostulanteDao dao = new PostulanteDao();
    Postulante p = new Postulante();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
            String accion = request.getParameter("accion");
            switch (accion){
                case "Modo Administrador":
                    List<Postulante> datos = dao.listar();
                    System.out.println("long: "+ datos.size());
                    request.setAttribute("datos", datos);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "Modo Postulante":
                    request.getRequestDispatcher("add.jsp").forward(request, response);
                    break;
                case "Registrarse":
                    String dni = request.getParameter("txtdni");
                    String nombre = request.getParameter("txtnom");
                    String correo = request.getParameter("txtcorreo");
                    String telefono = request.getParameter("txttelefono");
                    String carrera = request.getParameter("txtcarrera");
                    //System.out.println("dni: "+ dni);
                    //System.out.println("nombre: "+ nombre);
                    //System.out.println("correo: "+ correo);
                    //System.out.println("telefono: "+ telefono);
                    //System.out.println("carrera: "+ carrera);
                    
                    p.setDni(dni);
                    p.setNombres(nombre);
                    p.setCarrera(carrera);
                    p.setCorreo(correo);
                    p.setTelefono(telefono);
                    dao.agregar(p);
                    request.getRequestDispatcher("Controlador?accion=Modo Administrador").forward(request, response);
                case "Actualizar":
                    String DNI= request.getParameter("dni");
                    Postulante p = dao.posByDni(DNI);
                    //System.out.println("dni: "+ p.getDni());
                    //System.out.println("carrera: "+ p.getCarrera());
                    //System.out.println("corr: "+ p.getCorreo());
                    //System.out.println("telef: "+ p.getTelefono());
                    //System.out.println("condicion: "+ p.getCondicion());
                    request.setAttribute("postulante", p);
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                    break;
                case "Guardar":
                    String dni1 = request.getParameter("txtdni");
                    String nombre1 = request.getParameter("txtnom");
                    String correo1 = request.getParameter("txtcorreo");
                    String telefono1 = request.getParameter("txttelefono");
                    String carrera1 = request.getParameter("txtcarrera");
                    String condicion = request.getParameter("txtcondicion");
                    System.out.println("dni: "+ dni1);
                    
                    p = new Postulante();
                    p.setDni(dni1);
                    p.setNombres(nombre1);
                    p.setCarrera(carrera1);
                    p.setCorreo(correo1);
                    p.setTelefono(telefono1);
                    p.setCondicion(condicion);
                    
                    dao.actualizar(p);
                    request.getRequestDispatcher("Controlador?accion=Modo Administrador").forward(request, response);
                    break;
                case "Eliminar":
                    String DNI2= request.getParameter("dni");
                    dao.eliminar(DNI2);
                    request.getRequestDispatcher("Controlador?accion=Modo Administrador").forward(request, response);
                    break;
                default:    
                    throw new AssertionError();
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
