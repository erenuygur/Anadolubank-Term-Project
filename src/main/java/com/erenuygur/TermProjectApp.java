package com.erenuygur;

import com.erenuygur.util.Display;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class TermProjectApp {
    private static AbstractApplicationContext ctx = null;
    private static final Scanner KEYBOARD_INPUT = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        for (;;) {
            System.out.print("Please chose report type ->\n" +
                    "1-Comparison of policy amounts by years (Bar Chart)\n" +
                    "2-Comparison of policy amounts by years (Line Chart)\n" +
                    "3-Comparison of policy count by policy type (Pie Chart)\n" +
                    "4-Comparison of policy count by policy type (Bar Chart)\n" +
                    "5-Comparison of agents by amount (Bar Chart)\n" +
                    "E-Exit\n");
            String input = KEYBOARD_INPUT.nextLine();

            if (input.equalsIgnoreCase("E"))
                System.exit(0);

            Display.run(input);
        }
    }
}
