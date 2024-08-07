import java.util.Scanner;

public class Lab5_32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many words do you want to enter: ");
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter word" + (i + 1) + ": ");
            words[i] = sc.next();
        }
        int randomNumber = (int) Math.floor(Math.random() * n);
        System.out.println("Random number generated = " + randomNumber);
        System.out.println(
                "Word stored at the index " + randomNumber + " is the array is \"" + words[randomNumber] + "\"");
        System.out.println("Enter the anagram of the word: ");
        String anagram = sc.next();
        if (anagram.length() == words[randomNumber].length()) {
            char[] anagramArray = new char[anagram.length()];
            for (int i = 0; i < anagramArray.length; i++) {
                anagramArray[i] = anagram.toLowerCase().charAt(i);
            }
            char[] wordArray = new char[words[randomNumber].length()];
            for (int i = 0; i < wordArray.length; i++) {
                wordArray[i] = words[randomNumber].toLowerCase().charAt(i);
            }
            for (int i = 0; i < anagramArray.length-1; i++) {
                for(int j=i+1; j<anagramArray.length; j++) {
                    if(anagramArray[i]>anagramArray[j]) {
                        char temp = anagramArray[i];
                        anagramArray[i] = anagramArray[j];
                        anagramArray[j] = temp;
                    }
                }
            }
            for(int i=0; i<wordArray.length-1; i++) {
                for(int j=i+1; j<wordArray.length; j++) {
                    if(wordArray[i]>wordArray[j]) {
                        char temp = wordArray[i];
                        wordArray[i] = wordArray[j];
                        wordArray[j] = temp;
                    }
                }
            }
            for(int i=0; i<anagramArray.length; i++) {
                if(anagramArray[i] != wordArray[i]) {
                    System.out.println("Not an anagram");
                    return;
                }
            }
            System.out.println("Anagram");
        }
        else {
            System.out.println("Not an anagram");
        }
        sc.close();
        scanner.close();
    }
}
