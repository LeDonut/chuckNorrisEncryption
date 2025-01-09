package org.example;

import java.util.Scanner;

public class MenuHandler {
    private final Encoder encoder = new Encoder();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();

            switch (operation) {
                case "encode":
                    handleEncode();
                    break;
                case "decode":
                    handleDecode();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    running = false;
                    break;
                default:
                    System.out.println("There is no '" + operation + "' operation");
            }
        }
    }

    private void handleEncode() {
        System.out.println("Input string:");
        String input = scanner.nextLine();
        String encodedString = encoder.encode(input);
        System.out.println("Encoded string:");
        System.out.println(encodedString);
    }

    private void handleDecode() {
        System.out.println("Input encoded string:");
        String encodedInput = scanner.nextLine();

        try {
            String decodedString = encoder.decode(encodedInput);
            System.out.println("Decoded string:");
            System.out.println(decodedString);
        } catch (IllegalArgumentException e) {
            System.out.println("Not valid encoded string");
        }
    }
}