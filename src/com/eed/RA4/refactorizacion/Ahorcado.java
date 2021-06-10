package com.eed.RA4.refactorizacion;

/* AHORCADO
 * 
 * 
 * @author Guillermo Tamaj�n Hern�ndez
 * 
 * 
 */
public class Ahorcado extends Juego {
  
  private String palabra;
  private String palabraOculta;
  private int longitud;
  private int vidasRestantes;
  private String letrasUsadas;

  //Constructor
  Ahorcado(String palabra) {
    //Guardo la palabra en may�suclas
    this.palabra = palabra.toUpperCase(); 
    //Longitud de la cadena
    this.longitud = palabra.length();
    //Palabra oculta que se ir� desbloqueando
    this.palabraOculta = "_".repeat(this.longitud);
    //Vidas iniciales
    this.vidasRestantes = VIDAS_INICIALES;
    //Letras usadas iniciales, es decir, cadena vac�a
    this.letrasUsadas = "";
  }
  
  //Getter para las vidas restantes
  public int getVidasRestantes() {
    return this.vidasRestantes;
  }
  
  //Getter para la palabra original
  public String getPalabra() {
    return this.palabra;
  }
  
  //Getter para letras usadas
  public String getLetrasUsadas() {
    return this.letrasUsadas;
  }
  
  //Setter para devolver el objeto al estado inicial y jugar con el mismo
  public void setPalabra(String nuevaPalabra) {
    this.palabra = nuevaPalabra.toUpperCase(); 
    this.longitud = this.palabra.length();
    this.palabraOculta = "_".repeat(this.longitud);
    this.vidasRestantes = VIDAS_INICIALES;
    this.letrasUsadas = "";
  }
  
  //Metodo para introducir letras nuevas y reaccion en los atributos del obj.
  
  //Me he basado en una funcion que, con cada introduccion de letra, construye de
  //nuevo la cadena de la palabra oculta
  public boolean letraDescubierta(char letra) {
    //Inicializacion de la nueva cadena de la palabra oculta
    String nuevaPalabraOculta = "";
    //Inicializacion de comprobadores de aciertos y de palabra ya dicha
    boolean acierto = false;
    boolean yaAcertada = false;
    //Bucle para buscar coincidencias en la palabra original
    for (int i =0 ; i < this.longitud; i++) {
      //Primera comprobaci�n: si la posicion ya est� desbloqueada
      if (this.palabraOculta.charAt(i) == this.palabra.charAt(i)){
        nuevaPalabraOculta = nuevaPalabraOculta + this.palabraOculta.charAt(i);
        //Comprobaci�n de si estamos repitiendo una palabra ya dicha
        if (this.palabraOculta.charAt(i) == Character.toUpperCase(letra)) {
          yaAcertada = true;
        }
      }
      //Segunda comprobaci�n: si la letra se puede desbloquear en una posicion
      else if (this.palabra.charAt(i) == Character.toUpperCase(letra)) {
        nuevaPalabraOculta = nuevaPalabraOculta + Character.toUpperCase(letra); 
        acierto = true;
      }   
      //Situacion restante: la letra sigue sin desbloquear
      else {
        nuevaPalabraOculta = nuevaPalabraOculta + "_";
        
      }
    }
    //Actualizamos la palabra oculta
    this.palabraOculta = nuevaPalabraOculta;
    
    //Comprobacion de si ha habido aciertos y devolvemos true
    if (acierto) {
      return true;
    }
    //Situacion contraria: no hubo aciertos y quitamos vida
    vidasRestantes--;
    
    if(yaAcertada) {
      return false;
    }
    //Comprobacion de si la letra usada erroneamente ya se uso, y no volverla a a�adir
    if (!this.letrasUsadas.contains(Character.toString(Character.toUpperCase(letra)))) {
      this.letrasUsadas = this.letrasUsadas + Character.toString(Character.toUpperCase(letra)) + ", ";
    }
    return false;
  }
  
  //Metodo para comprobar si se ha encontrado la palabra
  public boolean acierto() {
    return this.palabra.equals(this.palabraOculta);  
  }
  
  //toString que muestra bonito la palabra en proceso de ser desbloqueada del obj
  public String toString() {
    String devolucion = "";
    
    for (int i = 0; i < this.palabra.length(); i++) {
      devolucion = devolucion + this.palabraOculta.charAt(i) + " ";
    }
    
    return devolucion;
    
  }
  

}
