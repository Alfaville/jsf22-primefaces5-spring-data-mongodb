package utils;

import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class ResourceBundlesUtils {

	private static ResourceBundle bundle = null; 

	public static void setResouce( String resourceBundle ) {
		bundle = ResourceBundle.getBundle( resourceBundle );
	}
	
	private static ResourceBundle getResource(){
		if(bundle == null){
			bundle = ResourceBundle.getBundle( "" );
		}
		return bundle;
	}

	public static String getString(String key){
		try {
			return getResource().getString(key);
		} catch (Exception e) {
			System.err.print(e.getMessage()); 
		}
		return null;
	}

	public static String[] getStringArray(String key) {  
        String[] retorno = null;  
        try {  
            String array = getResource().getString(key);  
            StringTokenizer st = new StringTokenizer(array, ",");  
            int tokens = st.countTokens();  
            retorno = new String[tokens];  
  
            for (int i = 0; i < tokens; i++) {  
                retorno[i] = st.nextToken();  
            }  
              
        } catch (Exception e) {  
            System.err.print(e.getMessage());              
            retorno =  null;  
        }  
        return retorno;  
    }  
  
    public static int getInt(String key) {  
        try {  
            return new Integer(getResource().getString(key)).intValue();  
        } catch (Exception e) {  
            System.err.print(e.getMessage());              
        }  
        return 0;  
    }  
  
    public boolean getBoolean(String key) {  
        try {  
            return new Boolean(getResource().getString(key)).booleanValue();  
        } catch (Exception e) {  
            System.err.print(e.getMessage());              
        }  
        return false;  
    }  	
	
}
