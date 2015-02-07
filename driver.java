
import javax.swing.*;
import java.awt.*;

public class driver
{
	public static void main(String [] args )
		 {

		JFrame theGUI = new JFrame();
		theGUI.setTitle("Dino's Pong");
		theGUI.setSize(400,400);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel panel = new MyPanel(Color.CYAN);

		theGUI.add(panel);
		theGUI.setVisible(true);
	}
}