// Task1
import java.util.Random;
import java.util.Scanner;
public class NumberGame{
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      Random random = new Random();
      boolean playAgain = true;
      int roundsPlayed = 0;
      int totalScore = 0;
      System.out.println("Welcome to NumberGame!");
      while(playAgain){
          roundsPlayed++;
          int maxNumber=100;
          int maxAttempts=10;
          int numberToGuess=random.nextInt(maxNumber)+1;
          int attempt=0;
          boolean guessedCorrectly=false;
          System.out.println("\nRound"+roundsPlayed+"\nNumber to Guess: "+maxNumber);
          System.out.println("you have"+maxAttempts+"Attempts.");
          while(attempt<maxAttempts && !guessedCorrectly){
              System.out.print("Enter your guess: ");
              int userGuess;
              //Validate input
              if(sc.hasNextInt()){
                  userGuess=sc.nextInt();
              }else{
                  System.out.println("You guessed an invalid input. Please try again.");
                  sc.next();
                  continue;
              }
              attempt++;
              if(userGuess==numberToGuess) {
                  System.out.println("Congratulations! You guessed correctly in" + attempt + " attempts.");
                  guessedCorrectly = true;
                  totalScore += (maxAttempts - attempt + 1);
              }else if(userGuess<numberToGuess){
                  System.out.println("Too low! Try again.");

              }else{
                  System.out.println("Too high! Try again.");
              }
          }
          if(!guessedCorrectly){
              System.out.println("Sorry, you used all attempts.The correct number was "+numberToGuess+".");

          }
          System.out.println("Your current score:"+totalScore);

          //ask if user want to play another round
          System.out.println("Do you want to play again? (Y/N)");
          String response = sc.next().toLowerCase();
          if(!response.equals("y")){
              playAgain = false;
              System.out.println("\nThank you for playing.");
              System.out.println("Total rounds played: "+roundsPlayed);
              System.out.println("Total score: "+totalScore);
          }
      }
      sc.close();
  }
}
