import java.awt.*;
import java.awt.geom.*;
/** This is a class for Head object to draw mouth
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class Mouth{
   private static final Color DEFAULT_COLOR = Color.RED;
   private Color color;
/**
   *constructor
   * Creates a mouth
   *@param   c   the color of the mouth
   */
   public Mouth(Color c){
      this.color = c;
   }
/**
   * no argument constructor just initial color
   */
   public Mouth(){
      this.color = DEFAULT_COLOR;
   }
/**
   * draw method to draw mouth
   *@param   g2   the Graphics2D tool
   *@param  xPos   the x position of the face
   *@param  yPos   the y position of the face
   *@param  width   the width of the face
   *@param  height   the height of the face
   *@param  state   the state of the mouth
   */
   public void draw(Graphics2D g2, int xPos, int yPos, int width, int height, int state)
   {
      int mouthD = width/2;
      if(state == 1){
         Arc2D.Double mouth = new Arc2D.Double(xPos + width/4, yPos + height/2, mouthD, mouthD, 225, 90, Arc2D.OPEN);
         g2.setColor(color);
         g2.setStroke(new BasicStroke(4.0f));
         g2.draw(mouth);
      }
      else if(state == 2){
         Arc2D.Double mouth = new Arc2D.Double(xPos + width/4, yPos + height/2, mouthD, mouthD, 180, 180, Arc2D.OPEN);
         g2.setColor(color);
         g2.setStroke(new BasicStroke(4.0f));
         g2.draw(mouth);
      }
      else if(state == 3){ 
         Arc2D.Double mouth = new Arc2D.Double(xPos + width/4, yPos + height/2, mouthD, mouthD, 180, 180, Arc2D.PIE);
         g2.setColor(Color.RED);
         g2.fill(mouth);
         g2.draw(mouth);
      } 
   }
}
