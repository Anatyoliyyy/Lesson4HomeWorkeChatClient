package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetUser implements Runnable {
    private String login;
    private String pass;
    private String status;

    public GetUser(String login, String pass, String status) {
        this.login = login;
        this.pass = pass;
        this.status = status;
    }

    @Override
    public void run() {
        try {
            URL url = new URL("http://127.0.0.1:8080/user?name=" + login + "&pass=" + pass + "&status=" + status);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream is = http.getInputStream();

            try {
                byte[] buf = requestBodyToArray(is);
                String response = new String(buf, StandardCharsets.UTF_8);
                System.out.println(response);
                if(response.equals("Password incorrect") || response.equals("Bad request")) {
                    Service.setConnect(false);
                }
            } finally {
                is.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private byte[] requestBodyToArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
}
