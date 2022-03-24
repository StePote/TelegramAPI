/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramapi.Messaggio;

/**
 *
 * @author Stefano Potenza
 */
public class update extends Thread{
    condivisa c;

    public update() {
        c = condivisa.getInstance();
    }

    public update(condivisa c) {
        this.c = c;
    }

    @Override
    public void run() {       
        int size = 0;
        int last_update_id=-1;
        while (true) {
            try {
                try {
                    c.results.addAll(c.telegramLib.getUpdate(last_update_id));                    
                    if (c.results.size() > 0) {                        
                        size = c.results.size();
                        Messaggio m;
                        m = c.results.get(c.results.size() - 1);
                        last_update_id = m.getUpdate_id() + 1;

                    }
                } catch (IOException ex) {
                    Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
