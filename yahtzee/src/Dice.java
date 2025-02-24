
public class Dice
{


   private final int MAX = 6;  

   private int faceValue;  

   public Dice()
   {
      faceValue = 1;
   }

   public Dice(int value)
   {
      faceValue = value;
   }

   public int roll()
   {
      faceValue = (int)(Math.random() * MAX) + 1;

      return faceValue;
   }

   public void setFaceValue (int value)
   {
      faceValue = value;
   }

   public int getFaceValue()
   {
      return faceValue;
   }

   public String toString() 
   { 
      return Integer.toString(faceValue); 
   } 



   /**
 * @param args
 */
/**
 * @param args
 */
/**
 * @param args
 */
/**
 * @param args
 */
/**
 * @param args
 */
public static void main (String[] args)
   {

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
      
      System.out.println
               ("Youre roll is : " +
      		          dice1.getFaceValue() + 
    		    " " + dice2.getFaceValue() +
      			" " + dice3.getFaceValue() +
      			" " + dice4.getFaceValue() +
      			" " + dice5.getFaceValue());
   }
}

