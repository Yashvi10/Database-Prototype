package user;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Deeksha Sareen
 *
 */
public class Main {

    
	public static void main(String[] args) throws IOException, SQLException {

		ApplicationOutput applicationOutput = ApplicationOutput.getInstance();
		applicationOutput.displayOutput();

	}
}
