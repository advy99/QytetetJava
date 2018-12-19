/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistatextualqytetet;

import controladorqytetet.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class VistaTextualQytetet {
    
    private static final Scanner in = new Scanner (System.in);

    private ControladorQytetet controlador = new ControladorQytetet();
    
    public int elegirCasilla(int ordinalOpcionMenu){
        ArrayList<Integer> casillasValidas = controlador.obtenerCasillasValidas(ordinalOpcionMenu);
        ArrayList<String>  casillas = new ArrayList<>();
        int valorDevolver;
        
        if(casillasValidas.isEmpty()){
            valorDevolver = -1;
        }else {
            for (Integer i: casillasValidas){
                System.out.println(i);
                casillas.add(Integer.toString(i));
            }

            valorDevolver = Integer.parseInt(leerValorCorrecto(casillas));
        }
    
        return valorDevolver;
    }
    
    
    
    
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
    
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos){
        String valor;
       
        valor = in.next();
                
        while(!valoresCorrectos.contains(valor)){
            System.out.println("ERROR: No has introducido un valor correcto, vuelve a probar.");
            valor = in.next();
        }
        
        return valor;
        
    }
    
    public int elegirOperacion(){
        ArrayList<Integer> operacionesValidasEntero = controlador.obtenerOperacionesJuegoValidas();
        ArrayList<String> operacionesValidas = new ArrayList<>();
                
        
        for(int i: operacionesValidasEntero){
            operacionesValidas.add(Integer.toString(i));
            
            System.out.println( i + " : " + OpcionMenu.values()[i]);
        }
                
          
        int operacion = Integer.parseInt(leerValorCorrecto(operacionesValidas));
        
        
        return operacion;
        
    }
    
    
    
    public static void main(String[] args) {
        
        VistaTextualQytetet ui = new VistaTextualQytetet();
        ui.controlador.setNombreJugadores(ui.obtenerNombreJugadores());
        int operacionElegida = 0, casillaElegida = 0;
        boolean necesitaElegirCasilla;
        do {
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = ui.controlador.necesitaElegirCasilla(operacionElegida);
            if (necesitaElegirCasilla)
                casillaElegida = ui.elegirCasilla(operacionElegida);
            if (!necesitaElegirCasilla || casillaElegida >= 0)
                System.out.println(ui.controlador.realizarOperacion(operacionElegida, casillaElegida));
        } while (1 == 1);
    }
    
    
    
}
