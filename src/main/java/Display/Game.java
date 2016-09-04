package Display;

import Display.Display;
import AnimalFactory.AnimalType;
import AnimalFactory.AnimalSimpleFactory;
import AnimalFactory.AnimalGameFactory;
import Animals.Cat;
import Animals.Owl;
import Animals.Dog;
import Animals.Animal;
import com.mycompany.tamagochi.GuiButton;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Game extends Display implements MouseMotionListener, MouseListener
{

	private static Animal animal;	
	private static GuiButton buttonActivities = new GuiButton(23, 482, 128, 128, 1, "Czynność", "button_uns.png");	
	private static GuiButton buttonMenu = new GuiButton(645, 482, 128, 128, 1, "Menu główne", "button_uns.png");
	public Game()
	{		
		animal =new Cat(340, 375, "cat.png", true);
		lists(); 
		addMouseMotionListener(this); 
		addMouseListener(this); 
	}
	
	private void lists()
	{
		listOfAnimals.add(animal); 		
		listOfButtons.add(buttonActivities);
		listOfButtons.add(buttonMenu); 
	}
	
	
	public void gameBreak()
	{
		
		if(buttonActivities.getBox().contains(getMouseLocation()))
		{
			buttonActivities.setMouseOver(true);
		}
		else
		{
			buttonActivities.setMouseOver(false);
		}
		
		if(buttonMenu.getBox().contains(getMouseLocation()))
		{
			buttonMenu.setMouseOver(true);
		}
		else
		{
			buttonMenu.setMouseOver(false);
		}
		
		if(animal.isDead())
		{
			Main.setDisplay(Main.getGameOverInstance());
			setVisible(false);
		}
		
		super.gameBreak(); }
	
	
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g); 
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		
		for (int i = 0; i < listOfAnimals.size(); ++i)
		{
			Animal animal = (Animal)listOfAnimals.get(i);
			animal.life();
			animal.render(g);
		}
		
		for (int i = 0; i < listOfButtons.size(); ++i)
		{
			GuiButton button = (GuiButton)listOfButtons.get(i);
			button.time();
			button.drawImage(g);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 26));
		g.drawString(animal.getName(), 350, 560); 
		g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
		g.drawString(animal.getStatus(), 365, 580);
		
		super.draw(g);
	}
	
	
	public Animal getAnimalInstance()
	{
		return animal;
	}	
        
    public Cat getCatInstance()
	{
		return (Cat)animal;
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
		
		if(buttonMenu.getBox().contains(e.getPoint()))
		{
			Main.getMenuInstance().reset();
			Main.setDisplay(Main.getMenuInstance());
			setVisible(false);
		}
		
		if(animal.getStatus() == "Idle")
		{
			if(buttonActivities.getBox().contains(e.getPoint()))
			{
				Main.setDisplay(Main.getActivitiesInstance());
				setVisible(false);
			}
		}
		
		e.consume();
	}
	
	
	
	

	@Override
	public void mouseDragged(MouseEvent i) {}
	@Override
	public void mouseEntered(MouseEvent i) {}
	@Override
	public void mouseExited(MouseEvent i) {}
	@Override
	public void mousePressed(MouseEvent i) {}
	@Override
	public void mouseReleased(MouseEvent i) {}
	
}
























