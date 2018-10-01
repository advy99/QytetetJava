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
    private int precioCompra;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    public Casilla(int numeroCasilla, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = TipoCasilla.CALLE;
        setTitulo(titulo);
        this.precioCompra = this.titulo.getPrecioCompra();

    }
    
    public Casilla(int numeroCasilla, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        precioCompra = 0;
        this.titulo = null;
        
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getPrecioCompra() {
        return precioCompra;
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
                 "Tipo de casilla: " + tipo + "\n";
        
        if (tipo == TipoCasilla.CALLE){
            texto += "Precio de compra: " + precioCompra + "\n ";
                     
            if ( titulo != null){
                texto += titulo.toString();

            }
        }
     
        return texto;
    }
    
    
}
