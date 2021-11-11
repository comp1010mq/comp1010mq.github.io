package samplePackage;

import processing.core.*; 

public class ClickCounter extends PApplet {

	private static final long serialVersionUID = 1L;
	int counter = 0;
	final int TIME_LIMIT = 10;

	public void setup() {
		background(255);
	}

	public void draw() {
		if (millis() <= TIME_LIMIT*1000 + 10) {
			background(255);
			fill(0);
			textSize(24);
			text("Time left: "+(TIME_LIMIT - (int)millis()/1000), 10, 40);
			text("Clicks: "+counter, 10, 140);
		}
	}

	public void mousePressed() {
		if (millis() <= TIME_LIMIT*1000) {
			counter = counter + 1;
		}
	}

	public void settings() {  
		size(200, 200); 
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "ClickCounter" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
