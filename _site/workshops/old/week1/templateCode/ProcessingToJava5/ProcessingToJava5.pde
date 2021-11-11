float[] x = new float[5];
float[] y = new float[5];

void setup() {
  frameRate(1);
  size(403, 307);
  background(255);
  initialize(x, y);
}

void draw() {
  background(255);
  for (int i=0; i<x.length-1; i++) {
    stroke(255 - (i+1)*255.0/x.length);
    line(x[i], y[i], x[i+1], y[i+1]);
    x[i] = x[i+1];
    y[i] = y[i+1];
  }    

  x[x.length - 1] = random(width);
  y[y.length - 1] = random(height);
}

void initialize(float[] a, float[] b) {
  for (int i=0; i<a.length; i++) {
    a[i] = random(width);
    b[i] = random(height);
  }
}

