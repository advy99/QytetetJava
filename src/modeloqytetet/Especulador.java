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
public class Especulador extends Jugador {
    private int fianza;
    
    protected Especulador(Jugador jugador, int fianza){
        super(jugador);

        this.fianza = fianza;
        
    }
    
    @Override
    protected void pagarImpuesto(){
        
        modificarSaldo(getCasillaActual().getCoste()/2);
    }
    
    @Override
    protected boolean deboIrACarcel(){
        return super.deboIrACarcel() && !pagarFianza();
    }
    
    @Override
    protected Especulador convertirme(int fianza){
        return this;
    }
    
    private boolean pagarFianza(){
        boolean pagada = false;
        
        if ( tengoSaldo( fianza ) ){
            modificarSaldo(-fianza);
            
            pagada = true;
        }
        
        return pagada;
    }
    
    
    @Override
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        boolean puedo = false;
        
        puedo = titulo.getNumCasas() < 8 && tengoSaldo(titulo.getPrecioEdificar());
        
        return puedo;
    }
    
    @Override
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
        boolean puedo = false;
        
        puedo = titulo.getNumHoteles() < 8 && titulo.getNumCasas() >= 4 &&
                tengoSaldo(titulo.getPrecioEdificar());
        
        return puedo;
    }
       
    
    @Override
    public String toString(){
        String texto = "\nFianza: " + fianza + super.toString();
        
        
        return texto;
    }
    
}
