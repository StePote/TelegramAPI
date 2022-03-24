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
import java.net.URLEncoder;
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
    
    public List<Messaggio> getUpdate(int last_update_id) throws IOException {
        List<Messaggio> results = null;
        
        String jsonString = JsonFromUrl("https://api.telegram.org/bot5296856967:AAH16g7Ivs-xM57AAFhXu9_uPolgOP7_pbU/getUpdates");
        JSONObject obj = new JSONObject(jsonString);
        boolean ok = obj.getBoolean("ok");
        if (ok) {
            results = new ArrayList<Messaggio>();
            JSONArray arr = obj.getJSONArray("result");
            for (int i = 0; i < arr.length(); i++) {
                Messaggio m = new Messaggio();
                int update_id = arr.getJSONObject(i).getInt("update_id");
                JSONObject message = arr.getJSONObject(i).getJSONObject("message");
                int message_id = message.getInt("message_id");
                JSONObject from = message.getJSONObject("from");
                utente p_from = utente.JSONObject(from);
                JSONObject ch = message.getJSONObject("chat");
                chat p_chat = chat.elaborateJSONObject(ch);
                int date = message.getInt("date");
                String text = message.getString("text");
                m.chat = p_chat;
                m.u = p_from;
                m.update_id = update_id;
                m.message_id = message_id;
                m.date = date;
                m.text = text;
                results.add(m);
            }
        }
        return results;
    }
    public boolean sendMessage(int chat_id, String text) throws IOException {
        String encode_txt = URLEncoder.encode(text, "UTF-8");
        String String = JsonFromUrl("https://api.telegram.org/bot5296856967:AAH16g7Ivs-xM57AAFhXu9_uPolgOP7_pbU/sendMessage?chat_id=" + chat_id + "&text=" + encode_txt);
        if (!String.equals("")) {
            JSONObject obj = new JSONObject(String);
            boolean ok = obj.getBoolean("ok");
            if (ok) {
                return true;
            }
        }
        return false;
    }

    public boolean sendLocation(int chat_id, double[] coord) throws IOException {
      
        String jsonString = JsonFromUrl("https://api.telegram.org/bot5296856967:AAH16g7Ivs-xM57AAFhXu9_uPolgOP7_pbU/sendLocation?chat_id=" + chat_id + "&latitude=" + coord[0] +"&longitude="+coord[1]);
        if (!jsonString.equals("")) {
            JSONObject obj = new JSONObject(jsonString);
            boolean ok = obj.getBoolean("ok");
            if (ok) {
                return true;
            }
        }
        return false;
    }
}
