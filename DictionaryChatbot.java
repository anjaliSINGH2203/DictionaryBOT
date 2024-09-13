package com.mycompany.botford;

import java.util.Scanner;

public class DictionaryChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Dictionary Chatbot! Type a word to get its definition or 'exit' to quit.");
        
        String sourceLang = "en-us"; // Specify the source language

        while (true) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();

            if (word.equalsIgnoreCase("exit")) {
                break;
            }

            String definition = DictionaryAPI.getDefinition(word);
            System.out.println("Definition: " + definition);
        }

        scanner.close();
    }
}
