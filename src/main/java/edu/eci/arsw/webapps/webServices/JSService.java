package edu.eci.arsw.webapps.webServices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSService implements RestService {

    @Override
    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-Type: application/javascript \r\n" +
                "\r\n";
    }

    @Override
    public String getResponse() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/index.js"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}
