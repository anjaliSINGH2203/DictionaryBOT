package com.mycompany.botford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class DictionaryAPI {

    private static final String APP_ID = "d2a05aff"; // Replace with your app id
    private static final String APP_KEY = "1cc9b294ea1da90713e52304263d561e"; // Replace with your API key
    private static final String BASE_URL = "https://od-api-sandbox.oxforddictionaries.com/api/v2/entries";

    public static String getDefinition(String word) {
        String urlString = "https://api.dictionaryapi.dev/api/v2/entries/en/"  + word.toLowerCase();
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
           // conn.setRequestProperty("app_id", APP_ID);
           // conn.setRequestProperty("app_key", APP_KEY);
            conn.setRequestProperty("Accept", "application/json");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            // Process response
            String res ="{results:" + response.toString()+"}";
            JSONObject jsonResponse = new JSONObject(res);
            if (jsonResponse.has("results")) {
                JSONObject firstResult = jsonResponse.getJSONArray("results").getJSONObject(0);
                JSONObject lexicalEntries = firstResult.getJSONArray("meanings").getJSONObject(0);
                JSONObject entries = lexicalEntries.getJSONArray("definitions").getJSONObject(0);
                String meaning= (String) entries.get("definition");
                
                return meaning;
                //JSONObject senses = entries.getJSONArray("definition").getJSONObject(0);
                //return senses.getJSONArray("definitions").getString(0); // Adjust according to the actual API response format
            } else {
                return "No definition found.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving definition.";
        }
    }
}
