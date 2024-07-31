package com.addmethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AddMethodTest {

    private final AddMethod addMethod = new AddMethod();

    @Test
    public void shouldReturnZeroWhenInputIsEmptyString() {
        assertEquals(0, addMethod.add(""));
    }

    @Test
    public void shouldReturnZeroWhenInputIsNull() {
        assertEquals(0, addMethod.add(null));
    }

    @Test
    public void shouldReturnNumberWhenSingleNumberIsProvided() {
        assertEquals(1, addMethod.add("1"));
        assertEquals(15, addMethod.add("15"));
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersCommaSeparated() {
        assertEquals(3, addMethod.add("1,2"));
        assertEquals(8, addMethod.add("3,5"));
    }

    @Test
    public void shouldReturnSumWhenMultipleNumbersProvided() {
        assertEquals(10, addMethod.add("1,2,3,4"));
        assertEquals(6, addMethod.add("1\n2,3"));
    }

    @Test
    public void shouldReturnSumWhenNewLineIsUsedAsDelimiter() {
        assertEquals(6, addMethod.add("1\n2\n3"));
        assertEquals(10, addMethod.add("1\n2,3\n4"));
    }

    @Test
    public void shouldReturnSumWithCustomDelimiter() {
        assertEquals(3, addMethod.add("//;\n1;2"));
        assertEquals(6, addMethod.add("//.\n1.2.3"));
        assertEquals(10, addMethod.add("//[***]\n1***2***3***4"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> addMethod.add("1,-2,3,-4"));
        assertEquals("Negative numbers not allowed: [-2, -4]", thrown.getMessage());
    }

    @Test
    public void shouldReturnSumWithMultipleDelimiters() {
        assertEquals(6, addMethod.add("//[;][,]\n1;2,3"));
        assertEquals(10, addMethod.add("//[;][|]\n1;2|3|4"));
    }
}
