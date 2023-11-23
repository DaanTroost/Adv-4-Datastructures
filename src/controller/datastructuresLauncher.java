package controller;

import model.StudentResult;
import model.Vakken;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class datastructuresLauncher {
    public static void main(String[] args) {
        Vakken vakkenlijst = new Vakken();
        vakkenlijst.readFromFile("vakcodes.txt");

        StudentResult studentResult = new StudentResult();
        studentResult.readFromFile("studentresults.txt");

        System.out.println("Student 1000 has earned credits for the courses: ");
        System.out.println(studentResult.getCompletedCoursesForStudent(1000));

        System.out.printf("Student 1000 has earned %d credits for these courses.",
                studentResult.getPointsEarnedByStudent(1000, vakkenlijst));

        Set<Integer> studentList = studentResult.getStudentNumbers();

        for (Integer studentNumber : studentList) {
            List<String> completedCourses = studentResult.getCompletedCoursesForStudent(studentNumber);
            Map<String, Integer> creditsPerCourse = vakkenlijst.getCourseCredits();
            int earnedCredits = studentResult.getPointsEarnedByStudent(studentNumber, vakkenlijst);
            for (String completedCourse : completedCourses) {
                System.out.printf("Student %d has completed the course %s, worth %2d credits.\n",
                        studentNumber,
                        completedCourse,
                        creditsPerCourse.get(completedCourse)
                        );
            }
            System.out.printf("Student %d has completed %3d courses, worth %2d points.\n",
                    studentNumber,
                    completedCourses.size(),
                    earnedCredits
                    );
            System.out.println("-------------------------------------------------------------\n");
        }


    } // end of main

} // end of datastructuresLauncher