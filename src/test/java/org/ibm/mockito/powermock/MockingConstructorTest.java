package org.ibm.mockito.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//Mocking constructor for Arraylist class
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class) //To be able to mock the Constructor, we need to add in the Class that creates the new object*/})
public class MockingConstructorTest {
    //PrepareForTest =>SystemUnderTest.class
    //Override the constructor

    @Mock
    ArrayList mockList;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testConstructorForArrayList() throws Exception {
        List<Integer> stats= Arrays.asList(1,2,6,7);
        when(mockList.size()).thenReturn(8);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
        int size = systemUnderTest.methodUsingAnArrayListConstructor();
        assertEquals(8,size);
    }
}
