/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author USUARIO
 */
public class Productos { 
    private int id_producto,id_marca,existencia;
    String producto;
    private String descripcion;
    private float precio_costo,precio_venta;
    Conexion cn;
     public Productos(){};
     public Productos(int id_producto, int id_marca, String descripcion, int existencia, String producto, float precio_costo, float precio_venta) {
        this.id_producto = id_producto;
        this.id_marca = id_marca;
        this.existencia = existencia;
        this.producto = producto;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.descripcion = descripcion;
    }

    public Productos(Integer valueOf, Integer valueOf0, String parameter, String parameter0, String parameter1, String parameter2, String parameter3, String parameter4, String parameter5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Productos(Integer valueOf, Integer valueOf0, String parameter, String parameter0, String parameter1, String parameter2, String parameter3, String parameter4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
        
    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public HashMap drop_sangre(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="Select id_Marca as id,marca from marcas;";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.coneccionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("marca") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
}
