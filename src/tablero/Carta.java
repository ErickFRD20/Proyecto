/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablero;

/**
 *
 * @author UTN
 */
public class Carta {
    private int imagen;
    private boolean visible;
    private boolean encontrada;

    public int getImagen() {
        return imagen;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEncontrada() {
        return encontrada;
    }
    
    public void mostrar(){
        visible = true;
    }
    
    public void ocultar(){
        if (!encontrada) {
            visible = false;
        }
    }
    
    public void encontrar(){
        encontrada = true;
        visible = true;
    }
    
    public void reiniciar(){
        visible = false;
        encontrada = false;
    }
    
    public Carta(int imagen) {
        this.imagen = imagen;
        this.visible = false;
        this.encontrada = false;
    }
}
