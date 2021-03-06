package org.ibm.mockito.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class InvokingPrivateMethodTest {
    //specific JUnitRunner
    //Initialize Utility class
    //mock
    @Mock
    Dependency dependency;
    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingMock() throws Exception {
        List<Integer> stats= Arrays.asList(1,2,6,7);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        long result = Whitebox.invokeMethod(systemUnderTest,"privateMethodUnderTest");
        assertEquals(16,result);
    }
}
