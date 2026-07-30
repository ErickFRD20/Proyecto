/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablero;
import java.util.Random;
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
        distribuirParejas();
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
        int totalParejas = nivel.getTotalParejas();
        int[] imagenes = new int[totalParejas * 2];
        int posicion =0;
        
        //este metodo crea dos imagenes iguales por cada pareja
        for (int i = 1; i <= totalParejas; i++) {
            imagenes[posicion] = i;
            posicion++;
            
            imagenes[posicion] = i;
            posicion++;
        }
        
        //este metodo mezcla las imagenes
        Random aleatorio = new Random();
        
        for (int i = 0; i < imagenes.length; i++) {
            int posicionAleatoria = aleatorio.nextInt(imagenes.length);
            int auxiliar = imagenes[i];
            imagenes[i] = imagenes[posicionAleatoria];
            imagenes[posicionAleatoria] = auxiliar;
        }
        
        //este metodo coloca las imagenes dentro de la matriz
        posicion = 0;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                tablero[fila][columna] = new Carta(imagenes[posicion]);
                posicion++;
            }
        }
    }
    
    public Carta obtenerCarta(int fila, int columna){
        return tablero[fila][columna]; 
    }
    
    public boolean compararCartas(Carta carta1, Carta carta2){
        return carta1.getImagen() == carta2.getImagen();
    }
    
    public boolean juegoFinalizado(){ 
            for (int fila = 0; fila < tablero.length; fila++) {
                for (int columna = 0; columna < tablero[fila].length; columna++) {
                    if (!tablero[fila][columna].isEncontrada()) {
                        return false;
                    }
                }
        }
            return true;
    }
    
    public void reiniciar(){
        
    }
}
