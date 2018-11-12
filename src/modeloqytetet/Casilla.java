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
public class Casilla {
    
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    Casilla(int numeroCasilla, TituloPropiedad titulo){
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
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getNumeroCasilla() {
        return numeroCasilla;
    }

    int getCoste() {
        return coste;
    }

    TipoCasilla getTipo() {
        return tipo;
    }

    TituloPropiedad getTitulo() {
        return titulo;  
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    int pagarAlquiler(){
        int costeAlquiler = pagarAlquiler();
        
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado(){
        boolean lo_esta = false;
        
        if(titulo != null)
            lo_esta = titulo.propietarioEncarcelado();
        
        return lo_esta;
    }
    
    boolean soyEdificable(){
        return tipo == TipoCasilla.CALLE;
    }
    
    boolean tengoPropietario(){
        boolean lo_tengo = false;
        
        if(titulo != null)
            lo_tengo = titulo.tengoPropietario();
        
        return lo_tengo;
    }
    
    
    @Override
    public String toString(){
        
        String texto = "";
        
        texto += "Numero de casilla: " + numeroCasilla + "\n" +
                 "Tipo de casilla: " + tipo + "\n" +
                 "Coste: " + coste + "\n ";
        
        if (tipo == TipoCasilla.CALLE && titulo != null){
            texto += titulo.toString();
        }
     
        return texto;
    }
    
    
}
