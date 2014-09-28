package cn.freeteam.util;

import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



public class JsonUtil {
	private static  ObjectMapper objectMapper;
	  private static  JsonGenerator jsonGenerator = null;

	static{
		init();
	}
	public  static  void init() {
		   objectMapper = new ObjectMapper();

	        try {

	            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);

	        } catch (IOException e) {

	            e.printStackTrace();

	        }
	}
	
	public static String objectToJson(Object obj) throws IOException{
		try {
		
		
			return objectMapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException(e);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException(e);
		}
	}

}
