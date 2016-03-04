/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/

/*Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
import java.util.*;
public class wordLadder {
    public  static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	if(wordList.size() == 0 || wordList == null) {
    		return 0;
    	}
    	if(beginWord.equals(endWord)) {
    		return 1;
    	}
    	wordList.add(endWord);
    	Set<String> set = new HashSet<String>();
		java.util.Queue<String> q = new java.util.LinkedList<String>();
    	q.offer(beginWord);
    	int length = 1;
    	while(!q.isEmpty()) {
    		length++;
    		int size = q.size();
    		for(int i = 0; i < size; i++) {
	    		String word = q.poll();
	    		for(String k: findSimilarWords(word, wordList)) {
	    			if(k.equals(endWord)) {
	    				return length;
	    			}
	    			if(set.contains(k)) {
	    				continue;
	    			}
	    			set.add(k);
	    			q.offer(k);
	    		}
	    	}
    	}
        return 0;
    }
    // return a set of similar words of a word. EX: word = hit. return hot, hat if wordList has these two.
    private static Set<String> findSimilarWords(String word, Set<String> wordList) {
    	Set<String> similarWords = new HashSet<String>();
    	for(char a = 'a'; a < 'z'; a++) {
    		for(int i = 0; i < word.length(); i++) {
    			if(word.charAt(i) == a) {
    				continue;
    			} else {
    				String newWord = replaceWord(i, word, a);
    				if(wordList.contains(newWord)) {
    					similarWords.add(newWord);
    				} else {
    					continue;
    				}
    			}
    		}
    	}
    	return similarWords;
    }
    private static String replaceWord(int index, String word, char a) {
    	char[] chars = word.toCharArray();
    	chars[index] = a;
    	return new String(chars);
    }
    public static void main(String[] args) {
    	String start = "hot";
    	String end = "dog";
    	Set<String> wordList = new HashSet<String>();
    	wordList.add("hot");
    	wordList.add("cog");
    	wordList.add("dog");
    	wordList.add("tot");
    	wordList.add("hog");
    	wordList.add("hop");
    	wordList.add("pot");
    	wordList.add("dot");
    	System.out.println(ladderLength(start, end, wordList));


    }

}