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
    
    public Casilla(int numeroCasilla, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = TipoCasilla.CALLE;
        setTitulo(titulo);
        this.coste = this.titulo.getPrecioCompra();

    }
    
    public Casilla(int numeroCasilla, int n_coste, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = n_coste;
        this.titulo = null;
    }
    
    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
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
