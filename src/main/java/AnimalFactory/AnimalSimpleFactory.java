
package AnimalFactory;

import Animals.Animal;

public interface AnimalSimpleFactory {
	Animal createCreature(AnimalType type);
}
