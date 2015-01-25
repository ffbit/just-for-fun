package com.ffbit.fun.list;

import com.ffbit.fun.list.AddTwoNumbers.ListNode;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class AddTwoNumbersTest {
    private AddTwoNumbers calculator = new AddTwoNumbers();

    @Test
    public void itShouldAddNumbersOfSameLengthWithoutGreatestDigitCarrying() {
        ListNode firstNumber =
                new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode secondNumber =
                new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode expectedSum =
                new ListNode(7, new ListNode(0, new ListNode(8)));

        ListNode sum = calculator.sum(firstNumber, secondNumber);

        assertThat("sum must not be null", sum, is(notNullValue()));
        assertThat(sum.toString(), is(expectedSum.toString()));
    }

    @Test
    public void itShouldAddNumbersOfSameLengthWithGreatestDigitCarrying() {
        ListNode firstNumber = new ListNode(6);
        ListNode secondNumber = new ListNode(7);

        ListNode expectedSum = new ListNode(3, new ListNode(1));

        ListNode sum = calculator.sum(firstNumber, secondNumber);

        assertThat("sum must not be null", sum, is(notNullValue()));
        assertThat(sum.toString(), is(expectedSum.toString()));
    }

    @Test
    public void itShouldAddNumbersOfDifferentLength() {
        ListNode firstNumber = new ListNode(1, new ListNode(2));
        ListNode secondNumber = new ListNode(3);

        ListNode expectedSum = new ListNode(4, new ListNode(2));

        ListNode sum = calculator.sum(firstNumber, secondNumber);

        assertThat("sum must not be null", sum, is(notNullValue()));
        assertThat(sum.toString(), is(expectedSum.toString()));
    }

}
