package test;

import model.Vakken;
import org.junit.jupiter.api.*;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class VakkenTest {
    private static Vakken vakkenLijst = new Vakken();

    @BeforeAll
    static void initAll(){
        vakkenLijst.readFromFile("vakcodes.txt");
    }

    @Test
    @DisplayName("Course CS101, worth 6 credits, is in the list.")
    void verifyPresenceOfCourseCS101WithItsAppropriateCredits(){
        Assertions.assertTrue(vakkenLijst.getCourseCredits().containsKey("CS101"));
        Assertions.assertEquals(6, vakkenLijst.getCourseCredits().get("CS101"));
    }

    @Test
    @DisplayName("Course CS999 is not in the list.")
    void verifyAbsenceOfCourseCS999(){
        Assertions.assertFalse(vakkenLijst.getCourseCredits().containsKey("CS999"));
    }

    @Test
    @DisplayName("There is a course worth exactly 10 credits.")
    void verifyPresenceOfACourseWorth10Credits(){
        Assertions.assertTrue(vakkenLijst.getCourseCredits().containsValue(10));
    }

    @Test
    @DisplayName("All credits values are indeed added to the returned List")
    void returnAListOfCreditValues(){
        Assertions.assertEquals(vakkenLijst.getAllCourseCredits().size(), vakkenLijst.getCourseCredits().values().size());
    }

    @Test
    @DisplayName("The sum of all credits is, in fact, the sum of all credits.")
    void sumOfAllCreditsMatchesTheSumOfValues(){
        int sumOfAllCredits = 6 + 8 + 4 + 6 + 3 + 10 + 12 + 8 + 4 + 2 + 12 + 9 + 5;
        Assertions.assertEquals(sumOfAllCredits, vakkenLijst.sumAllCredits());
    }



} // end of VakkenTest