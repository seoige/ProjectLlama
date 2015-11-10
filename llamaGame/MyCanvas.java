import java.util.Scanner;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.geom.AffineTransform;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MyCanvas extends JPanel implements ActionListener{

	private Image background;
	private static Image llama;
	private static Image platform;
	private int h;
	private int w;
	
	public MyCanvas(){
		loadImage(); // load background image here
		w = background.getWidth(this);
		h = background.getHeight(this);
		setPreferredSize(new Dimension(w, h)); 
		//add key listener to panel using a keyadapter class as argument
		//saddKeyListener(new TAdapter());
		setFocusable(true); // Set panel as focusable
		setDoubleBuffered(true); //set frame buffer to two
		
		int imageWidth = llama.getWidth(this);
		System.out.println("Image width is "+imageWidth);
		int imageHeight = llama.getHeight(this);
		System.out.println("Image height is "+imageHeight);
		//timer = new Timer(5, this); // five milliseconds timer
        //timer.start(); //start timer now and call 
	}
	
	
	private void loadImage() {
        ImageIcon ii = new ImageIcon("background2.jpg");
        background = ii.getImage(); 
		ii = new ImageIcon("llama_image.gif");
		llama = ii.getImage();
		ii = new ImageIcon("platform2.gif");
		platform = ii.getImage();
    }
	
	public void actionPerformed(ActionEvent e) {
		repaint();  
    }
	
	public void paint(Graphics g) {
        super.paint(g);
		g.drawImage(background, 0, 0, null);
		drawPlatforms(g);
		//draw player here
		drawPlayer(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
	
	private static void drawPlayer(Graphics g){
		int x = 450;
		int y = 350;
		Graphics2D g2d = (Graphics2D)g;
		//g2d.drawImage(llama, x/2, y/2, null);
		g2d.drawImage(llama, x, y, null);
		
	}
	
	private static void drawPlatforms(Graphics g){
		int x = 400;
		int y = 400;
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(platform, x/2, y/2, null);
		g2d.drawImage(platform, 200+(x/2), (y/2)-200, null);
	}
}