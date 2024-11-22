import java.util.Scanner;
import java.util.Random;

public class MasterMind {
    public static void main(String[] args){
        System.out.println("Witaj! Rozpocznij grę MasterMind!");
        System.out.println(" ");
        System.out.println("Zasady gry: ");
        System.out.println("Napisz 4-cyfrowy kod składający się z liczb od 1 do 6, aby zgadnąć cyfry w poprawnym układzie.");
        System.out.println("W przypadku błędnie podanego kodu, otrzymasz możliwość ponownej próby oraz podpowiedź, co do liczby trafionych cyfr w poprawnym i niepoprawnym układzie.");
        System.out.println(" ");
        System.out.println("Podaj 4 cyfry: ");
        
        Scanner scanner = new Scanner(System.in);
        
        Random randNumber = new Random();
        
        int codelength = 4;
        int maxNumber = 6;
        int[] codeRandom = new int[codelength];
        int[] userCode = new int[codelength];
        boolean guessed = false;
        
        for(int i = 0; i < codelength; i++){
            codeRandom[i] = randNumber.nextInt(maxNumber) + 1;
        };
            
        // do testów: wygenerowanie kodu w konsoli
        // System.out.print("Wygenerowane liczby: ");
        // for(int i = 0; i < codelength; i++){
        //     System.out.print(codeRandom[i]);
        // };
        // System.out.println(" ");
        
        while(guessed == false){
            String trial = scanner.nextLine();
                
            try{
                if(trial.length() != codelength){
                throw new NumberFormatException();
                };
                for(int i = 0; i < codelength; i++){
                    userCode[i] = Character.getNumericValue(trial.charAt(i));
                    if(userCode[i] < 1 || userCode[i] > maxNumber){
                        throw new NumberFormatException();
                    };
                };
                
            int identicalButNotInPlace = 0;
            int identicalAndInPlace = 0;
            boolean[] countedInUserCode = new boolean[codelength];
            boolean[] countedInSecretCode = new boolean[codelength];
            
            for(int i = 0; i < codelength; i++){
                if(userCode[i] == codeRandom[i]){
                    identicalAndInPlace++;
                    countedInUserCode[i] = true;
                    countedInSecretCode[i] = true;
                }
            }
            for(int i = 0; i < codelength; i++){
                if(countedInUserCode[i] != true){
                    for(int j = 0; j < codelength; j++){
                        if(countedInSecretCode[j] == false && userCode[i] == codeRandom[j]){
                            identicalButNotInPlace++;
                            countedInUserCode[i] = true;
                            countedInSecretCode[i] = true;
                        }
                    }
                }
            }
            if(identicalAndInPlace == codelength){
                System.out.println("Gratulacje! Zgadłeś kod.");
                guessed = true;
            } else{
                System.out.println("Liczba trafionych cyfr w poprawnym układzie: " + identicalAndInPlace);
                System.out.println("Liczba trafionych cyfr w złym układzie: " + identicalButNotInPlace);
                System.out.println("Spróbuj raz jeszcze:");
            }

            }catch(NumberFormatException e){
                    System.out.println("Kod powinien zawierać 4 cyfry od 1 do " + maxNumber + ". Spróbuj ponownie:");
            };
        };
            
        scanner.close();
  }
}