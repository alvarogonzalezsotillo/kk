
<%
   String nombre = request.getParameter("nombre");
   String apellidos = request.getParameter("apellidos");
   if( nombre != null && apellidos != null ){
       miweb.Cliente c = new miweb.Cliente();
       c.setNombre(nombre);
       c.setApellidos(apellidos);
       miweb.MiDAO.insertaCliente(c);
       %>
       El cliente de nombre <%=nombre%> y apellidos <%=apellidos%> ha sido creado con identificador <%=c.getIdCliente()%>
       <a href="listarCliente.jsp?<%=new java.util.Date()%>">Volver</a>
       <%     
   }
   else{
       %>
       <div id="crear-cliente">
         <h1>Nuevo cliente</h1>
         <form method="post">
               Nombre: <input type="text" name="nombre">
               <p>
               Apellidos: <input type="text" name="apellidos">
               <p>
               <input type="submit">
         </form>
       </div>

       <div id="listar-clientes">
          <table border=1>
            <tr><td>ID</td><td>Nombre</td><td>Apellidos</td></tr>
              
            <%
                  for( miweb.Cliente c: miweb.MiDAO.todosLosClientes() ){
                  %>
                          <tr>
                                  <td><%=c.getIdCliente()%></td>
                                  <td><%=c.getNombre()%></td>
                                  <td><%=c.getApellidos()%></td>
                          </tr>
                  <%
                  }
            %>
          </table>
       </div>
       <%
   }

%>  