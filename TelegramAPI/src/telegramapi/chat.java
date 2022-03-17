/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramapi;

import org.json.JSONObject;

/**
 *
 * @author Stefano Potenza
 */
public class chat {
    int id;
    String name;
    String username;
    String type;

    public chat() {
        this.id = 0;
        this.name = "";
        this.username = "";
        this.type = "";
    }

    public chat(int id, String first_name, String username, String type) {
        this.id = id;
        this.name = first_name;
        this.username = username;
        this.type = type;
    }
    
    static public chat elaborateJSONObject(JSONObject object)
    {
        chat chat = new chat();
        chat.id = object.getInt("id");
        chat.name = object.getString("first_name");
        chat.username = object.getString("username");
        chat.type = object.getString("type");
        return chat;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }
}
