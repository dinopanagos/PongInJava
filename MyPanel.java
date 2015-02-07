// dino panagos
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel
{
  private int x,y;
private Circle c1;
private Rectangle rec;
private Rectangle selecRec;
private javax.swing.Timer timer;
private int hits = 0;
private int num=0;

	public MyPanel( Color backGroundColor)
	{
	    setBackground(backGroundColor);
	  	x = 200;
	  	y = 200;
	  	c1 = new Circle(x,y,25,Color.RED,6,140);// start going left
	  	rec = new Rectangle (350,140,20,100, Color.black);
	  	addMouseListener(new PanelListener());
	  	addMouseMotionListener(new listener());
	  	timer = new javax.swing.Timer(5, new AnimationListener());
	    timer.start();

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		c1.fill(g);
		rec.fill(g);

		for(int i = 0; i <30; i+=2)
		{
			g.drawLine(getWidth()/2, getHeight()*i/30, getWidth()/2 ,getHeight()*(i+1)/30);
		}
		g.drawString("Score: "+hits,getHeight()/3,10);
	}


	private class AnimationListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			moveCircle(c1);
			repaint();
		}
	}

	private void moveCircle( Circle c )
	{

		int x = c.getX();
		int y = c.getY();
		int radius = c.getRadius();
		int width = getWidth();
		int height = getHeight();
		int direction = c.getDirection();
		System.out.println(direction);




		if(x-radius<=0)//left
		{
		c.setDirection((360-(direction-180))%360);
		}
		else if (y-radius<=0)//top
		{
			c.setDirection((90-(direction-270))%360);
		}
    	else if (x + radius >= width)//right)
    	{

		c1 = new Circle(200,200,25,Color.RED,5,155);


  		hits = 0;
  		selecRec=null;
    	}
    	else if (y+radius>=height)//bottom
    	{
    				c.setDirection((270-(direction-90))%360);
    	}
    	else if (rec.contains(x+radius,y))
 		 {
 		 			System.out.println("hit");

			c.setDirection((180-(direction-360))%360);
			hits++;
			num++;
 		 }
		c.move();
		if(num>=3)
		{
			c.setVelocity(c.getVelocity()+2);
			num = 0;
		}
	}

	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			x = e.getX();
			y = e.getY();
			if (rec.contains(x,y))
			{
			System.out.println("has");
				selecRec = rec;
			}
			else
				System.out.println("no");

		}

		public void mouseReleased (MouseEvent e)
		{
			selecRec = null;
		}
	}
	private class listener extends MouseMotionAdapter
	{

			public void mouseDragged (MouseEvent e)
 			 {
  			 	int X2 = (e.getX()-x);
   				int Y2 = (e.getY()-y);
   				y=e.getY();
   					x=e.getX();

   				if((selecRec != null)&&(rec.contains(x,y)))
  				 {
   				 selecRec.move(Y2);
    				repaint();
   				}
  			}
		}
	}
