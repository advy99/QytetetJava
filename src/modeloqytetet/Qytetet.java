/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import InterfazUsuarioQytetet.InterfazUsuarioQytetet;

/**
 *
 * @author antonio
 */
public class Qytetet {
    
    public static int MAX_JUGADORES = 4;
    public static int NUM_CASILLAS = 20;
    static int NUM_SORPRESAS = 10;
    static int PRECIO_LIBERTAD = 200;
    static int SALDO_SALIDA = 1000;
    
    private static final Qytetet instance = new Qytetet();
    
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    
    private Tablero tablero;
    
    private Sorpresa cartaActual;
    
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    
    private Jugador jugadorActual;
    
    private Dado dado = Dado.getInstance();
    
    private EstadoJuego estadoJuego;
    
    private Qytetet(){
    
    }
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    /**
     * @brief Consultar el mazo
     * @return mazo
     */
    ArrayList<Sorpresa> getMazo(){
        return mazo;
    }
    
    Tablero getTablero() {
        return tablero;
    }
    
    /**
     * @brief Inicializar las cartas sorpresa
     */
    private void inicializarCartasSorpresa(){
        
        
        mazo.add(new Sorpresa ("Un fan anónimo ha pagado tu fianza. Sales " +
                 "de la cárcel", 0, TipoSorpresa.SALIRCARCEL));
        
        mazo.add(new Sorpresa ("Por ir tan rápido debes pagar una multa de" +
                "500 euros", -500, TipoSorpresa.PAGARCOBRAR));
        
        mazo.add(new Sorpresa ("Por ser tan buen programador te damos un " +
                " premio de 1000 euros", 1000, TipoSorpresa.PAGARCOBRAR));
        
        mazo.add(new Sorpresa ("Es tu cumpleaños y tus compañeros son " +
               " generosos, cada jugador te da 200 euros",
                 200, TipoSorpresa.PORJUGADOR));
        
        mazo.add(new Sorpresa ("No era tu cumpleaños, ¡mentiroso!. Debes darle"
                 + " a los demás lo que te han dado con intereses, 300 euros a "
                 + "cada uno", -300, TipoSorpresa.PORJUGADOR));
        
        mazo.add(new Sorpresa ("Eres muy emprendedor, obtienes 100 euros por "+
                "cada casa y hotel que poseas",
                 100, TipoSorpresa.PORCASAHOTEL));
        
        mazo.add(new Sorpresa ("Tienes demasiadas propiedades, deja algo para" +
                 " los demás. Paga 150 euros por cada casa y hotel", -150, 
                  TipoSorpresa.PORCASAHOTEL));
        
        mazo.add(new Sorpresa ("Te hemos pillado con chanclas y calcetines," +
                 "lo sentimos, ¡debes ir a la carcel!",
                  tablero.getCarcel().getNumeroCasilla(),
                  TipoSorpresa.IRACASILLA));
        
        mazo.add(new Sorpresa ("Has tenido suerte, vas a cobrar sin trabajar." +
                 "Ve a la casilla de salida.", 0, TipoSorpresa.IRACASILLA));
        
        mazo.add(new Sorpresa ("Encuentras un atajo en el camino.",
                 18, TipoSorpresa.IRACASILLA));
        
        
        Collections.shuffle(mazo);
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();
    }

    
    void actuarSiEnCasillaEdificable(){
        boolean deboPagar = jugadorActual.deboPagarAlquiler();
        
        if(deboPagar){
            jugadorActual.pagarAlquiler();
            
            if (jugadorActual.getSaldo() <= 0){
                setEstadoJuego ( EstadoJuego.ALGUNJUGADORENBANCARROTA);
            }
            
        }
        
        Casilla casilla = obtenerCasillaJugadorActual();
        
        boolean tengoPropietario = casilla.tengoPropietario();
        
        if (estadoJuego != EstadoJuego.ALGUNJUGADORENBANCARROTA){
            if (tengoPropietario){
                setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
            }else{
                setEstadoJuego(EstadoJuego.JA_PUEDECOMPRAROGESTIONAR);
            }
        }
        
    }
    
    void actuarSiEnCasillaNoEdificable(){
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        Casilla casillaActual = jugadorActual.getCasillaActual();
        
        if(casillaActual.getTipo() == TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }else{
            if(casillaActual.getTipo() == TipoCasilla.JUEZ){
                encarcelarJugador();
            }else{
                if (casillaActual.getTipo() == TipoCasilla.SORPRESA ){
                    cartaActual = mazo.get(0);
                    
                    mazo.remove(0);
                    
                    setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
                }
            }
        }
    }
    
    public void aplicarSorpresa(){
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        if (cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL){
            jugadorActual.setCartaLibertad(cartaActual);
        }else{
            
            mazo.add(cartaActual);
            
            if(cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR){
                
                jugadorActual.modificarSaldo(cartaActual.getValor());
                
                if(jugadorActual.getSaldo() <= 0){
                    setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
                
            }else if (cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
                
                int valor = cartaActual.getValor();
                
                boolean casillaCarcel = tablero.esCasillaCarcel(valor);
                
                if (casillaCarcel){
                    encarcelarJugador();
                }else{
                    mover(valor);
                }
                
            }else if (cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
                
                int cantidad = cartaActual.getValor();
                
                int numeroTotal = jugadorActual.cuantasCasasHotelesTengo();
                
                jugadorActual.modificarSaldo(cantidad*numeroTotal);
                
                if (jugadorActual.getSaldo() <= 0){
                    setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
                
            }else if(cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
                for (Jugador j: jugadores){
                    if (j != jugadorActual){
                        j.modificarSaldo(cartaActual.getValor());
                        
                        if(j.getSaldo() <= 0){
                            setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                        }
                        
                        jugadorActual.modificarSaldo(-cartaActual.getValor());
                        
                        if (jugadorActual.getSaldo() <= 0){
                            setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                        }   
                        
                    }
                    
                }
            }
        }
        
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        boolean cancelada = false;
        
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        
        TituloPropiedad titulo = casilla.getTitulo();
        
        cancelada = jugadorActual.cancelarHipoteca(titulo);
        
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        return cancelada;
    }
    
    public boolean comprarTituloPropiedad(){
        boolean comprado = jugadorActual.comprarTituloPropiedad();
        
        if (comprado){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        
        return comprado;
    }
    
    public boolean edificarCasa(int numeroCasilla){
        boolean edificada = false;
        
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        
        TituloPropiedad titulo = casilla.getTitulo();
        
        edificada = jugadorActual.edificarCasa(titulo);
        
        
        if(edificada){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        
        return edificada;
        
    }
    
    public boolean edificarHotel(int numeroCasilla){
        boolean edificado = false;
        
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        
        TituloPropiedad titulo = casilla.getTitulo();
        
        edificado = jugadorActual.edificarHotel(titulo);
        
        
        if(edificado){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        
        
        return edificado;
    }
    
    private void encarcelarJugador(){
        if (!jugadorActual.tengoCartaLibertad()){
            Casilla casillaCarcel = tablero.getCarcel();
            
            jugadorActual.irACarcel(casillaCarcel);
            
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
            
            
        }else{
            
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            
            mazo.add(carta);
            
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
    }
    
    public Sorpresa getCartaActual(){
        return cartaActual;
    }
    
    Dado getDado(){
        return dado;
    }
    
    public EstadoJuego getEstadoJuego(){
        return estadoJuego;
    }
    
    Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public int obtenerValorDado(){
        return dado.getValor();
    }
    
    public void hipotecarPropiedad(int numeroCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        
        TituloPropiedad titulo = casilla.getTitulo();
        
        jugadorActual.hipotecarPropiedad(titulo);
        
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
    }

    public void inicializarJuego(ArrayList<String> nombres ){  
        
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
        
        salidaJugadores();
        
        
    }
    
    /**
     * @brief Inicializar jugadores
     * @param nombres 
     * 
     * @pre 2 <= nombres.size <= MAX_JUGADORES 
     */
    
    private void inicializarJugadores(ArrayList<String> nombres) {

        for (String n: nombres){
            jugadores.add( new Jugador(n));
            
        }
        
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        if (metodo == MetodoSalirCarcel.TIRANDODADO){
            int resultado = tirarDado();
            
            if (resultado >= 5){
                jugadorActual.setEncarcelado(false);
            }
        }else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
            jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
        }
        
        boolean encarcelado = jugadorActual.getEncarcelado();
        
        if (encarcelado){
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }else{
            setEstadoJuego(EstadoJuego.JA_PREPARADO);
        }
        
        return !encarcelado;
        
    }
    
    public void jugar(){
        Casilla casillaFinal;
        
        int v_dado = tirarDado();
        
        casillaFinal = tablero.obtenerCasillaFinal(jugadorActual.getCasillaActual(), v_dado);
        
        mover(casillaFinal.getNumeroCasilla());
        
    }
    
    void mover(int numCasillaDestino){
        Casilla casillaInicial = jugadorActual.getCasillaActual();
        
        Casilla casillaFinal = tablero.obtenerCasillaNumero(numCasillaDestino);
        
        jugadorActual.setCasillaActual(casillaFinal);
        
        if (numCasillaDestino < casillaInicial.getNumeroCasilla()){
            jugadorActual.modificarSaldo(SALDO_SALIDA);
        }
        
        if (casillaFinal.soyEdificable()){
            actuarSiEnCasillaEdificable();
        }else{
            actuarSiEnCasillaNoEdificable();
        }
        
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        return jugadorActual.getCasillaActual();
    }
    
    //public ArrayList<Casilla> obtenerCasillasTablero(){
    //    throw new UnsupportedOperationException("Sin implementar");
    //}
    
    public ArrayList<Integer> obtenerPropiedadesJugador(){
        ArrayList<Integer> pro = new ArrayList<>();
        
        for(Casilla c: tablero.getCasillas()){
            if (jugadorActual.getPropiedades().contains(c.getTitulo())){
                pro.add(c.getNumeroCasilla());
            }
        
        }
        
        return pro;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca(
                                                       boolean estadoHipoteca) {
        ArrayList<TituloPropiedad> pro = jugadorActual.obtenerPropiedades(estadoHipoteca);
        ArrayList<Integer> sol = new ArrayList<>();
        
        for(Casilla c: tablero.getCasillas()){
            if (pro.contains(c.getTitulo())){
                sol.add(c.getNumeroCasilla());
            }
        
        }
        
        
        return sol;
    }
    
    public void obtenerRanking(){
        Collections.sort(jugadores);
    }
    
    public int obtenerSaldoJugadorActual(){
        return jugadorActual.getSaldo();
    }
    
    private void salidaJugadores(){
        for(Jugador j: jugadores){
            j.setCasillaActual(tablero.obtenerCasillaNumero(0));
        }
        
        Random r = new Random();
        
        jugadorActual = jugadores.get(r.nextInt(jugadores.size()));
        
        estadoJuego = EstadoJuego.JA_PREPARADO;
    }
    
    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador(){
        int n_jugador = 0;
        
        for(int i = 0; i < jugadores.size(); i++){
            if(jugadores.get(i) == jugadorActual){
                n_jugador = i;
            }
        }
        
        n_jugador = (n_jugador + 1) % jugadores.size();
        
        jugadorActual = jugadores.get(n_jugador);
        
        if(jugadorActual.getEncarcelado()){
            estadoJuego = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        }else{
            estadoJuego = EstadoJuego.JA_PREPARADO;
        }
    }
    
    int tirarDado(){
        return dado.tirar();
    }
    
    public void venderPropiedad(int numCasilla){
        Casilla casilla = tablero.obtenerCasillaNumero(numCasilla);
        
        jugadorActual.venderPropiedad(casilla);
        
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
    }
    
  
    public void setEstadoJuego(EstadoJuego estado){
        estadoJuego = estado;
    }
    
    
    
    @Override
    public String toString(){
        String texto = "";
        
        texto += "Maximo de jugadores: " + MAX_JUGADORES + "\n"+
                 "Numero de cartas sorpresa: " + NUM_SORPRESAS + "\n"+
                 "Numero de casillas: " + NUM_CASILLAS + "\n" +
                 "Precio de libertad: " + PRECIO_LIBERTAD + "\n" +
                 "Saldo al pasar por Salida: " + SALDO_SALIDA + "\n\n";
                  
        texto += dado.toString();
        
        texto += tablero.toString();
        
        for (Jugador j: jugadores){
            texto += j.toString();
        }
        
        if (cartaActual != null)
            texto += cartaActual.toString();
        
        texto += "\nJugador actual: " + jugadorActual.getNombre() + "\n";
        
        return texto;
    }
    
    
    
}
