/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugador;

/**
 *
 * @author josed
 */
public class Jugador {
    private int puntaje;
    private int intentos;
    private int parejasEncontradas;
    
    public Jugador(){
        puntaje = 0;
        intentos = 0;
        parejasEncontradas = 0;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getParejasEncontradas() {
        return parejasEncontradas;
    }
    
    public void registrarIntentos(){
        intentos++;
        if (puntaje >= 20){
            puntaje -=20;
            
        }else{
            puntaje = 0;
        }
    }
    public void registrarPareja(){
        parejasEncontradas++;
        puntaje += 100;
    }
 public void reiniciar(){
     puntaje = 0;
     intentos = 0;
     parejasEncontradas = 0;
 }   
 
}
