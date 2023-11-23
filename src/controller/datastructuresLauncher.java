package controller;

import model.StudentResult;
import model.Vakken;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class datastructuresLauncher {
    public static void main(String[] args) {
//        Vakken vakkenlijst = new Vakken();
        StudentResult studentResult = new StudentResult();
        studentResult.readFromFile("studentresults.txt");
//
//        vakkenlijst.readFromFile("vakcodes.txt");
//
//        vakkenlijst.printAllEntries();
//        System.out.println();
//        vakkenlijst.printAllEntriesSortedByCourseCode();
        System.out.println(studentResult.getStudentResults());

        System.out.println("Student 1000 has earned credits for: ");
        System.out.println(studentResult.getStudentResults(1000));


    } // end of main

} // end of datastructuresLauncher