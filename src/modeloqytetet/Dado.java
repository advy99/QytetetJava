/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.Random;

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
        Random r = new Random();
        
        valor = (r.nextInt() % 6) + 1;
        
        return valor;
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
