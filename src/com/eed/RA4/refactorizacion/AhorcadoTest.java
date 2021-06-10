package com.eed.RA4.refactorizacion;

import java.util.Scanner;
public class AhorcadoTest {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    //Inicializacion
    Ahorcado Probando = new Ahorcado("");
    
    
    System.out.println("JUGUEMOS AL AHORCADO");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.print("ESCRIBE LA PALABRA: ");
    
    
    
    //Set en el mismo objeto cada vez que vayamos a jugar
    Probando.setPalabra(s.next());
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    
    System.out.println("");
    System.out.println("");
    
    
    System.out.println("VAMOS A JUGAR, TIENES QUE ADIVINAR: "+ Probando);
    
    
    //Bucle para probar letras hasta ganar o perder
    while (!Probando.acierto() && Probando.getVidasRestantes() > 0) {
      System.out.print("�QU� LETRA QUIERES PROBAR?: ");
      if (!Probando.letraDescubierta(s.next().charAt(0)) ) {
        System.out.println("");
        System.out.println("����FALLASTE!!!! TE QUEDAN " + Probando.getVidasRestantes() + " VIDAS.");
        }
      System.out.println("");
      System.out.println("Ahora la palabra es " + Probando);
      System.out.println("Letras falladas: " + Probando.getLetrasUsadas());
      System.out.println("");
      
    }
    
    //Comprobacion de si has ganado o has perdido
    if (Probando.getVidasRestantes() > 0) {
    System.out.println("HAS ACERTADO, LA PALABRA ERA: " + Probando.getPalabra());
    }
    else {
      System.out.println("SE TE ACABARON LAS VIDAS, PERDISTE");
      System.out.println("LA PALABRA ERA: " + Probando.getPalabra());
    }
    
    
    
    
    
    
    
  }

}
