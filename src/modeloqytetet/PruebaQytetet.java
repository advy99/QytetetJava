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
public class PruebaQytetet {

    /**
     * @param args the command line arguments
     */
    
    static Qytetet juego = new Qytetet();
    
    static private ArrayList<Sorpresa> getSorpresasPositivas(ArrayList<Sorpresa> sorpresas){
    
        ArrayList<Sorpresa> positivas = new ArrayList<>();
        
        for (Sorpresa s: sorpresas){
            if(s.getValor() > 0)
                positivas.add(s);
        }
        
        return positivas;
        
    }
    
    static private ArrayList<Sorpresa> getSorpresasIrACasilla(ArrayList<Sorpresa> sorpresas){
    
        ArrayList<Sorpresa> irACasilla = new ArrayList<>();
        
        for (Sorpresa s: sorpresas){
            if(s.getTipo() == TipoSorpresa.IRACASILLA)
                irACasilla.add(s);
        }
        
        return irACasilla;
        
    }
    
    static private ArrayList<Sorpresa> getSorpresasTipo(ArrayList<Sorpresa> sorpresas,
                                                  TipoSorpresa tipo){
    
        ArrayList<Sorpresa> sorpresasTipo = new ArrayList<>();
        
        for (Sorpresa s: sorpresas){
            if(s.getTipo() == tipo)
                sorpresasTipo.add(s);
        }
        
        return sorpresasTipo;
        
    }
    
    
    public static void main(String[] args) {
        
        juego.inicializarCartasSorpresa();
        
        for (Sorpresa s: juego.getMazo()){
            System.out.println(s.toString());
        }
        
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
        
        
    }
    
}
