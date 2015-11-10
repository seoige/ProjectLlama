import java.io.*;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Dimension; 
import java.awt.Toolkit;

public final class GameRun extends JFrame {
    //Constructor for this class
    public GameRun()
    {
    	
    	//add panel to frame
        add(new MyCanvas());
		//handle frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Llama Land");
        setResizable(false);
		setVisible(true);
		pack();
		setMyLocation();

    }
	
	public void setMyLocation(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
		Point newLocation = new Point(middle.x - (this.getWidth() / 2), 
                              middle.y - (this.getHeight() / 2) - 15);
		this.setLocation(newLocation);
	}
				
    public static void main(String[] args) throws InterruptedException{
        new GameRun(); //creates an anonymnous instance of this class
    }
}
