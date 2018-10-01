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
public class Tablero {
    
    private ArrayList<Casilla> casillas;
    
    private Casilla carcel;
 
    public Tablero(){
        
        inicializar();

    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public Casilla getCarcel() {
        return carcel;
    }
    
    @Override
    public String toString(){
     
        String texto = "\n";
        
        for(Casilla s: casillas){
            texto += s.toString();
        }
        
        //texto += carcel.toString();
        
        return texto;
        
    }
    
    
    private void inicializar(){
        casillas = new ArrayList<>();
        
        TituloPropiedad t1 = new TituloPropiedad( "Calle", 713, 207,
                                                (float) 1.3, 3000, 300);
        
        TituloPropiedad t2 = new TituloPropiedad( "Avenida", 1300, 400,
                                                (float) 1.9, 4000, 600);
        
        TituloPropiedad t3 = new TituloPropiedad( "Carretera", 599, 150,
                                                (float) 0.9, 1400, 1975);
        
        TituloPropiedad t4 = new TituloPropiedad( "Rotonda", 1720, 450,
                                                (float) 1, 4000, 1999);
        
        TituloPropiedad t5 = new TituloPropiedad( "Acera", 502, 130,
                                                (float) 0.6, 900, 800);
        
        TituloPropiedad t6 = new TituloPropiedad( "CarrilBici", 912, 234,
                                                (float) 0.8, 1800, 1120);
        
        TituloPropiedad t7 = new TituloPropiedad( "Metro", 3290, 700,
                                                (float) 2.5, 6000, 2800);
        
        TituloPropiedad t8 = new TituloPropiedad( "Bus", 560, 140,
                                                (float) 2.9, 1200, 600);
        
        TituloPropiedad t9 = new TituloPropiedad( "Taxi", 1543, 320,
                                                (float) 1.2, 3500, 2000);

        TituloPropiedad t10 = new TituloPropiedad( "Coche", 3198, 690,
                                                (float) 2.2, 10000, 1790);

        TituloPropiedad t11 = new TituloPropiedad( "Tranvia", 587, 100,
                                                (float) 0.2, 10000, 400);

        TituloPropiedad t12 = new TituloPropiedad( "Limusina", 890, 300,
                                                (float) 3.2, 10000, 200);


        
        casillas.add(new Casilla(0, TipoCasilla.SALIDA));
        casillas.add(new Casilla(1, t1));
        casillas.add(new Casilla(2, t2));
        casillas.add(new Casilla(3, t3));
        casillas.add(new Casilla(4, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(5, t4));
        casillas.add(new Casilla(6, TipoCasilla.IMPUESTO));
        casillas.add(new Casilla(7, t5));
        casillas.add(new Casilla(8, t6));
        casillas.add(new Casilla(9, TipoCasilla.CARCEL));
        casillas.add(new Casilla(10, t7));
        casillas.add(new Casilla(11, t8));
        casillas.add(new Casilla(12, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(13, t9));
        casillas.add(new Casilla(14, TipoCasilla.PARKING));
        casillas.add(new Casilla(15, t10));
        casillas.add(new Casilla(16, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(17, t11));
        casillas.add(new Casilla(18, TipoCasilla.JUEZ));
        casillas.add(new Casilla(19, t12));
        
        carcel = casillas.get(9);
    }
    
}
