package Display;

import Display.Display;
import Animals.Cat;
import Animals.Owl;
import Animals.Dog;
import Animals.Animal;
import com.mycompany.tamagochi.GuiButton;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainMenu extends Display implements MouseMotionListener, MouseListener
{

	
	private static GuiButton buttonPlay = new GuiButton(35, 479, 128, 128, 1, "Start", "button_uns.png");
	
	private static GuiButton buttonExit = new GuiButton(631, 479, 128, 128, 1, "Zakończ", "button_uns.png");
	
    private static GuiButton buttonCatSelect = new GuiButton(400, 280, 128, 64, 2, "Cat", "button_c_uns.png");
	
    private Animal cat = new Cat(330, 280, "cat.png", false);
	
	
	public boolean animalSelected = false;
	
	public static String animal;
	
	private TextField name = new TextField(18);
	
	public MainMenu()
	{
		add(name); 
		name.setText("Wpisz imię zwierzaka"); 
		name.setVisible(true); 
		lists();
		addMouseListener(this); 
		addMouseMotionListener(this); 
	}
	
	private void lists()
	{
		listOfButtons.add(buttonPlay); 
		listOfButtons.add(buttonExit); 
		listOfButtons.add(buttonCatSelect);
        listOfAnimals.add(cat);
	}
	
	
	public String getAnimal()
	{
		return animal;
	}
	
	@Override
	public void gameBreak()
	{	
		for (int i = 0; i < listOfButtons.size(); ++i)
		{
			GuiButton button = listOfButtons.get(i);
			
			if(button.getBox().contains(getMouseLocation()))
			{
				button.setMouseOver(true);
			}
			else
			{
				button.setMouseOver(false);
			}	
		}
		
		super.gameBreak(); 
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g); 
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		
		for (int i = 0; i < listOfButtons.size(); ++i)
		{
			GuiButton button = listOfButtons.get(i);
			button.time();
			button.drawImage(g);
		}
		
		for (int i = 0; i < listOfAnimals.size(); ++i)
		{
			Animal creature = listOfAnimals.get(i);
			creature.life();
			creature.render(g);
		}
			
		if(!animalSelected)
		{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 26));
			g.drawString("Wybierz rodzaj zwierzaka...", 170, 90);
		}
			
		if(animalSelected)
		{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 26));
			g.drawString(animal + " wybrany", 190, 90);
		}
		
		super.draw(g);
	}
	
	public void reset()
	{
		animalSelected = false;
		animal = null;
		name.setText("Wpisz imie zwierzaka");
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		setMousePoint(e.getPoint());
		e.consume();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
        if(buttonCatSelect.getBox().contains(e.getPoint()))
		{
			animalSelected = true;
			animal = "Cat";
			Main.startGame();
		}
		if(buttonPlay.getBox().contains(e.getPoint()) && animalSelected)
		{
			
			Main.setDisplay(Main.getGameInstance());
			Main.getGameInstance().getAnimalInstance().setName(name.getText());
			setVisible(false);
		}
		if(buttonExit.getBox().contains(e.getPoint()))
		{
			System.exit(1); 
		}
		
		
		e.consume();
	}
	
	@Override 
	public void mouseDragged(MouseEvent e)
	{
		setMousePoint(e.getPoint());
		e.consume();
	}
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
}
