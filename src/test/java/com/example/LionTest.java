package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getFoodTest() throws Exception {

        Lion lion = new Lion(feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void doesHaveManeTestTrue() throws Exception {
        Lion lion = new Lion("Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeExceptionTest() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Оно");
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void doesHaveManeTestFalse() throws Exception {
        Lion lion = new Lion("Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }


}