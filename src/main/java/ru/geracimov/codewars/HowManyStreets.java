package ru.geracimov.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * The longest street in the world, MAX_STREET, is crossed by many other streets and driven by many drivers. Determine how many streets each driver crosses.
 * <p>
 * Inputs
 * <p>
 * (1) A list (or array, depending on language) of streets that intersect MAX_STREET. (2) A list (or array, depending on language) of drivers. Each driver is represented by a pair of streets. The first element of the pair is the street where they enter MAX_STREET; the second is the street they exit. The driver crosses all the streets between those two streets.
 * <p>
 * Output
 * <p>
 * A list (or array, depending on language) showing how many streets each driver crosses.
 * <p>
 * Example
 * <p>
 * countStreets(new String[] {"first", "second", "third", "fourth", "fifth", "sixth", "seventh"},
 * new String [][] {{"first", "second"}, {"second", "seventh"}, {"sixth", "fourth"}}) should return new String[] {0,4,1}.
 * <p>
 * Details:
 * <p>
 * (1) Each street name is a non-empty word of no more than 10 letters. There are no duplicate street names.
 * <p>
 * (2) The entry and exit streets for each driver are distinct. They are guaranteed to come from the list of streets.
 * <p>
 * (3) The number of streets n satisfies 2 ≤ n ≤ 105. The number of drivers d satisfies 1 ≤ d ≤ 105. So efficiency is important.
 * <p>
 * Source: International Collegiate Programming Contest, North Central North American Regional, 2022.
 */
public class HowManyStreets {

    public static int[] countStreets(String[] streets, String[][] drivers) {
        Map<String, Integer> indices = indices(streets);
        return getFuncResult(drivers, indices);
    }

    private static int[] getFuncResult(String[][] drivers, Map<String, Integer> indices) {
        return Arrays.stream(drivers)
                .mapToInt(path -> getLength(path, indices))
                .toArray();
    }

    private static int[] getIterResult(String[][] drivers, Map<String, Integer> indexes) {
        var result = new int[drivers.length];

        for (int i = 0; i < drivers.length; i++) {
            String[] path = drivers[i];
            result[i] = getLength(path, indexes);
        }
        return result;
    }

    private static Map<String, Integer> indices(String[] streets) {
        Map<String, Integer> indexes = new HashMap<>();
        for (int i = 0; i < streets.length; i++) {
            indexes.put(streets[i], i);
        }
        return indexes;
    }

    private static int getLength(String[] path, Map<String, Integer> indices) {
        Integer from = indices.get(path[0]);
        Integer to = indices.get(path[1]);
        return Math.abs(to - from) - 1;
    }
}
