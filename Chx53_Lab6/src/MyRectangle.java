// INFSCI0017 Lab 6 - Created by Dr. John Ramirez
// Fill in the indicated code sections to complete this class.  Then test it
// by compiling and executing Lab6.java.
/**
 * CMPINF0401
 * @author Chengzhuo Xiong
 * Date: Oct 10, 2022
 */
public class MyRectangle
{
	private int startX;
	private int startY;
	private int width;
	private int height;
	// Declare instance variables here.  See toString() method below for names.

	public MyRectangle()
	{
		this.startX = 0;
		this.height = 0;
		this.startY = 0;
		this.width = 0;
		// Default constructor -- initialize all instance variables
		// to 0
	}

	public MyRectangle(int x, int y, int w, int h)
	{
		this.startX = x;
		this.startY = y;
		this.width = w;
		this.height = h;
		// Initialize instance variables based on parameters shown.
		// Be careful to get the order correct!
	}

	public int area()
	{
		int res = this.width*this.height;
		return res;
		// Return the area of this Rectangle
	}

	// I have written this method for you.  Note how a StringBuilder is
	// utilized, since (as we discussed in lecture) it can be modified
	// without having to create a new object each time (unlike a String).
	public String toString()
	{
		StringBuilder S = new StringBuilder();
		S.append("Width: " + width);
		S.append(" Height: " + height);
		S.append(" X: " + startX);
		S.append(" Y: " + startY);
		return S.toString();
	}

	public boolean isInside(int x, int y)
	{
		return (x>=this.startX&&x<=(this.startX+this.width))&&(y>=this.startY&&y<=(this.startY+this.height));
		// This is the trickiest of the methods to write.  This should
		// return true if point (x,y) is anywhere within the borders of the
		// current MyRectangle (including the borders themselves).  Use a
		// pencil and paper to figure out how this can be determined with
		// just a few simple relational operations.
	}

	public void setSize(int w, int h)
	{
		this.width = w;
		this.height = h;
		// Update width and height as shown
	}

	public void setPosition(int x, int y)
	{
		this.startX = x;
		this.startY = y;
		// Update startX and startY as shown
	}

}