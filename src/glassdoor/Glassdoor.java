package glassdoor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Glassdoor {

	public static void main(String[] args) {
		Glassdoor gProb = new Glassdoor();
		gProb.process();
		String statement = "In a indithis is a this athissbnbs generalskssThisj!!";
		gProb.findSubString(statement, "this");
		gProb.findWords("Th is!new@#(##Words.");
		gProb.findSubstrOccuranceWithKmp("abxabyxabyxaby", "abyxaby");
	}

	private void process() {
		String statement = "THis statement has some words.909090@$Which have      space more! more space,few-less!";
		findWords(statement);
		String[] words = statement.split("[\\W]+");
		for(String word : words){
			System.out.print(word);
		}
		System.out.println(words.length);
	}
	
	private void findSubString(String statement, String substr){
		String[] words = statement.split("(?i)this");
		for(String word : words){
			System.out.print(word);
		}
	}
	
	private void findWords(String statement){
		if(statement == null || statement.length() == 0) return ;
		int end = 0;
		List<String> wordList = new ArrayList<>();
		StringBuilder sbuf = new StringBuilder();
		while(end < statement.length()){
			char currC = statement.charAt(end);
			if(!Character.isAlphabetic(currC)){
				wordList.add(sbuf.toString());
				while(end < statement.length() && !Character.isAlphabetic(statement.charAt(end))){
					end++;
				}
				sbuf.setLength(0);
			}
			else{
				sbuf.append(currC);
				end++;
			}
		}
		System.out.println(wordList + " words " + wordList.size());
	}
	
	public void findSubstrOccuranceWithKmp(String str, String pattern){
		int[] lps = computeLPS(pattern);
		int strIndex = 0;
		int patIndex = 0;
		while(strIndex < str.length()){
			if(str.charAt(strIndex) == pattern.charAt(patIndex)){
				if(patIndex == pattern.length()-1){
					System.out.println("Pattern found at index:"+ strIndex);
					patIndex = lps[patIndex];
					strIndex++;
				}
				else{
					strIndex++;
					patIndex++;
				}
			}
			else{
				if(patIndex != 0){
					patIndex = lps[patIndex-1];
				}
				else{
					strIndex++;
				}
			}
		}
	}
	
	// KMP Algo
	public int[] computeLPS(String pattern){
		int len = pattern.length();
		int[] lps = new int[len];
		int j = 0;
		for(int i = 1; i<len ;){
			if(pattern.charAt(i) == pattern.charAt(j)){
				lps[i] = j + 1;
				i++;
				j++;
			}
			else{
				if(j == 0){
					lps[i] = 0;
					i++;
				}
				else{
					j = lps[j-1];
				}
			}
		}
		return lps;
	}
}
