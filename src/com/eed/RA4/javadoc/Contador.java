package com.eed.RA4.javadoc;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase Contador que ejecuta una cuenta atrás
 * @author hetag
 *
 */
public class Contador {
  
  /**
   * Intervalo de tiempo
   */
   int intervalo;
   /**
    * Temporizador
    */
   Timer timer;
   /**
    * Hace la cuenta atras
    * @param segundos
    */
  public void cuentaAtras(int segundos) {
    
    int delay = 1000;
    int periodo = 1000;
    timer = new Timer();
    intervalo = segundos;
    timer.scheduleAtFixedRate(new TimerTask() {

      public void run() {
          setInterval();

      }
      
      
  }, delay, periodo);
  }
  
/**
 * Actualiza los segundos restantes
 * @return segundos restantes
 */
  private  int setInterval() {
    if (intervalo == 1)
        timer.cancel();
    return --intervalo;
}
  
}
