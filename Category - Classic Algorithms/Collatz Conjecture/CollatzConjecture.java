package collatzConjecture;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CollatzConjecture {
	
	private JTextArea results;
	
	public int findNumberOfSteps(int input) {
		
		int steps = 0;
		
		while(!(input == 1)) {
			
			if(input%2 == 0) {
				results.setText(results.getText() + "(EVEN)   " + input + " / 2 = " + input/2 + "\n");
				input = input / 2;
				steps = steps + 1;
			} else if (!(input%2 == 0)) {
				results.setText(results.getText() + "(ODD)    " + input + " / 3 + 1 = " + (input/3 + 1 + "\n"));
				input = (input / 3) + 1;
				steps = steps + 1;
			}
					
		}
		
		results.setText(results.getText() + "TOTAL STEPS: " + steps);
		return steps;
	}
	
	public void showUI() {
		
		JFrame mainFrame = new JFrame();
		JPanel mainPanel = new JPanel();

		mainFrame.add(mainPanel);

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		mainPanel.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		
		JTextField numberInput = new JTextField(20);
		mainPanel.add(numberInput, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JButton calculateSteps = new JButton("Calculate steps");
		
		calculateSteps.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int number = Integer.parseInt(numberInput.getText());
				
					if(number>0) {
						results.setText("");
						findNumberOfSteps(number);		
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a positive integer");
					}
					
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid input");
				}
				
			}
			
		});
		
		mainPanel.add(calculateSteps, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 2;
		
		JLabel result = new JLabel("Results below:");
		mainPanel.add(result, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		
		results = new JTextArea(10, 20);
		JScrollPane scrollingPanel = new JScrollPane(results);
		mainPanel.add(scrollingPanel, c);
		
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
			
	}
	
	public static void main(String[] args) {
		CollatzConjecture collatz = new CollatzConjecture();
		collatz.showUI();
	}
}