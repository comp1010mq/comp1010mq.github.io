int counter = 0;
final int TIME_LIMIT = 10;
void setup() {
  size(200, 200);
  background(255);
}

void draw() {
  if (millis() <= TIME_LIMIT*1000 + 10) {
    background(255);
    fill(0);
    textSize(24);
    text("Time left: "+(TIME_LIMIT - (int)millis()/1000), 10, 40);
    text("Clicks: "+counter, 10, 140);
  }
}

void mousePressed() {
  if (millis() <= TIME_LIMIT*1000) {
    counter = counter + 1;
  }
}