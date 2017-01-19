package excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils{
	
	Properties properties = new Properties();
	public static Map<String, String> ProjectProperties = new HashMap<String, String>();
	public PropertyUtils () {
		loadPropertyFile();
	}
	
	private void loadPropertyFile(){
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("Config.properties");
			properties.load(is);
			Enumeration enumeration = properties.propertyNames();
			for(;enumeration.hasMoreElements();) {
				String key = enumeration.nextElement().toString();
				ProjectProperties.put(key,properties.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public String getPropertyValue(String key)
	{
		return ProjectProperties.get(key);
	}
}
