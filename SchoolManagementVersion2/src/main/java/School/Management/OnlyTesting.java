
package School.Management;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Using json to save the registered student.
 * 
 */
public class OnlyTesting {

	public static void main(String[] args) {
		File myFile = new File("student.json");
		HashMap<String, String[]> studentRegistered = new HashMap<String, String[]>();
		HashMap<String, String[]> test = new HashMap<String, String[]>();
		HashMap<String, String[]> test2 = new HashMap<String, String[]>();
		studentRegistered.put("wasan", new String[] { "112455", "oman" });

		try (FileWriter writer = new FileWriter(myFile, true)) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(studentRegistered, writer);
			writer.write("\n");

			writer.close();

			//Reader reader = new FileReader("student.json");

			Scanner sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
				String st;
				st=sc.nextLine();
				Type type = new TypeToken<HashMap<String, String[]>>(){}.getType();
				test = gson.fromJson(st, type);
				test2.putAll(test);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
