package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {
    private final String gender;
    private final boolean expected;

    public LionTest (String gender, Boolean expected){
       this.gender = gender;
       this.expected = expected;
    }
    @Mock
    Feline feline;

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }


    @Parameterized.Parameters
public static Object [][] getGender () {
        return new Object [][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void getKittensTest() throws  Exception{
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(gender, feline);
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("one", "two", "three"));
        var lion = new Lion(gender, feline);
        assertEquals(List.of("one", "two", "three"), lion.getFood());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        var lion = new Lion("Самец", feline);
        assertEquals(true, lion.doesHaveMane());
    }


}