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
public abstract class Casilla {
    
    private int numeroCasilla;
    private int coste;
    //private TipoCasilla tipo;
    
    /*Casilla(int numeroCasilla, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = TipoCasilla.CALLE;
        setTitulo(titulo);
        this.coste = this.titulo.getPrecioCompra();

    }
    
    Casilla(int numeroCasilla, int n_coste, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = n_coste;
        this.titulo = null;
    }*/
    
    Casilla (int numeroCasilla, int coste){
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
    }
    
    
    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    int getCoste() {
        return coste;
    }

    protected abstract TipoCasilla getTipo();

    protected abstract TituloPropiedad getTitulo(); /*{
        return titulo;  
    }*/

  
    /*int pagarAlquiler(){
        int costeAlquiler = titulo.pagarAlquiler();
        
        return costeAlquiler;
    }*/
    
    /*boolean propietarioEncarcelado(){
        boolean lo_esta = false;
        
        if(titulo != null)
            lo_esta = titulo.propietarioEncarcelado();
        
        return lo_esta;
    }*/
    
    public void setCoste(int coste){
        this.coste = coste;
    }
    
    protected abstract boolean soyEdificable();
    
    /*boolean tengoPropietario(){
        boolean lo_tengo = false;
        
        if(titulo != null)
            lo_tengo = titulo.tengoPropietario();
        
        return lo_tengo;
    }*/
    
    
    /*@Override
    public String toString(){
        
        String texto = "";
        
        texto += "Numero de casilla: " + numeroCasilla + "\n" +
                 "Tipo de casilla: " + tipo + "\n" +
                 "Coste: " + coste + "\n ";
        
        if (tipo == TipoCasilla.CALLE && titulo != null){
            texto += titulo.toString();
        }
     
        return texto;
    }*/
    
    
}
