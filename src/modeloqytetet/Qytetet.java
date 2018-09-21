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
public class Qytetet {
    
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    
    
    ArrayList<Sorpresa> getMazo(){
        return mazo;
    }
    
    void inicializarCartasSorpresa(){
        
        mazo.add(new Sorpresa ("Un fan anónimo ha pagado tu fianza. Sales " +
                 "de la cárcel", 0, TipoSorpresa.SALIRCARCEL));
        
        mazo.add(new Sorpresa ("Por ir tan rápido debes pagar una multa de" +
                "500 euros", -500, TipoSorpresa.PAGARCOBRAR));
        
        mazo.add(new Sorpresa ("Por ser tan buen programador te damos un premio" +
                " de 1000 euros", 1000, TipoSorpresa.PAGARCOBRAR));
        
        mazo.add(new Sorpresa ("Es tu cumpleaños y tus compañeros son generosos," +
               " cada jugador te da 200 euros", 200, TipoSorpresa.PORJUGADOR));
        
        mazo.add(new Sorpresa ("No era tu cumpleaños, ¡mentiroso!. Debes darle"
        + " a los demás lo que te han dado con intereses, 300 euros a cada uno",
        -300, TipoSorpresa.PORJUGADOR));
        
        mazo.add(new Sorpresa ("Eres muy emprendedor, obtienes 100 euros por "+
        "cada casa y hotel que poseas", 100, TipoSorpresa.PORCASAHOTEL));
        
        mazo.add(new Sorpresa ("Tienes demasiadas propiedades, deja algo para" +
        " los demás. Paga 150 euros por cada casa y hotel", -150, 
        TipoSorpresa.PORCASAHOTEL));
        
        mazo.add(new Sorpresa ("Te hemos pillado con chanclas y calcetines," +
        "lo sentimos, ¡debes ir a la carcel!", 9, TipoSorpresa.IRACASILLA));
        
        mazo.add(new Sorpresa ("Has tenido suerte, vas a cobrar sin trabajar." +
        "Ve a la casilla de salida.", 0, TipoSorpresa.IRACASILLA));
        
        mazo.add(new Sorpresa ("Encuentras un atajo en el camino.",
                18, TipoSorpresa.IRACASILLA));
    }
    
    
}
