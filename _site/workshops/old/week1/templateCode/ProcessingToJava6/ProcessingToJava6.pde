String s = "Hallelujah!";
PFont myFont;

void setup() {
  size(400, 300);
  background(0);
  myFont = createFont("Courier", 40);
}

void draw() {
}

void mouseClicked() {
  if (s!=null && s.length() > 0) {
    background(0);
    fill(240, 240, 80);
    textFont(myFont);
    textSize(40);
    textAlign(LEFT, TOP);
    text(s, random(width - s.length()*15), random(height - s.length()*15));
    s = s.substring(1); //remove the first character
  }
}

