package Display;

import Display.Display;
import Animals.Cat;
import Animals.Owl;
import Animals.Dog;
import Animals.Animal;
import com.mycompany.tamagochi.Button;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainMenu extends Display implements MouseMotionListener, MouseListener {

	private static Button buttonPlay = new Button(35, 479, 128, 128, 1, "Start", "button3.png");
	private static Button buttonExit = new Button(631, 479, 128, 128, 1, "Zakończ", "button3.png");
	private static Button buttonOwlSelect = new Button(400, 120, 128, 64, 2, "Owl", "button1.png");
	private static Button buttonDogSelect = new Button(400, 200, 128, 64, 2, "Dog", "button1.png");
	private static Button buttonCatSelect = new Button(400, 280, 128, 64, 2, "Cat", "button1.png");

	private Animal dog = new Dog(330, 200, "dog.png", false);
	private Animal cat = new Cat(330, 280, "cat.png", false);
	private Animal owl = new Owl(330, 120, "owl.png", false);

	public boolean animalSelected = false;

	public static String animal;

	private TextField name = new TextField(18);

	public MainMenu() {
		add(name);
		name.setText("Wpisz imię zwierzaka");
		name.setVisible(true);
		lists();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void lists() {
		listOfButtons.add(buttonPlay);
		listOfButtons.add(buttonExit);
		listOfButtons.add(buttonOwlSelect);
		listOfButtons.add(buttonDogSelect);
		listOfButtons.add(buttonCatSelect);
		listOfAnimals.add(dog);
		listOfAnimals.add(owl);
		listOfAnimals.add(cat);
	}

	public String getAnimal() {
		return animal;
	}

	@Override
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

		for (int i = 0; i < listOfAnimals.size(); ++i) {
			Animal creature = listOfAnimals.get(i);
			creature.life();
			creature.render(g);
		}

		if (!animalSelected) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 26));
			g.drawString("Wybierz rodzaj zwierzaka...", 170, 90);
		}

		if (animalSelected) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 26));
			g.drawString(animal + " wybrany", 190, 90);
		}

		super.draw(g);
	}

	public void reset() {
		animalSelected = false;
		animal = null;
		name.setText("Wpisz imie zwierzaka");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		setMousePoint(e.getPoint());
		e.consume();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (buttonOwlSelect.getBox().contains(e.getPoint())) {
			animalSelected = true;
			animal = "Owl";
			Main.startGame();
		}
		if (buttonDogSelect.getBox().contains(e.getPoint())) {
			animalSelected = true;
			animal = "Dog";
			Main.startGame();
		}
		if (buttonCatSelect.getBox().contains(e.getPoint())) {
			animalSelected = true;
			animal = "Cat";
			Main.startGame();
		}
		if (buttonPlay.getBox().contains(e.getPoint()) && animalSelected) {

			Main.setDisplay(Main.getGameInstance());
			Main.getGameInstance().getAnimalInstance().setName(name.getText());
			setVisible(false);
		}
		if (buttonExit.getBox().contains(e.getPoint())) {
			System.exit(1);
		}

		e.consume();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setMousePoint(e.getPoint());
		e.consume();
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
