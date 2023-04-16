package stats;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class League implements ILeague{
    @Override
    public StringBuffer getStats(String league_name) throws Exception {
        String url = "http://localhost:8003/api/stats-league/" + league_name;

        // Send an HTTP GET request to the API endpoint
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");

        // Read the response from the API endpoint
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer responseBuffer = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            responseBuffer.append(inputLine);
        }
        in.close();
        return responseBuffer;
    }
}
