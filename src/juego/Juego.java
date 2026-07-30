/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import Jugador.ControladorJugador;
import tablero.Carta;
import tablero.Nivel;
import tablero.Tablero;

/**
 *
 * @author mr117
 */
public class Juego {
    private Tablero tablero;
    private ControladorJugador controladorJugador;
    private Nivel nivel;
    
    private Carta primeraCarta;
    private Carta segundaCarta;
    private boolean bloqueado;


    
    public Juego(){
        nivel = Nivel.PRINCIPIANTE;
        tablero = new Tablero(nivel);
        controladorJugador = new ControladorJugador();
        
    primeraCarta = null;
    segundaCarta = null;
    bloqueado= false;
}
    public void iniciarPartida(){
        tablero = new Tablero(nivel);
        controladorJugador.iniciarJuego();
        primeraCarta =null;
        segundaCarta = null;
        bloqueado = false;
    }
    
    public void reiniciarPartida(){
        tablero.reiniciar();
        controladorJugador.reiniciarJuego();
        primeraCarta = null;
        segundaCarta =  null;
        bloqueado = false;
    }
    
    public void cambiarNivel(Nivel nivel){
        this.nivel = nivel;
        iniciarPartida();
    }
    
    public void seleccionarCarta(int fila,int columna){
        if(bloqueado){
            return;
        }
        
       Carta carta = tablero.obtenerCarta(fila, columna);
       if (carta == null || carta.isEncontrada()||carta.isVisible()){
           return;
       }
           carta.mostrar();
           if(primeraCarta == null){
               primeraCarta = carta;
           }else{
               segundaCarta = carta;
               compararCartas();  
       }
           }
   
    private void compararCartas(){
        controladorJugador.registrarIntento();
        
        if(tablero.compararCartas(primeraCarta,segundaCarta)){
            primeraCarta.encontrar();
            segundaCarta.encontrar();
            controladorJugador.encontrarPareja();
            primeraCarta = null;
            segundaCarta = null;
        }else{
            bloqueado = true;
        }        
    }
    
    public void ocultarCartas(){
        
    }
    public boolean juegoFinalizado(){
        return false;
    }
    
}