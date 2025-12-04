package Strings;

public class UpperCase {

    // Function to convert the first letter of each word to uppercase
    public static String toUpperCase(String str) {
        // Creating a StringBuilder to build the modified string
        StringBuilder sb = new StringBuilder("");

        // Convert the first character to uppercase and append it to the StringBuilder
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        // Loop through the rest of the string
        for (int i = 1; i < str.length(); i++) {
            // If current character is a space and it's not the last character
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i)); // Append the space
                i++; // Move to the next character (first letter of next word)
                // Convert it to uppercase and append it
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                // If it's not a space, just append the character as it is
                sb.append(str.charAt(i));
            }
        }

        // Return the final modified string
        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample input string
        String str = "hi, i am arpon";

        // Output: "Hi, I Am Arpon"
        System.out.println(toUpperCase(str));
    }
}
