size(500, 150);
background(255);
fill(73, 224, 242);

float dia = random(10, 60);
float oldDia;

// draw circles
for (float centerX = dia/2; centerX < width; centerX+=(dia/2 + oldDia/2)) {
  circle(centerX, height/2, dia);
  oldDia = dia;
  dia = random(10, 60); // set new diameter
  if(dia >= width - (centerX + oldDia/2)) {
    dia = width - (centerX + oldDia/2);
  }
}
