package nextPrimeNumber;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NextPrimeNumber {
	
	public boolean isPrime(int number) {
		
		int x = number;
		
		while(!(x == 1)) {
		
		if(!(x == number) && number % x == 0) {
			return false;
		}
			x = x - 1;
		}
		
		return true;
	}
	
	public int getNextPrime(int number) {

		int x = 1;

		while(true) {
		
		if(isPrime(number + x)) {
			return number + x;
		} else {
			x = x + 1;
		}
		
		}
		
	}
	
	public int getPreviousPrime(int number) {
		
		if(number == 1) {
			JOptionPane.showMessageDialog(new JFrame(), "Can't go lower than 1");
			return 1;
		}
			
		int x = 1;
		
		while(true) {
		
		if(isPrime(number - x)) {
			return number - x;
		} else {
			x = x + 1;
		}
		
		}
		
	}
	
	public void showUI() {
		JFrame mainFrame = new JFrame();
		JPanel mainPanel = new JPanel();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		mainFrame.add(mainPanel);
		mainPanel.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		
		JLabel currentNumber = new JLabel("1");
		mainPanel.add(currentNumber, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JButton previousNumber = new JButton("Prev. prime");
		previousNumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int newPrime = getPreviousPrime(Integer.parseInt(currentNumber.getText()));
				currentNumber.setText("" + newPrime);
			}
		});
		
		mainPanel.add(previousNumber, c);
	
		c.gridx = 1;
	
		JButton nextNumber = new JButton("Next prime");
		nextNumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int newPrime = getNextPrime(Integer.parseInt(currentNumber.getText()));
				currentNumber.setText("" + newPrime);
			}
		});
		
		mainPanel.add(nextNumber, c);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		NextPrimeNumber nextPrime = new NextPrimeNumber();
		nextPrime.showUI();		
	}
}