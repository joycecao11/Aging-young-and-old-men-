import java.awt.*;
import javax.swing.JComponent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
/** This is an extended class of components of Head objects to draw different part of face
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class HeadComponent extends JComponent{
   //Declare instance variable
   private Head head;
   private int hairState;
   private int mouthState;
   private int eyeState;
   private int length;
   private int eyeD;
   private static int dH = 1;
   private static int dM = 1;
   private static int dE = 1;
/** 
 *Constructs a HeadComponent object.
 * <p>
 *Initialize the instance variables.
 * 
 */
   public HeadComponent(){
      head = new Head();
      this.hairState = 1;
      this.mouthState = 1;
      this.eyeState = 1;
   }
/** 
 *Construct paintComponentfor Head 
 * <p> 
 *At first, I designed the frame to be a square and calculate all the width and height and positions of x and y based on the square.
   In order to change the size of the head when user resize the frame, divide three situations.
   When the width wider than height, the width and height of head are based on the height so that the actual space that show the heads is square again..
   When the width equals to height, the width and height of head are original width and height that designed by me.
   When the height wider than width, the width and height of head are based on the width.
 * @param   g    the Graphics2D tool
 *   
 * @return This method returns nothing.
 */
   public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g; 
      if(getWidth() > getHeight()){
         this.length = getHeight();
         this.eyeD = length/20;
         int width = getHeight()/2;
         int height = getHeight()/4*3;
         int x1 = getHeight()/2-width/2;
         int y1 = getHeight()/2-height/2;
         head.setLength(length);
         head.draw(g2, x1,y1,width,height,hairState,mouthState,eyeState);         
      }
      else if(getWidth() == getHeight()){
         this.length = getWidth();
         this.eyeD = length/20;
         int width = getWidth()/2;
         int height = getHeight()/4*3;
         int x1 = getWidth()/2-width/2;
         int y1 = getHeight()/2-height/2;
         head.setLength(length);
         head.draw(g2, x1,y1,width,height,hairState,mouthState,eyeState); 
      }
      else if(getWidth() < getHeight()){
         this.length = getWidth();
         this.eyeD = length/20;
         int width = getWidth()/2;
         int height = getWidth()/4*3;
         int x1 = getWidth()/2-width/2;
         int y1 = getWidth()/2-height/2;
         head.setLength(length);
         head.draw(g2, x1,y1,width,height,hairState,mouthState,eyeState);
      }
   }
/*To change the state of the hair if the state is one it will increase by one every time until it reach 3 it will decrease
  * @return  this method returns nothing
   */
   public void changeHairState(){
      this.hairState += dH;
      if(hairState >= 3 || hairState <= 1)
         dH = -dH;
   }
/*To change the state of the mouth if the state is one it will increase by one every time until it reach 3 it will decrease
  * @return  this method returns nothing
   */
   public void changeMouthState(){
      this.mouthState += dM;
      if(mouthState >= 3 || mouthState <= 1)
         dM = -dM;
   }
/*To change the state of the eye if the state is one it will increase by one every time until it reach 3 it will decrease
  * @return  this method returns nothing
   */
   public void changeEyeState(){
      this.eyeState += dE;
      if(eyeState >= 3 || eyeState <= 1)
         dE = -dE;
   }
/*Based on the mouse click position to get move distances for left and right eyes
  * @return  this method returns nothing
   */
   public void moveEye(int x, int y){
      int leftDx = getDx(length/2-length/4+length/16+eyeD/2,length/8+length*6/8/3+eyeD/2,x, y);
      int leftDy = getDy(length/2-length/4+length/16+eyeD/2,length/8+length*6/8/3+eyeD/2,x, y);
      int rightDx = getDx(length/4+length/2*5/8+eyeD/2,length/8+length*6/8/3+eyeD/2,x, y);
      int rightDy = getDy(length/4+length/2*5/8+eyeD/2,length/8+length*6/8/3+eyeD/2,x, y);
      head.setLength(length);
      head = new Head(leftDx,leftDy,rightDx,rightDy);
      repaint();
   }
/*Get move distance horizontally
  * @return  this method returns nothing
   */
   public int getDx(int xPos, int yPos,int moveX, int moveY){
      double d = Math.sqrt((moveY-yPos)*(moveY-yPos)+(moveX-xPos)*(moveX-xPos));
      int dx = (int)(eyeD/2/d*(moveX-xPos));
      return dx;     
   }
/*Get move distance vertically
  * @return  this method returns nothing
   */
   public int getDy(int xPos, int yPos,int moveX, int moveY){
      double d = Math.sqrt((moveY-yPos)*(moveY-yPos)+(moveX-xPos)*(moveX-xPos));
      int dy = (int)(eyeD/2/d*(moveY-yPos));
      return dy;     
   }
/*Get the eye state
  * @return  this method returns int
   */
   public int getEyeState(){
      return eyeState;
   }
}