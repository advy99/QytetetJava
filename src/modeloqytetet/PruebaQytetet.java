/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Antonio David Villegas Yeguas
 */
public class PruebaQytetet {

    /**
     * @param args the command line arguments
     */
    
    //Instancia del juego Qytetet
    static Qytetet juego = Qytetet.getInstance();
    
    
    //Scanner para lectura de datos
    private static final Scanner in = new Scanner (System.in);

    
    /**
     * @brief Obtener las sorpresa con valor positivo
     * 
     * @param sorpresas Array de Sorpresas
     * @return Sorpresas positivas
     */
    
    private static ArrayList<Sorpresa> getSorpresasPositivas
                                       (ArrayList<Sorpresa> sorpresas){
    
        //Creamos array vacio
        ArrayList<Sorpresa> positivas = new ArrayList<>();
        
        //De todas las sorpresas, añadimos las de valor positivo
        for (Sorpresa s: sorpresas){
            if(s.getValor() > 0)
                positivas.add(s);
        }
        
        return positivas;
        
    }
    
    /**
     * @brief Obtener sorpresas de tipo IrACasilla
     * @param sorpresas Array de Sorpresas
     * @return Array de sorpresas positivas
     */
    
    private static ArrayList<Sorpresa> getSorpresasIrACasilla
                                       (ArrayList<Sorpresa> sorpresas){
    
        //Creamos Array vacio
        ArrayList<Sorpresa> irACasilla = new ArrayList<>();
        
        //Añadimos sorpresas con tipo IrACasilla
        for (Sorpresa s: sorpresas){
            if(s.getTipo() == TipoSorpresa.IRACASILLA)
                irACasilla.add(s);
        }
        
        return irACasilla;
        
    }
    
    /**
     * @brief Obtener sopresas de cierto tipo
     * @param sorpresas Array de Sorpresas
     * @param tipo Tipo de sorpresa a buscar
     * @return Arrar con las sorpresas tipo
     */
                                       
    private static ArrayList<Sorpresa> getSorpresasTipo
                                       (ArrayList<Sorpresa> sorpresas,
                                        TipoSorpresa tipo){
    
        //Creamos Array vacio
        ArrayList<Sorpresa> sorpresasTipo = new ArrayList<>();
        
        //Buscamos las sorpresas que coincidan y las añadimos
        for (Sorpresa s: sorpresas){
            if(s.getTipo() == tipo)
                sorpresasTipo.add(s);
        }
        
        return sorpresasTipo;
        
    }
   
                                       

    private static ArrayList<String> getNombreJugadores(){
        
        int numeroJugadores;
        ArrayList<String> nombres = new ArrayList<>();
        
        do{
            System.out.println("Introduce el numero de jugadores (de 2 a 4):");
            numeroJugadores = in.nextInt();
        }while(numeroJugadores > 4 || numeroJugadores < 2);
        
        in.nextLine();
        
        for(int i = 0; i < numeroJugadores; i++){
            System.out.println("Introduce el nombre del jugador " + i + "\n" );
            String n = in.nextLine();
            nombres.add(n);
        }
        
        return nombres;
    }
                                       
    
    public static void main(String[] args) {
        
        /* PREBAS PRACTICA 1
        
        //Mostramos las cartas
        for (Sorpresa s: juego.getMazo()){
            System.out.println(s.toString());
        }
        
        //Prueba de funciones
        System.out.println("Prueba 1:");

        for(Sorpresa s: getSorpresasPositivas(juego.getMazo())){
            System.out.println(s.toString());
        }
        
        for(Sorpresa s: getSorpresasIrACasilla(juego.getMazo())){
            System.out.println(s.toString());
        }
        
        
        for(TipoSorpresa tipo: TipoSorpresa.values()){
            System.out.println("Nuevo tipo");
            
            for(Sorpresa s: getSorpresasTipo(juego.getMazo(),tipo)){
                System.out.println(s.toString());
            }
        }
        
        System.out.println("\nTenemos el siguiente tablero: \n");
        
        System.out.println(juego.getTablero().toString());
            
       */
        
        juego.inicializarJuego(getNombreJugadores());
                
        for (int i = 0; i < juego.getJugadores().size(); i++){
            System.out.println("Jugador " + i + " : " +
                                juego.getJugadores().get(i));
        }
        
        
        System.out.println(juego.toString());
        
    }
    
}
