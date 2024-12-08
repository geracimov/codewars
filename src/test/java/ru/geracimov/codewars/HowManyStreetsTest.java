package ru.geracimov.codewars;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HowManyStreetsTest {

    @Test
    void testSimpleCases() {

        // Example from description
        final String[] streets1 = {"first", "second", "third", "fourth", "fifth", "sixth", "seven"};
        final String[][] drivers1 = {{"first", "second"}, {"second", "seven"}, {"sixth", "fourth"}};
        assertArrayEquals(new int[]{0, 4, 1}, HowManyStreets.countStreets(streets1, drivers1));

        // Bigger example
        final String[] streets2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        final String[][] drivers2 = {{"j", "a"}, {"b", "i"}, {"c", "d"}, {"e", "j"}, {"i", "g"},
                {"a", "i"}, {"f", "e"}, {"a", "j"}, {"e", "a"}, {"e", "h"}, {"h", "b"}};
        assertArrayEquals(new int[]{8, 6, 0, 4, 1, 7, 0, 8, 3, 2, 5}, HowManyStreets.countStreets(streets2, drivers2));

        // 2 streets, 1 driver
        final String[] streets3 = {"first", "second"};
        final String[][] drivers3 = {{"second", "first"}};
        assertArrayEquals(new int[]{0}, HowManyStreets.countStreets(streets3, drivers3));

        // 3 streets, 5 drivers (1 duplicate)
        final String[] streets4 = {"Drive", "DrivE", "carefully"};
        final String[][] drivers4 = {{"Drive", "DrivE"}, {"Drive", "carefully"}, {"DrivE", "Drive"},
                {"Drive", "DrivE"}, {"carefully", "Drive"}};
        assertArrayEquals(new int[]{0, 1, 0, 0, 1}, HowManyStreets.countStreets(streets4, drivers4));
    }

    @Test
        // Test efficiency of solution using scenerio where n = d = 10^5 = 100000.
    void maxTest() {
        final String[] streets = HowManyStreetsTest.generateMultipleStrings(100000, 10);
        HowManyStreetsTest.TestCase testCase = HowManyStreetsTest.generateTest(streets);

        final int[] result = HowManyStreets.countStreets(streets, testCase.drivers);
        assertArrayEquals(testCase.expected, result, "maxTest case failed");
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    public static String generateRandomString(int length) {
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        return sb.toString();
    }

    public static String[] generateMultipleStrings(int numStrings, int length) {
        final Set<String> randomStrings = new HashSet<>();
        while (randomStrings.size() < numStrings) randomStrings.add(generateRandomString(length));
        return randomStrings.toArray(new String[0]);
    }

    public static TestCase generateTest(String[] streets) {
        int size = streets.length;
        final int numberOfDrivers = 100000;
        final String[][] drivers = new String[numberOfDrivers][2];
        final int[] result = new int[numberOfDrivers];

        for (int i = 0; i < numberOfDrivers; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            if (a == b) b = (b + 1) % size; // Ensure distinct streets for each driver
            drivers[i] = new String[]{streets[a], streets[b]};
            result[i] = Math.abs(a - b) - 1;
        }

        return new TestCase(drivers, result);
    }

    public static class TestCase {
        public final String[][] drivers;
        public final int[] expected;

        public TestCase(String[][] drivers, int[] expected) {
            this.drivers = drivers;
            this.expected = expected;
        }
    }
}