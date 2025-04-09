import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CSVDelegate {

    public static final String TEST_FILE = "C:\\Users\\Jason\\Desktop\\test.txt";
    public static final String CSV_DELIMITER = ";";
    private static final int INDEX_NAME = 0;
    private static final int INDEX_SERIES = 1;
    private static final int INDEX_SCORE = 2;
    private static final int INDEX_COMMENT = 3;

    public static List<Seltzer> getFileContents(){

        final List<Seltzer> seltzers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TEST_FILE))){
            String headerRow = bufferedReader.readLine();
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                String[] rowData = row.split(CSV_DELIMITER);
                Seltzer seltzer = new Seltzer(rowData[INDEX_NAME], Seltzer.Series.getEnumByDescription(rowData[INDEX_SERIES]),
                                              BigDecimal.valueOf(Double.parseDouble(rowData[INDEX_SCORE])), rowData[INDEX_COMMENT]);
                seltzers.add(seltzer);
                }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return seltzers;
    }

    public static void updateFileContents(){
        List<Seltzer> seltzerList = getFileContents();
        System.out.println("Here are the file contents:");
        seltzerList.forEach(System.out::println);

        System.out.println("Please select which Seltzer you would like to edit.");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        System.out.println(inputName);

//        Optional<Seltzer> seltzer = seltzerList.stream().filter(s -> s.getName().equalsIgnoreCase(inputName)).findFirst();
//        int index = seltzer
//        System.out.println(index);

        int index = 0;
        for (final Seltzer s : seltzerList){
            if (s.getName().equalsIgnoreCase(inputName)){
                System.out.println("Success!");
                break;
            }
            index++;
        }

        System.out.println("Update the comment:");
        String updatedComment = scanner.nextLine();
            seltzerList.get(index).setComment(updatedComment);

        doWriteUpdate(seltzerList);
        getFileContents().forEach(System.out::println);
    }

    public static void doWriteUpdate(List<Seltzer> p_seltzerList){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TEST_FILE))){
//            bufferedWriter.write(TestData.HEADER_ROW);
//            bufferedWriter.newLine();
            for (final Seltzer s : p_seltzerList) {
                bufferedWriter.write(s.toCSVFormattedString());
                bufferedWriter.newLine();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void doTestWriting(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TEST_FILE))){
//            bufferedWriter.write(TestData.HEADER_ROW);
//            bufferedWriter.newLine();
            for (final Seltzer s : TestData.lstSeltzer) {
                bufferedWriter.write(s.toCSVFormattedString());
                bufferedWriter.newLine();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
