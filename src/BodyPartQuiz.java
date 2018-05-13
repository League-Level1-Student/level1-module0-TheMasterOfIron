/*
 *    Copyright (c) The League of Amazing Programmers 2013-2017
 *    Level 1
 */

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BodyPartQuiz {

	// 0. You can use the celebrity photos we have placed in the default java package,  
	// or if you prefer, get celebrity photos from the Internet, place them in the default
	// package, and change the names below.
	
	String firstImage = "src/arm 2.jpeg";
	String secondImage = "src/leg.jpeg";
	String thirdImage = "src/Finger.jpeg";
	String fourthImage = "src/Hand.jpeg";
	
	JFrame window = new JFrame();
	JPanel panel = new JPanel();


	private void startQuiz() {

		// 1. Make an int variable to hold the score.
int score = 0;
		// 2. Set the size of the window in the initializeGui() method below

		for (int i = 0; i < 4; i++) {
			
			// 4. Ask the user who this person is and store their answer
			String guess= JOptionPane.showInputDialog("What part of the body is this?");
			
			// 5. Check their answer. If they guessed correctly:
			// -- Tell them they are right and increase the score by 1
if (i == 0 && guess .equalsIgnoreCase("Arm")) {
	speak("Wow you got it right!");
	score ++;
}
			// 6. Otherwise:
			// -- Tell them they are wrong and who the person is
else if (i == 0 ){
	speak("YOU FAIL! The correct answer is Arm.");
}
else if (i == 1 && guess .equalsIgnoreCase("Leg")) {
	speak("Wow you got it right!");
	score ++;
}
			
else if (i == 1 ){
	speak("YOU FAIL! The correct answer is Leg.");
}
else if (i == 2 && guess .equalsIgnoreCase("Finger")) {
	speak("Wow you got it right!");
	score ++;
}
			
else if (i == 2 ){
	speak("YOU FAIL! The correct answer is Finger.");
}
else if (i == 3 && guess .equalsIgnoreCase("Hand")) {
	speak("Wow you got it right!");
	score ++;
}
			
else if (i == 3 ){
	speak("YOU FAIL! The correct answer is Hand.");
}
			// 7. Use the showNextImage() method below to get the next image
			showNextImage();
		    // 8. Show them their current score
			JOptionPane.showMessageDialog(null, "Your score so far is " + score + ".");
			// 9. .... repeat for all your images.....


		}

	}

	public void showNextImage() {
		panel.removeAll();
		panel.add(getNextImage());		
		window.setVisible(true);
	}

	public static void main(String[] args) {
		BodyPartQuiz quiz = new BodyPartQuiz();
		quiz.initializeGui();
		quiz.startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		
		// 3. Change the size of the window so that you can only see part of the image.		
		window.setSize(500,500);
		
		showNextImage();
		
	}

	private JLabel loadImage(String fileName) {
		Icon icon = new ImageIcon(fileName);
		JLabel label = new JLabel(icon);
		return label;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(firstImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(secondImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(thirdImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(fourthImage);
		imageList.add(imageLabel);
	}

	private JLabel getNextImage() {
		if (imageIterator.hasNext())
			return imageIterator.next();
		System.exit(0);
		return new JLabel();
	}
	static void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
