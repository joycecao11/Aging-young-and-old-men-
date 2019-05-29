import java.awt.*;
import java.awt.geom.*;
/** This is a class eye state 2
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class EyeStateTwo extends Eye{
   //Declare instance variables
   private boolean isLeft;
   private Color color;
   private Arc2D.Double eye;
   private Arc2D.Double eyeC;
 /**
   *constructor
   * Creates a left or right eye for No.two state
   *@param    a     the string that shows whether the eye is left or right
   */
   public EyeStateTwo(String a){
      this.color = Color.BLACK;
      if(a.equalsIgnoreCase("left")){
         this.isLeft = true;
      }
      else{
         this.isLeft = false;
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
   public void draw(Graphics2D g2, int xPos, int yPos, int width, int height){
      int eyeD = width/10;
      if (this.isLeft){
         eye = new Arc2D.Double(xPos+width/4 ,yPos+height/3, eyeD, eyeD, 180, 180, Arc2D.PIE);
         eyeC = new Arc2D.Double(xPos+width/4-eyeD/2 ,yPos+height/3-eyeD/2, 2*eyeD, 2*eyeD, 180, 180, Arc2D.PIE);
      }
      else{
         eye = new Arc2D.Double(xPos+width*5/8 ,yPos+height/3, eyeD, eyeD, 180, 180, Arc2D.PIE);
         eyeC = new Arc2D.Double(xPos+width*5/8-eyeD/2 ,yPos+height/3-eyeD/2, 2*eyeD, 2*eyeD, 180, 180, Arc2D.PIE);
      }
      g2.setColor(color);
      g2.fill(eye);
      g2.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(2.0f));
      g2.draw(eye);
      g2.draw(eyeC);
   }
}   