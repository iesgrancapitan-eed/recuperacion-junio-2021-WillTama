package com.eed.RA4.javadoc;


/**
 * 
 * @author Guillermo Tamajón Hernández
 * 
 */



import java.util.Timer;
import java.util.TimerTask;

public class Contador {
  
   int intervalo;
   Timer timer;
 
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
  

  private  int setInterval() {
    if (intervalo == 1)
        timer.cancel();
    return --intervalo;
}
  
}
