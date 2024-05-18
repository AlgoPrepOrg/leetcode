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

            String parameters = "chat_id=" + chatId +
                    "&parse_mode=MarkdownV2" +
                    "&text=" + escapeTextForMarkdown(text);


            HttpClient.sendMessage(telegramMessageApiUrl, POST, CONTENT_TYPE, APPLICATION_X_WWW_FORM_URLENCODED, parameters);
        } else {
            System.out.println("Skip sendMessage to telegram  botToken & chatId is null.");
        }
    }

    private static String escapeTextForMarkdown(String text) {
        StringBuilder escapedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            switch (c) {
                case '_':
                case '*':
                case '[':
                case ']':
                case '(':
                case ')':
                case '~':
                case '`':
                case '>':
                case '#':
                case '+':
                case '-':
                case '=':
                case '|':
                case '{':
                case '}':
                case '.':
                case '!':
                    escapedString.append('\\').append(c);
                    break;
                default:
                    escapedString.append(c);
                    break;
            }
        }
        return escapedString.toString();
    }

}
