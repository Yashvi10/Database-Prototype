package parser;

/**
 * @author Yashvi Lad
 * This class is reponsible for checking the validity/ syntax of the SQL delete query
 *
 */
public class deletequeryValidity {

  public static boolean validateDelete (String query) {
    int whereIndex = query.indexOf("where");
    int fromIndex = query.indexOf("from");
    int attributeIndex = query.indexOf("*");
    if(fromIndex == -1) {
      return false;
    }
    if (attributeIndex != -1 && whereIndex != -1) {
      if(whereIndex+5==query.length()) {
        return false;
      }
      if(fromIndex+4==query.length()) {
        return false;
      }
      if (attributeIndex < fromIndex && attributeIndex < whereIndex) {
        return true;
      }
    }
    if (attributeIndex == -1 && whereIndex == -1) {
      return true;
    }
    if (attributeIndex != -1 && whereIndex == -1) {
      if (attributeIndex < fromIndex) {
        return true;
      }
    }
    if(attributeIndex == -1 && whereIndex != -1) {
      if (fromIndex < whereIndex) {
        return true;
      }
    }
    return false;
  }

}
