package miweb;




import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;



@ManagedBean
@ViewScoped
public class ClientesView {

    private static void log( String s) {
        System.out.println( s );
    }
    
    private Cliente _selectedCliente;
    private Cliente _editedCliente;

    
    public static int INVALID_CLIENTE_ID = -1;
    public static int NEW_CLIENTE_ID = 0;
    
    public Cliente getSelectedCliente() {
        if( _selectedCliente == null ){
            return nuevoClienteInvalido();
        }
        return _selectedCliente;
    }

    private Cliente nuevoClienteInvalido() {
        Cliente c = new Cliente();
        c.setIdCliente(INVALID_CLIENTE_ID);
        c.setNombre("");
        c.setApellidos("");
        
        return c;
        
    }

    
    public void setSelectedCliente(Cliente selectedCliente) {
        _selectedCliente = selectedCliente;
        log( "PaginationClientesView: setSelected:" + _selectedCliente );
    }


    public ClientesView() {
        log( "Crean un PaginationClientesView");
    }

    public List<Cliente> getClientes(){
        return MiDAO.todosLosClientes();
    }
	

    public void nuevoClienteAction() {
        log( "nuevoClienteAction" );
        Cliente c = nuevoClienteInvalido();
        c.setIdCliente(NEW_CLIENTE_ID);
        setEditedCliente(c);
    }
    
    public void editarClienteSeleccionadoAction(){
        Cliente c = getSelectedCliente();
        log( "Editar cliente:" + c );
        setEditedCliente(c);
    }
    
    public void borrarClienteSeleccionadoAction(){
        Cliente c = getSelectedCliente();
        log( "Borrar cliente:" + c );
        MiDAO.borraCliente(c);
    }
    
    public void salvarClienteAction(){
        Cliente c = getEditedCliente();
        log( "salvarClienteAction:" + c );
        if( c.getIdCliente() == NEW_CLIENTE_ID ){
            MiDAO.insertaCliente(c);
        }
        else if( c.getIdCliente() == INVALID_CLIENTE_ID ){
            throw new IllegalStateException();
        }
        else{
            MiDAO.actualizaCliente(c);
        }
    }

    public Cliente getEditedCliente() {
        if( _editedCliente == null ){
            return nuevoClienteInvalido();
        }
        return _editedCliente;
    }

    public void setEditedCliente(Cliente editedCliente) {
        log( "PaginationClientesView: setEdited:" + editedCliente );
        
        _editedCliente = editedCliente;
    }
     
}