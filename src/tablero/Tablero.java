/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablero;

/**
 *
 * @author UTN
 */
public class Tablero {
    private Carta[][] tablero;
    private Nivel nivel;

    public Tablero(Nivel nivel) {
        this.nivel = nivel;
        crearTablero();
    }
    
    public void crearTablero(){
        if(nivel == Nivel.PRINCIPIANTE){
            tablero = new Carta[4][4];
        }else if(nivel == Nivel.INTERMEDIO){
            tablero = new Carta[4][8];
        }else if(nivel == Nivel.AVANZADO){
            tablero = new Carta[8][8];
        }
    }
    
    public void distribuirParejas(){
        
    }
    
    public Carta obtenerCarta(int fila, int columna){
        return tablero[fila][columna]; 
    }
    
    public boolean juegoFinalizado(){ 
        return false;
    }
    
    public void reiniciar(){
        
    }
}
