This is an abstract class that itself extends from JPanel.

Adding this to a JFrame gives you a JTextField for input, JButton for processing the input and a JTextArea for results. The "Process" method is inherited when extending it.

Other methods:

getInput() returns what's in the JTextField
outputText() takes a string parameter and outputs that to the results JTextArea
setProcessButtonText() takes a string parameter and is used to change the text on the process button, like for example "Calculate PI" or "Get Fibonacci numbers"
