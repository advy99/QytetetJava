/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author antonio
 */
public class Calle extends Casilla{
    private TituloPropiedad titulo;
    
    
    Calle(int numeroCasilla, TituloPropiedad titulo){
        super(numeroCasilla, titulo.getPrecioCompra());
        setTitulo(titulo);

    }
    
    
    public void asignarPropietario(Jugador jugador){
        titulo.setPropietario(jugador);
        
    }
    
    protected TipoCasilla getTipo(){
        return TipoCasilla.CALLE;
    }
    
    protected TituloPropiedad getTitulo(){
        return titulo;
        
    }
    
    public int pagarAlquiler(){
        int costeAlquiler = titulo.pagarAlquiler();
        
        return costeAlquiler;
    }
    
    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    protected boolean soyEdificable(){
        return true;
    }
    
    public boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
    
    @Override
    public String toString(){
        
        String texto = "";
        
        texto += "Numero de casilla: " + getNumeroCasilla() + "\n" +
                 "Tipo de casilla: " + getTipo() + "\n" +
                 "Coste: " + getCoste() + "\n ";
        
        texto += titulo.toString();
     
        return texto;
    }
}
