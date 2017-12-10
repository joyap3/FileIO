import java.io.*;

/**
 * Created by joyapuryear on 7/11/17.
 */
public class FileIOApp {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Ford");
        car.setMileage(3);
        System.out.println(car);


        //this sections is writing to a file
        writeToFile(car);
        readFromFile();


    }

    private static void readFromFile() {
        // this section is reading from the file
        // here if the file that we're trying to read from does not exist
        // we're going to get an exception
        try {
            ObjectInputStream is = new ObjectInputStream((new FileInputStream("testWrite.ser")));
            Car carRestore = (Car) is.readObject();
            System.out.println("type: " + carRestore.getClass() + " " + carRestore);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(Car car) {
        try {
            //FILEOUTPUTSTREAM Knows how to connect and create a file
            //if the file being passed in as a parameter does not exist it creates one automatically
            FileOutputStream filestream = new FileOutputStream("testWrite.ser");

            //OBJECTOUTPUTSTREAM is a class that lets you write objects but it cant
            // directly connect to the file(needs a helper fileStream)
            //this is also called chaining
            ObjectOutputStream os = new ObjectOutputStream(filestream);

            //this method serializes the object
            os.writeObject(car);

            //close the stream - closes all other streams as well
            os.close();

        } catch (FileNotFoundException e) {
            System.out.println("Hey your file was not found contact 800.333.1234");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}