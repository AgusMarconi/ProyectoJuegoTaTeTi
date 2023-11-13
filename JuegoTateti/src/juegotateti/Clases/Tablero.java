
package juegotateti.Clases;

import java.util.Scanner;

/**
 *
 * @author Agus
 */
public class Tablero {
    private String[][] tabla;

    public Tablero() {
        tabla=new String[3][3];//Creamos la tabla del TATETI;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                this.tabla[i][j]=" ";//Ponemos a todas las casillas en " ";
            }
        }
    }

    public String[][] getTabla() {
        return tabla;
    }

    public void setTabla(String[][] tabla) {
        this.tabla = tabla;
    }
    
    public void mostrar_tabla(){//Con este metodo mostramos la tabla;
        System.out.println("       0        1        2");
        System.out.println("  ╔═════╦═════╦═════╗");
        for (int i=0;i<3;i++){
            System.out.println(i+" ║    "+tabla[i][0]+"   ║    "
                    +tabla[i][1]+"   ║   "
                    +tabla[i][2]+"   ║   ");
            if (i==2){
                break;
            }
            System.out.println("  ╠═════╬═════╬═════╣");
        }
        System.out.println("  ╚═════╩═════╩═════╝");
    }
    
    
    public void elegirCasilla(Jugador jugador_actual) throws Exception{//Con este metodo hacemos
        //elegir al jugador que casilla marcara, pero teniendo en cuenta que no puedo marcar
        //el mismo lugar que el otro oponente ya marco;
        Scanner leer=new Scanner(System.in);
        System.out.println("Elija una casilla: ");
        System.out.print("Fila: ");//Pedimor el numero de la fila;
            try {
            int i=Integer.parseInt(leer.nextLine());
            System.out.print("Columna: ");//Pedimos el numero de la columna;
            int j=Integer.parseInt(leer.nextLine());
        
            if (this.tabla[i][j].equals(" ")){//Verificamos si la casilla esta vacia;
                this.tabla[i][j]=jugador_actual.getSimbolo();
                
            }else{//Si no lo esta, mandamos una Excepción avisando que ya esta ocupada;
                throw new MiExcepcion("Error: lugar ocupado.");
            }
            
        } catch (MiExcepcion ME) {//Con esta excepción atrapamos el throw personal;
            System.out.println("======"+ME.getMessage()+"======");
            elegirCasilla(jugador_actual);//Hasta que no ingrese correctamente, no saldra del metodo;
        }catch (NumberFormatException NFE){//Otras posibles excepciones;
            System.out.println("======Error: Formato incorrecto, debe ser un número entre 0 y 2.======");
            elegirCasilla(jugador_actual);//Hasta que no ingrese correctamente, no saldra del metodo;
        }catch (ArrayIndexOutOfBoundsException AIOBE){
            System.out.println("======Error: Lugar fuera de rango.======");
            elegirCasilla(jugador_actual);//Hasta que no ingrese correctamente, no saldra del metodo;
        }
        
    }
    
    public boolean tresEnLinea(Jugador jugador_actual){//Metodo donde verificamos todas las posibles tres en linea;
        boolean valor=true;
        for (int r=0;r<2;r++){
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    switch (r) {
                        case 0:
                            //Comprobación por fila;
                            valor=tabla[i][j].equals(jugador_actual.getSimbolo());
                            break;
                        case 1:
                            //Comprobación por columna;
                            valor=tabla[j][i].equals(jugador_actual.getSimbolo());
                            break;
                    }
                    if (valor==false){//Si hubo alguna diferencia, pasamos a la siguiente comprobación
                        break;
                    }
                }if (valor==true){//Si una linea dio todo bien, devolvemos el tres en linea True;
                    return true;
                }
            }
        }
        //Comprobación por diagonal principal;
        if (tabla[0][0].equals(jugador_actual.getSimbolo()) && tabla[0][0].equals(tabla[1][1]) && tabla[0][0].equals(tabla[2][2])){
            return true;
        }//Comprobación por diagonal inversa;
        return tabla[0][2].equals(jugador_actual.getSimbolo()) && tabla[0][2].equals(tabla[1][1]) && tabla[0][2].equals(tabla[2][0]);
    }
    
    public void turno(Jugador jugador_actual) throws Exception{//Metodo que hace jugar al jugador actual;
           System.out.println("TABLA:");
           mostrar_tabla();
           System.out.println("Turno de "+jugador_actual.getNombre());
           elegirCasilla(jugador_actual);
        
    }
    public void Limpiar(){//Metodo que vacia la tabla;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tabla[i][j]=" ";
            }
        }
    }
    
}
