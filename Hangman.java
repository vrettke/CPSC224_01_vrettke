/***************
Homework #2
Due Date: 2/11/19
Names: Vincent Tramonte, Vincent Rettke
********************/

package hangman;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.*;

public class Hangman {

    public static void main(String[] args) 
    {   
        int userChoice;
        String userWord = null;
        
        while(true) 
        {
            userChoice = menu();
        
            if(userChoice == 1)
            {
                userWord = wordFromList(); 
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
            char[] convertedWord = convertWord(userWord);
            char[] mysteryWord = new char [convertedWord.length];
            for(int i = 0; i < mysteryWord.length; i++) 
            {
                mysteryWord[i] = '_'; 
            }
            runGame(userWord.length(), convertedWord, mysteryWord);
        }
        
        
    }
  
    
    //displays menu and returns the users choice 
    public static int menu() {
        String userInputNum;
        int userChoice; 
        
        userInputNum = JOptionPane.showInputDialog(null, "Enter 1 to Play game from a randomly chosen word in a list\n" +
                "Enter 2 to Play game from a word entered by another user\n" + 
                "Enter 3 to Exit Game");
        
        userChoice = Integer.parseInt (userInputNum); 
        return userChoice; 
    }    

    
    //selects random word for user
    public static String wordFromList()
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
        return word;      
    }
    
    
    //randomizer
    public static int randomNumber()
    {
        Random rand = new Random();
        int wordNumber = rand.nextInt(4); 
        return wordNumber; 
    }

    
    //takes user input for play in option 2 
    public static String inputWord()
    {
        String userWord; 
        
        userWord = JOptionPane.showInputDialog("Enter your word: ");
        userWord.toLowerCase(); 
        return userWord;   
    }
    
  
    //runs game, keeps track of strikes, and displays current progress 
    public static void runGame(int wordLength, char[] letterArray, char[] mysteryWord)
    {
        int strikesRemaining = 6;
        //char[] tempArray = new char[mysteryWord.length];  
        
        while((viewArrays(mysteryWord, letterArray) == false) && (strikesRemaining > 0))
        {
          String guess = JOptionPane.showInputDialog(null,"**HANGMAN**\n" + "**************\n" + 
          "-----------\n" + Arrays.toString(mysteryWord) +"\n" + "-----------\n" +
          "**************\n");
          char userGuess = guess.charAt(0); 
          char[] tempArray = populateArray(mysteryWord);
          mysteryWord = guessValidation(letterArray, mysteryWord, userGuess); 
          
          if ((viewArrays(mysteryWord, letterArray)))
          {
              JOptionPane.showMessageDialog(null,"The word is: " + Arrays.toString(letterArray) + 
               "\n" + "You win!");
          }
          else if (viewArrays(tempArray, mysteryWord))
          {
              strikesRemaining--; 
              if(strikesRemaining == 1)
              {
                  JOptionPane.showMessageDialog(null,"You have 1 strike remaining");                  
              }
              else if(strikesRemaining == 2)
              {
                  JOptionPane.showMessageDialog(null,"You have 2 strikes remaining");                 
              }
              else if(strikesRemaining == 3)
              {
                  JOptionPane.showMessageDialog(null,"You have 3 strikes remaining");                 
              }
              else if(strikesRemaining == 4)
              {
                  JOptionPane.showMessageDialog(null,"You have 4 strikes remaining");                 
              }
              else if(strikesRemaining == 5)
              {
                  JOptionPane.showMessageDialog(null,"You have 5 strikes remaining");                 
              }
              else if(strikesRemaining == 6)
              {
                  JOptionPane.showMessageDialog(null,"You have 6 strikes remaining");                 
              }
              else if(strikesRemaining == 0)
              {
                  JOptionPane.showMessageDialog(null,"Sorry, the word was: " + Arrays.toString(letterArray));                 
              }
              
          }
          
        }   
        
    }

    
    //returns an array of characters, that make up the users word
    public static char[] convertWord(String userWord)
    {
        char[] wordArray = userWord.toCharArray(); 
        return wordArray; 
    }
    

    //populates an array with the current form of the mystery word
    public static char[] populateArray(char[] mysteryArray)
    {
        char[] populatedArray = new char[mysteryArray.length]; 
        for(int i = 0; i < mysteryArray.length; i++) 
        {
            populatedArray[i] = mysteryArray[i]; 
        }
        return populatedArray; 
    }
    
    
    //checks individual guesses by user 
    public static char[] guessValidation(char[] letterArray, char[] mysteryArray, char userGuess)
    {
        for(int i = 0; i < letterArray.length; i++)
        {
            if(userGuess == letterArray[i])
            {
                mysteryArray[i] = userGuess;
            }
        }
        return mysteryArray;
    }       
    
    
    //compares the array of the guesser with that of the actual word
    public static boolean viewArrays(char[] mysteryArray, char[] letterArray)
    {
        for(int i = 0; i < mysteryArray.length; i++)
        {
            if(mysteryArray[i] != letterArray[i])
            {
                return false; 
            }
        }
        return true; 
    }
        
