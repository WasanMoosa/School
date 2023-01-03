
package School.Management;

import java.awt.dnd.InvalidDnDOperationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.tree.AbstractLayoutCache;

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
		HashMap<String, String[]> allStudent = new HashMap();
		Scanner sc = new Scanner(System.in);
		// Loading the file

		File myFile = new File("student.json");
		if (myFile.exists()) {
			Gson gson = new GsonBuilder().create();
			HashMap<String, String[]> temp = new HashMap();

			Scanner sfile;
			try {
				sfile = new Scanner(myFile);
				while (sfile.hasNextLine()) {
					String st;
					st = sfile.nextLine();
					Type type = new TypeToken<HashMap<String, String[]>>() {
					}.getType();
					temp = gson.fromJson(st, type);
					allStudent.putAll(temp);
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		} else {
			try {
				myFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Showing the menu
		menu();

		// choosing the action
		int action = Integer.parseInt(sc.nextLine());
		System.out.println("\n");
		// Registeration method
		if (action == 1) {
			registration();
		}

		if (action == 2) {
			String idSearch;
			System.out.println("Enter the id of the student to search for it");
			idSearch = sc.nextLine();
			Searching(idSearch, allStudent);
		}

		// Manage student
		if (action == 3) {
			System.out.println("Choose the action");
			System.out.println("1) Delete Student");
			System.out.println("2) Update Student");
			int manageAction = Integer.parseInt(sc.nextLine());

			if (manageAction == 1) {
				// Deleting
				boolean continueDelet = true;
				while (continueDelet) {
					System.out.println("Enter the id of the student to delet it");
					String idDelet = sc.nextLine();
					delete(idDelet, allStudent);
					System.out.println("Do you want to delet more?");
					System.out.println("Delet next student (press 1)");
					System.out.println("Finish (press 0) ");

					if (Integer.parseInt(sc.nextLine()) == 1) {
						continueDelet = true;
					} else {
						continueDelet = false;

					}

				}
			}
			if (manageAction == 2) {
				System.out.println("Enter the id of the student to update it");
				String idUpdate = sc.nextLine();
				update(idUpdate, allStudent);
			}
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

	public static void ReloadFile(HashMap<String, String[]> studentRegistered) {
		File myFile = new File("student.json");

		try (FileWriter writer = new FileWriter(myFile)) {
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
				System.out.println("The total number of students you have enrolled is " + (numOfStudent + 1));

			}

		}
		putInFile(studentRegistered);
	}

	public static void Searching(String id, HashMap<String, String[]> allStudent) {

		if (allStudent.containsKey(id)) {
			System.out.print(id + " ");
			for (int i = 0; i < allStudent.get(id).length; i++)
				System.out.print(allStudent.get(id)[i] + " ");
		}
	}

	public static void delete(String id, HashMap<String, String[]> allStudent) {

		if (allStudent.containsKey(id)) {
			System.out.print(id + " ");
			for (int i = 0; i < allStudent.get(id).length; i++) {
				System.out.print(allStudent.get(id)[i] + " ");
			}
			allStudent.remove(id);
			System.out.println(" Has been successfully deleted ");
			ReloadFile(allStudent);

		}
	}

	public static void update(String id, HashMap<String, String[]> allStudent) {
		Scanner sc = new Scanner(System.in);
		String[] information = new String[2];

		if (allStudent.containsKey(id)) {
			System.out.print(id + " ");
			for (int i = 0; i < allStudent.get(id).length; i++) {
				System.out.print(allStudent.get(id)[i] + " ");
			}
			System.out.println(" is ready to update");

			information = allStudent.get(id);
			System.out.println("What do you want to update ");
			System.out.println("1) name ");
			System.out.println("2) address ");
			int choose = Integer.parseInt(sc.nextLine());

			if (choose == 1) {
				System.out.println("Write the name of student " + id);
				information[0] = sc.nextLine();
			}
			if (choose == 2) {
				System.out.println("Write the address " + id);
				information[1] = sc.nextLine();
			}
			allStudent.put(id, information);
			ReloadFile(allStudent);
			System.out.print(id + " Has been successfully updated ");

		}
	}
}
