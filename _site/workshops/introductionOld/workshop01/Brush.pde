void setup() {
  size(400, 300);
  background(0);
}

void draw() {
}

void mouseDragged() {
  stroke(240,240,80);
  strokeWeight(3);
  line(pmouseX,pmouseY,mouseX,mouseY);
}

void keyPressed() {
  background(0);
}