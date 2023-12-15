package demoPackResponse;

import java.util.Map;

import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class demoClassResponse implements RequestHandler<Map<String,String>, String> {

    @Override
    public String handleRequest(Map<String,String> input, Context context) {
    	
    	LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + input.getClass().toString());
        
        String data= input != null ? input.toString() : "{}";
        context.getLogger().log("EVENT DATA: " + data);
                       
        String name = input.get("name");
        String id = input.get("id");
        String responseBody = "Thanks " + name;
        
        int coderesponse = 200;
               
        JSONObject jsonResponse = new JSONObject();
        
        jsonResponse.put("HTTP_STATUS", coderesponse);
        jsonResponse.put("body", responseBody);
        jsonResponse.put("id", id);
                        
        context.getLogger().log("EVENT RESPONSE: " + jsonResponse.toString());
        return jsonResponse.toString();
    }
}