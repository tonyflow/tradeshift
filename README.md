# Tradeshift Triangle Classifier
#### Design Overview and Analysis
____________________________________________
The included Maven project's architecture is depicted in detail on the following UML diagram.

![alt text](https://github.com/tonyflow/tradeshift/blob/master/classifier-class-diagram.png "Class Diagram")

There was the clear need to discriminate between implementation and test cases thus I chose a Maven project to categorize the two and easily handle dependecy managegement for junit and java doc

The project was developed, built and tested with Java 1.8.

There are three branches on this project :

1. **master** : Contains the main implementation of the triangle classifier

2. **big-integer** : Contains a `TriangleClassifier` implementation which handles triangles whose sides can be `BigInteger`s

3. **classifier-factory** : Contains an abstraction of the classifier. Here you can specify what kind of classifier you want to use by providing the kind of `Shape` that you want to classify and the factory pattern will choose the appropriate one from a number of implementations.


The basic generic interface `Classifier` is the interface anybody wanting to implement a classifier of any type can use.

```java
public interface Classifier<S extends Shape,T extends Type> {
	T classify(S s);
}
```


Its type parameters represent the `Shape` one wants to classify and the `Type` which is advised to be an enumeration of the available types a shape can be classified into.

For the `TriangleClassifier`, which is the required implementation of the aforementioned `Classifier`



#### Implementation Details and Mathematical background
____________________________________________
The actual implementation of `TriangleClassifier` will first verify that there is a triangle that can be formed. This can be achieved using either the *triangle inequality formula* or *the semiperimeter formula*:

1.**Triangle inequlity formula** 
>  a < b + c && b < a + c && c < a + b

2.**Semiperimeter formula** : 
> max(a,b,c)<s, where s=(a+b+c)/2
_________________________________
**Edge case handling**

There were a number of edge cases that had to be handled. Testing the classifier's appropriate behavior for them can be found in the unit tests provided.
The edge cases handled were the following: 

1.**Negative sides / edges** : Negatively valued edges are acceptable and their absolute value is used to classify the composed triangle.

2.**Degenerate Triangle** : This is a triangle whose vertices are colinear. This kind of degenerations cannot be classified.

3.**Triangle does not exist** : 

4.**Zero edges** : The classifier is given an illegal argument. There does not exist a zero edged triangle. This case can be deduced to case \#3.

There is also a performance tests suite included in the package where you can see the application stretched out.