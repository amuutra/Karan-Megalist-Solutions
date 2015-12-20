package reusableComponents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class BasicInputProcessor extends JPanel {
	
	private JTextField textInput;
	private JButton processInput;
	private JTextArea resultsField;
	private JLabel resultsBelow;
	
	public BasicInputProcessor() {
		setUpPanel();
	}
	
	public String getInput() {
		return textInput.getText();
	}
	
	public void outputText(String textToOutput) {
		resultsField.setText(textToOutput);
	}
	
	public abstract void processInput();
	
	public void setUpPanel() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLayout(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		
		textInput = new JTextField(20);
		this.add(textInput, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		processInput = new JButton("Process");
		processInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				processInput();
			}		
		});
		
		this.add(processInput, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		
		resultsBelow = new JLabel("Results Below:");
		this.add(resultsBelow, c);
	
		c.gridx = 0;
		c.gridy = 3;
		
		resultsField = new JTextArea(10, 20);
		resultsField.setLineWrap(true);
		JScrollPane scrollingPanel = new JScrollPane(resultsField);
		this.add(scrollingPanel, c);
	}
	
	public void setProcessButtonText(String buttonText) {
		processInput.setText(buttonText);
	}
	
}
