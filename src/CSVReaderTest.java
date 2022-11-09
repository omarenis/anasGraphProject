import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderTest {
    public static final String delimiter = ",";
    public static List<List<Integer>> read(String csvFile) {
        List<List<Integer>> output = new ArrayList<>();
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            int i= 0;
            while((line = br.readLine()) != null) {
                output.add(new ArrayList<>());
                tempArr = line.split(delimiter);
                for(String tempStr : tempArr) {
                    if(!tempStr.equals(""))
                    {
                        output.get(i).add(Integer.parseInt(tempStr));
                    }
                }
                i++;
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return output;
    }
    public static void main(String[] args) {
        // csv file to read
        String csvFile = "data.csv";
        System.out.println(CSVReaderTest.read(csvFile));
    }
}
