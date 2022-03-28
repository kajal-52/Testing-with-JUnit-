package org.ibm.mockito.business;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestMatcherTest {

    @Test
    public void testList_WithHamcrestMatchers(){
        List<String> list= Arrays.asList("Red","Blue","Green","Yellow");
        //list has 4 items
        assertThat(list,hasSize(4));
        assertThat(list,hasItems("Blue","Green"));

        //String
        assertThat("",isEmptyString()); //hamcrest version 1.3
        assertThat(null, isEmptyOrNullString());
        //Arrays
        Integer[] array={2, 4, 5, 6};
        assertThat(array,arrayWithSize(4));
        assertThat(array,arrayContaining(2,4,5,6));
        assertThat(array,arrayContainingInAnyOrder(6,4,5,2));
    }
}
