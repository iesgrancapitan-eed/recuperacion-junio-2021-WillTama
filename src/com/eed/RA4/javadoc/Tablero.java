package com.eed.RA4.javadoc;

/**
 * 
 * @author Guillermo Tamajón Hernández
 * 
 */


import java.util.ArrayList;
import java.util.HashSet;

public class Tablero {
  char[] tableroDeJuego = new char[16];
  
  
  Tablero(){
    this.llenarTablero();
  }


  public void llenarTablero() {
    for(int i = 0; i < tableroDeJuego.length; i++) {
      tableroDeJuego[i] = (new Dado()).getCaraAleatoria();
    }
  }
  
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
  
  
  public boolean estaPalabraEnLaRAE(String palabra, HashSet<String> palabrasRAE) {
    
    return palabrasRAE.contains(palabra.toLowerCase());
  }
  
  public boolean esPalabraCorrecta(String palabra, HashSet<String> palabrasRAE) {
    
    if(estaPalabraEnTablero(palabra) && estaPalabraEnLaRAE(palabra, palabrasRAE)) {
      return true;
    }
    
    return false;
  }
  
  
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
