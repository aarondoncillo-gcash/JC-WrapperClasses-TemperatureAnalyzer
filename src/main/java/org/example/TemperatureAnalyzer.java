package org.example;

import java.util.Scanner;

public class TemperatureAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Get Input
        System.out.print("Enter Day 1 High Temperature (e.g., 28.5): ");
        String day1TempStr = sc.nextLine();
        System.out.print("Enter Day 2 High Temperature (e.g., 28.5): ");
        String day2TempStr = sc.nextLine();
        System.out.print("Enter Day 3 High Temperature (e.g., 28.5): ");
        String day3TempStr = sc.nextLine();

        double day1TempPrimitive = 0, day2TempPrimitive = 0, day3TempPrimitive = 0;
        //Parse Strings to Primitives. End program if input is invalid
        try {
            day1TempPrimitive = Double.parseDouble(day1TempStr);
        } catch (NumberFormatException nfe) {
            System.err.println("Day 1 input is not a valid temperature! Exiting program...\n");
            System.exit(0);
        }
        try {
            day2TempPrimitive = Double.parseDouble(day2TempStr);
        } catch (NumberFormatException nfe) {
            System.err.println("Day 2 input is not a valid temperature! Exiting program...\n");
            System.exit(0);
        }
        try {
            day3TempPrimitive = Double.parseDouble(day3TempStr);
        } catch (NumberFormatException nfe) {
            System.err.println("Day 3 input is not a valid temperature! Exiting program...\n");
            System.exit(0);
        }
        System.out.println("\n--- Temperature Analysis ---\n");
        System.out.println("Parsed Day 1 Temp (primitive double): " + day1TempPrimitive);
        System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);

        //Convert Primitives to Wrappers
        Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
        Double day2TempWrapper = Double.valueOf(day2TempPrimitive);
        Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

        //Compare Wrapper Objects. Comparison of day 1 and day 2 temperatures
        int comparisonResult = day1TempWrapper.compareTo(day2TempWrapper);
        switch (comparisonResult) {
            case 1:
                System.out.println("\nDay 1 (" + day1TempWrapper + "°C) was warmer than Day 2 (" + day2TempWrapper + "°C).\n");
                break;
            case -1:
                System.out.println("\nDay 1 (" + day1TempWrapper + "°C) was cooler than Day 2 (" + day2TempWrapper + "°C).\n");
                break;
            case 0:
                System.out.println("\nDay 1 (" + day1TempWrapper + "°C) has the same temperature as Day 2 (" + day2TempWrapper + "°C).\n");
                break;
        }

        // Extract Primitive Values
        float day1TempFloat = day1TempWrapper.floatValue();
        int day2TempInt = day2TempWrapper.intValue();
        System.out.println("Extracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
        System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2TempInt);

        // Find the maximum temperature among day1TempWrapper, day2TempWrapper, and day3TempWrapper
        System.out.println("\nThe highest temperature recorded was: " + Double.max(Double.max(day1TempWrapper, day2TempWrapper), day3TempWrapper) + "°C");
    }
}