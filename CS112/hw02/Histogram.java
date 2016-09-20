import java.util.Scanner;

public class Histogram { 
  
  public static final int numberInputs = 20;
  public static final int numberBins = 10;
  public static final int sizeBins = 100 / numberBins;
  public static double[] number = new double[numberInputs];
  public static int[] histogram = new int[numberBins];
    
  public static void printHistogram(){
    System.out.print("[0..10]:\t");
    for(int a = 0;a < histogram[0]; a++)
      System.out.print("*");
    for(int i = 1;i < numberBins;++i){
      System.out.print("\n(" + (i*10)+".." + (i*10+10) + "]:\t");
    for(int a = 0;a < histogram[i]; a++)
      System.out.print("*");
    }   
  }
  
  public static void printHeading() { 
    System.out.println("\nWelcome to the Histogram Program!\nThis program will print out a histogram of the numbers");
    System.out.println("input by the user; enter up to 20 doubles and hit Control-d to end.");
}  
  public static boolean validInput(double x) { 
    if(x >= 0 && x <= 100)
      return true;
    else 
      return false;
}  
  public static void main(String[] args) {
    
    printHeading();
    
    Scanner userInput = new Scanner(System.in);  
    int i = 0;
    outerloop:
    while(userInput.hasNext() && (i <= numberInputs)){
    for(i = 0; i < numberInputs + 1; i++){
      if (userInput.hasNextDouble()){
          double num = userInput.nextDouble();
          if(validInput(num) == false ){
            System.out.println("Input must be a double in range [0..100], try again!");
            i--;
            continue;
          } 
          else if(i == numberInputs){
            System.out.println("Maximum number of inputs("+numberInputs+") exceeded, proceeding to calculate histogram...");
            i--;
            break outerloop;
          }
          else if(i < numberInputs + 1){
            number[i] = num;
            if(number[i]%10 == 0)
              histogram[(int)number[i]/10 - 1]++;
            else if(number[i] == 0)
              histogram[0]++;
            else{
              histogram[(int)number[i]/10]++;
            }
          }
      }
     
      else{
          System.out.println("Input must be a double in range [0..100], try again!");
           i--;
           break;
      }
    }
    }
  
  
       System.out.print("\nYou input "+(i + 1)+" numbers: [ "+number[0]);
       for( int a = 1; a < i + 1; a++ )
           System.out.print(", " + number[a]);
       System.out.println(" ]");
       printHistogram();
    }
  
      
    }
  
