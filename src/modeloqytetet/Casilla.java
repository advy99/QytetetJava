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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean soyEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
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
