package Display;

import Display.Display;
import com.mycompany.tamagochi.Button;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameOver extends Display implements MouseListener, MouseMotionListener
{

	private static Button buttonMenu = new Button(23, 482, 128, 128, 1, "Menu główne", "button3.png");
	
	public GameOver()
	{
		lists();
		addMouseListener(this); 
		addMouseMotionListener(this); 
	}
	
	private void lists()
	{
		listOfButtons.add(buttonMenu); 
	}
	
	public void gameBreak()
	{
		if(buttonMenu.getBox().contains(getMouseLocation()))
		{
			buttonMenu.setMouseOver(true);
		}
		else
		{
			buttonMenu.setMouseOver(false);
		}
		super.gameBreak(); 
	}

	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g); 
	}
	
	@Override
	public void drawInterface(Graphics2D g)
	{
		super.drawInterface(g); 
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		for (int i = 0; i < listOfButtons.size(); ++i)
		{
			Button button = listOfButtons.get(i);
			button.time();
			button.drawImage(g);
		}
		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.BOLD, 58));
		g.drawString("Koniec gry",  215, 60);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		g.drawString("Twój zwierzak żył przez " 
												+ Main.getGameInstance()
												.getAnimalInstance()
														.getTicksLiving() 
															+ " jednostek czasu.", 210, 330);
		super.draw(g); 
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
		e.consume();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
