package com.eed.RA4.javadoc;


import java.util.ArrayList;
/**
 * Clase Jugador que reprensenta cada jugador 
 * @author hetag
 *
 */
public class Jugador {
  
  /**
   * Contiene palabras acertadas
   */
  ArrayList<String> palabrasAcertadas = new ArrayList<String>();
  /**
   * Puntos del jugador
   */
  int puntos;
  /**
   * Nombre del jugador
   */
  String nombre;
  
  /**
   * Crea objetos de tipo jugador
   * @param nombre
   */
  Jugador(String nombre){
    this.nombre = nombre;
    puntos = 0;
  }
  
  /**
   * Devuelve nombre del jugador
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Devuelve puntos del jugador
   * @return puntos
   */
  public int getPuntos() {
    return puntos;
  }


  /**
   * Comprueba si la palabra es correcta y la añade
   * @param palabra
   */
  public void addPalabra(String palabra) {
    
    if (!palabrasAcertadas.contains(palabra.toUpperCase())) {
      palabrasAcertadas.add(palabra.toUpperCase());
    
    sumarPuntos(palabra);
    }
  }
  

  /**
   * Comprueba la longitud de la palabra y suma los puntos correspondientes
   * @param palabra
   */
  public void sumarPuntos(String palabra) {
    
    if (palabra.length() >= 8) {
      puntos = puntos + 4;
    }
    
    else if (palabra.length() == 7) {
      puntos = puntos + 3;
    }
    
    else if (palabra.length() == 6) {
      puntos = puntos + 2;
    }
    
    else {
      puntos = puntos + 1;
    }
    
  }
  
  /**
   * Devuelve puntos del jugador
   * @return puntos
   */
  public int devolverPuntos() {
    return puntos;
  }
  

  /**
   * Devuelve las palabras acertadas
   * @return palabras acertadas
   */
  public String devolvePalabrasAcertadas() {
    
    String palabrasADevolver = "";
    for(int i = 0; i<palabrasAcertadas.size(); i++) {
      palabrasADevolver = palabrasADevolver + palabrasAcertadas.get(i) + ", ";
    }
    return palabrasADevolver;
  }

}
