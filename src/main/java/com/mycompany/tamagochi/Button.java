package com.mycompany.tamagochi;

import java.awt.*;

import javax.swing.ImageIcon;

public class Button 
{

	protected double x, y;	
	protected int width, height;	
	protected int type;	
	protected boolean mouse = false;	
	protected String string;	
	protected Image image;	
	protected Rectangle rectangle;	
	protected Font font = new Font("Impact", Font.BOLD, 20);	
	
	public Button(double v1, double v2, int v3, int v4, int v5, String v6, String v7)
	{
		x = v1;
		y = v2;
		width = v3;
		height = v4;
		type = v5;
		string = v6;
		image = new ImageIcon(Main.class.getResource("/Buttons/" + v7)).getImage();
		rectangle = new Rectangle();
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getType()
	{
		return type;
	}
	
	public boolean isMouseOver()
	{
		return mouse;
	}
	
	public Image getTexture()
	{
		return image;
	}
	
	public String getText()
	{
		return string;
	}
	
	public Rectangle getBox()
	{
		return rectangle;
	}
	
	public void setX(double v1)
	{
		x = v1;
	}
	
	
	public void setY(double v1)
	{
		y = v1;
	}
	
	public void setMouseOver(boolean v1)
	{
		mouse = v1;
	}
	
	public void setTexture(String v1)
	{
		image = new ImageIcon(Main.class.getResource("/Buttons/" + v1)).getImage();
	}
	
	public void setBoxBounds(double x, double y, int width, int height)
	{
		rectangle.setBounds((int)x, (int)y, width, height);
	}
	
	public void time()
	{
		setBoxBounds(getX(), getY(), getWidth(), getHeight());
		if(getType() == 1)
		{
			if(isMouseOver())
			{
				setTexture("button3.png");
			}
			else
			{
				setTexture("button4.png");
			}
		}
		
		if(getType() == 2)
		{
			if(isMouseOver())
			{
				setTexture("button1.png");
			}
			else
			{
				setTexture("button2.png");
			}
		}
		
	}
	
	public void drawImage(Graphics2D g)
	{
		g.drawImage(getTexture(), (int)getX(), (int)getY(), getWidth(), getHeight(), null);
		text(g);
	}
	
	public void text(Graphics2D g)
	{
		if(getType() == 1)
		{
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString(getText(), (int)getX() + 20, (int)getY() + 68);
		}
		
		if(getType() == 2)
		{
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString(getText(), (int)getX() + 33, (int)getY() + 37);
		}
		
	}
	
}









