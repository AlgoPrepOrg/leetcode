package io.algopreorg.alog;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static void sendMessage(String urlToSend, String requestMethod,
                     String requestPropertyKey, String requestPropertyValue,
                     String parameters) throws IOException {
        HttpURLConnection connection = null;
        try  {
            var url = new URL(urlToSend);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setDoOutput(true);
            connection.setRequestProperty(requestPropertyKey, requestPropertyValue);

            try (var outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(parameters);
                outputStream.flush();
            }

            handleResponseCode(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static void handleResponseCode(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Message sent successfully. Response: " + extractedResponse(connection));
            return;
        }

        System.out.println("Failed to send message. Response code: " + responseCode);
    }

    private static String extractedResponse(HttpURLConnection connection) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            return reader.lines()
                    .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                    .toString();
        }
    }
}
