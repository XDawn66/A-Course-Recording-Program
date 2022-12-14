/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS170-01 
Lab #: Lab Assignment Four
Submission Date: 10pm, Tue(11/22)
Description:  This is a driver class that calls function from Record class and act like an app.
First, it will ask user to do the initialization, and the user can stop by inputting n. Then, 
it will display the menu and perform different tasks by calling functions from the Record class
base on the user inputs. The program will keep looping until the user select quit.
*********************************************************************************************/ 
import java.util.Scanner;

public class CourseRecordingApp
{
	
	public static void main(String[] args)
	{
		boolean run = true; //keep looping until the user quit the program
		boolean init = true; //keep looping until the initilization is done
		String user_input;
		System.out.println("Weclome to the CourseRecording App");
		System.out.println("Initilizatng...");
		Scanner input = new Scanner(System.in); //a scanner for gathering input
		Record myRecord = new Record();
		
		while(run) 
		{
			while(init)//while the initilization
			{
				System.out.print("Creating a new Course... Press enter to continue or enter n to stop.");
				user_input = input.nextLine(); //getting whatever the user puts in the next line
				if(user_input.equals("n") ||user_input.equals("N")) //if the user didn't input n
				{
					System.out.println("Finish initilization.\n");
					init = false; //false when the user enters n					
				}
				else
				{	
					myRecord.add(); //keep calling the adding methods to add more courses
				}
			}
			System.out.println("App functions:"); //the app menu
			System.out.println("1. ADD RECORD");
			System.out.println("2. DELETE RECORD");
			System.out.println("3. SEARCH");
			System.out.println("4. SORT RECORDS");
			System.out.println("5. DISPLAY ALL RECORDS");
			System.out.println("6. QUIT\n");
			
			
			user_input = input.next();
			if(user_input.equals("1")) //if the user input these number
			{
				myRecord.add(); //calling  the add course function from the Record class 
			}
			else if(user_input.equals("2"))
			{
				myRecord.delete();  //calling the delete course function from the Record class 
			}
			else if(user_input.equals("3"))
			{
				System.out.println("Please enter the name that you want to search");
				user_input = input.next();
				myRecord.search(user_input);  //calling the search course function from the Record class 
			}
			else if(user_input.equals("4"))
			{
				myRecord.sort();  //calling the sort course function from the Record class 
				System.out.println("Displaying sorted result:");
				myRecord.display();  //calling the display function from the Record class 
			}
			else if(user_input.equals("5"))
			{
				myRecord.display(); //calling the display function from the Record class 
			}
			else if(user_input.equals("6")) //when the user choose to quit
			{
				System.out.println("Thank you for using!"); 
				run = false; //the loop condition false
			}
			else //if the user input other options
			{
				System.out.println("Please enter a vaild input\n");
			}
		}
	}
}