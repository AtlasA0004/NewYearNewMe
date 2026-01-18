//Import Theater and media classes
import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  // Instance Variables
  private String[] futureImages = FileReader.toStringArray("FutureImages.txt");
  private String textColor;

  // Static Variables
  private static double waitTime = 4;
  private static String thisBackground = "Maroon";


  /*
  * No-argument constuctor
  */
  public ThisYear() {
    futureImages = null;
    textColor = "white";
  }

  /*
  *Parameterized constructor
  */
  public ThisYear(String[] futureImages, String textColor) {
    this.futureImages = futureImages;
    this.textColor = textColor;
  }

  /*
   * Top level drawScene method
   * Clear the screen and set a new text color
   * Draw the future page by calling the randomCircleColor and drawStack methods
   * Precondition: thisBackground, textColor are properly defined
   * Postcondition: None
   */
  public void drawScene() {
    //Set up the screen and text
    clear(thisBackground);
    setTextColor(textColor);
    drawText("What I am looking foward to this year", 20, 45);

    //Chose a random color for the circle, and draw it
    setFillColor(randomCircleColor());
    drawEllipse(30, 50, 350, 350);

    //Display the images in a stacked manor
    drawStack();
  }

  /*
  *Select a random color for the background circle
  *Use the Math.random to chose a random number
  *Depending on the number, return a color
  * Precondition: None
  * Postcondition: Returns a random color value of gray, white, or blue with equal probability
  */
  public String randomCircleColor(){
    //Choose a random interger from 0-2
    int index = (int) (Math.random() *3);
    
    //Use the interger to chose a color
    if(index == 0){
      return "gray";
    }
    if(index == 1){
      return "white";
    }
    else{
      return "blue";
    }
  }

  /*
  *Display the 4 future images in a stacked format
  *Adusted from base code to not include a border and move the stack down by 50.
  * Precondition: futureImages is defined as a 1D String array with atleast 1 index
  * Postcondition: None
  */
  public void drawStack() {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String image : futureImages) {
      // choose a random degree to rotate (0-45)
      int angle = (int) (Math.random() * 46);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = 50 + (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      // Draw the image, pausing 2.5 seconds before reiterating the loop
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      pause(2.5);
    }
  }


  
}