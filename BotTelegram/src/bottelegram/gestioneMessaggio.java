/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import java.io.IOException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramapi.Messaggio;
/**
 *
 * @author Stefano Potenza
 */
public class gestioneMessaggio extends Thread{
    condivisa c;

    public gestioneMessaggio() {
        c = condivisa.getInstance();
    }

    @Override
        public void run() {
        while (true) {
            c = condivisa.getInstance();
            if (c.results.size() > 0) {
                Messaggio m = c.results.get(0);
                String text = m.getText();
                String operation = text.strip();
                operation = operation.split(" ")[0];
                switch (operation) {
                    case "/help": {
                        try {
                            String comandi = "/help -> elenco dei comandi\n"+ "/città + spazio + nomecittà -> per inserire la città di residenza\n";
                            c.telegramLib.sendMessage(m.getChat().getId(), "---ELENCO COMANDI---");
                            c.telegramLib.sendMessage(m.getChat().getId(), comandi);
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(gestioneMessaggio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case "/città": {
                        try {
                            String citta = text.substring(7).strip();
                            OpenStreetMaps maps = new OpenStreetMaps();
                            double[] coord = maps.getPosition(citta);
                            if (coord != null) {
                                c.telegramLib.sendMessage(m.getChat().getId(), citta);
                                c.telegramLib.sendLocation(m.getChat().getId(), coord);
                                Users user = new Users(citta, m.getChat().getId(), coord[0], coord[1]);
                                if (!c.checkDouplicate(user)) {
                                    c.gf.appendLocation(condivisa.PATH, user);
                                } else {
                                    c.gf.saveLocations(condivisa.PATH, c.users);
                                }

                            }
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(gestioneMessaggio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    default: {
                        try {
                            c.telegramLib.sendMessage(m.getChat().getId(), "Comando non riconosciuto");
                        } catch (IOException ex) {
                            Logger.getLogger(gestioneMessaggio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
                c.results.remove(0);
            }
        }
        }
}
