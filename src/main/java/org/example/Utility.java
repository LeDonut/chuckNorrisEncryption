package org.example;

class Utility {

    private Utility() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String charToBinary(char character) {
        String binaryString = Integer.toBinaryString(character);
        return String.format("%7s", binaryString).replace(' ', '0');
    }

    public static String binaryToChar(String binaryString) {
        if (binaryString.length() % 7 != 0) {
            throw new IllegalArgumentException("Not valid binary string");
        }

        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 7) {
            String byteString = binaryString.substring(i, i + 7);
            int charCode = Integer.parseInt(byteString, 2);
            decoded.append((char) charCode);
        }
        return decoded.toString();
    }

    public static String convertChuckNorrisToBinary(String chuckNorrisCode) {
        StringBuilder binaryString = new StringBuilder();
        String[] blocks = chuckNorrisCode.split(" ");

        for (int i = 0; i < blocks.length; i += 2) {
            String type = blocks[i];
            String zeros = blocks[i + 1];
            char bit = type.equals("0") ? '1' : '0';

            binaryString.append(String.valueOf(bit).repeat(zeros.length()));
        }

        return binaryString.toString();
    }

    public static String convertBinaryToChuckNorris(String binaryString) {
        StringBuilder chuckNorrisCode = new StringBuilder();
        char currentChar = binaryString.charAt(0);
        chuckNorrisCode.append(currentChar == '1' ? "0 " : "00 ");
        chuckNorrisCode.append("0");

        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == currentChar) {
                chuckNorrisCode.append("0");
            } else {
                currentChar = binaryString.charAt(i);
                chuckNorrisCode.append(" ");
                chuckNorrisCode.append(currentChar == '1' ? "0 " : "00 ");
                chuckNorrisCode.append("0");
            }
        }

        return chuckNorrisCode.toString();
    }
}