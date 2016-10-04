package dym.swingplatformer;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dym.swingplatformer.entities.player.Character1;
import dym.swingplatformer.entities.player.Player;
import dym.swingplatformer.physics.Rect;
public class Game extends JFrame {
	private static final long serialVersionUID = 665457190433165744L;
	private static Display d;
	private static Player player;
	private static Input i;

	public static Game g;
	
	public static BufferedImage testIsland;
	
	public Game() {
		super("Game");
		try {
			testIsland = ImageIO.read(new File("res/testisland.png"));
		} catch (Exception e) {
			
		}
		this.setSize(1280,720);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(i);
		i = new Input();
		d = new Display();
		player = new Character1(new Rect((1280/2)-16,(720/2)-16,32,32));
		SceneManager.ent.add(player);
		this.setContentPane(d);
		this.addKeyListener(i);
		pack();
		while (true) loop();
	}
	
	public static void main(String args[]) {
		g = new Game();
	}
	public static void loop() {
		try {
			player.update();
			d.repaint();
			System.out.println("Keys: "+Input.keysDown);
			Thread.sleep(15);
		} catch (InterruptedException e) 
		{e.printStackTrace();}
	}
}
