package model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class Vakken {
    private Map<String, Integer> courseCredits = new HashMap<>();

    public void readFromFile(String filename) {
        Path filepath = Path.of(String.format("src/resources/%s", filename));
        try (Scanner inputFile = new Scanner(filepath)){
            while (inputFile.hasNextLine()){
                String line = inputFile.nextLine();
                String[] lineParts = line.split("\\s");
                courseCredits.put(lineParts[0], Integer.parseInt(lineParts[1]));
            }
        } catch (IOException e){
            System.err.println("File not found at this location.");
        }

    }

    public Map<String,Integer> getCourseCredits(){
        return courseCredits;
    }

    public Set<String> getAllCourseCodes(){
        return courseCredits.keySet();
    }

    public List<Integer> getAllCourseCredits(){
        Collection<Integer> creditsCollection = courseCredits.values();
        List<Integer> creditsList = new ArrayList<>();
        creditsList.addAll(creditsCollection);
        return creditsList;
    }

    public int sumAllCredits(){
        Collection<Integer> creditsCollection = courseCredits.values();
        int sum = 0;
        for (Integer credit : creditsCollection) {
            sum += credit;
        }
        return sum;
    }

    public void printAllEntries(){
        Set<Map.Entry<String,Integer>> entries = courseCredits.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("The course %s is worth %d credits.\n", entry.getKey(), entry.getValue());
        }
    }

    public void printAllEntriesSortedByCourseCode(){
        Set<String> keys = courseCredits.keySet();
        Object[] keysArray = keys.toArray();
        Arrays.sort(keysArray);

        for (Object o : keysArray) {
            System.out.printf("The course %s is worth %d credits.\n", o, courseCredits.get(o));
        }

    }
} // end of Vakken