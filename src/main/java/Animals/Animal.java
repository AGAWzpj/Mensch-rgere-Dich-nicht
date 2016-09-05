package Animals;

import com.mycompany.tamagochi.Main;
import java.awt.*;
import javax.swing.ImageIcon;

public abstract class Animal {
	protected double x, y;
	protected String name;
	protected int power;
	protected int happiness;
	protected int eating;
	protected boolean sleepiness;
	protected boolean ifExist;
	protected boolean gone;
	protected final int scale = 80;
	protected String status;
	protected int ticksLiving;
	protected Image animalPicture;
	protected Image sleepStatus;
	protected Image powerStatus;
	protected Image eatingStatus;
	protected Image statHappiness;
	protected Image bone;
	protected Image seed;
	protected Image mouse;
	
	public abstract void life();	
	public abstract void feeding();	
	public abstract void sleeping();
	
	protected Animal(double v1, double v2, String v3, boolean v4)
	{
		x = v1;
		y = v2;
		ifExist = v4;
		sleepiness = false;
		power = 85;
		eating = 90;
		happiness = 4;
		gone = false;
		ticksLiving = 0;
		animalPicture = new ImageIcon(Main.class.getResource("/Animals/" + v3)).getImage();
		sleepStatus = new ImageIcon(Main.class.getResource("/Icon/sleepStatus.png")).getImage();
		powerStatus = new ImageIcon(Main.class.getResource("/Icon/energyStatus.png")).getImage();
		eatingStatus = new ImageIcon(Main.class.getResource("/Icon/hungerStatus.png")).getImage();
		statHappiness = new ImageIcon(Main.class.getResource("/Icon/happy4.png")).getImage();
		bone = new ImageIcon(Main.class.getResource("/Icon/bone.png")).getImage();
		seed = new ImageIcon(Main.class.getResource("/Icon/seed.png")).getImage();
		mouse = new ImageIcon(Main.class.getResource("/Icon/mouse.png")).getImage();
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public int getPower()
	{
		return power;
	}
	
	public int getHappiness()
	{
		return happiness;
	}
	
	public int getEating()
	{
		return eating;
	}
	
	public boolean getSleepiness()
	{
		return sleepiness;
	}
	
	public boolean isExisting()
	{
		return ifExist;
	}
	
	public boolean isDead()
	{
		return gone;
	}
	
	public int getScale()
	{
		return scale;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public int getTicksLiving()
	{
		return ticksLiving;
	}
	
	public Image getAnimalPicture()
	{
		return animalPicture;
	}
	
	public Image getBoneTexture()
	{
		return bone;
	}
	
	public Image getSeedTexture()
	{
		return seed;
	}
	
	public Image getMouseTexture()
	{
		return mouse;
	}
	
	public void setX(double v1)
	{
		x = v1;
	}
	
	public void setY(double v1)
	{
		y = v1;
	}
	
	public void setPower(int v1)
	{
		power = v1;
		
		if(power > 100)
		{
			power = 100;
		}
		if(power < 0)
		{
			power = 0;
		}
	}
	
	public void setHappiness(int v1)
	{
		happiness = v1;
		
		if(happiness > 4)
		{
			happiness = 4;
		}
		if(happiness < 1)
		{
			happiness = 1;
		}
	}
	
	public void setEating(int v1)
	{
		eating = v1;
		if(eating > 100)
		{
			eating = 100;
		}
	}
	
	public void setSleepiness(boolean v1)
	{
		sleepiness = v1;
	}
	
	public void setName(String v1)
	{
		name = v1;
	}
	
	public void setAnimalPicture(String v1)
	{
		animalPicture = new ImageIcon(Main.class.getResource("/Animals/" + v1)).getImage();
	}
	
	public void setStatTexture(String v1, String v2)
	{
		if(v1 == "happiness")
		{
			statHappiness = new ImageIcon(Main.class.getResource("/Icon/" + v2)).getImage();
		}
	}
	
	public void setStatus(String v1)
	{
		status = v1;
	}
	
	public void setGone(boolean v1)
	{
		gone = v1;
	}
	
	public void setTicksLiving(int v1)
	{
		ticksLiving = v1;
	}
	
	int sleepingTimer = 0;
	public void render(Graphics2D g)
	{
		if(isExisting()) 
		{
			if(getSleepiness()) 
			{	
				++sleepingTimer;	
				
				if(sleepingTimer > 75 && sleepingTimer < 150)
				{
					g.drawImage(sleepStatus, 225, 10, 48, 48, null); 
				}
				
				if(sleepingTimer > 150)
				{
					sleepingTimer = 0; 
				}		
			}
			
			g.setFont(new Font("Arial", Font.BOLD, 12)); 
			g.setColor(Color.black); 
			g.drawImage(powerStatus, 335, 10, 32, 32, null);
			g.drawString(getPower() + "%", 335, 57);
			
			g.drawImage(eatingStatus, 435, 10, 32, 32, null);
			g.drawString(getEating() + "%", 440, 57);
			
			g.drawImage(statHappiness, 535, 12, 32, 32, null);
		}
	}
	public void die()
	{
		setStatus("Dead"); 
		setGone(true); 
	}

}
