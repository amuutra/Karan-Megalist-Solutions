package wordCount;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
	public void getWordCount(String input) {
		
		wordCount = 0;
		characterCount = 0;
		charactersNoSpacesCount = 0;
				
		for(int i = 0; i < input.length(); i++) {
			
			characterCount = characterCount + 1;
			
			if(!(input.charAt(i) == ' ')) {
				charactersNoSpacesCount = charactersNoSpacesCount + 1;
			}
			
			if(input.charAt(i) == ' ' && i+1<input.length() && !(input.charAt(i+1) == ' ')) {
				wordCount = wordCount + 1;
			}
			 			
		}
		
		//This is required for it to count the last word in the sentence.
		if(wordCount>0) {
			wordCount = wordCount + 1;
		}
			
	}
	
	public void showUI() {
		
		JFrame mainFrame = new JFrame("Word counter");
		
		JTextArea textInput = new JTextArea(20, 20);
		textInput.setLineWrap(true);

		JScrollPane scrolling = new JScrollPane(textInput);
		
		JPanel wordCountPanel = new JPanel();		
		wordCountPanel.setLayout(new BoxLayout(wordCountPanel, BoxLayout.Y_AXIS));

		wordCounter = new JLabel("WORDS: ");
		characterCounter = new JLabel("CHARACTERS: ");
		charactersNoSpacesCounter = new JLabel("CHARACTERS (NO SPACES): ");

		/*The "Count words" button is on a new JPanel because that way it 
		fills the line it is on, and that looks better.*/
		JPanel anotherPanel = new JPanel();
		JButton countWords = new JButton("Count words");
		
		countWords.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWordCount(textInput.getText());
				updateLabels();
			}
			
		});
		
		anotherPanel.setLayout(new BorderLayout());
		anotherPanel.add(countWords, BorderLayout.CENTER);
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
	
	public static void main(String[] args) {
		WordCount words = new WordCount();
		words.showUI();	
	}
	
}
\ No newline at end of file
