/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS170-01 
Lab #: Lab Assignment Four
Submission Date: 10pm, Tue(11/22)
Description:  This is a Validtor class which has two functions to check 
the users input are valid or not. The class will throw exceptions if the user is not inputing
the correct data. Those functions will keep asking for inputs until the user is inputting
correct data 
*********************************************************************************************/ 
import java.util.Scanner;

public class Validator
{
	public int check_credit(Scanner sc) //this function is used to check the course credit
	{
		int credit = 0;
		String input = "";
		boolean valid = false;
		while(!valid)
		{
			try 
			{
				input = sc.next();
				credit = Integer.parseInt(input);
				if(credit < 0 || credit > 5) // if the credit is not in range
				{
					throw new Exception(); //throw an exception
				}
				valid = true;
			}
			catch (NumberFormatException e) //if the user input other than integer numbers
			{
				System.out.println("Please enter an integer number");
			}
			catch (Exception y) //if the number is not in range
			{
				System.out.println("Please a number in range(0-5) ");
			}
		}
		return credit; //return the valid credit number
	}
	
	public String check_grade(Scanner sc) //this function is used to check the course grade
	{ 
		String grade = "";
		boolean valid = false;
		String valid_grades[] = {"A", "B","C","D","F"}; // an array with all allowed grades
		while(!valid)
		{
			try 
			{
				grade = sc.next();
				for(int i = 0; i < 5; i++)
				{
					if(grade.equals(valid_grades[i])) // if the user input is matching any of the grades in the array
					{
						valid = true;
					}
				}
				if(!valid) //if the input is not matching
				{
					throw new Exception(); //throw an exception
				}
			}
			catch(Exception y) 
			{
				System.out.println("Please put a valid grade(A-D, or F)");
			}	
		}
		return grade; //return the valid letter grade
	}
}