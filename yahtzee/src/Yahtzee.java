
import static org.junit.Assert.assertEquals;

import java.util.List;

public class Yahtzee {



    
    public static void main (String[] args)
	   {

        Console console = new Console();

	      Dice dice1 = new Dice();
	      Dice dice2 = new Dice();
	      Dice dice3 = new Dice();
	      Dice dice4 = new Dice();
	      Dice dice5 = new Dice();

	      dice1.roll();
	      dice2.roll();
	      dice3.roll();
	      dice4.roll();
	      dice5.roll();

          ScoreCard card;
	      ScoreCardAssembler scoreCardAssembler = new ScoreCardAssembler();
	      card = scoreCardAssembler.assembleScoreCard();
	      
	      console.writeLineToConSoleWithNewLine("Your roll is : " +
	      		          dice1.getFaceValue() + 
	    		    " " + dice2.getFaceValue() +
	      			" " + dice3.getFaceValue() +
	      			" " + dice4.getFaceValue() +
	      			" " + dice5.getFaceValue());

	
          List<ScoreCardLine> scoreCardLines = card.getScoreCardLines();
          int i=1;
          for(ScoreCardLine line : scoreCardLines) {
              //line.score(dice1, dice2, dice3, dice4, dice5);
           }
	      
	      boolean validCardProvided = false;
	      while ( validCardProvided == false )
	      {	  
		      try 
		      {
		    	  printScoreCard(card, console);
		    	  int cardChoice = readCardChoice(console);
		    	  
		    	  if ( (cardChoice -1) > scoreCardLines.size() )
		    	  {
		    		  console.writeLineToConSoleWithNewLine("Please select a category number from the list");
		    		  continue;		    		  
		    	  }
		    	  
		    	  ScoreCardLine scoreCardLine = scoreCardLines.get(cardChoice -1);
		    	  
		    	  
		    	  if ( scoreCardLine == null )
		    	  {
		    		  console.writeLineToConSoleWithNewLine("Please enter valid category number");
		    		  continue;
		    	  }
		    	  
		    	  if ( scoreCardLine.hasBeenScored() == true )
		    	  {
		    		  console.writeLineToConSoleWithNewLine("This category has been scored");
		    		  continue;
		    	  }
		    		  
		    	  
		    	  scoreCardLine.score(dice1, dice2, dice3, dice4, dice5);
		    	  printScoreCard(card, console);
		    	  validCardProvided = true;
		      }
		      catch ( Exception e)
		      {
		    	  console.writeLineToConSoleWithNewLine("Please enter valid card number");
		      }
	      }    

	      
	      

          



	      
	      
	   }

    private static int readCardChoice(Console console) throws NumberFormatException
    {
  	  	  console.writeLineToConSoleWithPrompt("Please choose a category");
	      String chosenCard = console.readLineFromConsole();
	      int cardNumber = new Integer(chosenCard);
	      return cardNumber;
    }
    
    private static void printScoreCard(ScoreCard card, Console console)
    {
        List<ScoreCardLine> scoreCardLines = card.getScoreCardLines();

        int i=1;
        for(ScoreCardLine line : scoreCardLines) {
            //line.score(dice1, dice2, dice3, dice4, dice5);
        	if ( line.hasBeenScored() == true )
        	{	
        		console.writeLineToConSoleWithNewLine(i++ + " " + line.getName() + ": " + line.getScore() );
        	}
        	else
        	{
        		console.writeLineToConSoleWithNewLine(i++ + " " + line.getName() + ": ");
        	}
        }
    }

}
