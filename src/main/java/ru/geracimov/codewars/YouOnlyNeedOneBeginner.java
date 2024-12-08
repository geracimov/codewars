package ru.geracimov.codewars;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You will be given an array a and a value x. All you need to do is check whether the provided array contains the value.
 * <p>
 * Array can contain numbers or strings. X can be either.
 * <p>
 * Return true if the array contains the value, false if not.
 */
public class YouOnlyNeedOneBeginner {

    public boolean solution(Object[] a, Object x) {
        Comparator<Object> f = (o1, o2) -> 0;
        Arrays.sort(a, f);
        return Arrays.binarySearch(a, x) >= 0;
    }
}
