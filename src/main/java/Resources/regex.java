package Resources;
/**
 * @author Deeksha Sareen
 *
 */
public class regex {
	
	private regex() {
	}

    public static final String SELECT = "select\\s+(.*?)\\s*from\\s+(.*?)\\s*(where\\s(.*?)\\s*)?;";
    public static final String CREATE = "^create\stable\s(?!_)\\w*\\(((([a-z0-9]+)\s(int|varchar\\(\\d+\\))([,]*))+)(?<!,)\\);$";
	public static final String DELETE = "";
	public static final String UPDATE = "";
	public static final String DATABASE = "^use\s+[^;]*;$";
		
		
	
}
