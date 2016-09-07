
package AnimalFactory;

import Animals.Animal;

public class FactoryWrapper {

	AnimalSimpleFactory simpleFactory;

	public FactoryWrapper() {
		simpleFactory = new AnimalGameFactory();
	}

	public FactoryWrapper(AnimalSimpleFactory simpleFactory) {
		this.simpleFactory = simpleFactory;
	}

	public void setSimpleFactory(AnimalSimpleFactory simpleFactory) {
		this.simpleFactory = simpleFactory;
	}

	public Animal getAnimal(AnimalType type) {
		return simpleFactory.createCreature(type);
	}
}
