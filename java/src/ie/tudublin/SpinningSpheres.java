package ie.tudublin;

import processing.core.PApplet;

public class SpinningSpheres extends AudioVisual {
    private float angle = 0;
    
    public SpinningSpheres(PApplet ui) {
      super(ui);
    }
    
    public void render() {
      ui.background(0);
  
      float level = song.mix.level();
  
      ui.translate(ui.width/2, ui.height/2, 0);
      ui.rotateY(angle);
      ui.rotateX(angle);
  
      // Create rotating spheres
      ui.noStroke();
  
      for (int i = 0; i < 1300; i++) {
          float x = ui.random(-ui.width/2, ui.width/2);
          float y = ui.random(-ui.height/2, ui.height/2);
          float z = ui.random(-100, 100);
          
          float d = PApplet.dist(0, 0, 0, x, y, z);
          
          ui.fill(ui.random(255), 255, 255);
          ui.pushMatrix();
          ui.translate(x, y, z);
          ui.sphere((float) (d * level * 0.1));
          ui.popMatrix();
      }
      angle += 0.01;
    }

    public float getAngle() {
      return angle;
    }

    public void setAngle(float angle) {
      this.angle = angle;
    }
  }