/**
 * @author Deeksha Sareen
 * This class is reponsible for parsing the SQL query
 */
package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectParser {

	public static String selectFields;
	public static String where = "";
	public static String tableName;
	public static void parsingAttributes(String query) {

		String[] columns = selectFields.split(",");
		List<Integer> lstAttributes = new ArrayList<>();
		if (!columns[0].equals("*")) {
			for (String col : columns) {
				System.out.println(col);
			}
		}
		if (where != "") {
			String[] whereClause = where.split("=");
			for (String x : whereClause) {
				System.out.println(x);
			}
//		} else {
//			if (lstAttributes.size() > 0) {
//				System.out.println(table.toString(lstAttributes));
//			} else {
//				System.out.println(table.toString());
//			}
//
//		}

	}
//
//	String Attributes = "";
//	String conditions = "";
//	String query = "";
//	Map<String, ArrayList<String>> mapping = new HashMap<String, ArrayList<String>>();if(splitQuery[0].compareToIgnoreCase("SELECT")==0)
//	{
//		queryValidity valid = new queryValidity();
//		if (valid.validateSelect(query) == true) {
//			for (int word = 1; word < splitQuery.length; word++) {
//				if (splitQuery[word].equalsIgnoreCase("FROM")) {
//					ArrayList<String> from = new ArrayList<>();
//					from.add(splitQuery[word + 1]);
//					mapping.put("From", from);
//
//					ArrayList<String> attr = new ArrayList<>();
//					String[] attributes = Attributes.split("\\s");
//					for (String a : attributes) {
//						attr.add(a);
//					}
//					mapping.put("Attributes", attr);
//					break;
//				} else {
//					Attributes = splitQuery[word] + " " + Attributes;
//				}
//			}
//			if (query.indexOf("where") != -1) {
//				String[] where = query.split("where");
//				String[] whereClause = where[1].trim().split(" ");
//				ArrayList<String> Clause = new ArrayList<>();
//				for (String b : whereClause) {
//					Clause.add(b);
//				}
//				mapping.put("Where", Clause);
//			}
//
//		} else if (valid.validateSelect(query) == false) {
//			System.out.println("Invalid syntax for select query. Please check the SQL user manual for query sytax");
//		}
//	}
//	identifier obj = new identifier();obj.identifyTableSelect(mapping);

}}
