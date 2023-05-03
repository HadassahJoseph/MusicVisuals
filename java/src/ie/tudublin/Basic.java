package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.opengl.*;
import ddf.minim.analysis.*;


public class  Basic extends PApplet {
    Minim minim;
    AudioPlayer song;
    float angle = 0;

    public void settings() 
    {
        size(500, 500, P3D);
        
    }

    public void setup() 
    {
        colorMode(HSB);
        minim = new Minim(this);
        song = minim.loadFile("/java/data/heroplanet.mp3", 1024);
        song.play();
    }

    public void draw() 
    {
        background(0);

        float level = song.mix.level();

        translate(width/2, height/2, 0);
        rotateY(angle);
        rotateX(angle);

        //create rotating spheres
        noStroke();

        for (int i = 0; i < 1300; i++) {
            float x = random(-width/2, width/2);
            float y = random(-height/2, height/2);
            float z = random(-100, 100);
            
            float d = dist(0, 0, 0, x, y, z);
            
            fill(random(255), 255, 255);
            pushMatrix();
            translate(x, y, z);
            sphere((float) (d * level * 0.1));
            popMatrix();
        }
        angle += 0.01;
    }

    public void stop() {
        song.close();
        minim.stop();
        super.stop();
      }



}