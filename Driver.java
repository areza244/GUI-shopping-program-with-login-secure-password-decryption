/*
Author: Amirreza Pazira 
UCID: 30133500 
Tutorial: 08

Version: 13-April-2021

Program: GUI shopping program with login window and secure password decryption


Program Features: 

	General: Introduces a login window and shopping window - User can store his info to a .txt file - User needs to enter the correct password
	the correct was decrypted and read from .txt file - user has only 3 attempts to enter the correct password for security 
	User can enter password using login button and enter key on the keyboard - There's a pause for each action of the buttons in the program

	Login: After starting a Login window will pop up that asks for user's password the correct password will be read from a file 
	because the password is encrypted by Caeser cipher method the program will use that to reverse that and decrypt the password
	if the password entered by the user matches the correct password it will proceed to the shopping window if it's not after 3 attempts
	the program will shut down due to exceeding the incorrect password attempts -  There is a pause for the user to read the exit message before closing
	User can enter password using login button and enter key on the keyboard

	Shopping Window: After entering the correct password the login window will be closed and main window will open here you can enter your
	name and your address in the fields provided and hit enter to save them on a .txt file called "order" also you could hit the clear button
	to clear all the fields of text - There's a pause for each button action so that the user can read the appropriate message the
	message will be displayed on the window's title then it will go back to normal after some seconds - User can reenter the information  

Program Limitations: 

	The password needs to be read from a file and cannot be changed 
	The layout of the Shopping window is adaptive to resizing it will shrink the components when the window gets too small
	The program will overwrite previous information stored on order.txt file
	The program cannot store new passwords and encrypt them

Class specific features:

The driver of the program that starts the program first it will create a Dialog window for login and it will set the size and visibility
of the login window.

*/


import javax.swing.JDialog;

public class Driver
{
    public static void main(String [] args){
    	// Creating a new Dialog for login and setting the size and visibility
        MyDialog aDialog = new MyDialog();
        aDialog.setBounds(100,100,300,200);
        aDialog.setVisible(true);
    }
} 