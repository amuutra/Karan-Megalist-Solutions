package ciphers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Caesar {
	
	private JButton encryptButton;
	private JButton decryptButton;
	private JTextField output;

	private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	private char[] shiftedAlphabet = new char[26];
	private int currentShift = 0;
	
	public void setShift(int newShift) {
			
		currentShift = newShift;
	
		for(int i = 0; i < 26; i++) {
			
			int j = i + currentShift;
					
			if(j > 25) {
				j = i + currentShift - 26;
			}
	
			shiftedAlphabet[i] = alphabet[j];	
		}	
	}
	
	public char getShiftedCharacter(char charToShift) {
			
		for(int i = 0; i <= 25; i++) {
			
			if (alphabet[i] == charToShift) {
				return shiftedAlphabet[i];
			}
			
		}
		return charToShift;
	}
	
	public char getDeshiftedCharacter(char charToShift) {
		

		for(int i = 0; i <= 25; i++) {
			
			if (shiftedAlphabet[i] == charToShift) {
				return alphabet[i];
			}
			
		}
		return charToShift;
	}
	
	public String encryptText(String textToEncrypt) {
		
		StringBuilder newString = new StringBuilder();
			
		for(int i = 0; i < textToEncrypt.length(); i++) {
			newString.append(getShiftedCharacter(textToEncrypt.charAt(i)));
		}
		
		return newString.toString();
	}
	
	public String decryptText(String textToDecrypt) {
		
		StringBuilder newString = new StringBuilder();

		for(int i = 0; i < textToDecrypt.length(); i++) {
			newString.append(getDeshiftedCharacter(textToDecrypt.charAt(i)));
		}
		
		return newString.toString();
	}
	
	public void createAndShowUI() {
		JFrame mainFrame = new JFrame();
		JPanel mainPanel = new JPanel();
		
		mainFrame.add(mainPanel);
	
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		mainPanel.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;

		JLabel inputLabel = new JLabel("Input text");
		mainPanel.add(inputLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		
		JTextField input = new JTextField(10);
		mainPanel.add(input, c);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		
		JLabel shiftLabel = new JLabel("Shift (1-25)");
		mainPanel.add(shiftLabel, c);
		
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JTextField shiftInput = new JTextField(3);
		shiftInput.setText("1");
		mainPanel.add(shiftInput, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		
		encryptButton = new JButton("Encrypt text");	
		encryptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				int newShift = Integer.parseInt(shiftInput.getText());
				
				if(newShift <= 0 || newShift > 25) {
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a number 1-25");
				} else {
					setShift(Integer.parseInt(shiftInput.getText()));
					output.setText(encryptText(input.getText()));
				}
				
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "That wasn't a valid integer");
				}
				
			}
			
		});
		
		mainPanel.add(encryptButton, c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 3;

		decryptButton = new JButton("Decrypt text");
		decryptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
				int newShift = Integer.parseInt(shiftInput.getText());
				
				if(newShift <= 0 || newShift > 25) {
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a number 1-25");
				} else {
					setShift(Integer.parseInt(shiftInput.getText()));
					output.setText(decryptText(input.getText()));
				}
				
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "That wasn't a valid integer");
				}
					
			}
				
		});
		
		mainPanel.add(decryptButton, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 6;
		
		output = new JTextField();
		mainPanel.add(output, c);
		
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
		
	public static void main(String[] args) {
		Caesar caesar = new Caesar();
		caesar.setShift(1);	
		caesar.createAndShowUI();
	}

}