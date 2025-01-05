package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = sc.nextLine();

            switch (operation) {
                case "encode":
                    System.out.println("Input string:");
                    String input = sc.nextLine();

                    StringBuilder binaryBuilder = new StringBuilder();
                    for (int i = 0; i < input.length(); i++) {
                        binaryBuilder.append(charToBinary(input.charAt(i)));
                    }

                    String chuckNorrisCode = convertBinaryToChuckNorris(binaryBuilder.toString());
                    System.out.println("Encoded string:");
                    System.out.println(chuckNorrisCode);
                    break;

                case "decode":
                    System.out.println("Input encoded string:");
                    String encodedString = sc.nextLine();

                    try {
                        String binaryString = convertChuckNorrisToBinary(encodedString);
                        String decodedMessage = binaryToChar(binaryString);

                        if (decodedMessage.isEmpty()) {
                            throw new IllegalArgumentException("Not valid encoded string");
                        }

                        System.out.println("Decoded string:");
                        System.out.println(decodedMessage);
                    } catch (Exception e) {
                        System.out.println("Not valid encoded string");
                    }
                    break;

                case "exit":
                    System.out.println("Bye!");
                    flag = false;
                    break;

                default:
                    System.out.println("There is no '" + operation + "' operation");
            }
        }

        sc.close();
    }

    private static String charToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        int x;
        while (n != 0) {
            x = n % 2;
            n = n / 2;
            sb.append(x);
        }
        sb.reverse();

        while (sb.length() < 7) {
            sb.insert(0, '0');
        }

        return sb.toString();
    }

    private static String binaryToChar(String binaryString) {
        StringBuilder sb = new StringBuilder();

        if (binaryString.length() % 7 != 0) {
            throw new IllegalArgumentException("Not valid binary string");
        }

        int position = 0;
        while (position < binaryString.length()) {
            int x = 0;
            for (int i = 6; i >= 0; i--) {
                if(binaryString.charAt(position) == '1') {
                    x += (int) Math.pow(2, i);
                }
                position++;
            }
            sb.append((char) x);
        }

        return sb.toString();
    }

    private static String convertChuckNorrisToBinary(String binary) {
        StringBuilder result = new StringBuilder();
        int position = 0;

        while (position < binary.length()) {
            if (position + 1 < binary.length() && binary.charAt(position) == '0' && binary.charAt(position + 1) == ' ') {
                position += 2;

                while (position < binary.length() && binary.charAt(position) != ' ') {
                    result.append('1');
                    position++;
                }

            } else if (position + 2 < binary.length() && binary.charAt(position) == '0' && binary.charAt(position + 1) == '0') {
                position += 3;

                while (position < binary.length() && binary.charAt(position) != ' ') {
                    result.append('0');
                    position++;
                }

            } else {
                position++;
            }
        }


        return result.toString();
    }

    private static String convertBinaryToChuckNorris(String binary) {
        StringBuilder result = new StringBuilder();

        char currentChar = binary.charAt(0);
        result.append(currentChar == '1' ? "0 " : "00 ");
        result.append("0");

        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == currentChar) {
                result.append("0");
            } else {
                currentChar = binary.charAt(i);
                result.append(" ");
                result.append(currentChar == '1' ? "0 " : "00 ");
                result.append("0");
            }
        }

        return result.toString();
    }
}