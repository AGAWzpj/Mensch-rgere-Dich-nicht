package Display;

import Animals.Animal;
import com.mycompany.tamagochi.Buttons;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public abstract class Display extends JPanel {

	protected Image background = new ImageIcon(Main.class.getResource("/Icon/background.png")).getImage();
	protected Point mouseLocation;
	protected ArrayList<Buttons> listOfButtons;
	protected ArrayList<Animal> listOfAnimals;

	protected Display() {
		mouseLocation = new Point();
		listOfButtons = new ArrayList<Buttons>();
		listOfAnimals = new ArrayList<Animal>();
		setFocusable(true);
		requestFocus();
	}

	public void gameBreak() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		drawInterface(g2d);
		g.dispose();
		g2d.dispose();
	}

	public void drawInterface(Graphics2D g) {

		g.drawImage(getBackgroundImage(), 0, 0, 800, 600, this);
		draw(g);
		g.dispose();
	}

	public void draw(Graphics2D g) {
		gameBreak();
		g.dispose();
	}

	public Image getBackgroundImage() {
		return background;
	}

	public void setBackgroundDark() {
		background = new ImageIcon(Main.class.getResource("/Icon/background2.png")).getImage();
	}

	public void resetBackground() {
		background = new ImageIcon(Main.class.getResource("/Icon/background.png")).getImage();
	}

	public Point getMouseLocation() {
		return mouseLocation;
	}

	public void setMousePoint(Point v1) {
		mouseLocation = v1;
	}

}
