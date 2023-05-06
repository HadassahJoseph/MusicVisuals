
package ie.tudublin;

// import ddf.minim.*;
// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.AudioSource;
// import ddf.minim.Minim;
// import ddf.minim.analysis.FFT;
// import jogamp.opengl.glu.nurbs.Curve;
// import processing.core.PApplet;
import processing.core.PConstants;
//no longer needed as half is extend to my visula which is extened to visual  which has all these liabaries 

public class Half {

  float rotationX = 0; // Rotation angle around the x-axis
  float rotationY = 0; // Rotation angle around the y-axis
  float rotationZ = 0; // Rotation angle around the z-axis
  float sphereRadius = 350; // Radius of the sphere that the lines are drawn on
  int lineCount = 30; // Number of lines drawn in each direction
  int squareSize = 15; // Size of each square
  int colorChangeRate = 20; // How often the color of the lines change
  int colorTime = 0; // Counter to keep track of when to change the color

  MyVisual mv; // Reference to the main visual class
  

  public Half(MyVisual mv) {
     // Constructor that sets the main visual class reference
    this.mv = mv;

  }

  public void render() {
    // Calling draw in render 
    draw();
  }

  void draw() {
    // Set the stroke weight and background color
    mv.strokeWeight(2);
    mv.background(0);

    // Move the origin to the center of the canvas and apply rotations
    mv.translate(mv.width / 2, mv.height / 2, 0);
    mv.rotateX(rotationX);
    mv.rotateY(rotationY);
    mv.rotateZ(rotationZ);

    // Get the amplitude of the song
    float amplitude = mv.ap.mix.level();
    float sizeChange = MyVisual.map(amplitude, 0, 1, 1, 2);

    // Change the color of the lines based on the colorChangeRate
    colorTime++;
    if (colorTime % colorChangeRate == 0) {
      mv.stroke(mv.random(255), mv.random(255), mv.random(255));
    }

     // Draw the lines in a grid pattern
    for (int i = 0; i < lineCount; i++) {
      for (int j = 0; j < lineCount; j++) {
        mv.pushMatrix();
        float xPos = MyVisual.map(i, 0, lineCount, -sphereRadius, sphereRadius);
        float yPos = MyVisual.map(j, 0, lineCount, -sphereRadius, sphereRadius);
        mv.translate(xPos, yPos, 0);
        float dist = MyVisual.sqrt(MyVisual.sq(xPos) + MyVisual.sq(yPos));
        float angle = MyVisual.atan2(yPos, xPos);
        float zPos = MyVisual.sqrt(MyVisual.sq(sphereRadius) - MyVisual.sq(dist));
        mv.translate(0, 0, zPos);
        float rotAngle = MyVisual.map(zPos, 0, sphereRadius, 0, PConstants.PI);
        mv.rotateX(rotAngle);
        mv.rotateY(angle + MyVisual.radians(mv.frameCount));

        // Scale the square based on the amplitude
        float scaledSize = sizeChange * squareSize;

        // Scale and draw each square
        for (int k = 0; k < 4; k++) {
          mv.line(-scaledSize / 2, -scaledSize / 2, -scaledSize / 2, scaledSize / 2);
          mv.line(-scaledSize / 2, scaledSize / 2, scaledSize / 2, scaledSize / 2);
          mv.line(scaledSize / 2, scaledSize / 2, scaledSize / 2, -scaledSize / 2);
          mv.line(scaledSize / 2, -scaledSize / 2, -scaledSize / 2, -scaledSize / 2);
          mv.translate(0, 0, scaledSize / 2);
          mv.rotateX(PConstants.PI / 2);
        }
        mv.popMatrix();
      }
    }

    rotationX += 0.01;
    rotationY += 0.02;
    rotationZ += 0.03;
  }
}
