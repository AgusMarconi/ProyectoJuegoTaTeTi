
package juegotateti.Clases;

import java.util.Scanner;

/**
 *
 * @author Agus
 */
public class Arbitro {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tabla;


    public Arbitro() {
         //Creamos a los dos jugadores;
        this.jugador1 = new Jugador("X");
        this.jugador2 = new Jugador("O");
        this.tabla = new Tablero();//Creamos una clase Tablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Tablero getTabla() {
        return tabla;
    }

    public void setTabla(Tablero tabla) {
        this.tabla = tabla;
    }
    
    public void Inicio() throws Exception{
        Scanner leer=new Scanner(System.in);
        //Mostramos un mensaje de bienvenida para el juego;
        System.out.println("Inicio del Juego");
        
        System.out.println("¡¡BIENVENIDO AL JUEGO TA TE TI GAME!! ");
        System.out.println("1°Jugador: X  ║  2°Jugador: O");
        
        String decision;//Creamos una variable String para un opción del juego más adelante;
        ingresarNombres();//Usamos un metodo para ingresar los nombres de los jugadores;
        int i=1;//Creamos una variable i para indicar las rondas jugadas;
        while (true){//Usamos un bucle para que el juego siempre corra;
            System.out.println("RONDA "+i+"=================");
            JuegoEnCurso();//Llamamos un metodo donde se ejecuta el juego;
            //Mostramos el resultado de la jugada y los puntajes que cada jugador;
            System.out.println("PUNTAJES--> 1°Jugador: "+jugador1.getPuntaje()+"  ║  2°Jugador: "+jugador2.getPuntaje());
            //Consultamos si se quiere seguir con las rondas(mateniendo los puntajes) o se reinicia el juego;
            System.out.println("¿Nuevo Juego? Escriba 'Si'");
            
            decision=leer.nextLine().toLowerCase();
            if (decision.equals("si")){//Dependiendo de la elección, si se reinicia, ponemos todo a 0;
                i=0;
                jugador1.setPuntaje(0);
                jugador2.setPuntaje(0);
            }
            tabla.Limpiar();//En cada nueva ronda de juego se limpia la tabla.
            i++;
        }
    }
    
    public void JuegoEnCurso() throws Exception{//El juego comienza;
        
        Jugador jugador_actual=eleccionAleatoria();//usamos esta variable para guardar al
            //jugador que comenzara, siendo esto aleatoriamente;
        String mensaje;
        while (true){//Usamos un bucle para que se siga el juego hasta que alguien gane o empaten;
            tabla.turno(jugador_actual);//Metodo que hace que el jugador actual, juegue;
            System.out.println("================================");
            mensaje=GanarOEmpatar(jugador_actual);//Metodo que verifica si se sigue, se gano o empato;
            if (!mensaje.equals("")){//Verificamos si se termino el juego;
                //Si se acabo el juego, mostramos la tabla y el mensaje de que ocurrio(victoria o empate);
                tabla.mostrar_tabla();
                System.out.println(mensaje);
                break;//Se sale del bucle porque se termino el juego;
            }
            //Si no se termino, se cambia al siguiente jugador;
            if (jugador_actual.getSimbolo().equals("X")){
                jugador_actual=this.jugador2;
            }else{
                jugador_actual=this.jugador1;
            }
        }
    }
    
    public void ingresarNombres(){//Metodo para ponerle nombres a los jugadores;
        Scanner leer=new Scanner(System.in);
        System.out.print("Nombre Jugador 1: ");
        jugador1.agregarNombre(leer.nextLine().toUpperCase());
        System.out.print("Nombre Jugador 2: ");
        jugador2.agregarNombre(leer.nextLine().toUpperCase());
        
    }
    
    public Jugador eleccionAleatoria(){
        if ((int)(Math.random()*2)+1==1){//Usamos el Math.random para que elija de manera
            //aleatorio al jugador;
            return this.jugador1;
        }
        return this.jugador2;
    }
    
    
    public String GanarOEmpatar(Jugador jugador_actual){//Comprobamos si alguien gano, empataron o sigue el juego;
        if (tabla.tresEnLinea(jugador_actual)){//Con el metodo tresEnLinea() buscamos todas las posibles combinaciones;
            jugador_actual.puntuacion();//Si alguno gano, se le cuma un punto;
            return ("♛ ¡¡EL Jugador "+jugador_actual.getNombre()+" GANO!! ¡¡FELICIDADES!! ♛");
        }
        //Si nadie gano, verificamos si se completo la tabla o si aún hay lugares vacios;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (tabla.getTabla()[i][j].equals(" ")){
                    return ("");//Si aún hy lugares, mandamos este return;
                }
            }
        }return ("☹ NO HAY GANADOR ☹");//Si se comprobo que toda la tabla esta llena, no hay ganadores;
    }
    
    
}
