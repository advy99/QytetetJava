/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();
    }

    
    void actuarSiEnCasillaEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void actuarSiEnCasillaNoEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void aplicarSorpresa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarCasa(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void encarcelarJugador(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Sorpresa getCartaActual(){
        return cartaActual;
    }
    
    Dado getDado(){
        return dado;
    }
    
    Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public int getValorDado(){
        return dado.getValor();
    }
    
    public void hipotecarPropiedad(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    public void inicializarJuego(ArrayList<String> nombres ){  
        
        inicializarTablero();
        inicializarCartasSorpresa();
        inicializarJugadores(nombres);
        
        jugadorActual = jugadores.get(0);
        
    }
    
    /**
     * @brief Inicializar jugadores
     * @param nombres 
     * 
     * @pre 2 <= nombres.size <= MAX_JUGADORES 
     */
    
    private void inicializarJugadores(ArrayList<String> nombres) {

        for (String n: nombres){
            jugadores.add( new Jugador(n, tablero.obtenerCasillaNumero(0)));

        }
        
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void jugar(){
        Casilla casillaFinal;
        
        int v_dado = tirarDado();
        
        casillaFinal = tablero.obtenerCasillaFinal(jugadorActual.getCasillaActual(), v_dado);
        
        mover(casillaFinal.getNumeroCasilla());
        
    }
    
    void mover(int numCasillaDestino){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador(){
        ArrayList<Integer> pro = new ArrayList<>();
        
        for(Casilla c: tablero.getCasillas()){
            for(TituloPropiedad p: jugadorActual.getPropiedades()){
                if (c.getTitulo() == p){
                    pro.add(c.getNumeroCasilla());
                }
            }
        }
        
        return pro;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca(
                                                       boolean estadoHipoteca) {
        ArrayList<Integer> pro = obtenerPropiedadesJugador();
        
        for(Integer i: pro){
            if(tablero.obtenerCasillaNumero(i).getTitulo().getHipotecada() == estadoHipoteca )
                pro.remove(i);
        }
        
        
        return pro;
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
        
        jugadorActual = jugadores.get(r.nextInt()%jugadores.size());
        
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
    
    public boolean venderPropiedad(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
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
