
package juegotateti;

import juegotateti.Clases.Arbitro;
/*
Proyecto Programación: Juego tradicional Ta Te Ti Versión Terminal.
Curso: 1°2° Desarrollo de Software, Godoy Cruz.
Profesor: Nevada Claudia. 
Integrantes: Ortega Katia, Martino Tomas, Quevedo Alejo, Marconi Agustina.
*/

public class JuegoTateti {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
         
         Arbitro arbitro=new Arbitro();//Creamos una clase arbitro, que manejara todo;
         //tablero.setArbitro(arbitro);
         arbitro.Inicio();//Aqui comienza la magia...
    }
    
}
