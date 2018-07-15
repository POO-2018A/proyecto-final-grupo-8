/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites;
import java.awt.Dimension;
import java.util.Timer;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
/**
 *
 * @author AdminPC
 */
public class ClsAnimacion extends javax.swing.JLabel{
    private Timer tiempo ;
    private TimerTask task;
    private int speed = 60;
    private int frame=0;
    boolean run = false;
    
    //se crea el objeto y se redimensiona al tamaño del contenedor
    public ClsAnimacion(Dimension d){        
        this.setSize(d);
    }  
    //coloca una imagen en el objeto jlabel
    public void setimage(int n){        
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("m" + n + ".PNG"))); 
    }
    //coloca la velocidad en la variable 
    public void setvelocidad(int v){
        this.speed= v;        
    }
  //para la animacion  
  public void startAnimation() {    
        
           run=true;
           tiempo = new Timer();
           task = new TimerTask() {
int c = 0;               
               public void run() {
                   frame++;                   
                   if (frame<=12){
                        setimage(frame);
                   }
                   else{frame=0;}
                   
                   if(c > 20){
                       setimage(2);
                       stopAnimation();
                   }
                   c++;
               }
           };
           //se inicia la animacion
           System.out.println("Se inicia la animacion");                                             
           tiempo.schedule(task,0,speed);           
    }
    //detiene la animacion
     public void stopAnimation() {        
        tiempo.cancel();
        task.cancel();
        run=false;
        System.out.println("La animacion fue detenida");                                             
    }
}
