public class Solution {
    public static void main(String[] args) {
        Admin admin = Admin.getInstance();
        Admin anotherAdmin = Admin.getInstance();
        System.out.println(admin.hashCode());
        System.out.println(admin.hashCode());

        /*------------------------------------*/
        AnimalCreator animalCreator = new AnimalCreator();
        Animal husky = animalCreator.getAnimal("dog");
        husky.makeSound();
        Animal myCat = animalCreator.getAnimal("cat");
        myCat.makeSound();

        /*------------------------------------*/
        /*About Object Pool: Learn after.*/
    }
}

/*Singleton Design Pattern*/
class Admin {
    private static volatile Admin instance;

    private Admin() {
        instance = null;
    }

    public static Admin getInstance() {
        if (instance == null) {
            synchronized (Admin.class) {
                if (instance == null) {
                    instance = new Admin();
                }
            }
        }
        return instance;
    }
}

/*Factory Method Design Pattern*/
abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Wolf");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

class AnimalCreator {
    public Animal getAnimal(String type) {
        if (type.equals("dog")) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
