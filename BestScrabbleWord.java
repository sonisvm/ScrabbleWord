import java.io.*;
import java.util.*;

class Scrabble{
	 int score[] ;
	 
	 int countOfLettersGiven[];
	 
	 
	 Scrabble(String inputLetters){
		 score = new int[]{1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};
		
		 countOfLettersGiven = countLetters(inputLetters);
	 }
	 int[] countLetters(String word){
		 int count[] = new int[26];
		 for(int i=0;i<word.length();i++){
			 count[Character.toLowerCase(word.charAt(i)) - 'a']++;
		 }	
		return count;	
	 }	 
	 boolean isValid(String word){
		 if(word.length() > 7){
			 return false;
		 }
		 int countOfLettersInWord[];
		 countOfLettersInWord = countLetters(word);
		 
		 for(int i=0;i < 26;i++){
			 if(countOfLettersInWord[i] > countOfLettersGiven[i]){
				 return false;
			 }
			 
		 }
		 return true;
	 }	 
	 int calculateScore(String word){
            
            int wordScore = 0;
            for(int i=0;i < word.length();i++){
                wordScore += score[(Character.toLowerCase(word.charAt(i)) - 'a')];  
            }
            return wordScore;
        }
	 String findBestWord(){
		BufferedReader fileReader = null;
		String nextWord = "";
		int wordScore = 0;
		int maxScore = 0;
		String bestWord = "";
		try {
		   
			fileReader = new BufferedReader(new FileReader("sowpods.txt"));
			while ( (nextWord = fileReader.readLine()) != null ) {
				
				if(isValid(nextWord)){
					wordScore = calculateScore(nextWord);
					if (wordScore > maxScore){
						maxScore = wordScore;
						bestWord = nextWord;
					}
				}	
				
				
			}
			
		} 
		catch (Exception exp) {
			System.err.println(exp.getMessage());
		}
		return bestWord + " " + maxScore;
	 }	 
}	
public class BestScrabbleWord{
        
     public static void main(String []args){
        
		Scrabble object = new Scrabble("dtefiva");
		System.out.println(object.findBestWord());
     }
}

