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
public class Sorpresa {
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
    
    
    public Sorpresa(String n_texto, int n_valor, TipoSorpresa n_sorpresa){
        texto = n_texto;
        valor = n_valor;
        tipo = n_sorpresa;
        
    }

    String getTexto() {
        return texto;
    }

    TipoSorpresa getTipo() {
        return tipo;
    }

    int getValor() {
        return valor;
    }

    void setTexto(String texto) {
        this.texto = texto;
    }

    void setTipo(TipoSorpresa tipo) {
        this.tipo = tipo;
    }

    void setValor(int valor) {
        this.valor = valor;
    } 
    
    
    @Override
    public String toString(){
        return "Sorpresa{ texto= " + texto + ", valor= " + 
                Integer.toString(valor) + ", tipo= " + tipo + "}"; 
    }
    
    
}
