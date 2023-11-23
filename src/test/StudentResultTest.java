package test;

import model.StudentResult;
import model.Vakken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class StudentResultTest {
    private static StudentResult studentResult = new StudentResult();
    @BeforeAll
    static void initAll(){
        studentResult.readFromFile("studentresults.txt");
    }

    @Test
    @DisplayName("Student 1000 heeft 6 vakken gevolgd")
    void verifyThatStudent1000HasCompletedSixCourses(){
        Assertions.assertEquals(6, studentResult.getCompletedCoursesForStudent(1000).size());
    }

    @Test
    @DisplayName("Student 1000 heeft het correcte aantal punten behaald.")
    void verifySumOfStudent1000CourseCreditsEarned(){
        Vakken vakkenlijst = new Vakken();
        vakkenlijst.readFromFile("vakcodes.txt");

        int manualSumOfCourseCredits = 8 + 12 + 4 + 6 + 3 + 4;
        Assertions.assertEquals(manualSumOfCourseCredits, studentResult.getPointsEarnedByStudent(1000, vakkenlijst));
    }

} // end of StudentResultTest