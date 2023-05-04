
package ie.tudublin;

import ddf.minim.*;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioSource;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import jogamp.opengl.glu.nurbs.Curve;
import processing.core.PApplet;



public class Half {



float rotationX = 0;
float rotationY = 0;
float rotationZ = 0;
float sphereRadius = 250;
int lineCount = 30;
int squareSize = 15;
int colorChangeRate = 20;
int colorTime = 0;

MyVisual mv;



 
public Half(MyVisual mv) {

    this.mv = mv;
 
 }

 public void render()
 {
   draw ();
 }


void draw() {

mv.strokeWeight(2);
  mv.background(0);
  int width;
int height;
translate(width/2, height/2, 0);
  rotateX(rotationX);
  rotateY(rotationY);
  rotateZ(rotationZ);
  
  // Get the amplitude of the song
  float amplitude = song.mix.level();
  float sizeChange = map(amplitude, 0, 1, 1, 2);
  
  colorTime++;
  if (colorTime % colorChangeRate == 0) {
    stroke(random(255), random(255), random(255));
  }
  
  for (int i = 0; i < lineCount; i++) {
    for (int j = 0; j < lineCount; j++) {
      pushMatrix();
      float xPos = map(i, 0, lineCount, -sphereRadius, sphereRadius);
      float yPos = map(j, 0, lineCount, -sphereRadius, sphereRadius);
      translate(xPos, yPos, 0);
      float dist = sqrt(sq(xPos) + sq(yPos));
      float angle = atan2(yPos, xPos);
      float zPos = sqrt(sq(sphereRadius) - sq(dist));
      translate(0, 0, zPos);
      float rotAngle = map(zPos, 0, sphereRadius, 0, PI);
      rotateX(rotAngle);
      rotateY(angle + radians(frameCount));
      
      // Scale the square based on the amplitude
      float scaledSize = sizeChange * squareSize;
      
      for (int k = 0; k < 4; k++) {
        line(-scaledSize/2, -scaledSize/2, -scaledSize/2, scaledSize/2);
        line(-scaledSize/2, scaledSize/2, scaledSize/2, scaledSize/2);
        line(scaledSize/2, scaledSize/2, scaledSize/2, -scaledSize/2);
        line(scaledSize/2, -scaledSize/2, -scaledSize/2, -scaledSize/2);
        translate(0, 0, scaledSize/2);
        rotateX(PI/2);
      }
      popMatrix();
    }
  }
  
  rotationX += 0.01;
  rotationY += 0.02;
  rotationZ += 0.03;
}

private void background(int i) {
}
}