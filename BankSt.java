// this program calculates the total amount of
// bank transactions from a single csv file.
package bankst;

// import the related classes and methods
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.time.format.DateTimeFormatter;

// this program calculates the total amount of
// bank transactions from a single csv file.
public class BankSt
{
    // create a golobal variable for csv file path
    private static final String RESOURCE = "C:/Users/yasir/Desktop/Java Codes/BankStatement1/";
    
    // main method
    public static void main(final String... args) throws IOException
    {
        // get the csv file path and file name
        final Path path = Paths.get(RESOURCE + args[0]);
        
        // read ll lines (rows) from the CSV file
        final List<String> lines = Files.readAllLines(path);
        double total = 0d; // for total transactions
        final DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        double monthTotal = 0;
        
        // loop over the lines (rows) of the file
        for(final String line: lines)
        {
            // split the columns in each line and convert the 
            // second column to double data type
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            // parse date from the file
            final LocalDate date = LocalDate.parse(columns[0], datePattern);
            if(date.getMonth() == Month.JANUARY)
            {
                final double monthAmount = Double.parseDouble(columns[1]);
                monthTotal += monthAmount;
            }
            // increment the total amaount of the transactions
            total += amount;
        }
        
        // print the total of the transaction
        System.out.printf("The general total for all transc is $%.2f", total);
        System.out.printf("\nThe tolal for Jan: $%.2f",monthTotal);
        System.out.println();
        
    }        
    
}

