import java.security.MessageDigest;
import java.util.HashSet;

public class LicensePlateTest {

    public static void main(String[] args) throws Exception {
        HashSet<String> targetHashes = new HashSet<>();
        targetHashes.add("B4ECF4E82FCD763E2125CF8B9BAD4837239FF8E5EB2AB04D42293CEEBE636B0E");
        targetHashes.add("CFB0518AA3001B7BAE333093C1510334C1BE3F849F37795EAC217E07F31DB28C");
        targetHashes.add("62FE28DB9EB337A7133233134DD2CF34C5810691A4B04E64C0E9C732343BB813");

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";

         for (char l1 : letters.toCharArray()) {
            for (char l2 : letters.toCharArray()) {
                for (char l3 : letters.toCharArray()) {
                    for (char d1 : digits.toCharArray()) {
                        for (char d2 : digits.toCharArray()) {
                            for (char d3 : digits.toCharArray()) {
                                for (char d4 : digits.toCharArray()) {
                                    
                                    String plate = "" + l1 + l2 + l3 + "-" + d1 + d2 + d3 + d4;

                                    String hash = sha256(plate);

                                   if (targetHashes.contains(hash)) {
                                        System.out.println("Match found: " + plate + " -> " + hash);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
  public static String sha256(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
