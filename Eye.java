import java.awt.*;
import java.awt.geom.*;
/** This is a class eye state 1
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class Eye{
   //Declare instance variables
   private boolean isLeft;
   private Color color;
   private int eyeD;
   private int length;
   private int moveX;
   private int moveY;
   private Ellipse2D.Double eyeC;
   private Ellipse2D.Double eyeBall;
 /**
   * no argument constructor just initial color
   */
   public Eye(){
      this.color = Color.BLACK;
   }
 /**
   *constructor
   * Creates a left or right eye with fixed positions
   *@param    a     the string that shows whether the eye is left or right
   */
   public Eye(String a){
      this.moveX = 0;
      this.moveY = 0;
      this.color = Color.BLACK;
      if(a.equalsIgnoreCase("left")){
         this.isLeft = true;
      }
      else{
         this.isLeft = false;
      }
   }
/**
   *constructor
   * Creates a left or right eye with fixed positions and the move distance
   *@param    a     the string that shows whether the eye is left or right
   *@param    moveX     based on the mouse click the distance in horizontal direction the eyeball should move
   *@param     moveY     based on the mouse click the distance in vertical direction the eyeball should move
   */
   public Eye(String a,int moveX, int moveY){
      this.moveX = moveX;
      this.moveY = moveY;
      this.color = Color.BLACK;
      if(a.equalsIgnoreCase("left")){
         this.isLeft = true;
         //remaining codes
         //int xLeft = /*400-200+400/8*/;
         //int yLeft = /*(int)(100+600/3)*/;
         //eyeBall = new Ellipse2D.Double(xLeft+moveX ,yLeft+moveY, 40, 40);
      }
      else{
         this.isLeft = false;
         //remaining codes
         //int xRight = 200+400*5/8;
         //int yRight = (int)(100+600/3);
         //eyeBall = new Ellipse2D.Double(xRight+moveX ,yRight+moveY, 40, 40);
      }
   }
/**
   * draw method to draw eyes
   *@param   g2   the Graphics2D tool
   *@param  xPos   the x position of the face
   *@param  yPos   the y position of the face
   *@param  width   the width of the face
   *@param  height   the height of the face
   */
   public void draw(Graphics2D g2, int xPos, int yPos, int width, int height)
   {
      this.eyeD = width/10;
         if (isLeft){
            eyeBall = new Ellipse2D.Double(length/2-length/4+length/16+moveX,length/8+length*6/8/3+moveY,eyeD,eyeD);
            eyeC = new Ellipse2D.Double(length/2-length/4+length/16-eyeD/2,length/8+length*6/8/3-eyeD/2,2*eyeD,2*eyeD);
         }
         else{
            eyeBall = new Ellipse2D.Double(length/4+length/2*5/8+moveX,length/8+length*6/8/3+moveY,eyeD,eyeD);
            eyeC = new Ellipse2D.Double(length/4+length/2*5/8-eyeD/2,length/8+length*6/8/3-eyeD/2,2*eyeD,2*eyeD);
         }
         g2.setColor(color);
         g2.fill(eyeBall);
         g2.setColor(Color.BLACK);
         g2.setStroke(new BasicStroke(2.0f));
         g2.draw(eyeBall);
         g2.draw(eyeC);
   }
   public void setLength(int x){
      this.length = x;
   }
}
