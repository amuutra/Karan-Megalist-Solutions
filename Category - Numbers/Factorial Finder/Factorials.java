package factorials;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Factorials extends BasicInputProcessor {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		Factorials factorial = new Factorials();
		
		mainFrame.add(factorial);
		
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);	
	}
	
	public long getFactorial(long input) {
		
		long result = 1;
		
		if(input == 0) {
			return 1;
		}
		
		for(int i = 1; i<=input; i++) {
			result = result * i;
		}
		
		return result;
		
	}

	@Override
	public void processInput() {
		
		long output = 0;
		long input = 0;
		
		try {
			
			input = Long.parseLong(this.getInput());
			output = getFactorial(input);
			
			if(input < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Please enter a positive number");
				output = 0;
			}
			
			if(input > 20) {
				JOptionPane.showMessageDialog(new JFrame(), "Please enter a number 0-20");
				output = 0;
			}
			
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Invalid input");
		}
				
		this.outputText("" + output);
	}
}