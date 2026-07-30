/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import tablero.Nivel;
import tablero.Tablero;

/**
 *
 * @author mr117
 */
public class ControladorJuego {
    private Juego juego;
    
   
    public Juego getJuego() {
        return juego;
    }
    public Tablero getTablero() {
    return juego.getTablero();
    }
    public int getPuntaje(){
        return juego.getPuntaje();
    }
    public int getIntentos(){
        return juego.getIntentos();
    }
    public int getParejas(){
        return juego.getParejas();
    }
    public int getTiempo(){
        return juego.getTiempo();
    }
    public ControladorJuego(){
    juego = new Juego();
    } 
        
    
    public void iniciarJuego(){
        juego.iniciarPartida();
    }
    public void reiniciarJuego(){
        juego.reiniciarPartida();
    }
    public void cambiarNivel(Nivel nivel){
        juego.cambiarNivel(nivel);
    }
    public void seleccionarCarta(int fila, int columna){
        juego.seleccionarCarta(fila, columna);
    }
    public void ocultarCartas(){
        juego.ocultarCartas();
    }
    public boolean juegoFinalizado(){
        return juego.juegoFinalizado();
    }
}
