/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablero;

/**
 *
 * @author UTN
 */
public enum Nivel {
    PRINCIPIANTE(8),
    INTERMEDIO(16),
    AVANZADO(32);
    
    private final int totalParejas;

    private Nivel(int totalParejas) {
        this.totalParejas = totalParejas;
    }
    
    
    public int getTotalParejas() {
        return totalParejas;
    }
    
}
