package lib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    public static String hash(String input) {
        try {
            // Use SHA-256 algorithm (built-in to Java)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert input string to bytes and hash it
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convert hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0'); // Ensure two-digit hex
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 algorithm not found.", e);
        }
    }

    public static void main(String[] args) {
        String input = "mySecurePassword123";
        String hashed = hash(input);
        System.out.println("Original: " + input);
        System.out.println("Hashed: " + hashed);
    }
}