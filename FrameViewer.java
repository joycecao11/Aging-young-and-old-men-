import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
/** This is a class for frame to look pictures
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class FrameViewer {
  public static void main(String[] args){
      displayMessage("Click 1 botton on the number pad to start/stop hair,\n "+
                     "Click 2 botton on the number pad to start/stop mouth,\n "+
                     "Click 3 botton on the number pad to start/stop eye,\n " + 
                     "Click left botton to slow the rate of chage for three objects,\n " + 
                     "Click right botton to accelerate the rate of chage for three objects,\n " + 
                     "Only when the eyes are fully open, stop the eye, click the frame to move eyeballs.");
      JFrame fr = new JFrame();
      fr.setSize(800,800);
      fr.setTitle("Head");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      final HeadComponent headC = new HeadComponent();
      fr.add(headC);
      fr.setVisible(true);
/**
   *An inner class implements ActionListener
   *the timer to control movement of hair.
   */
      class HairTimerListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
            headC.changeHairState();
            headC.repaint();
         }
      }
/**
   *An inner class implements ActionListener
   *the timer to control movement of mouth.
   */
      class MouthTimerListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
            headC.changeMouthState();
            headC.repaint();
         }
      }
/**
   *An inner class implements ActionListener
   *the timer to control movement of eye.
   */
      class EyeTimerListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
            headC.changeEyeState();
            headC.repaint();
         }
      }
      ActionListener hairListener = new HairTimerListener();
      ActionListener mouthListener = new MouthTimerListener();
      ActionListener eyeListener = new EyeTimerListener();
      final int millisecs = 1000;
      Timer hairT = new Timer(millisecs, hairListener);
      Timer mouthT = new Timer(millisecs, mouthListener);
      Timer eyeT = new Timer(millisecs, eyeListener);
      hairT.start();
      mouthT.start();
      eyeT.start();
 /**
   *An inner class implements KeyListener
   * click on the 1 button on the numpad to start/stop the movement of hair
   * Click 2 botton on the number pad to start/stop mouth
   * Click 3 botton on the number pad to start/stop eye
   * Click left botton to slow the rate of chage for three objects
   * Click right botton to accelerate the rate of chage for three objects
   * Only when the eyes are fully open, stop the eye, click the frame to move eyeballs
   */
      class ArrowKeyListener implements KeyListener{
         @Override
         public void keyPressed(KeyEvent event){
            int key = event.getKeyCode();
            String keyS = KeyStroke.getKeyStrokeForEvent(event).toString();
            keyS = keyS.replace("pressed ", "");
            final int DELAY_PLUS = 500;
            if(key==event.VK_1){
               if(hairT.isRunning())
                  hairT.stop();
               else
                  hairT.restart();
            }
            else if (key==event.VK_2){
               if(mouthT.isRunning())
                  mouthT.stop();
               else
                  mouthT.restart();
            }
            else if (key==event.VK_3){
               if(eyeT.isRunning())
                  eyeT.stop();
               else
                  eyeT.restart();
            }
            else if (keyS.equals("LEFT")){
               int h = hairT.getDelay();
               hairT.setDelay(h+DELAY_PLUS);
               int m = mouthT.getDelay();
               mouthT.setDelay(m+DELAY_PLUS);
               int e = eyeT.getDelay();
               eyeT.setDelay(e+DELAY_PLUS);
            }
            else if(keyS.equals("RIGHT")){
               int h = hairT.getDelay();
               if(!(h-DELAY_PLUS <=0 )){ 
                  hairT.setDelay(h-DELAY_PLUS);
               }
               int m = mouthT.getDelay();
               if(!(m-DELAY_PLUS <=0 )){
                  mouthT.setDelay(m-DELAY_PLUS);
               }
               int e = eyeT.getDelay();
               if(!(e-DELAY_PLUS <=0 )){
                  eyeT.setDelay(e-DELAY_PLUS);
               }
            }
         }
         @Override
         public void keyTyped(KeyEvent event) {}
         public void keyReleased(KeyEvent event) {}
      } // ArrowKeyListener
      fr.addKeyListener(new ArrowKeyListener());
      fr.setFocusable(true);
      fr.addMouseListener(new MousePressListener(headC,eyeT));
   }
 /**
   *An inner class implements MouseListener
   *If the user click on the frame the eyeballs will move.
   */
   private static class MousePressListener implements MouseListener{
      private HeadComponent headC;
      private Timer eyeT;
      public MousePressListener(HeadComponent headC,Timer eyeT){
         this.headC = headC;
         this.eyeT = eyeT;
      }
      public void mousePressed(MouseEvent event){
         if(!eyeT.isRunning() && headC.getEyeState() == 1)
            headC.moveEye(event.getX(),event.getY());
      }
      // do-nothing methods  
      @Override
      public void mouseReleased(MouseEvent e) {}  
      @Override
      public void mouseClicked(MouseEvent e) {}  
      @Override
      public void mouseEntered(MouseEvent e) {}  
      @Override
      public void mouseExited(MouseEvent e) {}
   }
/** 
 *Display message by usinf dialog interferce.
 * <p>
 *use JOptionPane.showMessageDialog.
 * 
 * @param   msg   the instructions that need user to dc
 * This method returns nothing.
 */
   public static void displayMessage(String msg){
      JOptionPane.showMessageDialog(null, msg, "Movement instruction",JOptionPane.INFORMATION_MESSAGE);
   }
}
