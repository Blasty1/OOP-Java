package test.list;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

import org.junit.Test;

public class ListaTest {
    @Before
    public void prima()
    {
        System.out.println("Lesss go");
    }
    @Test
    public void test()
    {
        assertFalse("Sei un colions",false);
    }

    @After
    public void dopo()
    {
        System.out.println("Cdasds");
    }
}
