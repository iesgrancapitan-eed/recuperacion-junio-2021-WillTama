package com.eed.RA4.javadoc;
import java.util.ArrayList;

/**
 * Clase Dado que representa un dado con 6 caras
 * @author Guillermo Tamajón Hernández
 * 
 */


public class Dado {

  /**
   * Contiene caras con letras
   */
  char[] caras;


  /**
   * Contiene todas las caras para cada dado
   */
  static char[] caras1 = new char[] {'A','R','H','S','D','E'};
  static char[] caras2 = new char[] {'F','U','A','A','R','B'};
  static char[] caras3 = new char[] {'U','O','E','E','O','C'};
  static char[] caras4 = new char[] {'F','O','M','T','U','I'};
  static char[] caras5 = new char[] {'O','O','D','B','L','G'};
  static char[] caras6 = new char[] {'R','P','S','Z','T','L'};
  static char[] caras7 = new char[] {'E','B','I','O','U','A'};
  static char[] caras8 = new char[] {'C','A','R','E','M','E'};
  static char[] caras9 = new char[] {'R','S','J','E','F','I'};
  static char[] caras10 = new char[] {'N','S','X','J','A','H'};
  static char[] caras11 = new char[] {'U','V','D','Q','B','J'};
  static char[] caras12 = new char[] {'N','B','I','M','E','E'};
  static char[] caras13 = new char[] {'B','A','A','N','I','T'};
  static char[] caras14 = new char[] {'I','O','T','A','L','G'};
  static char[] caras15 = new char[] {'E','P','V','O','C','U'};
  static char[] caras16 = new char[] {'C','C','A','A','P','T'};
  
  /**
   * Contiene los dados sin usar
   */
  static ArrayList<char[]> dados = new ArrayList<char[]>();
      
  /**
   * Crea dados sin repetición
   */
  Dado(){
    
    if (dados.size() == 0) {
      dados.add(caras1);
      dados.add(caras2);
      dados.add(caras3);
      dados.add(caras4);
      dados.add(caras5);
      dados.add(caras6);
      dados.add(caras7);
      dados.add(caras8);
      dados.add(caras9);
      dados.add(caras10);
      dados.add(caras11);
      dados.add(caras12);
      dados.add(caras13);
      dados.add(caras14);
      dados.add(caras15);
      dados.add(caras16);
    }
    
    int indice = (int) (Math.random()*(dados.size() - 1));
    
    this.caras = dados.get(indice);
    dados.remove(indice);
  }

 /**
  * Devuelve un número aleatorio que se corresponde a una cara
  * @return una cara aleatoria
  */
  public char getCaraAleatoria() {
    return this.caras[(int)(Math.random()*5)];
  }
  
  


}