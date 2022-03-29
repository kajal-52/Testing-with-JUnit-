package org.ibm.mockito.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)//Prepare class containing static method
public class InvokingStaticMethodTest {
    //specific JUnitRunner
    //Initialize Utility class
    //mock
    @Mock
    Dependency dependency;
    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingMock() {
        List<Integer> stats= Arrays.asList(1,2,6,7);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(16)).thenReturn(160);
        assertEquals(160,systemUnderTest.methodCallingAStaticMethod());
        PowerMockito.verifyStatic();
    }
}
