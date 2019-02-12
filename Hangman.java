/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author vince
 */
public class Hangman {
    
    private int numberOfLines = 0;
    private int strikeCount;
    private String word;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        
        //numberOfLines = 0;
        //showLines(numberOfLines);
        wordFromList();
        
        
    }
    
    public static void wordFromList()
    {
        //String wordList[5] = {"dog", "cat", "ostrich", "potato", "lettuce"};
        int choice = randomNumber();
        String word;
        
        switch (choice) {
            case 0:
                word = "dog";
                break;
            case 1:
                word = "cat";
                break;
            case 2:
                word = "ostrich";
                break;
            case 3:
                word = "potato";
                break;
            default:
                word = "lettuce";
                break;
        }
        
        showLines(word.length());
                   
            
        
        
    }
    
    public static int randomNumber()
    {
        Random rand = new Random();
	int wordNumber = rand.nextInt(4); 
	return wordNumber; 
    }
    
    public static void showLines(int lines)
    {
        String spaces = "";
        for (int i = 0; i < lines; i++)
        {
            spaces += "_ ";    
        }
        
        //guessLetter();
        String letter;
        String strikes = "* * * * * *";
                
        letter = JOptionPane.showInputDialog(null,"Guess a letter.\n" + spaces 
                + "\n\nStrikes Remaining: " + strikes);
        
        
    }
    
    
    public static void strikes()
    {
        int strikeCount = 0;
        System.out.println("Strikes Remaining: ");
        for (int i = 0; i < 6 - strikeCount; i++)
        {
            System.out.print("*");
        }
    }
    
    public static boolean isFound(int numberOfLines)
    {
        boolean foundIt = false;
        for (int i = 0; i < numberOfLines; i++)
        {
            /*if (word[i] == target)
            {
                foundIt = true;
                return foundIt;
            }*/
        }
        return foundIt;
    }
    
    public static void showWord()
    {
        
    }
    
    // 2 players: player 1 chooses word for player 2 to guess
    
    public static void inputWord()
    {
        
    }
    
    
    
}
