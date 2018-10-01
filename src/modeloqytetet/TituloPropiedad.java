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
public class TituloPropiedad {
    
    private String nombre;
    private boolean hipotecada = false;
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private int numCasas;
    private int numHoteles;
    
    
    public TituloPropiedad(String nombre, int precioCompra, int alquilerBase,
                           float factorRevalorizacion, int hipotecaBase,
                           int precioEdificar){
        
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        
        this.numHoteles = 0;
        this.numCasas = 0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getAlquilerBase() {
        return alquilerBase;
    }

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    public int getHipotecaBase() {
        return hipotecaBase;
    }

    public int getPrecioEdificar() {
        return precioEdificar;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    
    @Override
    public String toString(){
        return "Titulo propiedad: \n" +
                            "\t Nombre: " + nombre + "\n" +
                            "\t Hipotecada: " + hipotecada + "\n" +
                            "\t Precio de compra: " + precioCompra + "\n" +
                            "\t Alquiler base: " + alquilerBase + "\n" +
                            "\t Factor revalorizacion: " + factorRevalorizacion + "\n" +
                            "\t Hipoteca base: " + hipotecaBase + "\n" +
                            "\t Precio para edificar: " + precioEdificar + "\n" +
                            "\t Numero de casas: " + numCasas + "\n" +
                            "\t Numero de hoteles: " + numHoteles + "\n\n";
    }
    
    
}
