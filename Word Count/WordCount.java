package wordCount;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordCount {
	
	private int wordCount;
	private int characterCount;
	private int charactersNoSpacesCount;	
	private JLabel wordCounter;
	private JLabel characterCounter;
	private JLabel charactersNoSpacesCounter;
	
	private JTextArea textInput;
		
	public void getWordCount(String input) {
		
		wordCount = 0;
		characterCount = 0;
		charactersNoSpacesCount = 0;
				
		for(int i = 0; i < input.length(); i++) {
			
			characterCount = characterCount + 1;
			
			if(!(input.charAt(i) == ' ')) {
				charactersNoSpacesCount = charactersNoSpacesCount + 1;
			}
			
			if(i + 1 < input.length()) {
				
				if(!(input.charAt(i) == '\n')) {
				
				if(!(input.charAt(i) == ' ') && (input.charAt(i+1) == ' ') || !(input.charAt(i) == ' ') && (input.charAt(i+1) == '\n') ) {
					wordCount = wordCount + 1;
				}
				
				}
					
			}
					 			
		}
		
		if(wordCount>0) {
			wordCount = wordCount + 1;
		}
			
	}
	
	public void showUI() {
		
		JFrame mainFrame = new JFrame("Word counter");
		
		textInput = new JTextArea(20, 20);
		textInput.setLineWrap(true);

		JScrollPane scrolling = new JScrollPane(textInput);
		
		JPanel wordCountPanel = new JPanel();		
		wordCountPanel.setLayout(new BoxLayout(wordCountPanel, BoxLayout.Y_AXIS));

		wordCounter = new JLabel("WORDS: ");
		characterCounter = new JLabel("CHARACTERS: ");
		charactersNoSpacesCounter = new JLabel("CHARACTERS (NO SPACES): ");

		/*These buttons are on a new JPanel because that way they 
		fill the line they are on, and that looks better.*/
		JPanel anotherPanel = new JPanel();
		JButton countWords = new JButton("Count words");
		
		countWords.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWordCount(textInput.getText());
				updateLabels();
			}
			
		});
		
		JButton browseFile = new JButton("Load .txt file");
		
		browseFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadFromFile();
			}
					
		});
		
		anotherPanel.setLayout(new BorderLayout());
		anotherPanel.add(countWords, BorderLayout.CENTER);
		anotherPanel.add(browseFile, BorderLayout.SOUTH);
		mainFrame.add(anotherPanel);
		
		wordCountPanel.add(wordCounter);
		wordCountPanel.add(characterCounter);
		wordCountPanel.add(charactersNoSpacesCounter);
		
		mainFrame.add(scrolling, BorderLayout.NORTH);
		mainFrame.add(wordCountPanel, BorderLayout.SOUTH);
		
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	public void updateLabels() {
		wordCounter.setText("WORDS: " + wordCount);
		characterCounter.setText("CHARACTERS: " + characterCount);
		charactersNoSpacesCounter.setText("CHARACTERS (NO SPACES): " + charactersNoSpacesCount);
	}
	
	public void loadFromFile() {
		JFileChooser filechoose = new JFileChooser();
		filechoose.showOpenDialog(new JFrame());
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(filechoose.getSelectedFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if(filechoose.getSelectedFile().getName().endsWith(".txt")) {

			StringBuilder string = new StringBuilder();
			
			while(scan.hasNextLine()) {
				string.append(scan.nextLine());
				string.append("\n");
			}
			
			textInput.setText(string.toString());
			
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "This doesn't appear to be a .txt file");
		}
		
	}
	
	public static void main(String[] args) {
		WordCount words = new WordCount();
		words.showUI();	
	}
	
}