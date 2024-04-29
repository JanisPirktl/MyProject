package Datenstrukturen_und_Algorithmen;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    private static final HashMap<Character, String> morseCodes = new HashMap<>();
    private static final HashMap<String, Character> reverseMorseCodes = new HashMap<>();

    static {
        morseCodes.put('A', ".-");
        morseCodes.put('B', "-...");
        morseCodes.put('C', "-.-.");
        morseCodes.put('D', "-..");
        morseCodes.put('E', ".");
        morseCodes.put('F', "..-.");
        morseCodes.put('G', "--.");
        morseCodes.put('H', "....");
        morseCodes.put('I', "..");
        morseCodes.put('J', ".---");

        for (Map.Entry<Character, String> entry : morseCodes.entrySet()) {
            reverseMorseCodes.put(entry.getValue(), entry.getKey());
        }
    }

    public static String encode(String string) {
        StringBuilder result = new StringBuilder();
        string = string.toUpperCase();
        for (int i = 0; i < string.length(); i++) {
            String morse = morseCodes.get(string.charAt(i));
            result.append(morse).append("  ");
        }
        return result.toString();
    }

    public static String decode(String string) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = string.split("   ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (!letter.isEmpty()) {
                    Character decodedChar = reverseMorseCodes.get(letter);
                    if (decodedChar != null) {
                        decodedMessage.append(decodedChar);
                    }
                }
            }
            decodedMessage.append(" ");
        }
        return decodedMessage.toString().trim();
    }
    public static void main(String[] args) {
        String string = "ABCDEFGHIJ";
        String reversedString = encode(string);
        System.out.println(reversedString);
        System.out.println(decode(reversedString));
    }
}
