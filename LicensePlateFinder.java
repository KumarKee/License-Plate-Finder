import java.security.MessageDigest;
import java.util.HashSet;

public class LicensePlateFinder {

    public static void main(String[] args) throws Exception {
        // Here we define the target hashes
        HashSet<String> targetHashes = new HashSet<>();
        targetHashes.add("22B6A7BCDB572888F8CBC4EBB83BA852168E1ACBD13E0E87535B7EA9E8A70A33");
        targetHashes.add("9F9A163C6A2D96F86CF9C2E414E012B0A81B5CCAA1143A29C7A415594FEC97D5");
        targetHashes.add("9A88E9F00DF0B4EA6FA04078140A252250CBCFB6D7AF3C0D5C25EEF597BD2A6F");
        targetHashes.add("723AC77093509D324A25DFA12F1DCCEFE409EC734913CAD4DFA3437CE71A8516");
        targetHashes.add("51FCEB71C63DCE2E608FC8D666A3B2AC7D0ECA40B98C38EE7DC466B44A5F112A");
        targetHashes.add("365CAF26DA5A991E759A5048E6896D8A4C9EFE8120BA093C405BCC7DF00EB51E");
       
        // Here we define the character sets for letters and numbers
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";

        // Here we use nested loops to make every possible combination of the license plates
        for (char l1 : letters.toCharArray()) {
            for (char l2 : letters.toCharArray()) {
                for (char l3 : letters.toCharArray()) {
                    for (char d1 : digits.toCharArray()) {
                        for (char d2 : digits.toCharArray()) {
                            for (char d3 : digits.toCharArray()) {
                                for (char d4 : digits.toCharArray()) {
                                    // This generates the plate
                                    String plate = "" + l1 + l2 + l3 + "-" + d1 + d2 + d3 + d4;

                                    // This computes SHA-256 hash of the plate
                                    String hash = sha256(plate);

                                    // This checks if the hash matches any of the target hashes
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
   
     // This is the method to compute SHA-256 hash of a string
        public static String sha256(String input) throws Exception {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // This computes the hash of the plate
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            // This converts it into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
            	// Then converts each byte to a hexadecimal value
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
          return hexString.toString().toUpperCase();
        }
    }
  

  
