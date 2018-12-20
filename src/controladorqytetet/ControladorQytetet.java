/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorqytetet;

import java.util.ArrayList;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.EstadoJuego;
import modeloqytetet.Qytetet;

/**
 *
 * @author antonio
 */
public class ControladorQytetet {
    
    static Qytetet modelo = Qytetet.getInstance();
    
    private ArrayList<String> nombreJugadores = new ArrayList<>();
    
    private static final ControladorQytetet instance = new ControladorQytetet();

    
    private ControladorQytetet(){
    
    }
    
    public static ControladorQytetet getInstance(){
        return instance;
    }
  
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas(){
        ArrayList<Integer> operacionesValidas = new ArrayList<>();
        //cambiar al ordinal
        if (modelo.getJugadores() == null || modelo.getJugadores().isEmpty()){
            operacionesValidas.add(OpcionMenu.INICIARJUEGO.ordinal());
        }else{
            EstadoJuego estado = modelo.getEstadoJuego();
            if (estado == EstadoJuego.JA_PREPARADO){
                operacionesValidas.add(OpcionMenu.JUGAR.ordinal());
            
            }else if(estado == EstadoJuego.ALGUNJUGADORENBANCARROTA){
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
            
            }else if(estado == EstadoJuego.JA_CONSORPRESA){
                operacionesValidas.add(OpcionMenu.APLICARSORPRESA.ordinal());
            
            }else if(estado == EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD){
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.ordinal());
            
            }else if(estado == EstadoJuego.JA_ENCARCELADO){
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
            
            }else if(estado == EstadoJuego.JA_PUEDEGESTIONAR){
                operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
            
            }else if(estado == EstadoJuego.JA_PUEDECOMPRAROGESTIONAR){
                operacionesValidas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                
                
            }
            
            operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
            operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
            operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
            operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());

        }
        
        
        return operacionesValidas;
    }
    
    
    
    
    public String realizarOperacion(int opcionElegida, int casillaElegida){
        //INICIARJUEGO
        String aDevolver = "";
        
        if (opcionElegida == 0){ 
            modelo.inicializarJuego(nombreJugadores);
        } else if (opcionElegida == 1){
            aDevolver = modelo.getJugadorActual().toString();
            modelo.jugar();
            aDevolver += "\nHa salido un " + modelo.obtenerValorDado();
            aDevolver += "\nEl jugador se ha movido a la casilla " + modelo.obtenerCasillaJugadorActual();
        
        } else if (opcionElegida == 2){
            aDevolver = "\nSe va a aplicar la siguiente carta sorpresa:" + modelo.getCartaActual().toString();
            modelo.aplicarSorpresa();
        } else if (opcionElegida == 3){
            if (modelo.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD)){
                aDevolver = "\nHas conseguido salir de la carcel\n";
            } else{
                aDevolver = "\nNo has conseguido salir de la carcel\n";
            }
        } else if (opcionElegida == 4){
            if (modelo.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO)){
                aDevolver = "\nHas conseguido salir de la carcel\n";
            } else{
                aDevolver = "\nNo has conseguido salir de la carcel\n";
            }
        } else if (opcionElegida == 5){
            if(modelo.comprarTituloPropiedad()){
                aDevolver = "\nSe ha comprado el titulo correctamente\n";
            }else{
                aDevolver = "\nNo se ha podido comprar el titulo\n";
            }
        } else if (opcionElegida == 6){
            modelo.hipotecarPropiedad(casillaElegida);
        } else if (opcionElegida == 7){
            modelo.cancelarHipoteca(casillaElegida);
        } else if (opcionElegida == 8){
            if (modelo.edificarCasa(casillaElegida)){
                aDevolver = "\nSe ha edificado la casa correctamente\n";
            } else{
                aDevolver = "\nNo se ha podido edificar la casa\n";
            }
        } else if (opcionElegida == 9){
            if(modelo.edificarHotel(casillaElegida)){
                aDevolver = "\nSe ha edificado el hotel correctamente\n";
            } else{
                aDevolver = "\nNo se ha podido edificar el hotel\n";
            }
            
        } else if (opcionElegida == 10){
            modelo.venderPropiedad(casillaElegida);
        } else if (opcionElegida == 11){
            modelo.siguienteJugador();
        } else if (opcionElegida == 12){
            modelo.obtenerRanking();
        } else if (opcionElegida == 13){
            System.exit(0);
        } else if (opcionElegida == 14){
            aDevolver = modelo.getJugadorActual().toString();
        } else if (opcionElegida == 15){
            aDevolver = modelo.getJugadores().toString();
        } else if (opcionElegida == 16){
            aDevolver = modelo.getTablero().toString();
        }
        
            
        return aDevolver;
        
    }
    
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu){
        ArrayList<Integer> casillasValidas = new ArrayList<>();
        
        OpcionMenu opcion = OpcionMenu.values()[opcionMenu];
        
        if (opcion == OpcionMenu.CANCELARHIPOTECA){
            casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true);
        } else if (opcion == OpcionMenu.COMPRARTITULOPROPIEDAD){
            casillasValidas.add(modelo.obtenerCasillaJugadorActual().getNumeroCasilla());
        } else if (opcion == OpcionMenu.EDIFICARCASA || opcion == OpcionMenu.EDIFICARHOTEL){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        } else if (opcion == OpcionMenu.HIPOTECARPROPIEDAD){
            casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false);
        } else if (opcion == OpcionMenu.VENDERPROPIEDAD){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        
        return casillasValidas;
        
    }
    
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores){
        this.nombreJugadores = nombreJugadores;
    }
    
    
    public boolean necesitaElegirCasilla(int valor){
        return (valor == OpcionMenu.HIPOTECARPROPIEDAD.ordinal() || 
                valor == OpcionMenu.CANCELARHIPOTECA.ordinal()   ||
                valor == OpcionMenu.EDIFICARCASA.ordinal()       ||
                valor == OpcionMenu.EDIFICARHOTEL.ordinal()      ||
                valor == OpcionMenu.VENDERPROPIEDAD.ordinal()    );
    
    }
    
}
