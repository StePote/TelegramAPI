package telegramapi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Dictionary;
import java.util.Iterator;
import org.json.*;
/**
 *
 * @author potenza_stefano
 */
public class test {
    public String hello(){
  
        
        JSONObject o = new JSONObject("{a:1,b:2,c:3}");
        s
        for (Iterator i = o.keys(); i.hasNext(); ) 
        {
            String key=(String)i.next();
            System.out.println(key);
            if(key=="message")
            {
                o.getJSONObject(key);
            }
            
        }
        return "";
    }
}
