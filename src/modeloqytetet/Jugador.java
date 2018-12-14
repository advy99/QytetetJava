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
    
    
    Jugador(String nombre){
        this.nombre = nombre;
        cartaLibertad = null;
        casillaActual = null;
    
    }
    
    protected Jugador (Jugador otroJugador){
        this.encarcelado = otroJugador.encarcelado;
        this.nombre = otroJugador.nombre;
        this.saldo = otroJugador.saldo;
        this.cartaLibertad = otroJugador.cartaLibertad;
        this.casillaActual = otroJugador.casillaActual;
        this.propiedades = otroJugador.propiedades;
    }
    
    
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        boolean cancelada = false;
        
        int costeCancelar = titulo.calcularCosteCancelar();
        
        if (saldo >= costeCancelar){
            modificarSaldo(-costeCancelar);
            
            
            titulo.cancelarHipoteca();
                        
            cancelada = true;
        }
        
        return cancelada;
    }
    
    protected Especulador convertirme(int fianza){
        Especulador especulador = new Especulador(this, fianza);
        
        return especulador;
    }
    
    boolean comprarTituloPropiedad(){
        boolean comprado = false;
        
        int costeCompra = casillaActual.getCoste();
        
        if(costeCompra < saldo){
            ((Calle) casillaActual).asignarPropietario(this);
            
            comprado = true;
            
            propiedades.add(casillaActual.getTitulo());
            
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
    
    protected boolean deboIrACarcel(){
        return  (!tengoCartaLibertad());
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
        
        //int numCasas = titulo.getNumCasas();
        
        if (puedoEdificarCasa(titulo)){
            
            titulo.edificarCasa();

            modificarSaldo(-titulo.getPrecioEdificar());

            edificada = true;
            
        }
        
        return edificada;
        
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean edificado = false;
        
        //int numCasas = titulo.getNumCasas();
        //int numHoteles = titulo.getNumHoteles();
        
        
        
        if(puedoEdificarHotel(titulo)){
            
           
            titulo.edificarHotel();

            modificarSaldo(-titulo.getPrecioEdificar());

            edificado = true;
            
           
        }
        
        return edificado;
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        propiedades.remove(titulo);
        
        titulo.setPropietario(null);
        
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo) {
        
        return propiedades.contains(titulo);
        
    }
    
    //boolean estoyEnCalleLibre(){
    //    throw new UnsupportedOperationException("Sin implementar");
    //}
    
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
    
    void hipotecarPropiedad(TituloPropiedad titulo){
        int costeHipoteca = titulo.hipotecar();
        
        modificarSaldo(costeHipoteca);
        
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
        int costeAlquiler = ((Calle) casillaActual).pagarAlquiler();
        
        modificarSaldo(-costeAlquiler);
    }
    
    protected void pagarImpuesto(){
        modificarSaldo(getCasillaActual().getCoste());
    }
    
    void pagarLibertad(int cantidad){
        boolean tengoSaldo = tengoSaldo(cantidad);
        
        if (tengoSaldo){
            setEncarcelado(false);
            
            modificarSaldo(-cantidad);
        }
    }
    
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        boolean puedo = false;
        
        puedo = titulo.getNumCasas() < 4 && tengoSaldo(titulo.getPrecioEdificar());
        
        return puedo;
    }
    
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
        boolean puedo = false;
        
        puedo = titulo.getNumHoteles() < 4 && titulo.getNumCasas() == 4 &&
                tengoSaldo(titulo.getPrecioEdificar());
        
        return puedo;
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
    
    protected boolean tengoSaldo(int cantidad) {
        return saldo >= cantidad;
    }
    
    void venderPropiedad(Casilla casilla) {
        TituloPropiedad titulo = casilla.getTitulo();
        
        eliminarDeMisPropiedades(titulo);
        
        int precioVenta = titulo.calcularPrecioVenta();
        
        modificarSaldo(precioVenta);
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
