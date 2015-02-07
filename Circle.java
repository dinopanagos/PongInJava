//dino panagos period 5
import javax.swing.*;
import java.awt.*;
public class Circle
{
	private int centerX, centerY, radius, vel, dir;
	private Color color;

	public Circle(int x, int y, int rad, Color color1, int v, int d)
	{
		dir = d;
		vel = v ;
		centerX = x;
		centerY = y;
		radius = rad;
		color = color1;
	}

	public void fill(Graphics g)
	{
		Color now = g.getColor(); //temp color
		g.setColor(color);
		g.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
		g.setColor(now);    // restore
	}
	public boolean containsPoint(int x, int y)
	{

	if((Math.pow((centerX - x),2) + Math.pow((centerY-y),2)) <= Math.pow(radius,2))
	{
//	System.out.println("has point");
	return true;}
	else
	{
	//	System.out.println("NO point");
    return	false;
}

	}
	public void move(int xAmount, int yAmount)
	{
		centerX +=xAmount;
		centerY +=yAmount;

	}
	public void move()
	{
		move((int)(vel * Math.cos(Math.toRadians(dir))),
       (int)(vel * Math.sin(Math.toRadians(dir))));
	}

	public void turn(int degrees)
	{
		dir = (dir + degrees) % 360;
	}
	public void setVelocity(int v)
	{
		vel = v;
	}
	public void setDirection(int degrees)
	{
		dir = degrees;
	}
	public int getX()
     {
  		return centerX;
     }
 	public int getY()
     {
     	 return centerY;
      }
       public int getRadius()
       {
       	return radius;
       }
     public int getDirection()
     {
     	return dir;
     }

     	public int getVelocity()
     	{
     		return vel;
     	}

}