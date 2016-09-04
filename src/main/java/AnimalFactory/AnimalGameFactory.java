
package AnimalFactory;

import Animals.Cat;
import Animals.Owl;
import Animals.Dog;
import Animals.Animal;


public class AnimalGameFactory implements AnimalSimpleFactory{
    @Override
	public Animal createCreature(AnimalType type) {
		Animal anim=null;
		switch(type){
		case Dog:
			anim=new Dog(340, 375, "wufa_a.png", true);
			break;
		case Owl:
			anim=new Owl(340, 375, "tweta_a.png", true);
			break;
                case Cat:
			anim=new Cat(340, 375, "cat.png", true);
			break;
		}
		return anim;
	}
}
