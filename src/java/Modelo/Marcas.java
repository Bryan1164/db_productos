/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Marcas extends Productos { 
   private int id_marca;
   private String marca;
   private Conexion cn;

    public Marcas(int id_marca, String marca) {
        this.id_marca = id_marca;
        this.marca = marca;
    }
     public Marcas(){}

    public Marcas(int id_marca, String marca, int id_producto, String descripcion, int existencia, String producto, float precio_costo, float precio_venta) {
        super(id_producto, id_marca, descripcion, existencia, producto, precio_costo, precio_venta);
        this.id_marca = id_marca;
        this.marca = marca;
    }
     
   
   

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
     String query = "SELECT e.id_Marca as id,e.id_producto,e.producto,e.descripcion,e.precio_costo,e.precio_venta,e.existencia,p.id_marca,p.marca FROM productos as e inner join marcas as p on e.id_Marca = p.id_Marca;";
     ResultSet consulta = cn.coneccionBD.createStatement().executeQuery(query);
     String encabezado[] = {"id,id_producto","producto","descripcion","precio_costo","precio_venta","existencia","marca","id_marca"};
     tabla.setColumnIdentifiers(encabezado);
     String datos[] = new String[9];
     while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("id_producto");
          datos[2] = consulta.getString("producto");
          datos[3] = consulta.getString("descripcion");
          datos[4] = consulta.getString("precio_costo");
          datos[5] = consulta.getString("precio_venta");
          datos[6] = consulta.getString("existencia");
          datos[7] = consulta.getString("marca");
          datos[8] = consulta.getString("id_marca");
          tabla.addRow(datos);
         }
        cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }

   @Override
   public int agregar(){
       int retorno = 0;
   try{
       PreparedStatement parametro;
       cn = new Conexion();
       String query  = "insert into productos(id_producto,producto,descripcion,precio_costo,precio_venta,existencia,id_marca,marca) values(?,?,?,?,?,?,?,?,?,?);";
       cn.abrir_conexion();
       parametro = (PreparedStatement)cn.coneccionBD.prepareStatement(query);
       parametro.setInt(1, getId_producto());
       parametro.setString(2, getProducto());
       parametro.setString(3, getDescripcion());
       parametro.setFloat(4, getPrecio_costo());
       parametro.setFloat(5, getPrecio_venta());
       parametro.setInt(6, getExistencia());
       parametro.setString(7, getMarca());
       parametro.setInt(8, getId_marca());
       retorno = parametro.executeUpdate();
       cn.cerrar_conexion();
       
   }catch(SQLException ex){
   System.out.println(ex.getMessage());
   retorno = 0;
   }
   return retorno;
   }    
    @Override
   public int modificar(){
       int retorno = 0;
   try{
       PreparedStatement parametro;
       cn = new Conexion();
       String query = "update productos set id_producto = ?,producto = ?,descripcion = ?,precio_costo= ?,precio_venta= ?,existencia= ?,marca = ? where id_marca = ?;";
       cn.abrir_conexion();
       parametro = (PreparedStatement)cn.coneccionBD.prepareStatement(query);
       parametro.setInt(1, getId_producto());
       parametro.setString(2, getProducto());
       parametro.setString(3, getDescripcion());
       parametro.setFloat(4, getPrecio_costo());
       parametro.setFloat(5, getPrecio_venta());
       parametro.setInt(6, getExistencia());
       parametro.setString(7, getMarca());
       parametro.setInt(8, getId_marca());
       retorno = parametro.executeUpdate();
       cn.cerrar_conexion();
       
   }catch(SQLException ex){
   System.out.println(ex.getMessage());
   retorno = 0;
   }
   return retorno;
   }    
  
   @Override
   public int eliminar (){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from productos where id_marca = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.coneccionBD.prepareStatement(query);
            parametro.setInt(1, this.getId_marca());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
  return retorno;
   }
    
}
