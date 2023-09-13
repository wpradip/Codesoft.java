import java.util.Random;
import java.util.Scanner;
public class Task1
{
     public static void main(String[] args) 

     {
        Random randI = new Random();
        int randomNumber = randI.nextInt(100);
        boolean result = false;
        int k = 5;
        int k2= 5;
        System.out.println(randomNumber);

        while(k>0)

        {
            @SuppressWarnings("resourse")
            Scanner sc = new Scanner(System.in);
            System.out.print ("Guess the Number Between 1 to 100 : ");
            int myNumber = sc.nextInt();

            if (randomNumber == myNumber)

            {
                 System.out.println("Congratulations!!! You guess the Right number & Number is : "+randomNumber);
                 result = true;
                 break;
            }

            else if(randomNumber > myNumber)
            {
                System.out.println("You guess small number");
                System.out.println();
                k--;
            }

            else
            {
                System.out.println("You guess Large number");
                System.out.println();
                k--;
            }
        
        }

        if(result == false)

        {
            System.out.println();
            System.out.println("Sorry...!!! You lose the game...");
            System.out.println("You didn't guess the number in " + k2  + "Chances");
            System.out.println(" the Actual number is : " + randomNumber);
         
        }

    }  

}