package miweb;

import javax.persistence.*;

@Entity
public class Cliente{

    private int idCliente;
    
    
    private String nombre;
    private String apellidos;
    
    public void setNombre(String s){
        nombre = s;
    }
    
    public void setApellidos( String s){
        apellidos = s;
    }

    public void setIdCliente(int i){
        idCliente = i;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    public int getIdCliente(){
        return idCliente;
    }
    
    @Column
    public String getNombre(){
        return nombre;
    }

    @Column
    public String getApellidos(){
        return apellidos;
    }
    
    
}