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
public class OtraCasilla extends Casilla {
    private TipoCasilla tipo;
    
    OtraCasilla(int numeroCasilla, int n_coste, TipoCasilla tipo){
        super(numeroCasilla, n_coste);
        
        this.tipo = tipo;
        
    }
    
    protected TipoCasilla getTipo(){
        return tipo;
    }
    
    protected boolean soyEdificable(){
        //return tipo == TipoCasilla.CALLE;
        return false;
    }
    
    protected TituloPropiedad getTitulo(){
        return null;
    }
    
    
    @Override
    public String toString(){
        
        String texto = "";
        
        texto += "Numero de casilla: " + getNumeroCasilla() + "\n" +
                 "Tipo de casilla: " + getTipo() + "\n" +
                 "Coste: " + getCoste() + "\n ";
        
     
        return texto;
    }
}
