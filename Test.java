import java.util.StringTokenizer;
import java.io.*;
public class Test {
  public static void main(String args[]) throws IOException {
        // variable declaration
        int ch;
        // FileWriter writer = new FileWriter( "output.txt");
        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("C:\\Users\\SHUBAAGA\\Downloads\\output.txt");
            BufferedReader br = new BufferedReader(fr);
            StreamTokenizer st = new StreamTokenizer(br);

            boolean eof = false;
            do {
              int token = st.nextToken();
              switch(token) {
                
                case StreamTokenizer.TT_EOF:
                eof = true;
                break;
                case StreamTokenizer.TT_WORD:
                  System.out.println("word "+ st.sval);
                  break;
                default:
                System.out.println(token);
              }
            } while(eof == false);
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
  }
}
