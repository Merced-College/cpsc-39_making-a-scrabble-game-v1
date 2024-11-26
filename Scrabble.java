
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class Scrabble {

     
    
    public static String alphabet = "abcdefghijklmnopqrstuvwvxyz";
    


    public static void randomLetters(){
        char randomChar = (char) ((Math.random() * 26) + 'A');
        System.out.print(randomChar);
    }
//    binary search
    public static int binarySearch(ArrayList<Word> words, Word target) {
    	int low = 0; 
    	int high = words.size() -1;
    	
    	while(low <= high) {
    		int mid = low + (high - low) /2;
    		Word midVal = words.get(mid);
    		int comparison = target.compareTo(midVal);
    		
    		if ( comparison == 0) {
    			return mid;
    			
    		}
    		else if(comparison < 0){
    			high = mid -1;
    		}
    		else {
    			low = mid+ 1;
    		}
    		
    	}
    	return -1;
    }



    
    public static void main(String[] args) {
    	ArrayList<Word> wordList = new ArrayList<>();
    	
        String filePath = "src/Collins Scrabble Words (2019)2.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                wordList.add(new Word(line));
//                 System.out.println(wordList); // Print each line  
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("You random letters are: ");
        for( int i = 0; i < 4; i++){
            randomLetters();
        }
        System.out.println();
        
        // user inputs word
        System.out.println("Please enter a word");
        Scanner scnr = new Scanner(System.in);
        String userInput = scnr.nextLine();
        String userInputUpperCaseString = userInput.toUpperCase();
        Word userWord = new Word(userInputUpperCaseString);
        

        // check if user word exists
        int index = binarySearch(wordList, userWord);
        if( index != -1) {
        	System.out.println("Word found at:"+ index);
        }else {
        	System.out.println("user word was not found");
        }
//        point system
        

    



        


    }
}
