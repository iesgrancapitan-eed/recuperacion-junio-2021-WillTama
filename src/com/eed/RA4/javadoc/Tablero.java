package com.eed.RA4.javadoc;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * Tablero que representa un tablero 4x4 de letras
 * @author hetag
 *
 */
public class Tablero {
  /**
   * Contiene letras
   */
  char[] tableroDeJuego = new char[16];
  
  /**
   * Crea objetos de tipo Tablero
   */
  Tablero(){
    this.llenarTablero();
  }


  /**
   * Llena el tablero de letras
   */
  public void llenarTablero() {
    for(int i = 0; i < tableroDeJuego.length; i++) {
      tableroDeJuego[i] = (new Dado()).getCaraAleatoria();
    }
  }
  
  /**
   * Comprueba si la palabra está en el tablero
   * @param palabra introducida
   * @return true si la palabra está en el tablero false si no lo está
   */
  public boolean estaPalabraEnTablero(String palabra) {
    
    if (palabra.length() == 0) {
      return false;
    }
    
    palabra = palabra.toUpperCase();
    ArrayList<Integer> posiciones1 = new ArrayList<Integer>();
    ArrayList<Integer> posiciones2 = new ArrayList<Integer>();
    
    for(int i = 0; i < tableroDeJuego.length; i++) {
      if(palabra.charAt(0) == tableroDeJuego[i]) {
        posiciones1.add(i);
      }
    }
    for(int i = 1; i<palabra.length(); i++) {

      for(int j = 0; j<posiciones1.size(); j++) {

        for(int k = 0; k < (devuelvePosicionesContiguas(posiciones1.get(j)).size()); k++) {
          
          if(tableroDeJuego[(devuelvePosicionesContiguas(posiciones1.get(j)).get(k))] == palabra.charAt(i)) {
            posiciones2.add(devuelvePosicionesContiguas(posiciones1.get(j)).get(k));
          }
        }
      }
      
      posiciones1 = posiciones2;
      posiciones2 = new ArrayList<Integer>();
    }
    return !posiciones1.isEmpty();
  }
  
  /**
   * Comprueba si la palabra está en la RAE
   * @param palabra introducida
   * @param palabrasRAE todas las palabras de la RAE
   * @return true si la palabra está en la RAE, false si no lo está
   */
  public boolean estaPalabraEnLaRAE(String palabra, HashSet<String> palabrasRAE) {
    
    return palabrasRAE.contains(palabra.toLowerCase());
  }
  
  /**
   * Comprueba si la palabra es correcta
   * @param palabra introducida
   * @param palabrasRAE todas las palabras de la RAE
   * @return true si la palabra es correcta, false si no lo es
   */
  public boolean esPalabraCorrecta(String palabra, HashSet<String> palabrasRAE) {
    
    if(estaPalabraEnTablero(palabra) && estaPalabraEnLaRAE(palabra, palabrasRAE)) {
      return true;
    }
    
    return false;
  }
  
  /**
   * Devuelve las posiciones contiguas a una letra
   * @param pos posición en el tablero de una letra
   * @return posiciones contiguas a una posicion
   */
  public static ArrayList<Integer> devuelvePosicionesContiguas(int pos) {

    ArrayList<Integer> posicionesContiguas = new ArrayList<Integer>();

    if((pos == 5 || pos == 6) || (pos==9 || pos==10)) {
      posicionesContiguas.add(pos-5);
      posicionesContiguas.add(pos-4);
      posicionesContiguas.add(pos-3);
      posicionesContiguas.add(pos-1);
      posicionesContiguas.add(pos+1);
      posicionesContiguas.add(pos+3);
      posicionesContiguas.add(pos+4);
      posicionesContiguas.add(pos+5);

    }

    else if(pos==1 || pos==2) {
      posicionesContiguas.add(pos-1);
      posicionesContiguas.add(pos+1);
      posicionesContiguas.add(pos+3);
      posicionesContiguas.add(pos+4);
      posicionesContiguas.add(pos+5);
    }

    else if(pos==4 || pos==8) {
      posicionesContiguas.add(pos-4);
      posicionesContiguas.add(pos-3);
      posicionesContiguas.add(pos+1);
      posicionesContiguas.add(pos+4);
      posicionesContiguas.add(pos+5);
    }

    else if(pos==7 || pos==11) {
      posicionesContiguas.add(pos-5);
      posicionesContiguas.add(pos-4);
      posicionesContiguas.add(pos-1);
      posicionesContiguas.add(pos+3);
      posicionesContiguas.add(pos+4);
    }

    else if(pos==13 || pos==14) {
      posicionesContiguas.add(pos-5);
      posicionesContiguas.add(pos-4);
      posicionesContiguas.add(pos-3);
      posicionesContiguas.add(pos-1);
      posicionesContiguas.add(pos+1);
    }

    else if(pos==0 ) {
      posicionesContiguas.add(pos+1);
      posicionesContiguas.add(pos+4);
      posicionesContiguas.add(pos+5);
    }

    else if(pos == 3) {
      posicionesContiguas.add(pos-1);
      posicionesContiguas.add(pos+3);
      posicionesContiguas.add(pos+4);
    }

    else if(pos == 12) {
      posicionesContiguas.add(pos-4);
      posicionesContiguas.add(pos-3);
      posicionesContiguas.add(pos+1);
    }

    else if(pos == 15) {
      posicionesContiguas.add(pos-5);
      posicionesContiguas.add(pos-4);
      posicionesContiguas.add(pos-1);
    }

    return posicionesContiguas;
  }

  /**
   * Devuelve una cadena para representar el tablero
   */
  public String toString() {

    String tablero = "";
    
    for (int i = 0; i <=15; i++) {
        tablero = tablero + this.tableroDeJuego[i] + " ";
        if((i+1)%4==0) {
          tablero = tablero + "\n";
        }
        
      }
    return tablero;
  }

}
