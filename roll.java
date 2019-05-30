import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class roll{
	public static void main(String[] args){
	int intRoll = (int)(Math.random()*4+1);
	System.out.println(intRoll);
	 if(intRoll == 1){
		 System.out.println("Player 1 goes first!");
	 }else if(intRoll == 2){
		 System.out.println("Player 2 goes first!");
	 }else if(intRoll == 3){
		 System.out.println("Player 3 goes first!");
	 }else if(intRoll == 4){
		 System.out.println("Player 4 goes first!");
	 }
	 
	}
}
