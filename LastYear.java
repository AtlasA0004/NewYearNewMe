//Import Theater and media classes
import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  // Instance Variables
  private String[] introImages;
  private String textColor;

  // Static Variables
  private static String[] placeImages = {"place1.JPG", "place2.jpeg", "place3.jpeg"};
  private static String[] placeText = {"Kayaking in Monteray Bay", "Flying in a WW2 Trainer Airplane", "Archery in Pasadena"};
  private static double waitTime = 4;
  private static String lastBackGround = "Navy";


  /*
  *No Argument Constructor
  */
  public LastYear() {
    introImages = FileReader.toStringArray("IntroImages.txt");
    textColor = "black";
  }

  /*
  *Parameterized Constructor
  */
  public LastYear(String[] introImages, String textColor){
    this.introImages = introImages;
    this.textColor = textColor;
  }

  /*
   * Top level drawScene method
   * Set the text style
   * Draw the introduction screen
   * Call the methods to display the images
   *Preconditions: The introImages, placeImages, and placeText arrays are defined with the correct amount of entries\
   *Postconditions: textColor is set to a random color value
   */
  public void drawScene() {
    //Sets the background
    clear("purple");

    //Draws the introduction images
    drawImage(introImages[0], 0, 170, 190);
    drawImage(introImages[1], 200, 170, 200);

    //Sets the text settings
    textColor = randomColor();
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(45);
    setTextColor(textColor);
    drawText("New Year, New Me", 5, 80);

    //Subtitle
    setTextHeight(25);
    drawText("Atlas A", 155, 125);

    //Wait 4 seconds and reset the screen to a navy background
    pause(waitTime);
    clear(lastBackGround);

    //Draw the places images and then clear the screen
    drawPlaces();
    clear(lastBackGround);

    //Draw the family images and then wait 4 seconds
    drawFamily();
    pause(waitTime);

  }

  /*
  *Draw 3 places images with captions, wating 4 seconds between each one
  *Generates a random text color
  *Iterates through 2 of the 1D arrays in a for loop
  *Draws the images and thier corresponding captions
  *Clears the screen
  Preconditions: placeImages and placeText are defined with three values, waitTime and LastBackground are defined as Strings
  Postconditions: textColor is assigned a random value
  */
  public void drawPlaces(){
    textColor = randomColor();
    setTextColor(textColor);

    //For every place image
    for(int i = 0; i<placeImages.length; i++){
      //For the dimensions and placement check which image is at the current index.
      if(i == 0){
        drawImage(placeImages[i], 70, 10, 250); 
        drawText(placeText[i], 75, 290);
      }

      if(i == 1){
        drawImage(placeImages[i], 300, 10, 250, 90); 
        drawText(placeText[i], 25, 300);
      }

      if(i == 2){
        drawImage(placeImages[i], 110, 10, 160);
        drawText(placeText[i], 100, 350);
      }      

      //Reset to screen for the next section
      pause(waitTime);
      clear(lastBackGround);
    }
  }

  /*
  *Draw 2 family images with thier corresponding captions
  * Precondition: waitTime and lastBackGround are defined as an int and String respectively
  * Postcondition: textColor is set to a random color
  */
  public void drawFamily(){
    //Set a random text color
    textColor = randomColor();
    setTextColor(textColor);

    //Draw the first image and its caption
   drawImage("family1.jpeg", 70, 10, 250); 
   drawText("My Family at Universal Studios", 50, 290);

    //Pause then clear the screen
   pause(waitTime);
    clear(lastBackGround);

    //Draw the second image and its caption
    drawImage("family2.jpeg", 70, 10, 250);
    drawText("My Family at 29 Palms", 50, 300);	

  }

  /*
  *Generate a random text color
  *Returns a string value
  *Uses Math.random() to select between three color options: gray, white, and red
  * Precondition: none
  * Postcondition: returns a color value of gray, white, of red with equal chance
  */
  public String randomColor(){
    //Chose a random interger between 0 and 2
    int index = (int) (Math.random() * 3);

    //Depending on the selection, return a color
    if(index == 0){
      return "gray";
    }
    else if(index == 1){
      return "white";
    }
    else{
      return "red";
    }
  }



}