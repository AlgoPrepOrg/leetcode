package io.algopreorg.alog;

import java.io.IOException;
import java.util.Objects;

public class TelegramUtils {
    public static final String TELEGRAM_SEND_MESSAGE_API_URL = "https://api.telegram.org/bot%s/sendMessage";
    public static final String POST = "POST";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public static void sendMessage(String botToken, String chatId, String text) throws IOException {


        if (Objects.nonNull(botToken) && Objects.nonNull(chatId)) {
            String telegramMessageApiUrl = String.format(TELEGRAM_SEND_MESSAGE_API_URL, botToken);

            text = escapeString(text);

            String parameters = "chat_id=" + chatId +
                    "&parse_mode=MarkdownV2" +
                    "&text=" + text;


            HttpClient.sendMessage(telegramMessageApiUrl, POST, CONTENT_TYPE, APPLICATION_X_WWW_FORM_URLENCODED, parameters);
        } else {
            System.out.println("Skip sendMessage to telegram  botToken & chatId is null.");
        }
    }

    public static String escapeString(String input) {
        StringBuilder escapedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '\"':
                    escapedString.append("\\\"");
                    break;
                case '\\':
                    escapedString.append("\\\\");
                    break;
                case '\b':
                    escapedString.append("\\b");
                    break;
                case '\f':
                    escapedString.append("\\f");
                    break;
                case '\n':
                    escapedString.append("\\n");
                    break;
                case '\r':
                    escapedString.append("\\r");
                    break;
                case '\t':
                    escapedString.append("\\t");
                    break;
                case '(':
                    escapedString.append("\\(");
                    break;
                case ')':
                    escapedString.append("\\)");
                    break;
                default:
                    escapedString.append(c);
                    break;
            }
        }
        return escapedString.toString();
    }

}
