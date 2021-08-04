package user;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Deeksha Sareen: This class creates an instance of the prompt. prompt
 *         recurs until the user enters exit.
 *
 */
public class Common {

	private Common() {
	}

	private static Common common;

	public static Common getInstance() {
		if (common == null)
			common = new Common();
		return common;
	}

	public void takeinput() throws IOException {

		System.out.println("Enter query :~");
		Scanner scanner = new Scanner(System.in);
		String query = scanner.nextLine();
		application obj = new application();
		obj.Application(query);
		takeinput();
	}
}
