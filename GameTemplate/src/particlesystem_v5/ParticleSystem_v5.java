// sdurant12
// 11/14/2012

package particlesystem_v5;

import java.awt.Canvas;
import javax.swing.*;

public class ParticleSystem_v5 extends Canvas {

  public static final int WIDTH = 1920;
  public static final int HEIGHT = 1200;
  public static final int TICK = 33;

  public static void main(String[] args) {

    JFrame frame = new JFrame("");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    //frame.setUndecorated(true);
    frame.setResizable(false);
    frame.setFocusable(true);

    final RenderClass_v5 ren = new RenderClass_v5(WIDTH, HEIGHT);
    frame.add(ren);

    frame.setVisible(true);

    Thread runThread = new Thread(new Runnable() {

      public void run() {
        if (true) {
          while (true) {
            long time = System.currentTimeMillis();
            ren.tick();
            ren.repaint();
            long endtime = System.currentTimeMillis();
            try {
              Thread.sleep(TICK - (endtime - time));
            } catch (Exception e) {
              System.out.println("Exception e at Thread.sleep");
            }
          }
        }
      }
    });

    runThread.start();

  }
}