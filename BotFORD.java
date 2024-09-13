/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author lenovo
 */
package com.mycompany.botford;

import java.util.Scanner;

public class BotFORD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Dictionary Chatbot! Type a word to get its definition or 'exit' to quit.");
        
        while (true) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();
            
            if ("exit".equalsIgnoreCase(word)) {
                System.out.println("Goodbye!");
                break;
            }
            
            String definition = DictionaryAPI.getDefinition(word);
            System.out.println("Definition: " + definition);
        }
        
        scanner.close();
    }
}

