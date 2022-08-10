/*
Author: Amirreza Pazira 
UCID: 30133500 
Tutorial: 08

Version: 13-April-2021

Program: GUI shopping program with login window and secure password decryption

Class specific features:

This class extends the JDialog class and implements ActionListener so that the user can hit enter or use the login button to login
This class will create an object of Reader class and call the read() method in that class to get the decrypted password from the password.txt file
Then it will decrypt the password by reversing caeser's cipher so that the correct password matches the entered password
This class will create the Dialog box for login section it will create buttons, labels and fields needed on the login window and set their size
This class uses actionPerformed(ActionEvent e) method for reacting to user's action when hitting enter or login button
This class will check if the entered password matches the correct password then it will either log you in or remove one attempts from max password attempts
If the failed attempts reach the max this program will display a message on window title will shut down after a pause
If the correct password is entered this class will create an object of MyFrame class which then creates a main shopping window

*/
// Importing necessary classes
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MyDialog extends JDialog implements ActionListener
{
    // Variables for max incorrect attempts and current attempts
    private final int MATCH = 0;
    private final int ATTEMPTS = 3;
    private int fails = 0;
    // objects referencing JPasswordField,JLabel,JButton
    private String password = null;
    private JPasswordField aPasswordField;
    private JLabel passLabel;
    private JButton loginButton;
    // Array for decrypting the password
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // Constructor for creating the objects and adding addActionListener to our password field and login button
    // Also adding all the components to our window
    public MyDialog(){
        password = password();
        setTitle("Welcome, Please Login!");
        passLabel = new JLabel("Enter password");
        loginButton = new JButton("Login");
        loginButton.setBounds(50,70,100,20);
        passLabel.setBounds(50,20,120,20);
        aPasswordField = new JPasswordField();
        aPasswordField.setBounds(50,40,120,20);
        aPasswordField.addActionListener(this);
        loginButton.addActionListener(this);
        setLayout(null);
        addControls();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    // Features: Method for adding each component or controls to our login Dialog window
    public void addControls(){
        add(passLabel);
        add(aPasswordField);
        add(loginButton);
    }
    // Features: Method for when either the user hits the enter key or login button this method will be called 
    // and it will check the password entered with the correct password if it matches it will call the loginsucces method
    // if it doesn't match it will call the loginFailed method
    // Limitations: Can't change the password 
    public void actionPerformed(ActionEvent e)
    {
	   Component aComponent = (Component) e.getSource();
        if (aComponent instanceof JButton){
            String passWordEntered = new String(aPasswordField.getPassword());
            if (passWordEntered.compareTo(password) == MATCH)
            {
            loginSuccess();
            }
            else
            {
            loginFailed();
            }

        }
	    if (aComponent instanceof JPasswordField){
	       String passWordEntered = new String(aPasswordField.getPassword());
	       if (passWordEntered.compareTo(password) == MATCH)
	       {
		  loginSuccess();
	       }
	       else
	       {
		  loginFailed();
	       }
	   }
    }
    // Features: Method for when either the failed attempts reach the max this method will be called this method will 
    // display a message on the title and after a short pause it will shut down the program
    public void exit(){
        setTitle("Max Attempts exceeded, exiting...");
	    try {
	       Thread.sleep(2500); 
	    }
	    catch (InterruptedException ex)  { 
	       System.out.println("Pausing of program was interrupted");
	    }
	    this.setVisible(false);
	    this.dispose();
	    System.exit(0);
    }
    // Features: Method for when the user enters the correct password this method will be called it will create an object of
    // MyFrame class and sets it size, visibility and close operation when this object is created it will create the main shopping window
    // this method also closes the login window when the main window is created
    public void loginSuccess(){
        MyFrame aFrame = new MyFrame();
        aFrame.setSize(500,500);
        aFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    // Features: Method for when the user enters the incorrect password this method will be called it will add one attempt to current failed attempts
    // Also it will set the title to number of remaining attempts and current failed attempts
    // If the failed attempts reach the max it will shut down the program by calling exit method after a short pause
    // Limitations: can't shutdown the program by itself
    public void loginFailed(){
        fails++;
        setTitle("No. Incorrect Attempts (Max = 3): " + fails);
        if (fails == ATTEMPTS){
            try {
                Thread.sleep(1100); 
            }
            catch (InterruptedException ex)  { 
                System.out.println("Pausing of program was interrupted");
            }
            exit();
        }
    }
    // Features: Method for getting correct password from Reader class by creating an object of that class and calling the read method
    // then it will reverse the Caeser's cipher by shifting each character in the word forward in the alphabet using the alphabet array
    // Limitations: can't change or encrypt the password
    public String password(){
        String temp = null;
        Reader pass = new Reader();
        temp = pass.read();
        char [] encrypted = temp.toCharArray();
        int i;
        int c;
        for (i = 0; i<encrypted.length; i++){
            for (c = 0; c<alphabet.length; c++){
                if (alphabet[c] == encrypted[i]){
                    if (c == alphabet.length - 1){
                        encrypted[i] = alphabet[0];
                        break;
                    }
                    else{
                        encrypted[i] = alphabet[c + 1];
                        break;
                    }
                }
            }
        }
        String decrypted = new String(encrypted);
        return(decrypted);
    }
}
