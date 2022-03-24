/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import java.util.ArrayList;
import java.util.List;
import telegramapi.Messaggio;
import telegramapi.test;

/**
 *
 * @author potenza_stefano
 */
public class condivisa {
    List<Messaggio> results;
    test telegramLib;
    gestioneFile gf;
    private static condivisa instance;
    public static String PATH = "file.txt";
    List<Users> users;
    
    private condivisa() {
        results = new ArrayList<Messaggio>();
        users = new ArrayList<Users>();
        telegramLib = new test();
        gf = new gestioneFile();
    }

    public static condivisa getInstance() {
        if (instance == null) {
            synchronized (condivisa.class) {
                if (instance == null) {
                    instance = new condivisa();
                }
            }
        }
        return instance;
    }

    public boolean checkDouplicate(Users u) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id_chat == u.id_chat) {
                users.remove(i);
                users.add(u);
                return true;
            }
        }
        return false;
    }
}
