/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugador;

/**
 *
 * @author josed
 */
public class ControladorJugador {
    private Jugador jugador;
    private Cronometro cronometro;
    
    public ControladorJugador(){
        jugador = new Jugador();
        cronometro = new Cronometro();
    }
   public void iniciarJuego(){
       jugador.reiniciar();
       cronometro.reiniciar();
       cronometro.iniciar();
   }
   public void registrarIntento(){
       jugador.registrarIntentos();
   }
   public void encontrarPareja(){
       jugador.registrarPareja();
   }
   
   public void detenerJuego(){
       cronometro.detener();
   }
   public void aumentarTiempo(){
       cronometro.aumentarSegundo();
   }
   
   public void reiniciarJuego(){
       jugador.reiniciar();
       cronometro.reiniciar();
   }
   public int getPuntaje(){
    return jugador.getPuntaje();
   }
   
   public int getIntentos(){
       return jugador.getIntentos();
   }
   public int getParejas(){
       return jugador.getParejasEncontradas();
   }
   public int getTiempo(){
       return cronometro.getSegundos();
   }
   public Cronometro getCronometro(){
       return cronometro;
   }
   
   
}
   
