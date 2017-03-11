// Jason L. German © 2010

int currentFrame = 0;
PImage[] frames = new PImage[3];
int lastTime = 0;

void setup() 
{
  size(1440,900);
  strokeWeight(1);
  smooth();
  background(255,255,255);
  for (int i = 0; i < frames.length; i++) {
    frames[i] = get();
  }
}

void draw() 
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

void nextFrame() 
{
  frames[currentFrame] = get(); 
  currentFrame++; 
  if (currentFrame >= frames.length) {
    currentFrame = 0;
  }
  image(frames[currentFrame], 0, 0);
}

void keyTyped()
{
  save("thing.png");
  noFill();

}
