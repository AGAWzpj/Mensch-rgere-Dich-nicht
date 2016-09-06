package Animals;

import Animals.Animal;
import com.mycompany.tamagochi.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Cat extends Animal {

	private Random rand = new Random();
	private int bobbing = 0;
	private int resources = 0;
	private int timeOfFeed = 0;
	private int timeOfSleep = 0;
	private int timeOfPlay = 0;
	private int playCount = 0;
	private int mouse;
	public int stage = 1;
	private int timeOfHunt = 0;

	public Cat(double v1, double v2, String v3, boolean v4) {
		super(v1, v2, v3, v4);
		mouse = 0;
		setStatus("Idle");
	}
        
        public int getBobbing(){
            return bobbing;
        }
        
        public void setBobbing(int x){
            this.bobbing = x;
        }

	public void hunting() {
		setStatus("Hunting");
		setPower(getPower() - (5 + rand.nextInt(17)));
		setEating(getEating() - (4 + rand.nextInt(8)));
	}

	public void play() {
		setStatus("Playing");
	}

	public void feeding() {
		setStatus("Feeding");
		setPower(getPower() + (3 + rand.nextInt(4)));
	}

	public void sleeping() {
		if (getSleepiness()) {
			setStatus("Sleeping");
			setPower(getPower() + (45 + rand.nextInt(18)));
		} else {
			return;
		}
	}

	public int getMouse() {
		return mouse;
	}

	public void addMouse(int v1) {
		mouse += v1;
	}

	public void decMouse(int v1) {
		if (v1 > mouse) {
			mouse = 0;
		} else {
			mouse -= v1;
		}
	}

	@Override
	public void life() {
		++bobbing;
		++resources;
		setTicksLiving(getTicksLiving() + 1);

		if (bobbing == 50) {
			setAnimalPicture("cat.png");
		}
		if (bobbing > 50 && bobbing == 100) {
			setAnimalPicture("cat2.png");
			bobbing = 0;
		}
		if (getStatus() != "Sleeping") {
			if (resources == 100) {
				if (getEating() != 0) {
					setEating(getEating() - (3 + rand.nextInt(3)));
				}
			}
			if (resources >= 200) {
				if (getPower() != 0) {
					setPower(getPower() - (2 + rand.nextInt(4)));
				}
				resources = 0;
			}
		}

		if (getPower() < 25) {
			setSleepiness(true);
			setHappiness(1);
		}
		if (getEating() >= 85) {
			setHappiness(4);
		}
		if (getEating() >= 50 && getEating() < 85) {
			setHappiness(3);
		}
		if (getEating() >= 35 && getEating() < 50) {
			setHappiness(2);
		}
		if (getEating() >= 1 && getEating() < 35) {
			setHappiness(1);
		}
		if (getPower() >= 25) {
			setSleepiness(false);
		}
		if (getEating() <= 0) {
			setEating(0);
		}
		if (getEating() > 100) {
			setEating(100);
		}
		if (getPower() <= 0) {
			setPower(0);
		}
		if (getPower() > 100) {
			setPower(100);
		}

		if (getStatus() == "Playing") {
			++timeOfPlay;

			if (timeOfPlay <= 20) {
				setY(getY() - 1.5);
			}
			if (timeOfPlay > 20 && timeOfPlay < 40) {
				setY(getY() + 1.4);
			}
			if (timeOfPlay >= 40) {
				setY(375);
				playCount++;
				timeOfPlay = 0;
			}
			if (playCount == 6) {
				setStatus("Idle");
				timeOfPlay = 0;
				playCount = 0;
			}

		}

		if (getStatus() == "Hunting") {

			if (stage == 1) {
				setX(getX() + 0.3);

				if (getX() >= 450) {
					stage = 2;
				}

			}
			if (stage == 2) {
				setY(getY() - 1);
				setX(getX() + 2);

				if (getX() >= 510) {
					stage = 3;
				}
			}
			if (stage == 3) {
				setY(getY() + 1);
				setX(getX() + 2);

				if (getX() >= 570) {
					stage = 4;
				}
			}

			if (stage == 4) {
				++timeOfHunt;
				if (timeOfHunt >= 20) {
					setY(getY() + 1.4);
					setX(getX() + 1.7);

					if (getX() <= 350 && getX() >= 320) {
						setStatus("Idle");
						stage = 1;
						timeOfHunt = 0;
						setX(340);
						setY(375);
					}
				}
			}
		}
		if (getX() >= 930) {
			setX(-20);
		}
		if (getX() < 340 && getX() > 330) {
			setStatus("Idle");
			setX(340);
		}

		if (getStatus() == "Sleeping") {
			++timeOfSleep;
			if (timeOfSleep < 800) {
				Main.getGameInstance().setBackgroundDark();
				setAnimalPicture("cat2.png");
			}
			if (timeOfSleep > 801) {
				Main.getGameInstance().resetBackground();
				setStatus("Idle");
				timeOfSleep = 0;
			}
		}

		if (getStatus() == "Feeding") {
			++timeOfFeed;

			if (timeOfFeed == 20) {
				setEating(getEating() + (2 + rand.nextInt(2)));
			}
			if (timeOfFeed == 40) {
				setEating(getEating() + (2 + rand.nextInt(2)));
			}
			if (timeOfFeed == 60) {
				setEating(getEating() + (2 + rand.nextInt(2)));
			}
			if (timeOfFeed == 80) {
				setEating(getEating() + (2 + rand.nextInt(2)));
			}
			if (timeOfFeed == 100) {
				setEating(getEating() + (2 + rand.nextInt(2)));
				setStatus("Idle");
				timeOfFeed = 0;
			}

		}

		if (getPower() == 0) {
			die();
		}

		if (isExisting()) {
			switch (getHappiness()) {
			case 1:
				setStatTexture("happiness", "happy1.png");
				break;
			case 2:
				setStatTexture("happiness", "happy2.png");
				break;
			case 3:
				setStatTexture("happiness", "happy3.png");
				break;
			case 4:
				setStatTexture("happiness", "happy4.png");
				break;

			default:
				setStatTexture("happiness", "happy.png");
				break;
			}
		}

	}

	@Override
	public void render(Graphics2D g) {

		g.drawImage(getAnimalPicture(), (int) getX(), (int) getY(), getScale(), getScale(), null);

		if (isExisting()) {
			g.drawImage(getMouseTexture(), (int) getX() + 32, (int) getY() - 16, 16, 16, null);
			g.setFont(new Font("Arial", Font.BOLD, 10));
			g.setColor(Color.white);
			g.drawString("" + getMouse(), (int) getX() + 32, (int) getY() - 14);

		}
		super.render(g);
	}
}
