
package School.Management;

import java.awt.dnd.InvalidDnDOperationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Using json to save the registered student.
 * 
 */
public class SchoolManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Showing the menu
		menu();

		// choosing the action
		int adm = Integer.parseInt(sc.nextLine());
		System.out.println("\n");
		// Registeration method
		if (adm == 1) {
			registration();
		}
		if (adm == 2) {
			String id;
			System.out.println("Do you want to search for student using");
			System.out.println("1) name");
			System.out.println("2) id");
			id = sc.nextLine();
			Searching(id);

		}

	}

	public static void menu() {
		System.out.print("This is a school management system");
		System.out.print("\n");
		System.out.println("Choose the action");
		System.out.println("1)Register student");
		System.out.println("2)Search student");
		System.out.println("3)Manage students");
		System.out.println("4)Hire teacher");
		System.out.println("5)Manage teacher");

	}

	public static void putInFile(HashMap<String, String[]> studentRegistered) {
		File myFile = new File("student.json");

		try (FileWriter writer = new FileWriter(myFile, true)) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(studentRegistered, writer);
			writer.write("\n");
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static void registration() {

		Scanner sc = new Scanner(System.in);
		int numOfStudent = 0;
		boolean ismore = true;
		HashMap<String, String[]> studentRegistered = new HashMap<String, String[]>();
		

		System.out.println("In student Registeration, Enter the details of student");

		while (ismore == true) {
			String studentID;
			String[] student = new String[2];
			System.out.println("Id of student :");
			studentID = sc.nextLine();
			// System.out.println(id.get(numOfStudent));
			System.out.println("name of student :");
			student[0] = sc.nextLine();
			// System.out.println(name.get(numOfStudent));
			System.out.println("Address of student :");
			student[1] = sc.nextLine();
			// System.out.println(address.get(numOfStudent));

			studentRegistered.put(studentID, student);

			System.out.println("Add next student (press 1)");
			System.out.println("Finish (press 0) ");

			if (Integer.parseInt(sc.nextLine()) == 1) {
				System.out.println("Enter the details of next student");
				ismore = true;
				numOfStudent++;
			} else {
				ismore = false;
				System.out.println("The total number of students you have enrolled is " + (numOfStudent + 1)
						+ "and they are shown below");

			}
		
		}
		putInFile(studentRegistered);
	}

	public static void Searching(String id) {
		File myFile = new File("student.json");
		Gson gson = new GsonBuilder().create();
		HashMap<String, String[]> allStudent = new HashMap();
		HashMap<String, String[]> temp = new HashMap();

		Scanner sc;
		try {
			sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
				String st;
				st = sc.nextLine();
				Type type = new TypeToken<HashMap<String, String[]>>() {
				}.getType();
				temp = gson.fromJson(st, type);
				allStudent.putAll(temp);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		if (allStudent.containsKey(id)) {
			System.out.print(id+" ");
			for (int i=0; i<allStudent.get(id).length; i++)
			System.out.print(allStudent.get(id)[i]+" ");
		}
	}
}
