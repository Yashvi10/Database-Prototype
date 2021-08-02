package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationOutput {
		
		private ApplicationOutput() {}
		
		private static ApplicationOutput applicationOutput;
		
		SwitchCase cases = new SwitchCase();
		public static ApplicationOutput getInstance() {
			if(applicationOutput == null)
				applicationOutput = new ApplicationOutput();
			return applicationOutput;
		}
		
		void displayOutput() throws SQLException, IOException {
			loadMainScreenContent();
		    
		}
		
		private void loadMainScreenContent() throws IOException {

			List<String> selectionOptions = getSelectionOptions();
			
			System.out.println("================================================================");
			System.out.println("                          RDBMS                         ");
			System.out.println("================================================================");
			System.out.println();
			int sel = cases.printSelection(selectionOptions);
			if(sel == 1) {
				 login login = new login();
		         if(login.login()==true) {
		        	 application application = new application();
		        	 application.Application();
		         }
			}
			else if(sel == 2) {
				login login = new login();
	            login.register();
				loadMainScreenContent();
			}
			else if(sel == 3) {
				System.exit(0);
			}
			else {
				System.out.println("INVALID_SELECTION");
				loadMainScreenContent();
			}
		}
		
		private List<String> getSelectionOptions() {
			List<String> selectionOptions = new ArrayList<>();
			selectionOptions.add("Login");
			selectionOptions.add("Register");
			selectionOptions.add("Exit");
			return selectionOptions;
		}
	
}
