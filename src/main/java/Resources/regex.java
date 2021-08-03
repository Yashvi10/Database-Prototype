package Resources;
/**
 * @author Deeksha Sareen
 *
 */
public class regex {
	
	private regex() {
	}

    public static final String SELECT = "^select\s(\\*|((([a-z]+)([,]*))+))\sfrom\s(?!_)\\w*(\s(where)\s[a-z0-9]*=[a-z0-9]*)?;$";
    public static final String CREATE = "";
	public static final String DELETE = "";
	public static final String UPDATE = "";
	public static final String DATABASE = "^use\s+[^;]*;$";
		
		
	
}
