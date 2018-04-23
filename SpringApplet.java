import javax.swing.JApplet;
import java.awt.*;
import java.util.Timer;

public class SpringApplet extends javax.swing.JApplet{
        //prywatne pola przechowujace obiekty
        private SimEngine SimulationEngine;
        private SimTask SimulationTask;
        private Timer SimulationTime;
    //przeciazenie metody init     
    public void init()
    {
    	//stworzenie apletu 600x600
        this.setSize(600,600);
        //stworzenie obiektow do symulacji
        SimulationEngine = new SimEngine(30,3,0.2,20,10,10,50,40,25); //masa, k,c,l0, x0, y0, ptx0,pty0, v    
        SimulationTask = new SimTask(SimulationEngine,this,0.01);
        //uruchomienie timera
        SimulationTime = new Timer();
        SimulationTime.scheduleAtFixedRate(SimulationTask, 0, 2);     
    }
    //przeciazenie metody paint
    public void paint(Graphics gDC){ //przeciazenie paint
        //narysowanie pola
        gDC.fillRect(0,0,600,600);
          
        //wyrysowanie "sprezyny"
        gDC.setColor(Color.white);
        gDC.drawLine((int) SimulationEngine.getPointLocX()+300, (int)SimulationEngine.getPointLocY(), (int)SimulationEngine.getMassLocX()+300, (int)SimulationEngine.getMassLocY()+300);
        //narysowanie lini na ktorej zawieszona jest sprezyna
        gDC.setColor(Color.red);
        gDC.drawLine(250, 40, 360, 40);
        //narysowanie masy na sprezynie
        gDC.setColor(Color.green);
        gDC.fillOval((int)SimulationEngine.getMassLocX()+275, (int)SimulationEngine.getMassLocY()+300, 50 , 70);       
    }
}