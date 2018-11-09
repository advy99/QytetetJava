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
    private int numCasas = 0;
    private int numHoteles = 0;
    private Jugador propietario;
    
    
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
    
    int calcularCosteCancelar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularCosteHipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularImporteAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularPrecioVente(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cobrarAlquiler (int coste){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getAlquilerBase() {
        return alquilerBase;
    }
    
    float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }
    
    int getHipotecaBase() {
        return hipotecaBase;
    }
    
    boolean getHipotecada() {
        return hipotecada;
    }


    String getNombre() {
        return nombre;
    }

    
    int getNumCasas() {
        return numCasas;
    }

    int getNumHoteles() {
        return numHoteles;
    }
    
    int getPrecioCompra() {
        return precioCompra;
    }

    int getPrecioEdificar() {
        return precioEdificar;
    }

    Jugador getPropietario(){
        return propietario;
    }
    
    int hipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        return propietario.getEncarcelado();
    }
   

    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    
    void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    boolean tengoPropietario(){
        return propietario != null;
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
