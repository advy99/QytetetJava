/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuarioQytetet;
import java.util.ArrayList;
import java.util.Scanner;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;

/**
 *
 * @author antonio
 */
public class InterfazUsuarioQytetet {

    private static final Scanner in = new Scanner (System.in);
    
    static Qytetet modelo = Qytetet.getInstance();
    
    public ArrayList<String> obtenerNombreJugadores(){
        int numeroJugadores;
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> numJugadoresValidos = new ArrayList<>();
        String valor;
        
        numJugadoresValidos.add("2");
        numJugadoresValidos.add("3");
        numJugadoresValidos.add("4");
        
        
        System.out.println("Introduce el numero de jugadores (de 2 a 4):");

        valor = leerValorCorrecto(numJugadoresValidos);
        
        numeroJugadores = Integer.parseInt(valor);
        
        for(int i = 0; i < numeroJugadores; i++){
            System.out.println("Introduce el nombre del jugador " + i + "\n" );
            String n = in.next();
            nombres.add(n);
        }
        
        return nombres;
    }
    
    public int obtenerOpcionMenu (ArrayList<String> menuOperaciones){
        for(String s: menuOperaciones){
            System.out.println(s);
        }
        int valor = Integer.parseInt(leerValorCorrecto(menuOperaciones));
        
        return valor;
    }
    
    public int elegirCasilla(int ordinalOpcionMenu){
        ArrayList<Integer> casillasValidas = obtenerCasillasValidas(ordinalOpcionMenu);
        
        int valorDevolver;
        
        if(casillasValidas.isEmpty()){
            valorDevolver = -1;
        }else {
            for (Integer i: casillasValidas){
                System.out.println(i);
            }
            //mas dudas
            valorDevolver = leerValorCorrecto(casillasValidas);
        }
    
    }
    
    public ArrayList<String> obtenerOperacionesJuegoValidas(){
        ArrayList<String> operacionesValidas = new ArrayList<>();
                
        if (modelo.getJugadores() == null){
            operacionesValidas.add(OpcionMenu.INICIARJUEGO.name());
        }else{
            String estado = modelo.getEstadoJuego().name();
            if (estado == "JA_PREPARADO"){
                operacionesValidas.add(OpcionMenu.JUGAR.name());
            }else if(estado == "ALGUNJUGADORENBANCARROTA"){
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.name());
            }else if(estado == "JA_CONSORPRESA"){
                operacionesValidas.add(OpcionMenu.APLICARSORPRESA.name());
            }else if(estado == "JA_ENCARCELADOCONOPCIONDELIBERTAD"){
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.name());
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.name());
            }else if(estado == "JA_ENCARCELADO"){
                operacionesValidas.add(OpcionMenu.PASARTURNO.name());
            }else if(estado == "JA_PUEDEGESTIONAR"){
                operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.name());
                operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.name());
                operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.name());
                operacionesValidas.add(OpcionMenu.EDIFICARCASA.name());
                operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.name());
                operacionesValidas.add(OpcionMenu.PASARTURNO.name());
            }else if(estado == "JA_PUEDECOMPRAROGESTIONAR"){
                operacionesValidas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.name());
                operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.name());
                operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.name());
                operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.name());
                operacionesValidas.add(OpcionMenu.EDIFICARCASA.name());
                operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.name());
                operacionesValidas.add(OpcionMenu.PASARTURNO.name());
            }
        }
        
        
        return operacionesValidas;
    }
    
    
    
    public boolean necesitaElegirCasilla(int opcionMenu){
        boolean necesita;
        
        necesita = opcionMenu == OpcionMenu.HIPOTECARPROPIEDAD.ordinal() ||
                   opcionMenu == OpcionMenu.CANCELARHIPOTECA.ordinal() ||
                   opcionMenu == OpcionMenu.EDIFICARCASA.ordinal() ||
                   opcionMenu == OpcionMenu.EDIFICARHOTEL.ordinal() ||
                   opcionMenu == OpcionMenu.VENDERPROPIEDAD.ordinal();
        
        return necesita;
    }
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu){
        
    }
    
    public void realizarOperacion(int opcionElegida, int casillaElegida){
        //INICIARJUEGO
        if (opcionElegida == 0){ 
            modelo.inicializarJuego(obtenerNombreJugadores());
        } else if (opcionElegida == 1){
            modelo.jugar();
            System.out.println("Ha salido un " + modelo.obtenerValorDado());
            System.out.println("El jugador se ha movido a la casilla " + modelo.obtenerCasillaJugadorActual());
        } else if (opcionElegida == 2){
            System.out.println("Se va a aplicar la siguiente carta sorpresa:");
            System.out.println(modelo.getCartaActual().toString());
            modelo.aplicarSorpresa();
        } else if (opcionElegida == 3){
            if (modelo.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD)){
                System.out.println("Has conseguido salir de la carcel");
            } else{
                System.out.println("No has conseguido salir de la carcel");
            }
        } else if (opcionElegida == 4){
            if (modelo.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO)){
                System.out.println("Has conseguido salir de la carcel");
            } else{
                System.out.println("No has conseguido salir de la carcel");
            }
        } else if (opcionElegida == 5){
            if(modelo.comprarTituloPropiedad()){
                System.out.println("Se ha comprado el titulo correctamente");
            }else{
                System.out.println("No se ha podido comprar el titulo");
            }
        } else if (opcionElegida == 6){
            modelo.hipotecarPropiedad(casillaElegida);
        } else if (opcionElegida == 7){
            modelo.cancelarHipoteca(casillaElegida);
        } else if (opcionElegida == 8){
            if (modelo.edificarCasa(casillaElegida)){
                System.out.println("Se ha edificado la casa correctamente");
            } else{
                System.out.println("No se ha podido edificar la casa");
            }
        } else if (opcionElegida == 9){
            if(modelo.edificarHotel(casillaElegida)){
                System.out.println("Se ha edificado el hotel correctamente");
            } else{
                System.out.println("No se ha podido edificar el hotel");
            }
            
        } else if (opcionElegida == 10){
            modelo.venderPropiedad(casillaElegida);
        } else if (opcionElegida == 11){
            modelo.siguienteJugador();
        } else if (opcionElegida == 12){
            modelo.obtenerRanking();
        } else if (opcionElegida == 13){
            //No nos habeis explicado como acabar el juego :D
        } else if (opcionElegida == 14){
            //preguntar duda
            System.out.println(modelo.getJugadorActual().toString());
        } else if (opcionElegida == 15){
            //preguntar duda
            
        } else if (opcionElegida == 16){
            //preguntar duda
            System.out.println(modelo.getTablero().toString());
        }
        
            
        
    }
    
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos){
        String valor;
       
        valor = in.nextLine();
        
        while(!valoresCorrectos.contains(valor)){
            System.out.println("ERROR: No has introducido un valor correcto, vuelve a probar.");
            valor = in.nextLine();
        }
        
        return valor;
        
    }
    
    public int elegirOperacion(){
        return obtenerOpcionMenu(obtenerOperacionesJuegoValidas());
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazUsuarioQytetet ui = new InterfazUsuarioQytetet();
        
        int operacionElegida, casillaElegida = 0;
        
        boolean necesitaElegirCasilla;
        boolean salir = false;
        
        do{
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = ui.necesitaElegirCasilla(operacionElegida);
            if (necesitaElegirCasilla){
                casillaElegida = ui.elegirCasilla(operacionElegida);
            }else if (casillaElegida >= 0){
                ui.realizarOperacion(operacionElegida, casillaElegida);
            }
            
        }while (!salir);
    }
    
}
