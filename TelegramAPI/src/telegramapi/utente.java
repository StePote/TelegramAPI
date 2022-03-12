/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramapi;

import org.json.JSONObject;

/**
 *
 * @author potenza_stefano
 */
public class utente {
    int idUtente;
    boolean input_bot;
    String nome;
    String username;
    String language_code;
    
    public utente() {
        this.idUtente = 0;
        this.input_bot = false;
        this.nome = "";
        this.username = "";
        this.language_code = "";
    }

    public utente(int id, boolean is_bot, String first_name, String username, String language_code) {
        this.idUtente = id;
        this.input_bot = is_bot;
        this.nome = first_name;
        this.username = username;
        this.language_code = language_code;
    }

    static public utente JSONObject(JSONObject object) {
        utente u = new utente();
        u.idUtente = object.getInt("id");
        u.input_bot = object.getBoolean("is_bot");
        u.nome = object.getString("first_name");
        u.username = object.getString("username");
        u.language_code = object.getString("language_code");
        return u;
    }
}
