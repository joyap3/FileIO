import java.io.*;

/**
 * Created by joyapuryear on 7/11/17.
 */
public class TextWriterDemo {
    public static void main(String[] args) {


        writeToFile();
        readFromFile();


        // some additional things you may want to do with this

        // make a file object that represents an existing file

        File f = new File("test.txt");

        // make a new directory
        File dir = new File("Java_June_Files");
        dir.mkdir();

        // list all contents in a directory (similar to ls command line)
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i < dirContents.length; i++) {
                System.out.println(dirContents[i]);

            }


            // get the absolute path of a file or directory
            System.out.println(dir.getAbsolutePath());

            // delete a file (return true if successful)
            boolean isDeleted = f.delete();
            System.out.println(isDeleted);
        }



    }

    private static void readFromFile() {
        // read from file
        try {
            File myFile = new File("test2.txt");

            // FileReader is a connection stream for characters that connects to a text file
            FileReader reader = new FileReader(myFile);

            // BufferedReader allows the FileReader to chain to it
            // it only goes back to check the file once the buffer is empty
            BufferedReader buff = new BufferedReader(reader);

            // declare a String variable to hold each line as it's read from the file
            String line = null;

            // this while loop says -- read a line of text and then assign it to the string line
            // while that variable is not null keep printing lines
            while ((line = buff.readLine()) != null) {
                System.out.println(line);
            }

            buff.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile() {
        // write to file
        try {

            // if the test.txt file does not exist FileWriter will create it
            //FileWriter writer1 = new FileWriter("text.txt");  -- this takes in just a file
            FileWriter writer = new FileWriter("test.txt", true);
            writer.write("\nHello World2");
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}