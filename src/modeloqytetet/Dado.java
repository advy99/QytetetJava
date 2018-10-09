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
public class Dado {
    
    private static final Dado instance = new Dado();
    
    private int valor;
    
    
    private Dado() {
        valor = 0;
        //valor = tirar();
    }
    
    public static Dado getInstance() {
        return instance;
    }
    
    
    int tirar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int getValor(){
        return valor;
    }
    
    @Override
    public String toString(){
        String texto = "";
        
        texto += "\nValor del dado: " + valor + "\n";
        
        return texto;
    }
}
