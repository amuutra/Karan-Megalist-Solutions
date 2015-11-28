package reverseAString;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ReverseString {
		
	
	//Method to do the reversing
	public String reverseString(String input) {

		StringBuilder builder = new StringBuilder();
		
		for(int i = input.length() - 1; i >= 0; i--) {
			builder.append(input.charAt(i));
		}
		
		return builder.toString();
	}
	
	//Also an UI because why not?
	public void showUI() {
		
		JFrame frame = new JFrame("String reverser");
		JPanel panel = new JPanel();
		
		JTextField input = new JTextField(50);
		input.setText("Reverse this string!");
		
		JButton reverse = new JButton("Reverse!");		
		
		JTextField output = new JTextField(50);
		
		reverse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				output.setText(reverseString(input.getText()));
			}
					
		});
		
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		layout.setVgap(10);
		
		panel.add(input, BorderLayout.NORTH);
		panel.add(reverse, BorderLayout.CENTER);
		panel.add(output, BorderLayout.SOUTH);
		
		frame.add(panel);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		ReverseString string = new ReverseString();
		string.showUI();
	}


}
