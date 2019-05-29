import java.awt.*;
import java.awt.geom.*;
/** This is a class for Head object to draw nose
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class Nose{
   private static final Color DEFAULT_COLOR = Color.BLACK;
   private Color color;
/**
   *constructor
   * Creates a nose
   *@param   c   the color of the nose
   */
   public Nose(Color c){
      this.color = c;
   }
/**
   * no argument constructor just initial color
   */
   public Nose(){
      this.color = DEFAULT_COLOR;
   }
/**
   * draw method to draw eyes
   *@param   g2   the Graphics2D tool
   *@param  xPos   the x position of the face
   *@param  yPos   the y position of the face
   *@param  width   the width of the face
   *@param  height   the height of the face
   *@param  state   the state of the hair
   */
   public void draw(Graphics2D g2, int xPos, int yPos, int width, int height)
   {
      int noseD = width/8;
      Arc2D.Double nose = new Arc2D.Double(xPos + width*3/8+noseD/2,yPos + height/2, noseD, noseD, 0, 180, Arc2D.PIE);
      g2.setColor(Color.BLACK);
      g2.fill(nose);
      g2.draw(nose);
   }
}
