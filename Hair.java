import java.awt.*;
import java.awt.geom.*;
/** This is a class for Head object to draw hair
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class Hair{
   private static final Color DEFAULT_COLOR = Color.RED;
   //Declare instance variables
   private Color color;
/**
   *constructor
   * Creates a hair
   *@param   c   the color of the hair
   */
   public Hair(Color c){
      this.color = c;
   }
/**
   * no argument constructor just initial color
   */
   public Hair(){
      this.color = DEFAULT_COLOR;
   }
/**
   * draw method to draw hair
   *@param   g2   the Graphics2D tool
   *@param  xPos   the x position of the face
   *@param  yPos   the y position of the face
   *@param  width   the width of the face
   *@param  height   the height of the face
   *@param  state   the state of the hair
   */
   public void draw(Graphics2D g2, int xPos, int yPos, int width, int height, int state)
   {
      if(state == 1){
         int[] x = {xPos,xPos+width/4,xPos+width*3/8,xPos+width/2, xPos+width*3/4,xPos+width*7/8,xPos+width};
         int[] y = {yPos+height/6,yPos-height/12,yPos,yPos-height/6,yPos,yPos-height/12,yPos+height/6};
         int points = 7;
         Polygon poly = new Polygon(x,y,points);
         g2.setColor(Color.BLACK);
         g2.fill(poly);
         g2.draw(poly);
      }
      else if(state == 2){
         Arc2D.Double hair = new Arc2D.Double(xPos, yPos, width, height/3,0, 180, Arc2D.PIE);
         g2.setColor(Color.BLACK);
         g2.fill(hair);
         g2.draw(hair);
      }
      else if(state == 3){ 
         Rectangle hat1 = new Rectangle(xPos+width/4, yPos-height/6/2, width/2, height/6);
         Ellipse2D.Double hat2 = new Ellipse2D.Double(xPos, yPos, width, height/6);
         g2.setColor(Color.BLACK);
         g2.fill(hat1);
         g2.fill(hat2);
         g2.draw(hat1);
         g2.draw(hat2); 
      } 
   }
}
