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

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .2f; 
 
public void setup() 
{   
	size(641,700);    
	 
} 
public void draw() 
{   
	background(0);   
	stroke(0,255,0);   
	line(320,480,320,380);   
	drawBranches(320,380,100,(3*Math.PI/2));  //174.36 is only angle that makes it right?!! 
     branchAngle = (double)mouseX/405;
} 
public void drawBranches(int x,int y, double branchLength, double angle) 
{  

	if(branchLength < 15)
	{
		int endX1;
	int endY1;
	int endX2;
	int endY2;
	double angle1; 
	double angle2;
	angle1 = angle + branchAngle;
    angle2 = angle - branchAngle;
    branchLength = branchLength * fractionLength;
	endX1 = (int)(branchLength*Math.cos(angle1) + x);  
    endY1 = (int)(branchLength*Math.sin(angle1) + y);
    endX2 = (int)(branchLength*Math.cos(angle2) +x );  
    endY2 = (int)(branchLength*Math.sin(angle2)  +y);
    line(x, y, endX1, endY1);
    line(x, y, endX2, endY2);
    
	}

	else 
	{
		int endX1;
	int endY1;
	int endX2;
	int endY2;
	double angle1; 
	double angle2;
	angle1 = angle + branchAngle;
    angle2 = angle - branchAngle;
    branchLength = branchLength * fractionLength;
	endX1 = (int)(branchLength*Math.cos(angle1) + x);  
    endY1 = (int)(branchLength*Math.sin(angle1) + y);
    endX2 = (int)(branchLength*Math.cos(angle2) +x );  
    endY2 = (int)(branchLength*Math.sin(angle2)  +y);
	line(x, y, endX1, endY1);
    line(x, y, endX2, endY2);
     drawBranches(endX1, endY1, branchLength, angle1) ;
    drawBranches(endX2, endY2, branchLength, angle2);
}
	

    }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
