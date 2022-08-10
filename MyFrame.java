/*
Author: Amirreza Pazira 
UCID: 30133500 
Tutorial: 08

Version: 13-April-2021

Program: GUI shopping program with login window and secure password decryption

Class specific features:

This class extends the JFrame class and implements ActionListener so that the user canuse the save or clear button
This class has two fields JTextArea and JTextField for the address and the name of the user
This class can create an object of Reader class and calling the write method in that class tho store the information on the order.txt file
This class has a save button when clicked it will change the window title and 
after a short pause it will call write method in Reader class to store the information in the order.txt file
This class has a clear button when clicked it will change the window title and 
after a short pause it will clear all the fields with text so that the user can easily enter the information again
This class can get the user's multiple times until the user closes the window then the program will shut down 


*/
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class MyFrame extends JFrame implements ActionListener{
    // Objects referencing different components needed on our window 
    private JButton save;
    private JButton clear;
    private JLabel name;
    private JLabel address;
    private JLabel logo;
    private GridBagLayout aLayout;
    private GridBagConstraints aConstraint;
    private ImageIcon anLogo;
    private ImageIcon saveIcon;
    private ImageIcon clearIcon;
    private JTextArea text;
    private JTextField nameText;
    private JScrollPane scrollPane;
    // Constructor for creating the shopping window setting the GridBagLayout for our layout design
    // It will create all the components needed then it will pass the size values for each component to other methods
    // It will also add ActionListener to our buttons so that user can click and interact with them
    public MyFrame(){
        int padding = 10;
        setTitle("Order Information");
        aConstraint = new GridBagConstraints();
        aConstraint.insets = new Insets(padding,0,0,0); 
        anLogo = new ImageIcon("logo.png");
        saveIcon = new ImageIcon("save.png");
        clearIcon = new ImageIcon("clear.png");
        logo = new JLabel(anLogo);
        text = new JTextArea(5,15);
        scrollPane = new JScrollPane(text); 
        nameText = new JTextField();
        nameText.setColumns(14);
        save = new JButton("Save",saveIcon);
        save.addActionListener(this);
        clear = new JButton("Clear",clearIcon);
        clear.addActionListener(this);
        name = new JLabel("Name");
        address = new JLabel("Address");
        aLayout = new GridBagLayout();
        setLayout(aLayout);     
        addWidgetLogo(logo, 0, 0, 0, 1);
        addWidgetInput(name, 0, 1, 1, 1);
        addWidgetInput(address, 3, 1, 1, 1);
        addWidgetInput(scrollPane,1, 2, 0, 1);
        addWidgetInput(nameText,0, 2, 1, 1);
        addWidgetButton(save, 0, 4, 1, 1);    
        addWidgetButton(clear, 3, 4, 1, 1);
    }
    // Features: method for getting the components that can take an Input and the size of them as parameter then it will set the GridBagConstraints to 
    // those values and at then end it will add the components to our window
    // Limitations: can't create new components or change the size of current ones
    public void addWidgetInput(Component widget, int x, int y, int w, int h){
        aConstraint.anchor = GridBagConstraints.NORTH;
        aConstraint.gridx = x;
        aConstraint.gridy = y;
        aConstraint.gridwidth = w;
        aConstraint.gridheight = h;
        aConstraint.weightx = 1;
        aConstraint.weighty = 0;
        aLayout.setConstraints (widget, aConstraint);
        add(widget);        
    }
    // Features: method for getting the logo component and the size of it as parameter then it will set the GridBagConstraints to 
    // those values and at then end it will add the component to our window
    // Limitations: can't create new components or change the size of current ones
    public void addWidgetLogo(Component widget, int x, int y, int w, int h){
        aConstraint.gridx = x;
        aConstraint.gridy = y;
        aConstraint.gridwidth = w;
        aConstraint.gridheight = h;
        aConstraint.weightx = 0;
        aConstraint.weighty = 1;
        aLayout.setConstraints (widget, aConstraint);
        add(widget);        
    }
    // Features: method for getting the Button components and the size of them as parameter then it will set the GridBagConstraints to 
    // those values and at then end it will add the components to our window
    // Limitations: can't create new components or change the size of current ones
    public void addWidgetButton(Component widget, int x, int y, int w, int h){
        aConstraint.anchor = GridBagConstraints.NORTH;
        aConstraint.gridx = x;
        aConstraint.gridy = y;
        aConstraint.gridwidth = w;
        aConstraint.gridheight = h;
        aConstraint.weightx = 1;
        aConstraint.weighty = 1;
        aLayout.setConstraints (widget, aConstraint);
        add(widget);        
    }
    // Features: Method for when either the user clicks on the save or clear button then if it's the save button action
    // it will create an object of Reader class and calls the write method to store the information in the order.txt file
    // also displays message on the title which goes back to normal after a short pause
    // or if it's the clear button action it will clear the fields after a shor pause and displays a message on title and after a short
    // pause goes back to normal title.
    // Limitations: Can't change the information
    public void actionPerformed(ActionEvent e){
        Component aComponent = (Component) e.getSource();
        if (aComponent == save){
            String [] order = new String[2];
            String nameInput = nameText.getText();
            order[0] = nameInput;
            String addressInput = text.getText();
            order[1] = addressInput;
            Reader anWriter = new Reader();
            anWriter.write(order);
            setTitle("Saving Information");
            try {
                Thread.sleep(1700); 
            }
            catch (InterruptedException ex)  { 
                System.out.println("Pausing of program was interrupted");
            }
            setTitle("Order Information");
        }
        if (aComponent == clear){
            setTitle("Clearing Information");
            try {
                Thread.sleep(1300); 
            }
            catch (InterruptedException ex)  { 
                System.out.println("Pausing of program was interrupted");
            }
            nameText.setText(null);
            text.setText(null);
            setTitle("Order Information");
        }
    }
}
