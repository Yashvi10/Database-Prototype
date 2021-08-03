package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Deeksha Sareen
 *
 */
public class Common {

	private Common() {}
	
	private static Common common;
	
	public static Common getInstance() {
		if(common == null)
			common = new Common();
		return common;
	}
	
	public void takeinput() throws IOException {
		
		    System.out.println("Enter query ~");
		    Scanner scanner = new Scanner(System.in);
		    String query = scanner.nextLine();
		    application obj = new application();
		    obj.Application(query);
		    takeinput();
	}
}
