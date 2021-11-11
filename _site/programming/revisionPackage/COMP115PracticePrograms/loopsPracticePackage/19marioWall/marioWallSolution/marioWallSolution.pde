int brickWidth = 45;
int brickHeight = 20;

size(300, 200);
background(#EA4F36);
stroke(0);
strokeWeight(4);

for (int y = 0; y<=height; y+=brickHeight) {
  // draw horizontal lines
  line(0, y, width, y);

  // draw vertical lines
  if (y%(brickHeight*2) == 0) { // type 'a' row
    for (int  x = 0; x<=width; x+=brickWidth) {
      line(x, y, x, y+brickHeight); //vertical lines on type 'a' row
    }
  } else { // type 'b' row
    for (int x = brickWidth/2; x<=width; x+=brickWidth) {
      line(x, y, x, y+brickHeight); //vertical lines on type 'b' row
    }
  }
}
