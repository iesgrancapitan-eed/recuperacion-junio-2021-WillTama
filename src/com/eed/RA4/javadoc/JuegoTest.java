package com.eed.RA4.javadoc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Sirve para jugar la partida.
 * Juego: Boggle
 * Una cantidad de jugadores a elegir jugarán para adivinar palabras durante 50 segundos. Una serie de dados se volcarán en un tablero 4x4
 * quedando así un tablero con letras. Para sumar puntos las palabras deben poder formarse siguiendo una cadena, sólo con las letras de alrededor.
 * También, debe aparecer en la RAE.
 * El jugador con más puntos gana
 * @author hetag
 *
 */
public class JuegoTest {

  /**
   * Segundos de partida
   */
  static final int segundos = 50;

  /**
   * Comprueba si el jugador quiere salir
   * @return true si el jugador quiere salir, false si no
   */
  static boolean deseoSalir() {
    Scanner s = new Scanner(System.in);
    System.out.println("¿Quiéres jugar otra? (s/n)");
    String salir = s.nextLine();

    if (salir.toLowerCase().charAt(0) == 's') {
      return true;
    }
    return false;
  }

  /**
   * Muestra los puntos de todos los jugadores
   * @param jugadores que han jugado
   */
  static void mostrarPuntos(ArrayList<Jugador> jugadores) {

    for(int i = 0; i<jugadores.size(); i++) {
      System.out.println(jugadores.get(i).getNombre() + " acertó: {"
          + jugadores.get(i).devolvePalabrasAcertadas() + "}, total de: " + jugadores.get(i).getPuntos() + " PUNTOS.");
    }    
  }

  /**
   * Muestra al jugador ganador
   * @param jugadores que han jugado
   */
  static void mostrarGanador(ArrayList<Jugador> jugadores) {

    System.out.println("Y el trofeo es para...");

    int puntuacionMax = 0;

    for(int i = 0; i<jugadores.size(); i++) {
      if(jugadores.get(i).getPuntos() >= puntuacionMax) {
        puntuacionMax = jugadores.get(i).getPuntos();
      }
    }

    String ganadores = "";
    for(int i = 0; i<jugadores.size(); i++) {
      if(jugadores.get(i).getPuntos() == puntuacionMax) {
        ganadores = ganadores + jugadores.get(i).getNombre() + " ";
      }
    }

    System.out.println("¡¡FELICIDADES " + ganadores + "...!!");
  }


  /**
   * Crea una colección con las palabras de la RAE
   * @return colección con las palabras de la RAE
   * @throws IOException
   */
  static HashSet<String> crearColeccionRAE() throws IOException {
    BufferedReader ficheroRAE = new BufferedReader(new FileReader("RAE.txt"));
    String linea;//Declaro para usar luego


    //Añado las palabras de la rae sin tildes a una colección
    HashSet<String> palabrasRAE = new HashSet<String>();
    while((linea=ficheroRAE.readLine()) != null) {
      palabrasRAE.add(linea);
    }

    ficheroRAE.close();
    return palabrasRAE;
  }
  
    
 

  /**
   * Crea jugadores 
   * @param númeroDeJugadores que participan
   * @return jugadores
   */
  static ArrayList<Jugador> crearJugadores(int numeroDeJugadores) {
    Scanner s = new Scanner(System.in);
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    String jugador = "";

    for(int i = 0; i < numeroDeJugadores; i++) {
      System.out.println("Nombre del jugador " + (i+1) +": ");
      
      jugador = s.nextLine();
      
      if (jugador.equals("")) {
        jugadores.add(new Jugador("Jugador " + (i+1)));
      }
      else {
        jugadores.add(new Jugador(jugador));
      }
      
    }

    return jugadores;
  }

  /**
   * Pausa hasta pulsar intro
   */
  private static void pausar() {
    Scanner s = new Scanner(System.in);
    System.out.println("Pulsa intro para comenzar...");
    s.nextLine();
  }

  /**
   * Pausa hasta pulsar intro
   */
  private static void pausar2() {
    Scanner s = new Scanner(System.in);
    System.out.println("Pulsa intro para continuar...");
    s.nextLine();
  }

  /**
   * Se encarga del proceso de la partida del Boggle. 
   * Se empezará eligiendo los jugadores.
   * Así, los jugadores empezarán a competir por ver quién tiene más puntos hasta que se desee terminar con la partida.
   * @param args
   */
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    try {
      String palabra = "";
      int jugador;
      HashSet<String> palabrasRAE = crearColeccionRAE();
      Tablero tablero;
      ArrayList<Jugador> jugadores;
      Contador contador;


      do {
        System.out.println("BIENVENIDO AL BOGGLE");
        System.out.println();
        System.out.println();

        tablero = new Tablero();

        System.out.println("¿Cuántos jugadores serán?: ");
        jugadores = crearJugadores(s.nextInt());
        s.nextLine();

        for (int i = 0; i < jugadores.size(); i++) {

          System.out.println("Es el turno de " + jugadores.get(i).nombre + ": ");
          pausar();


          contador = new Contador();
          contador.cuentaAtras(segundos);

          while (contador.intervalo > 0) {

            System.out.println(tablero);
            System.out.println("Quedan " + contador.intervalo + " segundos");

            System.out.print("Palabra: ");
            palabra = s.nextLine();

            if (tablero.esPalabraCorrecta(palabra, palabrasRAE) && contador.intervalo > 0) {
              jugadores.get(i).addPalabra(palabra);
            }

          }

          System.out.println("SE ACABÓ EL TIEMPO");
        }
        
        pausar2();
        System.out.println("HORA DE SABER LOS GANADORES\n");
        mostrarPuntos(jugadores);
        System.out.println();
        mostrarGanador(jugadores);
        pausar2();



      } while (deseoSalir());

      System.out.println("HASTA LA PRÓXIMA");

    } 
    catch (IOException e) {
      e.printStackTrace();
    }
    
    catch (InputMismatchException e) {
      System.out.println("Debes insertar un número");
      pausar2();
    }
    
    



  }



}