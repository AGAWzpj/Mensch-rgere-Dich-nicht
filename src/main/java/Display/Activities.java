package Display;

import Display.Display;
import Animals.Cat;
import Animals.Owl;
import Animals.Dog;
import com.mycompany.tamagochi.GuiButton;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Activities extends Display implements MouseMotionListener, MouseListener {
	private static GuiButton buttonOfMainActivity;
	private static GuiButton buttonFeed;
	private static GuiButton buttonTreat;
	private static GuiButton buttonPlay;
	private static GuiButton buttonSleep;
	private static GuiButton buttonBack = new GuiButton(645, 482, 128, 128, 1, "Cofnij", "button_uns.png");

	public Activities() {		
		if (Main.getGameInstance().getAnimalInstance() instanceof Cat) {
			buttonOfMainActivity = new GuiButton(70, 245, 128, 64, 2, "Poluj", "button_c_uns.png");
			buttonFeed = new GuiButton(210, 85, 128, 64, 2, "Nakarm", "button_c_uns.png");
			buttonTreat = new GuiButton(460, 85, 128, 64, 2, "Daj mysz", "button_c_uns.png");
			buttonPlay = new GuiButton(460, 395, 128, 64, 2, "Baw się", "button_c_uns.png");			
			buttonSleep = new GuiButton(335, 245, 128, 64, 2, "Śpij", "button_c_uns.png");
			
		}

		buttons();
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	private void buttons() {
		listOfButtons.add(buttonOfMainActivity);
		listOfButtons.add(buttonFeed);
		listOfButtons.add(buttonTreat);
		listOfButtons.add(buttonSleep);
		listOfButtons.add(buttonPlay);
		listOfButtons.add(buttonBack);
	}
	
	
	public void gameBreak() {
		for (int i = 0; i < listOfButtons.size(); ++i) {
			GuiButton button = listOfButtons.get(i);
			if (button.getBox().contains(getMouseLocation())) {
				button.setMouseOver(true);
			} else {
				button.setMouseOver(false);
			}
		}
		super.gameBreak();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < listOfButtons.size(); ++i) {
			GuiButton button = listOfButtons.get(i);
			button.time();
			button.drawImage(g);
		}
		super.draw(g);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		setMousePoint(e.getPoint());
		e.consume();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (buttonBack.getBox().contains(e.getPoint())) {
			Main.setDisplay(Main.getGameInstance());
			setVisible(false);
		}
		
		if (Main.getGameInstance().getAnimalInstance() instanceof Cat) {

			if (buttonOfMainActivity.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().hunting();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonFeed.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().feeding();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonTreat.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().addMouse(1);
				Main.getGameInstance().getCatInstance()
						.setSatisfaction(Main.getGameInstance().getCatInstance().getSatisfaction() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonPlay.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().play();
				Main.getGameInstance().getCatInstance()
						.setSatisfaction(Main.getGameInstance().getCatInstance().getSatisfaction() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonSleep.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().sleeping();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

		}

		e.consume();
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
