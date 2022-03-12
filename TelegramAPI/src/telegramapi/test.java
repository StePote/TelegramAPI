package telegramapi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import org.json.*;
/**
 *
 * @author potenza_stefano
 */
public class test {
//    public String hello(String str){
//        JSONObject o = new JSONObject(str);
//        for (Iterator i = o.keys(); i.hasNext(); ) 
//        {
//            String key=(String)i.next();
//            System.out.println(key);
//            if(key=="message")
//            {
//                o.getJSONObject(key);
//            }
//            
//        }
//        return "";
//    }
    public static String leggi(Reader rd) throws IOException{
        String s="";
        int v;
        while((v = rd.read()) != -1){
            s+= (char) v;
        }
        return s;
    }
    
    public static String JsonFromUrl(String url) throws IOException, JSONException {
        InputStream input = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String jsonContent = leggi(rd);
            return jsonContent;
        } finally {
            input.close();
        }
    }
}
