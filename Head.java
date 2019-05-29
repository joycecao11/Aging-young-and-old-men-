import java.awt.*;
import java.awt.geom.*;
/** This is a class for Head object to draw heads
 * @author   Xuechun  Cao
 * Student ID Number: 100271794
 * @version 1.0
 * Course: CPSC 1181
 * Section: 002
 */
public class Head{
   private static final Color SKIN_COLOR = new Color(251,227,179);
   //Declare instance variables
   private boolean shouldMove;
   private Color skinColor;
   private Eye leftEye;
   private Eye rightEye;
   private Hair hair;
   private Mouth mouth;
   private Nose nose;
   private int leftDx;
   private int leftDy;
   private int rightDx;
   private int rightDy;
   private int length;
/**
   * no argument constructor initial different parts of face
   */
   public Head()
   {
      this.shouldMove = false;
      this.skinColor = SKIN_COLOR;
      this.leftEye = new Eye("left");
      this.rightEye = new Eye("right");
      this.hair = new Hair();
      this.mouth = new Mouth();
      this.nose = new Nose();
   }
/**
   * Constructor to create a head
   *@param   leftDx  the distance in horizontal direction the left eye should move
   *@param  leftDy  the distance in vertical direction the left eye should move
   *@param  rightDx  the distance in horizontal direction the right eye should move
   *@param   rightDy  the distance in vertical direction the right eye should move
   */
   public Head(int leftDx, int leftDy, int rightDx, int rightDy)
   {
      this.leftDx = leftDx;
      this.leftDy = leftDy;
      this.rightDx = rightDx;
      this.rightDy = rightDy;
      this.shouldMove = true;
      this.skinColor = SKIN_COLOR;
      this.leftEye = new Eye("left",leftDx, leftDy);
      this.rightEye = new Eye("right",rightDx,rightDy);
      this.hair = new Hair();
      this.mouth = new Mouth();
      this.nose = new Nose();
   }
/**
   * draw method to draw head
   *@param   g2   the Graphics2D tool
   *@param  xPos   the x position of the face
   *@param  yPos   the y position of the face
   *@param  width   the width of the face
   *@param  height   the height of the face
   *@param  hairState   the state of hair
   *@param  mouthState   the state of mouth
   *@param  eyeState   the state of eye
   */
   public void draw(Graphics2D g2, int xPos, int yPos, int headWidth, int headHeight, int hairState, int mouthState, int eyeState)
   {
      //draw face
      Ellipse2D.Double face = new Ellipse2D.Double(xPos,yPos, headWidth, headHeight);
      g2.setStroke(new BasicStroke(2.0f));
      g2.setColor(skinColor);
      g2.fill(face);
      g2.setColor(Color.BLACK);
      g2.draw(face);
      //call other draw methods
      this.nose.draw(g2, xPos, yPos, headWidth, headHeight);
      this.mouth.draw(g2, xPos, yPos, headWidth, headHeight, mouthState);
      this.hair.draw(g2, xPos, yPos, headWidth, headHeight, hairState);
      if(eyeState == 1){
         if(shouldMove){
            this.leftEye = new Eye("left",leftDx, leftDy);
            this.rightEye = new Eye("right",rightDx,rightDy);
            this.leftEye.setLength(length);
            this.rightEye.setLength(length);
            this.leftEye.draw(g2, xPos, yPos, headWidth, headHeight);
            this.rightEye.draw(g2, xPos, yPos, headWidth, headHeight);
         }
         else{
            this.leftEye = new Eye("left");
            this.rightEye = new Eye("right");
            this.leftEye.setLength(length);
            this.rightEye.setLength(length);
            this.leftEye.draw(g2, xPos, yPos, headWidth, headHeight);
            this.rightEye.draw(g2, xPos, yPos, headWidth, headHeight);
         }
      }
      else if(eyeState == 2){
         this.leftEye = new EyeStateTwo("left");
         this.rightEye = new EyeStateTwo("right");
         this.leftEye.draw(g2, xPos, yPos, headWidth, headHeight);
         this.rightEye.draw(g2, xPos, yPos, headWidth, headHeight);
      }
      else if(eyeState == 3){
         this.leftEye = new EyeStateThree("left");
         this.rightEye = new EyeStateThree("right");
         this.leftEye.draw(g2, xPos, yPos, headWidth, headHeight);
         this.rightEye.draw(g2, xPos, yPos, headWidth, headHeight);
      }
   }
   public void setLength(int x){
      this.length = x;
   }
}
