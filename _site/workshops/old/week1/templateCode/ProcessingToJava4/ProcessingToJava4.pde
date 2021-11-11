final int ROWS = 5;
final int COLS = 5;

void setup() {
  size(403, 307);
  background(255);
}

void draw() {
}

void mouseClicked() {
  background(255);

  /* The height of each row is computed as total height divided by number of rows.
   * we need to convert one of them (numerator or denomenator) to 
   * floating-point because otherwise integer/integer division
   * will lose precision. try removing the "*1.0" and see what happens.  
   */
  float rowHeight = (height*1.0/ROWS);

  //same for column width
  float colWidth = (width*1.0/COLS);

  for (int i=0; i<ROWS; i++) {

    /*
       * we compute the top y coordinate of the bounding box
     * in which the ellipse will sit based on the current row number
     * multiplied by the height of each row. 
     */
    float y = i*rowHeight; 
    for (int k=0; k<COLS; k++) {
      //same logic as y computation to compute x location
      float x = k*colWidth;
      fill(random(255), random(255), random(255));
      noStroke();
      ellipseMode(CORNER);
      ellipse(x, y, colWidth, rowHeight);
    }
  }
}

