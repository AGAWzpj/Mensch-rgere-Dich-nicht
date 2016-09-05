package Animals;

import Animals.Animal;
import com.mycompany.tamagochi.Main;
import java.awt.*;
import java.util.Random;

public class Owl extends Animal {
	private Random rand = new Random();
	private int bobbing = 0;
	private int resources = 0;
	private int timeOfFly = 0;
	private int timeOfFeed = 0;
	private int timeOfSleep = 0;
	private int seed;
	private int stage = 1;

	public Owl(double v1, double v2, String v3, boolean v4) {
		super(v1, v2, v3, v4);
		seed = 0;
		setStatus("Idle");
	}

	public void fly() {
		setStatus("Flying");
		setEating(getEating() - (12 + rand.nextInt(8)));
		setPower(getPower() - (18 + rand.nextInt(5)));
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

	public int getSeed() {
		return seed;
	}

	public void addSeed(int par1) {
		seed += par1;
	}

	public void decSeed(int par1) {
		if (par1 > seed) {
			seed = 0;
		} else {
			seed -= par1;
		}
	}

	@Override
	public void life() {
		++bobbing;
		++resources;
		setTicksLiving(getTicksLiving() + 1);

		if (bobbing == 50) {
			setAnimalPicture("owl2.png");
		}
		if (bobbing > 50 && bobbing == 100) {
			setAnimalPicture("owl.png");
			bobbing = 0;
		}
		if (resources == 225) {
			if (getEating() != 0) {
				setEating(getEating() - 4);
			}
		}
		if (resources == 335) {
			if (getPower() != 0) {
				setPower(getPower() - 4);
			}
			resources = 0;
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

		if (getPower() == 0) {
			die();
		}

		if (getStatus() == "Sleeping") {
			++timeOfSleep;

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

			if (timeOfSleep < 800) {
				Main.getGameInstance().setBackgroundDark();
				setAnimalPicture("owl2.png");
			}
			if (timeOfSleep > 801) {
				Main.getGameInstance().resetBackground();
				setStatus("Idle");
				timeOfSleep = 0;
			}
		}

		if (getStatus() == "Flying") {
			if (stage == 1) {
				setY(getY() - 0.7);
				setX(getX() + 0.3);

				if (getY() <= 50) {
					stage = 2;
				}

			}
			if (stage == 2) {
				setY(getY() + 0.5);
				setX(getX() - 2);

				if (getX() <= 210) {
					stage = 3;
				}
			}
			if (stage == 3) {
				setY(getY() + 0.7);
				setX(getX() - 0.3);

				if (getX() <= 160) {
					stage = 4;
				}
			}
			if (stage == 4) {
				setY(getY() + 1);
				setX(getX() + 1.4);
				if (getX() <= 220) {
					stage = 5;
				}
			}
			if (stage == 5) {
				++timeOfFly;
				if (timeOfFly >= 100) {
					setY(getY() + 1.4);
					setX(getX() + 1.7);

					if (getX() <= 350 && getX() >= 320) {
						setStatus("Idle");
						stage = 1;
						timeOfFly = 0;
						setX(340);
						setY(375);
					}
				}
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
			g.drawImage(getSeedTexture(), (int) getX() + 32, (int) getY() - 16, 16, 16, null);

			g.setFont(new Font("Arial", Font.BOLD, 10));

			g.setColor(Color.white);

			g.drawString("" + getSeed(), (int) getX() + 26, (int) getY() - 14);

		}
		super.render(g);
	}

}
