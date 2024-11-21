import java.util.Scanner;
import java.util.Random;

public class MasterMind {
    public static void main(String[] args){
        System.out.println("Witaj! Rozpocznij grę MasterMind");
        System.out.println("Wybierz 4-cyfrowy kod składający się z liczb od 1 do 6.");
        
        Scanner scanner = new Scanner(System.in);
        
        Random randNumber = new Random();
        
        
        int codelength = 4;
        int maxNumber = 6;
        
        int[] codeRandom = new int[codelength];
        int[] userCode = new int[codelength];
        
        for(int i = 0; i < codelength; i++){
            codeRandom[i] = randNumber.nextInt(maxNumber) + 1;
        }
            
            
        
        // wygenerowanie kodu w konsoli
        // System.out.print("Wygenerowane liczby: ");
        // for(int i = 0; i < codelength; i++){
        //     System.out.print(codeRandom[i]);
        // };
        // System.out.println("");
        
        
        
        System.out.println("Wprowadź 4 cyfry: ");
        String trial = scanner.nextLine();
        
        

        
        try{
                    if(trial.length() != codelength){
            throw new NumberFormatException();
        }
        for(int i = 0; i < codelength; i++){
            userCode[i] = Character.getNumericValue(trial.charAt(i));
            if(userCode[i] < 1 || userCode[i] > maxNumber){
                throw new NumberFormatException();
            }
        }
        }catch(NumberFormatException e){
            System.out.println("Wprowadź 4 cyfry od 1 do " + maxNumber + ".");
        };
        
        // wyświetlenie próby przez kogracza - do usunięcia
        // System.out.println("Wybrano liczby: " + trial);
        
        scanner.close();
  }
}