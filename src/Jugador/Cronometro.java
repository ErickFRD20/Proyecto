/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugador;

/**
 *
 * @author josed
 */
public class Cronometro {
    private int segundos;
    private boolean iniciado;
    
    public Cronometro(){
      segundos = 0;
      iniciado = false;
    }

    public int getSegundos() {
        return segundos;
    }

    public boolean isIniciando() {
        return iniciado;
    }
   public void iniciar(){
       iniciado = true;
       
   }
   public void detener(){
       iniciado = false;
   }
   public void aumentarSegundo(){
       if (iniciado){
           segundos++;
       }
   }
   public void reiniciar(){
       segundos = 0;
       iniciado = false;
   }
}

