#Intent 
Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
#Applicability
 - Use the Abstract Factory when your code needs to work with various families of related products, but you don’t want it to depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future extensibility.
#Characteristics:
- creates families of objects in some way related to each other
- there is a mechanism of inheritance
- there is a mechanism of composition
- there is a dedicated customer class
- breaks the open-closed principle

https://medium.com/@sawomirkowalski/design-patterns-abstract-factory-and-its-types-26f3b317a38e

#Connection to other patterns
- Many designs start by using Factory Method (less complicated and more customizable via subclasses) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, but more complicated).

- Builder focuses on constructing complex objects step by step. Abstract Factory specializes in creating families of related objects. Abstract Factory returns the product immediately, whereas Builder lets you run some additional construction steps before fetching the product.

- Abstract Factory classes are often based on a set of Factory Methods, but you can also use Prototype to compose the methods on these classes.

- Abstract Factory can serve as an alternative to Facade when you only want to hide the way the subsystem objects are created from the client code.

- You can use Abstract Factory along with Bridge. This pairing is useful when some abstractions defined by Bridge can only work with specific implementations. In this case, Abstract Factory can encapsulate these relations and hide the complexity from the client code.

- Abstract Factories, Builders and Prototypes can all be implemented as Singletons.

#Q&A
- How is abstract factory different from factory method?
