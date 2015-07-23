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
		 int count[] = new int[27];
		 for(int i=0;i<word.length();i++){
			 if(Character.isWhitespace(word.charAt(i))){
				 count[26]++;
			 }	
			 else{
				 count[Character.toLowerCase(word.charAt(i)) - 'a']++;
			 }
			 
			 
		 }	
		return count;	
	 }	 
	 boolean isValid(String word, int countOfLettersInWord[]){
		 if(word.length() > 7){
			 return false;
		 }
		 int numOfDifferences = 0;
		 for(int i=0;i < 26;i++){
			 if(countOfLettersInWord[i] > countOfLettersGiven[i]){
				 numOfDifferences += countOfLettersInWord[i] - countOfLettersGiven[i];
			 }
			 
		 }
		 
		 if(numOfDifferences > countOfLettersGiven[26]){
			 return false;
		 }	 
		 return true;
	 }	 
	 int calculateScore(int countOfLettersInWord[]){
            
            int wordScore = 0;
            for(int i=0;i < countOfLettersInWord.length - 1;i++){
				if (countOfLettersInWord[i] <= countOfLettersGiven[i]){
					wordScore += score[i] * countOfLettersInWord[i];  
				}
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
				int countOfLettersInWord[];
				countOfLettersInWord = countLetters(nextWord);
					
				if(isValid(nextWord, countOfLettersInWord)){
					wordScore = calculateScore(countOfLettersInWord);
					if (wordScore > maxScore){
						maxScore = wordScore;
						bestWord = nextWord;
					}
					else if(wordScore == maxScore){
						bestWord = bestWord + " " + nextWord;
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
        
		Scrabble object = new Scrabble(" cetone");
		System.out.println(object.findBestWord());
     }
}

