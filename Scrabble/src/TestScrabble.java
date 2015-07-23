import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class TestScrabble {
	Scrabble object ;
	
	@Test
	
	public void testMain() {
		
		object = new Scrabble("acetone");
		assertEquals("acetone 9",object.findBestWord());
		object = new Scrabble("oneteca");
		assertEquals("acetone 9",object.findBestWord());
		boolean thrown = false ;
		try{
			object = new Scrabble("ONE;ACET");
			object.findBestWord();
		}catch (IndexOutOfBoundsException e){
			thrown = true; 
		}
		assertTrue(thrown);
		object = new Scrabble("onet");
		assertEquals("Required Input Size - 7",object.findBestWord());
		object = new Scrabble("on tec ");
		assertEquals("Maximum Input Length allowed is 7",object.findBestWord());
		object = new Scrabble("");
		assertEquals("0",object.findBestWord());
		object = new Scrabble("ONEACET");
		assertEquals("acetone 9",object.findBestWord());
		
	}
	
	@Test
	public void testCountLetters() {
		object = new Scrabble("acetone");
		int[] score = {1,0,1,0,2,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0};
		assertArrayEquals(score,object.countLetters("acetone"));
		object = new Scrabble("ace one");
		int[] score2 = {1,0,1,0,2,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1};
		assertArrayEquals(score2,object.countLetters("ace one"));
	}
	
    public static void main(String args[]){
    	
    	JUnitCore.main("TestScrabble");
    	
    }
}
