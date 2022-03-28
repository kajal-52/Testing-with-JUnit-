package org.ibm.mockito.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void testWithMock(){
        List arrayListMock=mock(ArrayList.class);
        assertEquals(0,arrayListMock.size());
        //mock return default value
        arrayListMock.add("Data0");
        stub(arrayListMock.size()).toReturn(5);
        assertEquals(5, arrayListMock.size());

    }
    @Test
    public void testWithSpy(){
        List arrayListSpy=spy(ArrayList.class);
        assertEquals(0,arrayListSpy.size());
        //mock return default value
        arrayListSpy.add("Data0");
        verify(arrayListSpy).add("Data0");
        assertEquals(1,arrayListSpy.size());
        arrayListSpy.remove("Data0");
        assertEquals(0, arrayListSpy.size());

    }
}
