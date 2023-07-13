import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HTTPConnectionExample {
    public static ArrayList<String> HTTPRESPONSE = new ArrayList<>();

    public static void makeHttpRequest(String url) {
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            HTTPRESPONSE.add(response.toString());
            System.out.println("Response: " + response.toString());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionLayer.TreeNode node = new SessionLayer.TreeNode(5);
        makeHttpRequest("http://www.google.com");
    }
}


