package com.mycompany.tamagochi;

import Display.Game;
import Display.MainMenu;
import Display.GameOver;
import Display.Activities;
import Display.Display;
import java.awt.*;
import javax.swing.*;

public class Main {
	private final Image image = new ImageIcon(this.getClass().getResource("/Animals/dog.png")).getImage();
	private static JFrame frame;
	private static Display displayGame;
	private static Display displayActivities;
	private static Display displayMenu;
	private static Display displayGameOver;

	public Main() {
		frame = new JFrame();
		displayMenu = new MainMenu();
		displayGameOver = new GameOver();
		frame.setTitle("Tamagotchi");
		frame.setIconImage(image);
		frame.add(displayMenu);
		frame.setSize(new Dimension(806, 628));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] v1) {
		new Main();
	}

	public static void startGame() {
		displayGame = new Game();
		displayActivities = new Activities();
	}

	public static Game getGameInstance() {
		return (Game) displayGame;
	}

	public static Activities getActivitiesInstance() {
		return (Activities) displayActivities;
	}

	public static MainMenu getMenuInstance() {
		return (MainMenu) displayMenu;
	}

	public static GameOver getGameOverInstance() {
		return (GameOver) displayGameOver;
	}

	public static void setDisplay(Display v1) {
		frame.add(v1);
		v1.setVisible(true);
	}

}
