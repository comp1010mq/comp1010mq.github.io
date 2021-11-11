void setup() {
  size(400, 300);
  background(255);
}

void draw() {
    stroke(255, 0, 0); //line color red
    strokeWeight(3); //thickness of line
    //line from previous mouse location to current mouse location
    line(pmouseX, pmouseY, mouseX, mouseY); 
}
