/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;
import java.io.IOException;
import telegramapi.*;

/**
 *
 * @author potenza_stefano
 */
public class BotTelegram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        condivisa c = condivisa.getInstance();
        c.users = c.gf.loadLocations(condivisa.PATH);
        gestioneMessaggio gm = new gestioneMessaggio();
        gm.start();
        update up = new update();
        up.start();

    }
    
}
