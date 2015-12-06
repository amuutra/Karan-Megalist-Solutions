package fibonacci;

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

public class Fibonacci {
	
	private JTextArea results;
	
	public void generateFibonacci(long input) {
		
		results.setText("");
		
		long x = 0;
		long y = 1;
		
		if(input == 1) {
			results.setText(results.getText() + 0 + "\n");
		} else if(input == 2) {
			results.setText(results.getText() + 0 + "\n");
			results.setText(results.getText() + 1 + "\n");
		} else {
			results.setText(results.getText() + 0 + "\n");
			results.setText(results.getText() + 1 + "\n");
			
			for(int i = 2; i < input; i++) {
				long next = x + y;
				results.setText(results.getText() + next + "\n");	

				x = y;
				y = next;
			}	
		}
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
		
		JButton getFibonacci = new JButton("Generate Fibonacci");
		
		getFibonacci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					long number = Long.parseLong(numberInput.getText());
				
					if(number>93) {
						JOptionPane.showMessageDialog(new JFrame(), "Input larger than '93' will make a number so large that everything breaks");
					} else if (number>0) {
						generateFibonacci(number);		
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a positive integer");
					}
					
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid input");
				}
				
			}
			
		});
		
		mainPanel.add(getFibonacci, c);
		
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
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.showUI();
	}
}