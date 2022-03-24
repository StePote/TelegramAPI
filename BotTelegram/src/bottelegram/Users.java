/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

/**
 *
 * @author potenza_stefano
 */
public class Users {
    String citta;
    int id_chat;
    double lat;
    double lon;

    public Users(String citta, int id_chat, double lat, double lon) {
        this.citta = citta;
        this.id_chat = id_chat;
        this.lat = lat;
        this.lon = lon;
    }

    public Users() {
    }

    public String createCSV() {
        String temp = id_chat + ";" + citta + ";" + lat + ";" + lon + ";";
        return temp;
    }

    public static Users readCSV(String csv) {
        String[] vett = csv.split(";");
        Users u = new Users();
        u.id_chat = Integer.parseInt(vett[0]);
        u.citta = vett[1];
        u.lat = Double.parseDouble(vett[2]);
        u.lat = Double.parseDouble(vett[3]);
        return u;
    }
}
