package controller;

import model.Vakken;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class datastructuresLauncher {
    public static void main(String[] args) {
        Vakken vakkenlijst = new Vakken();

        vakkenlijst.readFromFile("vakcodes.txt");

        vakkenlijst.printAllEntries();
        System.out.println();
        vakkenlijst.printAllEntriesSortedByCourseCode();

    } // end of main

} // end of datastructuresLauncher