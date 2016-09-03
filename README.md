# Tradeshift Triangle Classifier
#### Architectural Overview and Analysis
____________________________________________
The included Maven project's architecture is depicted in detail on the following UML diagram.

![alt text](https://github.com/tonyflow/tradeshift/blob/master/classifier-class-diagram.png "Class Diagram")

The basic generic interface `Classifier` is the interface anybody wanting to implement a classifier of any type can use.

```java
public interface Classifier<S extends Shape,T extends Type> {
	T classify(S s);
}
```


Its type parameters represent the `Shape` one wants to classify and the the `Type` which is advised to be an enumeration of the available type a shape can be classified into.

For the `TriangleClassifier`, which is the required implementation of the aforementioned `Classifier`

I chose to use a Maven project in order to provide clear documentation of my code with JavaDoc and finely grained testing of my development with unit tests

The project was developed,built and tested with Java 1.8.

#### Implementation Details and Mathematical background
____________________________________________
