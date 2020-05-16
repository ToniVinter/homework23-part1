package com.fasttrackit.homeWork23part1.menu;

import com.fasttrackit.homeWork23part1.caseControll.CaseControl;
import de.vandermeer.asciitable.AsciiTable;

import java.util.Scanner;

public class ControlMenu {

    CaseControl caseControl = new CaseControl();
    Scanner scanner = new Scanner(System.in);


    public void printMenu() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("1. Get all vacations");
        at.addRule();
        at.addRow("2. Get vacation for location");
        at.addRule();
        at.addRow("3. Get Vacation for max price");
        at.addRule();
        at.addRow("4. Add Vacation");
        at.addRule();
        at.addRow("5. Delete a vacation by ID");
        at.addRule();
        at.addRow("6. Update a vacation");
        at.addRule();
        at.addRow("7. Exit ");
        at.addRule();
        String rend = at.render();
        System.out.println(rend);

    }

    public void setOption() {
        var option = 0;
        do {
            printMenu();
            System.out.print("Select Option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    caseControl.case1();
                    break;
                case 2:
                    caseControl.case2();
                    break;
                case 3:
                    caseControl.case3();
                    break;
                case 4:
                    caseControl.case4();
                    break;
                case 5:
                    caseControl.case5();
                    break;
                case 6:
                    caseControl.case6();
                    break;
                default:
                    option = 7;
                    break;
            }
        } while (option != 7);
    }
}
