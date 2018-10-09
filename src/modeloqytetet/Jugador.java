/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Jugador {
    private boolean encarcelado = false; 
    private String nombre;
    private int saldo = 7500;
    
    private Sorpresa cartaLibertad;
    
    private Casilla casillaActual;
    
    private ArrayList<TituloPropiedad> propiedades = new ArrayList<>();
    
    
    Jugador(String nombre, Casilla casillaInicio){
        this.nombre = nombre;
        cartaLibertad = null;
        casillaActual = casillaInicio;
    
    }
    
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cuantasCasasHotelesTengo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    boolean edificarCasa(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa getCartaLibertad(){
        return cartaLibertad;
    }
    
    Casilla getCasillaActual(){
        return casillaActual;
    }
    
    boolean getEncarcelado(){
        return encarcelado;
    }
    
    String getNombre(){
        return nombre;
    }
    
    ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void irACarcel(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int modificarSaldo(int cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int obtenerCapital(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarImpuesto(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setCartaLibertad(Sorpresa carta) {
        cartaLibertad = carta;
    }
    
    void setCasillaActual(Casilla casilla){
        casillaActual = casilla;
    }
    
    void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean tengoSaldo(int cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString(){
    
        String texto = "";
        
        texto += "\nNombre: " + nombre + "\n" +
                 "Encarcelado: " + encarcelado + "\n" +
                 "Saldo: " + saldo + "\n\n";
        
        if (cartaLibertad != null)
          texto += cartaLibertad.toString();
        
        texto += "\nLas siguientes propiedades pertenecen a " + nombre + "\n";
        for (TituloPropiedad t: propiedades){
            texto += "\t" + t.getNombre() + "\n";
        }
        
        texto += "\n\nLa casilla actual del jugador es: ";
        
        texto += "\n" + casillaActual.toString() + "\n";
        
        
                 
        
        return texto;
    }
    
}
