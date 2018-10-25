/*
 *Sean Luo 25/10/2018
 *CustomerList.java
 *This is progrem calculates the CustomerList.
 */

package customerlist;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author toluo7449
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       String name,address,city,province,postcode;
         File textFile = new File("The customers' "
               + "information.txt");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;
		
		try {
                    in = new FileReader(textFile);
                    readFile = new BufferedReader(in);
                    while ((lineOfText = readFile.readLine()) != null ) {
                            System.out.println(lineOfText);
                    }
                    readFile.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File does not exist or could not be found.");
                    System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
                    System.out.println("Problem reading file.");
                    System.err.println("IOException: " + e.getMessage());
        }
        try{         
       PrintWriter fileout = new PrintWriter(new FileWriter("The customers' "
               + "information.txt",true));
       String people = JOptionPane.showInputDialog("How many people do you"
               + " want to be on this list",true);
       int number = Integer.parseInt(people);
       for(int i = 1;i <= number;i++){
           name = JOptionPane.showInputDialog("Name:");
           address = JOptionPane.showInputDialog("Address:");
           city = JOptionPane.showInputDialog("City:");
           province = JOptionPane.showInputDialog("Province:");
           postcode = JOptionPane.showInputDialog("postcode:");
           fileout.println(name);
           fileout.println(address);
           fileout.println(city);
           fileout.println(province);
           if(Character.isLetter(postcode.charAt(0))){
               if (Character.isDigit(postcode.charAt(1))){
                   if(Character.isLetter(postcode.charAt(2))){
                       if (Character.isDigit(postcode.charAt(3))){ 
                             if(Character.isLetter(postcode.charAt(4))){
                                 if (Character.isDigit(postcode.charAt(5))){
                                     fileout.println(postcode);
                                 }
                                 else{
                                     System.out.println("You enter wrong word on sixth word.");
                                 }
                             }
                             else{
                                 System.out.println("You enter wrong word on fifth word.");
                             }
                       }
                       else{
                           System.out.println("You enter wrong word on fourth word.");
                       }                          
                   }
                   else{
                       System.out.println("You enter wrong word on third word.");
                   }                 
              } 
               else{
                   System.out.println("You enter wrong word on second word.");
               }         
           }
           else{
               System.out.println("You enter wrong word on first word.");
           }
            
       }
        
       fileout.close();
        }
        catch (FileNotFoundException e) {
                    System.out.println("File does not exist or could not be found.");
                    System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
                    System.out.println("Problem reading file.");
                    System.err.println("IOException: " + e.getMessage());
    }
    
}
}