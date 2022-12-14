/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS170-01 
Lab #: Lab Assignment Four
Submission Date: 10pm, Tue(11/22)
Description:  This Course class contains all the info of a student, including their name,
course title, crouse's credit, their final letter grade
*********************************************************************************************/ 
public class Course implements Cloneable
{
	private String name, course_title, final_grade; //initialize some variables to store data
	private int credit;
	
	public Course() //initialize default values to the object
	{
		name = "No Name"; 
		course_title = "None";
		final_grade = "None";
		credit = 0;
	}
	
	public void setName(String name) //it is used to set the student name
	{
		this.name = name;
	}
	
	public void set_title(String course_title) //it is used to set the course title
	{
		this.course_title = course_title;
	}
	
	public void set_final_grade(String final_grade) //it is used to set the final grade
	{
		this.final_grade = final_grade;
	}
	
	public void setcredit(int credit) //it is used to set the credit
	{
		this.credit = credit;
	}
	
	public String getName() //it will return name of the object
	{
		return name;
	}
	
	public String get_course_title()  //it will return the course title of the object
	{
		return course_title;
	}
	
	public String get_final_grade() //it will return the final grade of the object
	{
		return final_grade;
	}
	
	public int get_credit() //it will return the credit of the object
	{
		return credit;
	}
	
}