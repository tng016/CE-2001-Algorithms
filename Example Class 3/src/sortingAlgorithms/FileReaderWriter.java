package sortingAlgorithms;
import java.io.*;
public class FileReaderWriter {

   public static void writeFile(String fileName, int n) throws IOException{
      File file = new File(fileName);
      
      // creates the file
      file.createNewFile();
      
      // creates a FileWriter Object
      FileWriter writer = new FileWriter(file); 
      
      //number of elements in array
      //int n = 10000;

      // Random NRIC generator
      for (int i=0;i<n;i++){ 
      	String c = Integer.toString((int)(Math.random() * n));
      	//String c = Integer.toString(i);
      	//String c = Integer.toString(n-i);
      	writer.write(c + "\n");
      	writer.flush();
      }
      writer.close();
   }

   public static int[] readFile(String fileName) throws IOException,FileNotFoundException{
      int size = 0;
      // Get the number of lines in the file 
      try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
          String line;
          while ((line = br.readLine()) != null) {
              size++;
          }
      }/* catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }*/
      
      // Store numbers in array
      int elements[] = new int[size];
      try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
          String line;
          int i = 0;
          while ((line = br.readLine()) != null) {
              elements[i] = Integer.parseInt(line);
              i++;
          }
      }/* catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }*/
      return elements;
   }
}
