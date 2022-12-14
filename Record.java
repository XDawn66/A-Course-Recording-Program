/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS170-01 
Lab #: Lab Assignment Four
Submission Date: 10pm, Tue(11/22)
Description: This Record class has an arraylist called database to store multiple Course objects,
and it has functions to add and delete Course objects. Further, it has functions to search
Course objects base on the given student name, and it can sort Course objects in the database 
by alphabetic orders. Lastly, it can display all info from the database by using the display
function. 
*********************************************************************************************/ 
import java.util.*;

public class Record
{
	private ArrayList<Course> database = new ArrayList();
	
	public void add() // this function is used to adding a new course to the database
	{
		String name, course, grade; //some variables to store data
		int credit;
		Validator check = new Validator(); //creating a Validator object
		Scanner input = new Scanner(System.in); //creating a Scanner
		System.out.println("Please enter the student name:");
		name = input.next(); //recording the user input as the student name
		System.out.println("Please enter the course title :");
		course = input.next(); //recording the user input as the course name
		System.out.println("Please enter the credit:");
		credit = check.check_credit(input); //recording the user input as the credit, and check the input with the validator
		System.out.println("Please enter the final grade:");
		grade = check.check_grade(input); //recording the user input as the course grade, and check the input with the validator
		Course student = new Course(); //creating a new course object
		student.setName(name); //assign data to the object
		student.set_title(course);
		student.setcredit(credit);
		student.set_final_grade(grade);
		database.add(student);
		System.out.println("Added a new course to the database\n");
	}
	
	public void delete()
	{
		Scanner input = new Scanner(System.in); 
		int counter = 0; //number of a record of the student
		boolean remove = false; //setting a boolean to detect the removal is success or not
		boolean done = false;
		String name;
		
		System.out.println("Please enter the student name:");
		name = input.next(); //gathering data from the user
		
		for(int i = 0; i < database.size(); i++) //going through the whole database
		{
			//if the name and the course title are mathching in the database
			if(database.get(i).getName().equals(name))
			{
				counter++; //to see how many records
			}
		}
		
		
		while(!done)
		{
			for(int i = 0; i < database.size(); i++) //going through the whole database
			{
				//if the name and the course title are mathching in the database
				if(database.get(i).getName().equals(name))
				{
					counter--;
					database.remove(i); //remove the current object
					remove = true; 
				}
				if(counter <= 0)
				{
					done = true; //when all records are deleted
				}
			}
		}
		
		if(remove)
		{
			System.out.println("Removed succssful!");
		}
		else
		{
			System.out.println("Removed unsuccssful due to unmatched data");
		}
	}
	
	public void sort() //this program is to sort the whole arraylist
	{
		Course temp = new Course(); //creating a temporary object to store data

		for(int i = 0; i < database.size(); i++) //using a bubble sort to do the sorting.
		{
			for(int j = i+1; j <database.size(); j++)
			{
				if(database.get(i).getName().compareTo(database.get(j).getName())>0)
				{
					temp.setName(database.get(i).getName()); //copying the data from front object to the temp object
					temp.set_title(database.get(i).get_course_title());
					temp.setcredit(database.get(i).get_credit());
					temp.set_final_grade(database.get(i).get_final_grade());
					
					database.get(i).setName(database.get(j).getName()); //applying the data from the back to the front the object
					database.get(i).set_title(database.get(j).get_course_title());
					database.get(i).setcredit(database.get(j).get_credit());
					database.get(i).set_final_grade(database.get(j).get_final_grade());
					
					database.get(j).setName(temp.getName());//applying the data from the temp to the back object
					database.get(j).set_title(temp.get_course_title());
					database.get(j).setcredit(temp.get_credit());
					database.get(j).set_final_grade(temp.get_final_grade());
				}
			}
		}
	}
	
	public void search(String student_name) //this function is used to find objects from the database with the given name
	{
		String name, title, grade; //some variables to store data
		boolean found = false; //a boolean to determine the student is found or not.
		int credit;
		for(int i = 0; i < database.size(); i++) //going through the whole databases
		{
			if(database.get(i).getName().equals(student_name)) //if the object has the desired name
			{
				found = true;
				name = database.get(i).getName();
				title = database.get(i).get_course_title();
				credit = database.get(i).get_credit();
				grade = database.get(i).get_final_grade();
				System.out.println("Name: "+name+" Course title: "+title+" credit: "+credit+" Grade: "+ grade+"\n");
				//print out all the info from that object
			}
		}
		if(!found)
		{
			System.out.println("Student is not found in the database\n");
		}
	}
	
	
	public void display() //this function is used to display all info in the database
	{
		String name, title, grade;
		int credit;
		for(int i = 0; i < database.size(); i++) //going through the whole database
		{
			name = database.get(i).getName();
			title = database.get(i).get_course_title();
			credit = database.get(i).get_credit();
			grade = database.get(i).get_final_grade(); //to_string
			System.out.println("Name: "+name+" Course title: "+title+" credit: "+credit+" Grade: "+ grade+"\n");
		}
	}
}