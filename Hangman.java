import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<String> wordsArray = getStringArray();
            String word = selectRandomWord(wordsArray);
            int wordIndex = getRandomInt(word.length());
            char letter = word.charAt(wordIndex);
            final String modifiedWord = word.replace(letter, '_');

            System.out.println("Guess the word: " + modifiedWord);
            System.out.println("Guess the missing letter: ");
            char answer = input.next().charAt(0);
            isCorrectLetter(letter, answer);
            System.out.println("The word was: " + word);
        }
    }


    static ArrayList<String> getStringArray() {
        try {
            ArrayList<String> wordsArray = new ArrayList<String>();
            File myObj = new File("shortwords.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                wordsArray.add(word);
            }
            myReader.close();

            return wordsArray;
    
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return null;
    }


    static int getRandomInt(int max){
        Random num = new Random(); 
        return num.nextInt((max - 0) + 1) + 0;
    }


    static String selectRandomWord(ArrayList<String> wordsArray) {
        int index = getRandomInt(wordsArray.size());
        final String word = wordsArray.get(index);
        return word;
    }


    static void isCorrectLetter(char letter, char answer) {
        if (letter == (char) answer) {
            System.out.println("Well done! You are awesome!");
        } else {
            System.out.println("Wrong!");
        }
    }
}