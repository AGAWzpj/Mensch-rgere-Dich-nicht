/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalFactory;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Owl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author asus
 */
@RunWith(MockitoJUnitRunner.class) 
public class FactoryWrapperTest {
    @Mock
    AnimalSimpleFactory mock;
    
    FactoryWrapper fw;
    
    public FactoryWrapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         fw = new FactoryWrapper(mock);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSimpleFactory method, of class FactoryWrapper.
     */
   // @Test
  /*  public void testSetSimpleFactory() {
        System.out.println("setSimpleFactory");
        AnimalSimpleFactory simpleFactory = null;
        FactoryWrapper instance = new FactoryWrapper();
        instance.setSimpleFactory(simpleFactory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getAnimal method, of class FactoryWrapper.
     */
    
    @Test
    public void testGetAnimal() {
        System.out.println("getAnimal");
        Animal expResult = new Cat(1, 2, "cat.png", false);

        //zdefiniowanie zachowania mocka, tak, zeby zwracal zawsze podany obiekt przy wywolaniu tej metody
        Mockito.when(mock.createCreature(Matchers.any(AnimalType.class))).thenReturn(expResult);

        AnimalType type = AnimalType.Cat;
        Animal result = fw.getAnimal(type);
        assertEquals(expResult, result);

        //sprawdzanie czy metoda zostala wywolana dokladnie raz z parametrem AnimalType.Cat
        Mockito.verify(mock, Mockito.times(1)).createCreature(AnimalType.Cat);
    }
    
    @Test
    public void testGetAnimal1() {
        System.out.println("getAnimal");
        Animal expResult = new Dog(1, 2, "dog.png", false);

        Mockito.when(mock.createCreature(Matchers.any(AnimalType.class))).thenReturn(expResult);

        AnimalType type = AnimalType.Dog;
        Animal result = fw.getAnimal(type);
        assertEquals(expResult, result);

        Mockito.verify(mock, Mockito.times(1)).createCreature(AnimalType.Dog);
    }
    
    @Test
    public void testGetAnimal2() {
        System.out.println("getAnimal");
        Animal expResult = new Owl(1, 2, "owl.png", false);

        Mockito.when(mock.createCreature(Matchers.any(AnimalType.class))).thenReturn(expResult);

        AnimalType type = AnimalType.Owl;
        Animal result = fw.getAnimal(type);
        assertEquals(expResult, result);

        Mockito.verify(mock, Mockito.times(1)).createCreature(AnimalType.Owl);
    }
}
