import java.util.Scanner;
import java.io.*;


public class App {
    public static String readFile(Scanner scan){
        System.out.print("Enter the path of the file:");
        String fileName = scan.nextLine().trim();
        String story = "";
        try{
            Scanner fsc = new Scanner(new File(fileName));
            while(fsc.hasNextLine()){
                story = story + fsc.nextLine() + (" ");
            }
            fsc.close();
            return story;
        } catch (Exception ex) {
            System.out.println("File could not be read");
            return null;
        }
    }
        public static int printMenu(Scanner scan){
            System.out.printf("Here are your options:\n" +
            "1. Count the number of vowels.\n" + 
            "2. Count the number of consonants.\n" +
            "3. Count the number of words\n" +
            "4. Print a summary to a file.\n" +
            "5. Quit\n" +
            "Enter the number of your choice:");
            int choice = scan.nextInt();
            return choice;
        }

        public static int countVowels(String story){
            int numVowels = 0;
            for(int i = 0; i < story.length(); i++){
                char ch = story.charAt(i);
                String letter = String.valueOf(ch).toUpperCase();
                if (letter.equals("A") || letter.equals("E") || 
                letter.equals("I") || letter.equals("O") || letter.equals("U")){
                    numVowels += 1;
                } else {
                    continue;
                }
                
            }
            return numVowels;
        }

        public static int countConsonants(String story){
            int numConsonants = 0;
            for(int i = 0; i < story.length(); i++){
                char ch = story.charAt(i);
                String letter = String.valueOf(ch).toUpperCase();
                if (!letter.equals("A") || !letter.equals("E") || 
                !letter.equals("I") || !letter.equals("O") || !letter.equals("U")){
                    numConsonants += 1;
                } else {
                    continue;
                }
                
            }
            return numConsonants;
        }

        public static int countWords(String story){
            String[] words = story.split(" ");
            return words.length;
        }
        public static void writeSummary(String story,Scanner scan){
            System.out.println("Enter the name of the file to write the summary:");
            String filepath = scan.next();
            try{
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(filepath))));
                pw.println("The number of Vowels is " + countVowels(story));
                pw.println("The number of Consonats is " + countConsonants(story));
                pw.println("The number of Words is " + countWords(story));
                pw.close();
            } catch (Exception ex){
                System.out.println(" An Error occured");
        
        }
    }

public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("*******************************************************************************");
        System.out.print(  "Welcome to TextAnalyzer V1.0");
        System.out.print("*******************************************************************************");
        String story = readFile(scan);
        while (true){
            if (!(story == null)){
                int choice = printMenu(scan);
                if(choice == 1){
                    System.out.println(countVowels(story));
                } else if (choice == 2){
                    System.out.println(countConsonants(story));
                } else if (choice == 3){
                    System.out.println(countWords(story));
                } else if (choice == 4){
                    writeSummary(story,scan);
                } else if (choice == 5){
                    System.out.println("Thanks for using");
                    System.exit(0);
                }
            } else {
                System.out.println("File could not be read");
            }
        }

    }
}
