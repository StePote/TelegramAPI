/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramapi;

/**
 *
 * @author Stefano Potenza
 */
public class Messaggio {
    utente u;
    chat chat;
    int message_id;
    String text;
    int date;
    int update_id;

    public Messaggio() {
        this.u = null;
        this.chat = null;
        this.message_id = 0;
        this.text = "";
        this.date = 0;
        this.update_id = 0;
    }

    public Messaggio(utente u, chat chat, int message_id, String text, int date, int update_id) {
        this.u = u;
        this.chat = chat;
        this.message_id = message_id;
        this.text = text;
        this.date = date;
        this.update_id = update_id;
    }
    
    public utente getUtente() {
        return u;
    }

    public chat getChat() {
        return chat;
    }

    public int getMessage_id() {
        return message_id;
    }

    public String getText() {
        return text;
    }

    public int getDate() {
        return date;
    }

    public int getUpdate_id() {
        return update_id;
    }
}
