boolean started = false;

final float WEIGHT = 3.2;

void setup() {
  size(400, 300);
  background(255);
  println("Lines drawn with weight "+WEIGHT);
}

void draw() {
}

void mouseClicked() {
  started = !started;
}

void mouseMoved() {
    if(started) {
      stroke(255, 0, 0);
      strokeWeight(WEIGHT);
      //line from previous mouse location to current mouse location
      line(pmouseX, pmouseY, mouseX, mouseY); 
    }
}
