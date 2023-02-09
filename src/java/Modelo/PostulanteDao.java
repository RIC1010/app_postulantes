/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rseba
 */
public class PostulanteDao {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    public List listar(){
        List<Postulante> lista = new ArrayList<>();
        String sql ="select * from postulante";
        try{
            con = c.conectar();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Postulante p = new Postulante();
                p.setDni(rs.getString(1));
                p.setNombres(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                p.setCarrera(rs.getString(5));
                p.setCondicion(rs.getString(6));
                lista.add(p);
            }
        }catch(Exception e){
            System.out.println("error: "+ e.getMessage());
        }
        return lista;
    }
    public int agregar(Postulante p){
        int x = 0;
        String sql = "insert into postulante(dni,nombres,correo, telefono, carrera, condicion)values(?,?,?,?,?,?)";
        try{
            con = c.conectar();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombres());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getCarrera());
            ps.setString(6, "POSTULANDO");
            x=ps.executeUpdate();
            if(x==1){
               x =1;
            }else{
               x=0;
            }
        
        }catch(Exception e){
            System.out.println("error: "+ e.getMessage());
           
            
        }
        return x;
    }
    public Postulante posByDni(String dni){
        String sql = "select * from postulante where dni="+ dni;
        Postulante p = new Postulante();
        try{
            con = c.conectar();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                p.setDni(rs.getString(1));
                p.setNombres(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                p.setCarrera(rs.getString(5));
                p.setCondicion(rs.getString(6));
            }
        }catch(Exception e){
            System.out.println("error: "+ e.getMessage());
        }
        return p;
    }
    public int actualizar(Postulante p){
        int x = 0;
        String sql = "update postulante set condicion=? where dni= ?";
        try{
            con = c.conectar();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getCondicion());
            ps.setString(2, p.getDni());
            rs= ps.executeQuery();
            if(x==1){
                x=1;
            }else{
                x=-1;
            }
        }catch(Exception e){
            System.out.println("error: "+ e.getMessage());
        }
        
        return x;
    }
    public void eliminar(String dni){
        String sql= "delete from postulante where dni="+dni;
        try{
            con = c.conectar();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            System.out.println("error: "+ e.getMessage());
        }
    }
}

