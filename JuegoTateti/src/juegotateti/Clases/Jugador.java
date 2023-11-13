
package juegotateti.Clases;

/**
 *
 * @author Agus
 */
public class Jugador {
    private String nombre;//Nombre del jugador;
    private int puntaje;//El puntaje que ira teniendo;
    private String simbolo;//El simbolo "X" o "O" según corresponda;


    public Jugador(String simbolo) {
        this.puntaje = 0;//El puntaje siempre iniciara en 0;
        this.simbolo=simbolo;//El simbolo se lo agregamos cuando creamos la clase;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getSimbolo() {
        return simbolo;
    }
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    
    
    public void agregarNombre(String nombre){
        this.nombre=nombre;//Agregamos el nombre;
    }
    
    public void puntuacion(){
        puntaje=puntaje+1;//Su puntuación aumentara en 1 si gana;
        
    }
}
