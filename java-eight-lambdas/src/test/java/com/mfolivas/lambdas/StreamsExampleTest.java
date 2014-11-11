package com.mfolivas.lambdas;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.hamcrest.Matcher;
import org.junit.Test;

public class StreamsExampleTest {

  @Test
  public void shouldReturnDifferentMathAggregations() {
    int [] values = {3,10,6,1,4,8,2,5,9,7};
    //Display all the values
    IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
    assertThat(values.length, is(10));

    //Count all values
    assertThat(IntStream.of(values).sum(), is(55));
    assertThat(IntStream.of(values).min().getAsInt(), is(1));

    int [] noValues = {};
    assertThat(IntStream.of(noValues).min().orElse(-1), is(-1));


    assertThat(IntStream.of(values).average().getAsDouble(), is(5.5));

    //Sum via reduce - fold (Scala)
    assertThat(IntStream.of(values).reduce(0, (x, y) -> x + y), is(55));

    //Product of values
    assertThat(IntStream.of(values).reduce(1, (x, y) -> x * y), is(3628800));

    //Sum of squares
    assertThat(IntStream.of(values).reduce(0, (x, y) -> x + y * y), is(385));

    //Even values displayed in sorted order
    System.out.printf("%nEven values displayed in sorted order: ");
    IntStream.of(values)
        .filter(value -> value % 2 == 0)
        .sorted()
        .forEach(value -> System.out.printf("%d ", value));

    //Odd values multiplied by 10
    System.out.printf("%nOdd values multiplied by 10 displayed in sorted order: ");
    IntStream.of(values)
        .filter(value -> value % 2 != 0)
        .map(value -> value * 10)
        .sorted()
        .forEach(value -> System.out.printf("%d ", value));

    //Sum range integers from 1 to 10, exclusive - not including the second element (10)
    assertThat(IntStream.range(1, 10).sum(), is(45));
    //Sum range integers from 1 to 10, inclusive. Include first and second argument
    assertThat(IntStream.rangeClosed(1, 10).sum(), is(55));

  }

  @Test
  public void shouldReturnStreamArrayAndMathAggregation() {
    Integer [] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};
    assertThat(Arrays.asList(values).toString(),
               is("[2, 9, 5, 0, 3, 7, 1, 4, 8, 6]"));
    assertThat(Arrays.stream(values).sorted().collect(Collectors.toList()).toString(),
               is("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"));

    //Greater than four
    List<Integer> greaterThanFour = Arrays.stream(values)
        .filter(value -> value > 4)
        .collect(Collectors.toList());

    assertThat(greaterThanFour.toString(), is("[9, 5, 7, 8, 6]"));
    assertThat(Arrays.stream(values)
                   .filter(value -> value > 4)
                   .sorted()
                   .collect(Collectors.toList()).toString(),
               is("[5, 6, 7, 8, 9]"));
    assertThat(greaterThanFour.stream()
                   .sorted()
                   .collect(Collectors.toList()).toString(),
               is("[5, 6, 7, 8, 9]"));

  }

  @Test
  public void shouldValidateStream() {
    String [] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
    List<String> upperCaseList =
        Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList());
    assertThat(upperCaseList, hasItems("RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "INDIGO",
                                       "VIOLET"));

    List<String>
        sortedList = Arrays.stream(strings)
        .filter(s -> s.compareToIgnoreCase("n") < 0)
        .sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
    String [] shouldBeSortedAsSuch = {"Blue", "green", "indigo"};
    assertThat(sortedList, is(Arrays.asList(shouldBeSortedAsSuch)));
  }

  @Test
  public void collectEveryWordAndMakeItUpperCase() {
    String [] words = {"a", "b", "hello"};
    List<String> test = Arrays.asList(words);
    List<String> listOfWordSizes = test.stream().map(word -> word.toUpperCase()).collect(Collectors.toList());
    assertThat(listOfWordSizes, hasItems("A", "B", "HELLO"));

  }
}