package org.ibm.mockito.business;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void letsMockListSizeMethod(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3,listMock.size());
    }
    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(2);
        assertEquals(3,listMock.size());
        assertEquals(2,listMock.size());
    }
    @Test
    public void letsMockListGetMethod_OutputForIndex0(){
        List listMock=mock(List.class);
        when(listMock.get(0)).thenReturn("Spring Tutorial");
        assertEquals("Spring Tutorial",listMock.get(0));
        assertEquals(null,listMock.get(4));
    }
    @Test
    public void letsMockListGetMethod_OutputIrrespectiveOfIndex(){
        List listMock=mock(List.class);
        //Argument Matchers anyInt for accepting any integer as parameter
        when(listMock.get(anyInt())).thenReturn("Spring Tutorial");
        assertEquals("Spring Tutorial",listMock.get(0));
        assertEquals("Spring Tutorial",listMock.get(4));
    }
    @Test(expected = RuntimeException.class)
    public void letsMockListGetMethod_ThrowAnException(){
        List listMock=mock(List.class);
        //Argument Matchers
        when(listMock.get(0)).thenThrow(new RuntimeException("An Exception is thrown"));
        listMock.get(0);
    }
    @Test(expected = RuntimeException.class)
    public void letsMockListGetMethod_mixingup(){
        List listMock=mock(List.class);
        //Argument Matchers
        when(listMock.subList(anyInt(),5)).thenThrow(new RuntimeException("An Exception is thrown"));
        listMock.subList(1,5);
    }
    @Test
    public void letsMockListGetMethod_UsingBddMock(){
        List listMock=mock(List.class);
        given(listMock.get(0)).willReturn("Spring Tutorial");
        assertThat(listMock.get(0),is("Spring Tutorial"));
    }



}
