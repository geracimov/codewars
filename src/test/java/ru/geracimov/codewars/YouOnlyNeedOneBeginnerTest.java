package ru.geracimov.codewars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YouOnlyNeedOneBeginnerTest {
    YouOnlyNeedOneBeginner clazz;

    @BeforeEach
    void setUp() {
        clazz = new YouOnlyNeedOneBeginner();

    }

    @Test
    void solution() {

        Object[] objects = new Object[]{1, 2, "2"};


        assertEquals(true, clazz.solution(objects, (Integer )3) );

    }
}