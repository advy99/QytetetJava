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
    
    /**
     * @brief Constructor Sorpresa
     * @param n_texto Texto de la sorpresa
     * @param n_valor Valor de la sorpresa
     * @param n_sorpresa Tipo de sorpresa, ha de ser alguno de los definidos
     *                   en TipoSorpresa.java
     * 
     */
    Sorpresa(String n_texto, int n_valor, TipoSorpresa n_sorpresa){
        texto = n_texto;
        valor = n_valor;
        tipo = n_sorpresa;
        
    }

    
    /**
     * @brief Consultor del texto de una sorpresa
     * @return texto
     */
    String getTexto() {
        return texto;
    }

    /**
     * @brief Consultor del tipo de una sorpresa
     * @return tipo
     */
    TipoSorpresa getTipo() {
        return tipo;
    }

    /**
     * @brief Consultor del valor de una sorpresa
     * @return valor
     */
    int getValor() {
        return valor;
    }

    /**
     * @brief Muestra una sorpresa como string
     * @return Valor de la sorpresa como string
     */
    
    @Override
    public String toString(){
        return "Sorpresa{ texto= " + texto + ", valor= " + 
                Integer.toString(valor) + ", tipo= " + tipo + "}"; 
    }
    
    
}
