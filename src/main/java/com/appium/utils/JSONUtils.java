/**
 * JsonDataReader is class responsible for reading JSON file.
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONUtils {

	public JSONObject getJSONObject(String jsonFileName) {
		JSONObject jsonObject;
		InputStream datais = null;
		try {
			datais = getClass().getClassLoader().getResourceAsStream(jsonFileName); //Read JSON file
			JSONTokener tokener = new JSONTokener(datais);
			jsonObject = new JSONObject(tokener); //JSON parser object to parse read file
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (datais != null) {
				try {
					datais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObject;   // return JSON Object array
	}
/*	public static JSONObject getJSONData(String JSON_path) throws IOException, ParseException {
		JSONParser parser = new JSONParser();                                    //JSON parser object to parse read file
		Object obj = parser.parse(new FileReader(JSON_path));                   //Read JSON file
		return (JSONObject) obj;                                               // return JSON Object array
	}*/
}
