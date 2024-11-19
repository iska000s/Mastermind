import java.util.Scanner;

public class MasterMind {
    public static void main(String[] args){
        System.out.println("Witaj! Rozpocznij grę MasterMind");
        System.out.println("Wybierz 4 cyfrowy kod składający się z liczb od 1 do 6.");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź 4 cyfry: ");
        String trial = scanner.nextLine();
        
        System.out.println("Wybrano liczby: " + trial);
        
        scanner.close();
  }
}