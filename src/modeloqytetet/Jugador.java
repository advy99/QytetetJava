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
public class Jugador implements Comparable {
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
        boolean comprado = false;
        
        int costeCompra = casillaActual.getCoste();
        
        if(costeCompra < saldo){
            TituloPropiedad titulo = casillaActual.asignarPropietario(this);
            
            propiedades.add(titulo);
            
            modificarSaldo(-costeCompra);
        }
        
        
        return comprado;
    }
    
    int cuantasCasasHotelesTengo(){
        int total = 0;
        
        for (TituloPropiedad p: propiedades){
            total += p.getNumCasas() + p.getNumHoteles();
        }
        
        return total;
    }
    
    boolean deboPagarAlquiler(){
        TituloPropiedad titulo = casillaActual.getTitulo();
        
        boolean deboPagar;
        
        boolean esDeMiPropiedad = esDeMiPropiedad(titulo);
        boolean tienePropietario = false;
        boolean estaHipotecada = false;
        
        if(!esDeMiPropiedad){
            tienePropietario = titulo.tengoPropietario();
            
            if(tienePropietario){
                boolean encarcelado = titulo.propietarioEncarcelado();
                
                if (!encarcelado){
                    estaHipotecada = titulo.getHipotecada();
                }
            }
        }
    
        deboPagar = !esDeMiPropiedad && tienePropietario && !estaHipotecada;
        
        
        return deboPagar;
    }
    
    Sorpresa devolverCartaLibertad() {
        Sorpresa cartaL = cartaLibertad;
        
        cartaLibertad = null;
        
        return cartaL;
    }

    boolean edificarCasa(TituloPropiedad titulo){
        boolean edificada = false;
        
        int numCasas = titulo.getNumCasas();
        
        if (numCasas < 4){
            int costeEdificarCasa = titulo.getPrecioEdificar();
            
            boolean tengoSaldo = tengoSaldo(costeEdificarCasa);
            
            if (tengoSaldo){
                titulo.edificarCasa();
                
                modificarSaldo(-costeEdificarCasa);
                
                edificada = true;
            }
        }
        
        return edificada;
        
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo) {
        
        return propiedades.contains(titulo);
        
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
        setCasillaActual(casilla);
        
        setEncarcelado(true);
    }
    
    int modificarSaldo(int cantidad) {
        saldo += cantidad;
        return saldo;
    }
    
    int obtenerCapital(){
        int capital = saldo;
        
        for (TituloPropiedad p: propiedades){
            capital += p.getPrecioCompra() + p.getPrecioEdificar()*
                       (p.getNumCasas()+p.getNumHoteles());
            
            if (p.getHipotecada())
                capital -= p.getHipotecaBase();
        }
        
        return capital;
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada) {
        ArrayList<TituloPropiedad> titulos = new ArrayList<>();

        for (TituloPropiedad p: propiedades){
            if (p.getHipotecada() == hipotecada){
                titulos.add(p);
            }
        }
        
        return titulos;
    }
    
    void pagarAlquiler(){
        int costeAlquiler = casillaActual.pagarAlquiler();
        
        modificarSaldo(-costeAlquiler);
    }
    
    void pagarImpuesto(){
        saldo -= casillaActual.getCoste();
    }
    
    void pagarLibertad(int cantidad){
        boolean tengoSaldo = tengoSaldo(cantidad);
        
        if (tengoSaldo){
            setEncarcelado(false);
            
            modificarSaldo(-cantidad);
        }
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
        return cartaLibertad != null;
    }
    
    private boolean tengoSaldo(int cantidad) {
        return saldo >= cantidad;
    }
    
    boolean venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString(){
    
        String texto = "";
        
        texto += "\nNombre: " + nombre + "\n" +
                 "Encarcelado: " + encarcelado + "\n" +
                 "Saldo: " + saldo + "\n" +
                 "Capital: " + obtenerCapital() + "\n\n" ;
        
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
    
    @Override
    public int compareTo(Object otroJugador){
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        return otroCapital - obtenerCapital();
    }
    
}
