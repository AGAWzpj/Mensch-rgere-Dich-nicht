/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asus
 */
public class OwlTest {
    
    public OwlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFlying() {
        System.out.println("walkies");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.fly();
        String expectedResult = "Flying";
        String result = instance.getStatus();
        assertEquals(expectedResult, result);
    }


   

    /**
     * Test of feeding method, of class Owl.
     */
    @Test
    public void testFeeding() {
        System.out.println("feeding");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.feeding();
        String expectedResult = "Feeding";
        String result = instance.getStatus();
        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of getseed method, of class Owl.
     */
    @Test
    public void testGetMouse() {
        System.out.println("getMouse");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        int expResult = 0;
        int result = instance.getSeed();
        assertEquals(expResult, result);
    }

        /**
     * Test of addseed method, of class Owl.
     */
    @Test
    public void testAddMouse() {
        System.out.println("addBone");
        int par1 = 1;
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.addSeed(par1);
        int expectedResult = 1;
        int result = instance.getSeed();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of decseed method, of class Owl.
     */
    @Test
    public void testDecBone() {
        System.out.println("decBone");
        int par1 = 3;
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.addSeed(par1);
        instance.decSeed(1);
        int expectedResult = 2;
        int result = instance.getSeed();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of life method, of class Owl.
     */
    @Test
    public void testLife() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.setBobbing(50);
        Image result = instance.getAnimalPicture();
        Image expectedResult = new ImageIcon(this.getClass().getResource("/Animals/owl.png")).getImage();
        assertEquals(expectedResult, result);
    }    
   
     
    
      @Test
    public void testLife2() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setPower(10);
        instance.life();
        boolean expectedResult = true;
        boolean result = instance.getSleepiness();
        assertEquals(expectedResult, result);
    }
    
      @Test
    public void testLife3() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.setEating(70);
        instance.life();
        int expectedResult = 3;
        int result = instance.getHappiness();
        assertEquals(expectedResult, result);
        
    }
    
      @Test
    public void testLife4() {
            System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.setEating(90);
        instance.life();
        int expectedResult = 4;
        int result = instance.getHappiness();
        assertEquals(expectedResult, result);
    }
     @Test
    public void testLife5() {
            System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.setEating(40);
        instance.life();
        int expectedResult = 2;
        int result = instance.getHappiness();
        assertEquals(expectedResult, result);
    }

     @Test
    public void testLife6() {
            System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.setEating(10);
        instance.life();
        int expectedResult = 1;
        int result = instance.getHappiness();
        assertEquals(expectedResult, result);
    }
    
    
      @Test
    public void testLife7() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setPower(40);
        instance.life();
        boolean expectedResult = false;
        boolean result = instance.getSleepiness();
        assertEquals(expectedResult, result);
    }
    
      @Test
    public void testLife8() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setEating(-3);
        instance.life();
        int expectedResult = 0;
        int result = instance.getEating();
        assertEquals(expectedResult, result);
    }
     
      @Test
    public void testLife9() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setEating(103);
        instance.life();
        int expectedResult = 100;
        int result = instance.getEating();
        assertEquals(expectedResult, result);
    }
    
    
      @Test
    public void testLife10() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setPower(-3);
        instance.life();
        int expectedResult = 0;
        int result = instance.getPower();
        assertEquals(expectedResult, result);
    }
     
      @Test
    public void testLife11() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setPower(103);
        instance.life();
        int expectedResult = 100;
        int result = instance.getPower();
        assertEquals(expectedResult, result);
    }
    
     
      @Test
    public void testLife12() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setStatus("Playing");
        instance.life();
        double expectedResult = 6.7;
        double result = instance.getY();
        assertEquals(expectedResult, result, 0.01);
    }
    
      @Test
    public void testLife13() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setStatus("Hunting");
        instance.stage = 1;
        instance.life();
        double expectedResult = 4.5;
        double result = instance.getX();
        assertEquals(expectedResult, result, 0.01);
    }
    
    @Test
    public void testLife14() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setX(1000);
        instance.life();
        double expectedResult = 1000;
        double result = instance.getX();
        assertEquals(expectedResult, result, 0.01);
    }
    
    @Test
    public void testLife15() {
        System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);        
        instance.setX(335);
        instance.life();
        double expectedResult = 335;
        double result = instance.getX();
        assertEquals(expectedResult, result, 0.01);
    }
    @Test
    public void testLife16() {
     System.out.println("life");
        Owl instance = new Owl(4.5,6.7,"owl.png",true);
        instance.setPower(0);
        instance.life();
        String expectedResult = "Dead";
        String result = instance.getStatus();
        assertEquals(expectedResult, result);
    }  
    
}

    

