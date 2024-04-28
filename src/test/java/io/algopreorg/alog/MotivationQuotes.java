package io.algopreorg.alog;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class MotivationQuotes {
    private final List<String> quotes = Arrays.asList(
            "Believe you can and you're halfway there(Theodore Roosevelt)",
            "The only way to do great work is to love what you do(Steve Jobs)",
            "Success is not final, failure is not fatal: It is the courage to continue that counts(Winston Churchill)",
            "The only limit to our realization of tomorrow will be our doubts of today(Franklin D. Roosevelt)",
            "Don't watch the clock; do what it does. Keep going(Sam Levenson)",
            "Your time is limited, don't waste it living someone else's life(Steve Jobs)",
            "The future belongs to those who believe in the beauty of their dreams(Eleanor Roosevelt)",
            "Hardships often prepare ordinary people for an extraordinary destiny(C.S. Lewis)",
            "The way to get started is to quit talking and begin doing(Walt Disney)",
            "The only person you should try to be better than is the person you were yesterday(Anonymous)",
            "In the middle of difficulty lies opportunity(Albert Einstein)",
            "Don't be pushed around by the fears in your mind. Be led by the dreams in your heart(Roy T. Bennett)",
            "You are never too old to set another goal or to dream a new dream(C.S. Lewis)",
            "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful(Albert Schweitzer)",
            "Keep your face always toward the sunshine—and shadows will fall behind you(Walt Whitman)",
            "You miss 100% of the shots you don't take(Wayne Gretzky)",
            "The only impossible journey is the one you never begin(Tony Robbins)",
            "The greatest glory in living lies not in never falling, but in rising every time we fall(Nelson Mandela)",
            "What you get by achieving your goals is not as important as what you become by achieving your goals(Zig Ziglar)",
            "The road to success and the road to failure are almost exactly the same(Colin R. Davis)",
            "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle(Christian D. Larson)",
            "It always seems impossible until it is done(Nelson Mandela)",
            "The best way to predict the future is to create it(Peter Drucker)",
            "Do not wait to strike till the iron is hot; but make it hot by striking(William Butler Yeats)",
            "You are the master of your fate, the captain of your soul(William Ernest Henley)",
            "The only place where success comes before work is in the dictionary(Vidal Sassoon)",
            "It does not matter how slowly you go as long as you do not stop(Confucius)",
            "Success is stumbling from failure to failure with no loss of enthusiasm(Winston Churchill)",
            "Happiness is not something readymade. It comes from your own actions(Dalai Lama)",
            "Don't let yesterday take up too much of today(Will Rogers)",
            "Success is walking from failure to failure with no loss of enthusiasm(Winston Churchill)",
            "You don't have to be great to start, but you have to start to be great(Zig Ziglar)",
            "The only way to do great work is to love what you do(Steve Jobs)",
            "Success seems to be connected with action. Successful people keep moving. They make mistakes, but they don't quit(Conrad Hilton)",
            "Don't let the fear of losing be greater than the excitement of winning(Robert Kiyosaki)",
            "The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it(Jordan Belfort)",
            "It is never too late to be what you might have been(George Eliot)",
            "You are never too old to set another goal or to dream a new dream(C.S. Lewis)",
            "Success is not how high you have climbed, but how you make a positive difference to the world(Roy T. Bennett)",
            "Success is liking yourself, liking what you do, and liking how you do it(Maya Angelou)",
            "The only limit to our realization of tomorrow will be our doubts of today(Franklin D. Roosevelt)",
            "The best time to plant a tree was 20 years ago. The second best time is now(Chinese Proverb)",
            "If you want to achieve greatness stop asking for permission(Anonymous)",
            "What you do today can improve all your tomorrows(Ralph Marston)",
            "You can't go back and change the beginning, but you can start where you are and change the ending(C.S. Lewis)",
            "The only person you should try to be better than is the person you were yesterday(Anonymous)",
            "I can't change the direction of the wind, but I can adjust my sails to always reach my destination(Jimmy Dean)",
            "Success is not just about making money, it's about making a difference(Anonymous)",
            "The greatest danger for most of us is not that our aim is too high and we miss it, but that it is too low and we reach it(Michelangelo)",
            "The only limit to our realization of tomorrow will be our doubts of today(Franklin D. Roosevelt)",
            "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful(Albert Schweitzer)",
            "Success is not final, failure is not fatal: It is the courage to continue that counts(Winston Churchill)",
            "Don't watch the clock; do what it does. Keep going(Sam Levenson)",
            "Hardships often prepare ordinary people for an extraordinary destiny(C.S. Lewis)",
            "Your time is limited, don't waste it living someone else's life(Steve Jobs)",
            "The future belongs to those who believe in the beauty of their dreams(Eleanor Roosevelt)",
            "Believe you can and you're halfway there(Theodore Roosevelt)",
            "The only way to do great work is to love what you do(Steve Jobs)",
            "Success is not final, failure is not fatal: It is the courage to continue that counts(Winston Churchill)",
            "The only limit to our realization of tomorrow will be our doubts of today(Franklin D. Roosevelt)",
            "Don't watch the clock; do what it does. Keep going(Sam Levenson)",
            "Your time is limited, don't waste it living someone else's life(Steve Jobs)",
            "The future belongs to those who believe in the beauty of their dreams(Eleanor Roosevelt)",
            "Hardships often prepare ordinary people for an extraordinary destiny(C.S. Lewis)",
            "The way to get started is to quit talking and begin doing(Walt Disney)",
            "The only person you should try to be better than is the person you were yesterday(Anonymous)",
            "In the middle of difficulty lies opportunity(Albert Einstein)",
            "Don't be pushed around by the fears in your mind. Be led by the dreams in your heart(Roy T. Bennett)",
            "You are never too old to set another goal or to dream a new dream(C.S. Lewis)",
            "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful(Albert Schweitzer)",
            "Keep your face always toward the sunshine—and shadows will fall behind you(Walt Whitman)",
            "You miss 100% of the shots you don't take(Wayne Gretzky)",
            "The only impossible journey is the one you never begin(Tony Robbins)",
            "The greatest glory in living lies not in never falling, but in rising every time we fall(Nelson Mandela)",
            "What you get by achieving your goals is not as important as what you become by achieving your goals(Zig Ziglar)",
            "The road to success and the road to failure are almost exactly the same(Colin R. Davis)",
            "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle(Christian D. Larson)",
            "It always seems impossible until it is done(Nelson Mandela)",
            "The best way to predict the future is to create it(Peter Drucker)",
            "Do not wait to strike till the iron is hot; but make it hot by striking(William Butler Yeats)",
            "You are the master of your fate, the captain of your soul(William Ernest Henley)",
            "The only place where success comes before work is in the dictionary(Vidal Sassoon)",
            "It does not matter how slowly you go as long as you do not stop(Confucius)",
            "Success is stumbling from failure to failure with no loss of enthusiasm(Winston Churchill)",
            "Happiness is not something readymade. It comes from your own actions(Dalai Lama)",
            "Don't let yesterday take up too much of today(Will Rogers)",
            "Success is walking from failure to failure with no loss of enthusiasm(Winston Churchill)",
            "You don't have to be great to start, but you have to start to be great(Zig Ziglar)",
            "The only way to do great work is to love what you do(Steve Jobs)",
            "Success seems to be connected with action. Successful people keep moving. They make mistakes, but they don't quit(Conrad Hilton)",
            "Don't let the fear of losing be greater than the excitement of winning(Robert Kiyosaki)",
            "The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it(Jordan Belfort)",
            "It is never too late to be what you might have been(George Eliot)",
            "You are never too old to set another goal or to dream a new dream(C.S. Lewis)",
            "Success is not how high you have climbed, but how you make a positive difference to the world(Roy T. Bennett)",
            "Success is liking yourself, liking what you do, and liking how you do it(Maya Angelou)",
            "The only limit to our realization of tomorrow will be our doubts of today(Franklin D. Roosevelt)",
            "The best time to plant a tree was 20 years ago. The second best time is now(Chinese Proverb)",
            "If you want to achieve greatness stop asking for permission(Anonymous)",
            "What you do today can improve all your tomorrows(Ralph Marston)"
    );

    public String getRandomQuote() {
        int quoteIndex = new SecureRandom().nextInt(quotes.size());
        return quotes.get(quoteIndex);
    }
}
