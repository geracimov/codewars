package ru.geracimov.codewars;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

    @NullAndEmptySource
    @ParameterizedTest
    void isBlank_ShouldReturnTrueForNullInputs(String parens) {
        assertTrue(ValidParentheses.validParentheses(parens));
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    void validParentheses(Map.Entry<String, Boolean> parameter) {
        assertEquals(parameter.getValue(), ValidParentheses.validParentheses(parameter.getKey()));
    }

    private static Stream<Map.Entry<String, Boolean>> getParameters() {
        return Stream.of(
                new AbstractMap.SimpleEntry<>("()()((()", false),
                new AbstractMap.SimpleEntry<>("()", true),
                new AbstractMap.SimpleEntry<>("()()", true),
                new AbstractMap.SimpleEntry<>("(())", true),
                new AbstractMap.SimpleEntry<>(")", false),
                new AbstractMap.SimpleEntry<>("())", false),
                new AbstractMap.SimpleEntry<>("((((()))))", true),
                new AbstractMap.SimpleEntry<>("()))", false),
                new AbstractMap.SimpleEntry<>("()()()())", false),
                new AbstractMap.SimpleEntry<>("(()()()())(())", true),
                new AbstractMap.SimpleEntry<>("((((((((", false),
                new AbstractMap.SimpleEntry<>("(())((()((()))))", true),
                new AbstractMap.SimpleEntry<>("())(", false),
                new AbstractMap.SimpleEntry<>(")()()()(", false),
                new AbstractMap.SimpleEntry<>("(()()))(", false),
                new AbstractMap.SimpleEntry<>(")()(", false),
                new AbstractMap.SimpleEntry<>("())(()", false),
                new AbstractMap.SimpleEntry<>("())(()", false),
                new AbstractMap.SimpleEntry<>("someText", true),
                new AbstractMap.SimpleEntry<>("()AnotherText#*)AND_MORE((AND_MORE*$YGSg49)", false));
    }

}