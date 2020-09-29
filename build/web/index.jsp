<%-- 
    Document   : index
    Created on : 18/09/2020, 01:47:48 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Marcas" %>
<%@page import="Modelo.Productos" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.swing.table.DefaultTableModel" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Formulario Productos</h1>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <form action="sr_productos" method="post" class="form-group">
                <label for="lbl_id_producto" ><b>ID PRODUCTO</b></label>
                <input type="text" name="txt_id_producto" id="txt_id_producto" class="form-control" value="0"  readonly>
                <label for="lbl_producto" ><b>Producto</b></label>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Ejemplo: Television" required>
                <label for="lbl_descripcion" ><b>Descripcion</b></label>
                <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Ejemplo: Tecnologia.." required>
                <label for="lbl_precio_costo" ><b>Precio Costo</b></label>
                <input type="number" name="txt_precio_costo" id="txt_precio_costo" class="form-control" placeholder="Ejemplo: 25.00" required>
                <label for="lbl_precio_venta" ><b>Precio Venta</b></label>
                <input type="number"  name="txt_precio_venta" id="txt_precio_venta" class="form-control" placeholder="Ejemplo: 45.00" required>
                <label for="lbl_existencia" ><b>Existencia</b></label>
                <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="Ejemplo: 10" required>
                <label for="lbl_id_marca" ><b>Id Marca</b></label>
                <input type="text"  name="txt_id_marca" id="txt_id_marca" class="form-control" placeholder="Ejemplo: 2"  required>
                <label for="lbl_marca" ><b>Marca</b></label>
                <select name="drop_marca id="drop_marca" class="form-control">
                    <% 
                         Productos productos = new Productos();
                        HashMap<String,String> drop = productos.drop_sangre();
                         for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                         
                        %>
                </select>
                <button name="<br>btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-success btn-lg">Modificar</button>
                <button name="btn_eliminar" id="btn_modificar"  value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
                </form>
        </div>
      </div>  
    </div>
   <table class="table table-striped">
    <thead>
      <tr>
        <th>Producto</th>
        <th>Descripcion</th>
        <th>Precio Costo</th>
        <th>Precio Venta</th>
        <th>Existencia</th>
         <th>id Marca</th>
        <th>Marca</th>
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <% 
        Marcas marcas = new Marcas();
        DefaultTableModel tabla = new DefaultTableModel();  
        tabla = marcas.leer();
        for (int t=0; t<tabla.getRowCount(); t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + "data-id_marca=" + tabla.getValueAt(t,7) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
            out.println("</tr>");
        }
        %>
     </tbody>
    </table>
  </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
