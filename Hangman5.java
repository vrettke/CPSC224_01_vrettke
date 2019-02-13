/***************
Homework #2
Due Date: 2/11/19
Names: Vincent Tramonte, Vincent Rettke
********************/
package hangman5;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author vince
 */
public class Hangman5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int userChoice;
        String userWord;
        
        while (true)
        {
            userChoice = menu();
            if(userChoice == 1)
                {
                    userWord = wordFromList();
                    gameBox(userWord);
                }
                else if(userChoice == 2)
                {
                    userWord = inputWord();  
                }
                else if(userChoice == 3)
                {
                    JOptionPane.showMessageDialog(null, "GoodBye!");
                    break;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid option!");
                    //userChoice = menu(); 
                }
        }
        
    }
    
    public static int menu()
    {
        String userInputNum;
        int userChoice; 
        
        userInputNum = JOptionPane.showInputDialog(null, "Enter 1 to Play game from a randomly chosen word in a list\n" +
                "Enter 2 to Play game from a word entered by another user\n" + 
                "Enter 3 to Exit Game");
        userChoice = Integer.parseInt (userInputNum); 
        return userChoice; 
    }
    
    public static String wordFromList()
    {
        String word;
        Random rand = new Random();
        int wordNumber = rand.nextInt(4);
        
        
        switch (wordNumber) {
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
        
        return word;
        
    }
    
    public static String inputWord()
    {
        
    }
    
    public static void gameBox(String userWord)
    {
        String lettersGuessed = "";
        
        
        for (int i = 0; i < userWord.length(); i++)
        {
            lettersGuessed += "_ ";
        }
        
        String letter;
        String strikes = "* * * * * *";
        
        boolean wordNotComplete = true;
        while (wordNotComplete)
        {
            letter = JOptionPane.showInputDialog(null,"Guess a letter.\n" + lettersGuessed 
                        + "\n\nStrikes Remaining: " + strikes);

            if (isCorrect(userWord, letter))
            {
                for (int i = 0; i < userWord.length(); i++)
                {
                    if (letter.charAt(0) == userWord.charAt(i))
                        lettersGuessed = lettersGuessed.replace(lettersGuessed.charAt(i), userWord.charAt(i));
                        
                    if (lettersGuessed == userWord)
                        wordNotComplete = false;
                }
            }
            
            else
            {
                strikes = strikes.substring(0, strikes.length()-2);
            }
        }
    }
    
    public static boolean isCorrect(String userWord, String letter)
    {
        for (int i = 0; i < userWord.length(); i++)
        {
            if (letter.charAt(0) == userWord.charAt(i))
                return true;
        }
        return false;
    }
}
