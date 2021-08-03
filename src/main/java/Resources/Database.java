package Resources;

/**
 * @author Deeksha Sareen
 *
 */
public class Database {

	private static String databaseName;

	private Database() {
	}

	private static Database database;

	public static void setDatabase(String databasename) {
		if (database == null) {
			database = new Database();
			database.setDatabaseName(databasename);
		}
	}

	public static Database instance() {
		return database;
	}

	public void setDatabaseName(String databasename) {
		this.databaseName = databasename;
	}

	public static String getDatabase() {
		return databaseName;
	}
}
