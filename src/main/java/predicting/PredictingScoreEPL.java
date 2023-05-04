package predicting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class PredictingScoreEPL implements PredictingScore{
    @Override
    public StringBuffer predictScore(String teamA, String teamB) throws Exception {

        String url = "http://localhost:5000/api/predict-score/" + teamA + "/" + teamB;
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
