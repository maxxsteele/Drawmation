import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class drawmation extends PApplet {

// Jason L. German \u00a9 2010

int currentFrame = 0;
PImage[] frames = new PImage[3];
int lastTime = 0;

public void setup() 
{
  size(1440,900);
  strokeWeight(1);
  smooth();
  background(255,255,255);
  for (int i = 0; i < frames.length; i++) {
    frames[i] = get();
  }
}

public void draw() 
{
  int currentTime = millis();
  if (currentTime > lastTime+30) {
    nextFrame();
    lastTime = currentTime;
  }
  if (mousePressed == true) {
    line(pmouseX, pmouseY, mouseX, mouseY);
  }
}

public void nextFrame() 
{
  frames[currentFrame] = get(); 
  currentFrame++; 
  if (currentFrame >= frames.length) {
    currentFrame = 0;
  }
  image(frames[currentFrame], 0, 0);
}

public void keyTyped()
{
  save("thing.png");
  noFill();

}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "drawmation" });
  }
}
