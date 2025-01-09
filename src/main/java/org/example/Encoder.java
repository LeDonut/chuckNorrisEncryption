package org.example;

public class Encoder {

    public String encode(String input) {
        StringBuilder binaryBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            binaryBuilder.append(Utility.charToBinary(c));
        }
        return Utility.convertBinaryToChuckNorris(binaryBuilder.toString());
    }

    public String decode(String input) {
        String binaryString = Utility.convertChuckNorrisToBinary(input);
        return Utility.binaryToChar(binaryString);
    }
}
