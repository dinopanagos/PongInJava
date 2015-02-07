import javax.swing.*;
import java.awt.*;
public class Rectangle
{
		private int x1, y1, w, h;
			private Color color;
    public Rectangle(int x, int y, int width, int height, Color color1)
    	{
    		x1=x;
    		y1=	y;
    		w = width;
    		h = height;
    		color = color1;

   		 }

   	public void fill(Graphics g)
	{
		Color now1 = g.getColor(); //temp color
		g.setColor(color);
		g.fillRect(x1,y1,w,h);
		g.setColor(now1);    // restore
	}

	public int getRecWidth()
	{
		return w;
	}

	public int getRecHeight()
	{
		return h;
	}

	public int getLeftSide()
	{
		return x1-w/2;
	}

		public int getRightSide()
	{
		return x1+w/2;
	}

		public int getFloor()
	{
		return y1+h/2;
	}

		public int getTop()
	{
		return y1-h/2;
	}

	public int getY()
	{
		return y1;
	}

	public int getX()
	{
		return x1;
	}

	public void setHeight( int hite)
	{
		h = hite;
	}

	public void setWidth( int wid)
	{
		w = wid;
	}

	public void move( int y)
	{
		y1 += y;
		// no x
	}
	public boolean contains(int x, int y)
	{
	if(((x>=x1+1)&&(x<=x1+w+1))&&((y>=y1+1)&&(y<=y1+h+1)))
 	return true;
  	return false;
	}

}