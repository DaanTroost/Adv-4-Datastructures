package model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class StudentResult {
    private Map<Integer, List<String>> studentResults = new HashMap<>();
    private Vakken vakkenLijst = new Vakken();
    public void readFromFile(String filename) {
        Path filepath = Path.of(String.format("src/resources/%s", filename));

        try (Scanner inputFile = new Scanner(filepath)){
            while (inputFile.hasNextLine()){
                String line = inputFile.nextLine();
                String[] lineParts = line.split("\\s+");
                int studentNumber = Integer.parseInt(lineParts[0]);
                String courseCode = lineParts[1];
                if (!studentResults.containsKey(studentNumber)) {
                    studentResults.put(studentNumber, new ArrayList<>());
                }
                studentResults.get(studentNumber).add(courseCode);
            }
        } catch (IOException e){
            System.err.println("File not found at this location.");
        }

    }

    public Set<Integer> getStudentNumbers(){
        return studentResults.keySet();
    }

    public Map<Integer,List<String>> getStudentResults(){
        return studentResults;
    }

    public List<String> getCompletedCoursesForStudent(int studentNumber){
        return studentResults.get(studentNumber);
    }

    public int getPointsEarnedByStudent(int studentNumber, Vakken vakkenLijst){
        int pointsEarned = 0;
        Map<String, Integer> creditsPerCourse = vakkenLijst.getCourseCredits();
        List<String> completedCourses = getCompletedCoursesForStudent(studentNumber);

        for (String course : completedCourses) {
            pointsEarned += creditsPerCourse.get(course);
        }
        return pointsEarned;
    }
} // end of StudentResult