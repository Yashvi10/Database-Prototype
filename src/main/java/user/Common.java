/**
 * 
 */
package user;

import java.util.Scanner;

/**
 * @author Deeksha Sareen
 *
 */
public class Common {

	public String[] takeinput() {
		
		    System.out.println("Please Enter the query for parsing:");
		    Scanner scanner = new Scanner(System.in);
		    String query = scanner.nextLine();
		    String[] queryToken = query.toLowerCase().split(" ");
		    return queryToken;
	}
}
