/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author potenza_stefano
 */
public class gestioneFile {
    public gestioneFile() {

    }

    public void appendLocations(String path, List<Users> users) throws FileNotFoundException, IOException {
        System.out.println("APPENDS");
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        for (int i = 0; i < users.size(); i++) {
            str += users.get(i).createCSV() + "\n";
        }
        if (!str.equals("")) {
            bw.append(str);
            bw.close();
        }
    }

    public void appendLocation(String path, Users user) throws FileNotFoundException, IOException {
        System.out.println("APPEND");
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        str += user.createCSV() + "\n";
        if (!str.equals("")) {
            bw.append(str);
            bw.close();
        }
    }

    public void saveLocations(String path, List<Users> users) throws FileNotFoundException, IOException {
        System.out.println("WRITES");
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        for (int i = 0; i < users.size(); i++) {
            str += users.get(i).createCSV() + "\n";
        }
        if (!str.equals("")) {
            bw.append(str);
            bw.close();
        }
    }

    public void saveLocation(String path, Users user) throws FileNotFoundException, IOException {
        System.out.println("WRITE");
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        str += user.createCSV() + "\n";
        if (!str.equals("")) {
            bw.append(str);
            bw.close();
        }
    }

    public List<Users> loadLocations(String path) throws FileNotFoundException, IOException {
        List<Users> users = new ArrayList<Users>();
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        for (String line = ""; (line = br.readLine()) != null;) {
            Users u = Users.readCSV(line);
            users.add(u);
        }
        br.close();
        return users;
    }

    public void saveFileFromURL(String url, String path) throws MalformedURLException, IOException {
        URL u = new URL(url);
        InputStreamReader in = new InputStreamReader(u.openStream());
        BufferedReader br = new BufferedReader(in);
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String line = ""; (line = br.readLine()) != null;) {
            line += "\n";
            bw.write(line);
        }
        bw.close();
        br.close();

    }
}
