import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] colony;
int x= (int)(Math.random()*800);
int y= (int)(Math.random()*800);

 public void setup()    
 {     
 	background(0);
 	size(500,500);
 	colony = new Bacteria[20];
 	for ( int p =0; p < colony.length; p++)
 	{
 		colony[p] = new Bacteria(250,250);
 	}
 }   

 public void draw()   
 {    
 	background(0);
 	fill(255); 
 	noStroke();                                      ellipse(mouseX, mouseY, 30,30);
 	for ( int l =0; l < colony.length; l++)
 	{
 		colony[l].move();
 		colony[l].show();
 	}

 }  

 class Bacteria    
 {     
 	int myX, myY, xchange, ychange, bactC, bactCtrim, numBugs;
 	boolean alive;
 	Bacteria ( int x, int y)
 	{
 		myX = x;
    	myY = y;
    	bactC=color(249,252,144);
    	bactCtrim=color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    	alive = true;
    }

 	public void move()
	{
		xchange=(int)(Math.random()*25)-12;
		ychange=(int)(Math.random()*25)-12;
		myX = myX + xchange;
		myY = myY + ychange;
	} 

	public void show()
	{
		if(get(myX,myY) == color(255))
		{
			alive = false;
			numBugs +=1;
		}

		if (alive == true)
		{
		int d = (int)(Math.random()*11 + 5);
		stroke(bactCtrim);
		fill(bactC); 
		ellipse(myX, myY, d,d);
		}
		stroke(255);
		textSize(15);
		text("Bugs Caught: " + numBugs, 50,450);
	} 

	public void MousePressed()
	{
		redraw();
	}
 }  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
