/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalFactory;
import Animals.Animal;

/**
 *
 * @author asus
 */
public class FactoryWrapper {
     
   AnimalSimpleFactory simpleFactory;
    
   public FactoryWrapper(){
        simpleFactory = new AnimalGameFactory();
    }
    
   public FactoryWrapper(AnimalSimpleFactory simpleFactory){
        this.simpleFactory = simpleFactory;
    }
    
    public void setSimpleFactory(AnimalSimpleFactory simpleFactory){
        this.simpleFactory = simpleFactory;
    }

    public Animal getAnimal(AnimalType type){
        return simpleFactory.createCreature(type);
    }
}

