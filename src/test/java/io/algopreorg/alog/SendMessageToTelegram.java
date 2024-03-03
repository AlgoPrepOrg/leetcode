package io.algopreorg.alog;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

class SendMessageToTelegram {

    private static final String BOT_TOKEN = "TELEGRAM_BOT_TOKEN";
    private static final String CHAT_ID = "TELEGRAM_CHAT_ID";
    private static final String NEW_PULL_REQUEST_OPENED_HTTPS_GITHUB_COM_ALGO_PREP_ORG_LEET_CODE_PULLS =
            "New Pull Request [opened](https://github.com/AlgoPrepOrg/leetcode/pulls)";
    public static final String TELEGRAM_SEND_MESSAGE_API_URL = "https://api.telegram.org/bot%s/sendMessage";
    public static final String POST = "POST";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    @Tag("sendTelegramMessage")
    @Test
    void sendTelegramMessage() throws Exception {
        String botToken = System.getenv(BOT_TOKEN);
        String chatId = System.getenv(CHAT_ID);
        System.out.println(botToken + " ->  " + chatId);

        if (Objects.nonNull(botToken) && Objects.nonNull(chatId)) {
            String telegramMessageApiUrl = String.format(TELEGRAM_SEND_MESSAGE_API_URL, botToken);

            String parameters = "chat_id=" + chatId +
                    "&parse_mode=MarkdownV2" +
                    "&text=" + NEW_PULL_REQUEST_OPENED_HTTPS_GITHUB_COM_ALGO_PREP_ORG_LEET_CODE_PULLS;

            HttpURLConnection connection = null;
            try  {
                var url = new URL(telegramMessageApiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(POST);
                connection.setDoOutput(true);
                connection.setRequestProperty(CONTENT_TYPE, APPLICATION_X_WWW_FORM_URLENCODED);

                try (var outputStream = new DataOutputStream(connection.getOutputStream())) {
                    outputStream.writeBytes(parameters);
                    outputStream.flush();
                }

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try (var reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        String response = reader.lines()
                                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append).toString();
                        System.out.println("Message sent successfully. Response: " + response);
                    }
                } else {
                    System.out.println("Failed to send message. Response code: " + responseCode);
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } else {
            System.out.println("Skip sendMessage to telegram  botToken & chatId is null.");
        }
    }
}
