package vowelCount;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VowelCount {
	
	private int aCount;
	private int eCount;
	private int iCount;
	private int oCount;
	private int uCount;
	
	private JLabel aCounter;
	private JLabel eCounter;
	private JLabel iCounter;
	private JLabel oCounter;
	private JLabel uCounter;
		
	public void getVowels(String input) {
		
		aCount = 0;
		eCount = 0;
		iCount = 0;
		oCount = 0;
		uCount = 0;
		
		String lowerCaseInput = input.toLowerCase();
		
		for(int i = 0; i < lowerCaseInput.length(); i++) {
			
			if(lowerCaseInput.charAt(i) == 'a') {
				aCount = aCount + 1;
			}
			
			if(lowerCaseInput.charAt(i) == 'e') {
				eCount = eCount + 1;
			}
			
			if(lowerCaseInput.charAt(i) == 'i') {
				iCount = iCount + 1;
			}
			
			if(lowerCaseInput.charAt(i) == 'o') {
				oCount = oCount + 1;
			}
			
			if(lowerCaseInput.charAt(i) == 'u') {
				uCount = uCount + 1;
			}
				
		}
		
	}
	
	public void showUI() {
		
		JFrame mainFrame = new JFrame("Vowel counter");
		
		JTextArea textInput = new JTextArea(20, 20);
		textInput.setLineWrap(true);

		JScrollPane scrolling = new JScrollPane(textInput);

		textInput.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				getVowels(textInput.getText());
				updateLabels();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
			
		});
		
		JPanel vowelCountPanel = new JPanel();		
		vowelCountPanel.setLayout(new BoxLayout(vowelCountPanel, BoxLayout.Y_AXIS));

		aCounter = new JLabel("A: ");
		eCounter = new JLabel("E: ");
		iCounter = new JLabel("I: ");
		oCounter = new JLabel("O: ");
		uCounter = new JLabel("U: ");
		
		vowelCountPanel.add(aCounter);
		vowelCountPanel.add(eCounter);
		vowelCountPanel.add(iCounter);
		vowelCountPanel.add(oCounter);
		vowelCountPanel.add(uCounter);
		
		mainFrame.add(scrolling, BorderLayout.NORTH);
		mainFrame.add(vowelCountPanel, BorderLayout.SOUTH);
		
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	public void updateLabels() {
		aCounter.setText("A: " + aCount);
		eCounter.setText("E: " + eCount);
		iCounter.setText("I: " + iCount);
		oCounter.setText("O: " + oCount);
		uCounter.setText("U: " + uCount);	
	}
	
	public static void main(String[] args) {
		VowelCount vowels = new VowelCount();
		vowels.showUI();	
	}
	
}