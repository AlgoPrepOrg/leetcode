package io.algopreorg.alog;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.algopreorg.alog.TelegramUtils.sendMessage;

class SendMessageToTelegram {

    private static final String BOT_TOKEN = "TELEGRAM_BOT_TOKEN";
    private static final String CHAT_ID = "TELEGRAM_CHAT_ID";
    private static final String NEW_PULL_REQUEST_OPENED_HTTPS_GITHUB_COM_ALGO_PREP_ORG_LEET_CODE_PULLS =
            "New Pull Request [opened](https://github.com/AlgoPrepOrg/leetcode/pulls)";

    @Tag("sendTelegramMessage")
    @Test
    void sendTelegramMessage() throws Exception {
        String botToken = System.getenv(BOT_TOKEN);
        String chatId = System.getenv(CHAT_ID);
        sendMessage(botToken, chatId, NEW_PULL_REQUEST_OPENED_HTTPS_GITHUB_COM_ALGO_PREP_ORG_LEET_CODE_PULLS);
    }

    @Tag("sendTelegramMessage")
    @Test
    void generateRandomQuotes() throws Exception  {
        String botToken = System.getenv(BOT_TOKEN);
        String chatId = System.getenv(CHAT_ID);

        var motivationQuotes = new MotivationQuotes();
        String randomQuote = motivationQuotes.getRandomQuote();

        sendMessage(botToken, chatId, randomQuote);
    }
}
