package com.eed.RA4.javadoc;

/**
 * 
 * @author Guillermo Tamajón Hernández
 * 
 */


import java.util.ArrayList;

public class Jugador {
  
  ArrayList<String> palabrasAcertadas = new ArrayList<String>();
  int puntos;
  String nombre;
  
  Jugador(String nombre){
    this.nombre = nombre;
    puntos = 0;
  }
  
  public String getNombre() {
    return nombre;
  }


  public int getPuntos() {
    return puntos;
  }


  public void addPalabra(String palabra) {
    
    if (!palabrasAcertadas.contains(palabra.toUpperCase())) {
      palabrasAcertadas.add(palabra.toUpperCase());
    
    sumarPuntos(palabra);
    }
  }
  

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
  
  public int devolverPuntos() {
    return puntos;
  }
  

  public String devolvePalabrasAcertadas() {
    
    String palabrasADevolver = "";
    for(int i = 0; i<palabrasAcertadas.size(); i++) {
      palabrasADevolver = palabrasADevolver + palabrasAcertadas.get(i) + ", ";
    }
    return palabrasADevolver;
  }

}
