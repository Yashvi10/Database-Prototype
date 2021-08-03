/**
 * 
 */
package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DeekshaSareen
 *
 */
public class syntaxValidation {

	public boolean validateQuerySyntax(String query, String queryRegex) {

		Pattern pattern = Pattern.compile(queryRegex, Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher(query);
		Boolean validity = match.find();
		return validity;
	}
}
