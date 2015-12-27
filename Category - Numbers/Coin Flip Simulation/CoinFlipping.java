package coinFlip;

import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CoinFlipping extends BasicInputProcessor {

	private Random random;
	
	public CoinFlipping() {
		random = new Random();
		this.setProcessButtonText("Flip coins");
	}
	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		CoinFlipping panel = new CoinFlipping();	
		mainFrame.add(panel);
		
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	public String flipCoin() {
		int result = random.nextInt(2);
		
		if(result == 1) {
			return "Heads";
		} else {
			return "Tails";
		}
		
	}

	@Override
	public void processInput() {
		int currentFlip = 1;
		int totalHeads = 0;
		int totalTails = 0;
		StringBuilder result = new StringBuilder();
		
		try {
			int flips = Integer.parseInt(this.getInput());
			
			if(flips<0) {
				JOptionPane.showMessageDialog(new JFrame(), "Enter a positive integer");
			} else {
			
			while(flips > 0) {
				String currentCoin = flipCoin();
				
				if(currentCoin.equals("Heads")) {
					totalHeads = totalHeads + 1;
				} else {
					totalTails = totalTails + 1;
				}				
				result.append(currentFlip + ") " + currentCoin + "\n");
				flips = flips - 1;
				currentFlip = currentFlip + 1;
			}
			
			float headsPercentage = (totalHeads * 100f) / (totalHeads + totalTails);
			float tailsPercentage = (totalTails * 100f) / (totalHeads + totalTails);
			DecimalFormat df = new DecimalFormat("#.##");
			
			result.append("TOTAL HEADS: " + totalHeads + " (" + df.format(headsPercentage) + "%)" + "\n");
			result.append("TOTAL TAILS: " + totalTails + " (" + df.format(tailsPercentage) + "%)" + "\n");
			this.outputText(result.toString());
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Enter a number between 1 and 2,147,483,647");
		}
	}
}