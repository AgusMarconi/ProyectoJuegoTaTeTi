
package juegotateti.Clases;

/**
 *
 * @author Agus
 */
public class MiExcepcion extends Exception{//Clase Excepciones que usamos para crear nuestras
    //Propias excepciones;
    private String mensaje;
    
    public MiExcepcion() {
    }

    public MiExcepcion(String mimensaje) {
        this.mensaje = mimensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
