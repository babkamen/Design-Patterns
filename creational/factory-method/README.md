#Intent
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
- complies with the open-closed principle
- there is always an inheritance mechanism
- no composition
- complicated logic is encapsulate
- easy to test

Sometimes also people call "Simple factory" as factory method   
```java
interface Fruit { }
 
class Apple implements Fruit { }
class Orange implements Fruit { }
 
class FruitFactory
{
    public Fruit createFruit(String type)
    {
        switch (type)
        {
            case "orange":
                return new Orange();
                break;
 
            case "apple":
                return new Apple();
                break;
 
            default:
                throw new IllegalArgumentException();
         }
     }
}
```
Comparison to other creational patterns
- the simplest way to separate implementations from the interface.
- no inheritance, no composition.
- no customer class.
- hard to test
- breaking the open-closed principle
#Implementation
https://dzone.com/articles/java-the-factory-pattern

