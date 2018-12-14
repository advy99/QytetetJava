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
    
    static final int NUM_CASILLAS = 20;
    
    private ArrayList<Casilla> casillas;
    
    private Casilla carcel;
 
    Tablero(){
        
        inicializar();

    }

   
    
    @Override
    public String toString(){
     
        String texto = "\n";
        
        for(Casilla s: casillas){
            texto += s.toString();
        }
        
        texto += "\n\n";
        
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


        
        casillas.add(new OtraCasilla(0,1000, TipoCasilla.SALIDA));
        casillas.add(new Calle(1, t1));
        casillas.add(new Calle(2, t2));
        casillas.add(new Calle(3, t3));
        casillas.add(new OtraCasilla(4, 0, TipoCasilla.SORPRESA));
        casillas.add(new Calle(5, t4));
        casillas.add(new OtraCasilla(6, 700, TipoCasilla.IMPUESTO));
        casillas.add(new Calle(7, t5));
        casillas.add(new Calle(8, t6));
        casillas.add(new OtraCasilla(9, 500, TipoCasilla.CARCEL));
        casillas.add(new Calle(10, t7));
        casillas.add(new Calle(11, t8));
        casillas.add(new OtraCasilla(12, 0, TipoCasilla.SORPRESA));
        casillas.add(new Calle(13, t9));
        casillas.add(new OtraCasilla(14, 0, TipoCasilla.PARKING));
        casillas.add(new Calle(15, t10));
        casillas.add(new OtraCasilla(16, 0, TipoCasilla.SORPRESA));
        casillas.add(new Calle(17, t11));
        casillas.add(new OtraCasilla(18, 0, TipoCasilla.JUEZ));
        casillas.add(new Calle(19, t12));
        
        carcel = casillas.get(9);
    }
    
    
    boolean esCasillaCarcel(int numCasilla){
        return numCasilla == carcel.getNumeroCasilla();
    }
    
    Casilla getCarcel() {
        return carcel;
    }
    
    ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
    Casilla obtenerCasillaFinal(Casilla casilla, int desplazamiento){
        return casillas.get( (casilla.getNumeroCasilla()+desplazamiento) % NUM_CASILLAS );
    }
    
    
    /**
     * @brief Obtener casilla dado un indice por parametro
     * @param numeroCasilla
     * @pre 0 <= numeroCasilla < NUM_CASILLAS
     * @return 
     */
    Casilla obtenerCasillaNumero(int numeroCasilla){
        return casillas.get(numeroCasilla);
    }
}
