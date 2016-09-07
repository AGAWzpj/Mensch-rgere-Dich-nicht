package Display;

import Display.Display;
import Animals.Cat;
import Animals.Owl;
import Animals.Dog;
import com.mycompany.tamagochi.Button;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Activities extends Display implements MouseMotionListener, MouseListener {
	private static Button buttonOfMainActivity;
	private static Button buttonFeed;
	private static Button buttonTreat;
	private static Button buttonPlay;
	private static Button buttonSleep;
	private static Button buttonScold;
	private static Button buttonBack = new Button(645, 482, 128, 128, 1, "Cofnij", "button3.png");

	public Activities() {
		if (Main.getGameInstance().getAnimalInstance() instanceof Dog) {
			buttonOfMainActivity = new Button(70, 245, 128, 64, 2, "Spacer", "button1.png");
			buttonFeed = new Button(210, 85, 128, 64, 2, "Nakarm", "button1.png");
			buttonTreat = new Button(460, 85, 128, 64, 2, "Daj kość", "button1.png");
			buttonPlay = new Button(460, 395, 128, 64, 2, "Baw się", "button1.png");
			buttonSleep = new Button(335, 245, 128, 64, 2, "Śpij", "button1.png");
			buttonScold = new Button(585, 245, 128, 64, 2, "Ukarz", "button1.png");
		}
		if (Main.getGameInstance().getAnimalInstance() instanceof Owl) {
			buttonOfMainActivity = new Button(70, 245, 128, 64, 2, "Lataj", "button1.png");
			buttonFeed = new Button(210, 85, 128, 64, 2, "Nakarm", "button1.png");
			buttonTreat = new Button(460, 85, 128, 64, 2, "Daj nasionka", "button1.png");
			buttonPlay = null;
			buttonSleep = new Button(335, 245, 128, 64, 2, "Śpij", "button1.png");
			buttonScold = null;
		}
		if (Main.getGameInstance().getAnimalInstance() instanceof Cat) {
			buttonOfMainActivity = new Button(70, 245, 128, 64, 2, "Poluj", "button1.png");
			buttonFeed = new Button(210, 85, 128, 64, 2, "Nakarm", "button1.png");
			buttonTreat = new Button(460, 85, 128, 64, 2, "Daj mysz", "button1.png");
			buttonPlay = new Button(460, 395, 128, 64, 2, "Baw się", "button1.png");
			;
			buttonSleep = new Button(335, 245, 128, 64, 2, "Śpij", "button1.png");
			buttonScold = null;
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

		if (buttonScold != null) {
			listOfButtons.add(buttonScold);
		}
		if (buttonPlay != null) {
			listOfButtons.add(buttonPlay);
		}
		listOfButtons.add(buttonBack);
	}

	public void gameBreak() {
		for (int i = 0; i < listOfButtons.size(); ++i) {
			Button button = listOfButtons.get(i);
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
			Button button = listOfButtons.get(i);
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
		if (Main.getGameInstance().getAnimalInstance() instanceof Dog) {

			if (buttonOfMainActivity.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getDogInstance().walkies();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

			if (buttonFeed.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getDogInstance().feeding();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

			if (buttonTreat.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getDogInstance().addBone(1);
				Main.getGameInstance().getDogInstance()
						.setHappiness(Main.getGameInstance().getDogInstance().getHappiness() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

			if (buttonPlay.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getDogInstance().play();
				Main.getGameInstance().getDogInstance()
						.setHappiness(Main.getGameInstance().getDogInstance().getHappiness() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

			if (buttonSleep.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getDogInstance().sleeping();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

			if (buttonScold.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getDogInstance().scold();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
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
						.setHappiness(Main.getGameInstance().getCatInstance().getHappiness() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonPlay.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().play();
				Main.getGameInstance().getCatInstance()
						.setHappiness(Main.getGameInstance().getCatInstance().getHappiness() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonSleep.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getCatInstance().sleeping();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}

		}
		if (Main.getGameInstance().getAnimalInstance() instanceof Owl) {
			if (buttonOfMainActivity.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getOwlInstance().fly();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonFeed.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getOwlInstance().feeding();
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);
			}
			if (buttonTreat.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getOwlInstance().addSeed(3);
				Main.getGameInstance().getOwlInstance()
						.setHappiness(Main.getGameInstance().getOwlInstance().getHappiness() + 1);
				Main.setDisplay(Main.getGameInstance());
				setVisible(false);

			}
			if (buttonSleep.getBox().contains(e.getPoint())) {
				Main.getGameInstance().getOwlInstance().sleeping();
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
