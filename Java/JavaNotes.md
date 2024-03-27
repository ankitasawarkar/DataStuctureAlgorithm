
# Java Interview Preparation

## Core

## OPPs

### Constructor

The constructor can be defined as the special type of method that is used to initialize the state of an object. It is invoked when the class is instantiated, and the memory is allocated for the object. Every time, an object is created using the new keyword, the default constructor of the class is called. The name of the constructor must be similar to the class name. The constructor must not have an explicit return type.

* Default Constructor - 
* Parameterized Constructor

The purpose of the default constructor is to assign the default value to the objects. The java compiler creates a default constructor implicitly if there is no constructor in the class.

The constructor **implicitly returns** the current instance of the class (**no explicit return** type with the constructor).

The constructor is **not inherited** and **can't be final**.

The constructors can be **overloaded** by changing the number of arguments accepted by the constructor or by changing the data type of the parameters

There is **no copy constructor** in java. However, we can copy the values from one object to another like copy constructor in C++.

There are many ways to copy the values of one object into another in java. They are:

* By constructor
* By assigning the values of one object into another
* By clone() method of Object class

Java Constructor	
* A constructor is used to initialize the state of an object.	
* A constructor must not have a return type.	
* The Java compiler provides a default constructor if you don't have any constructor in a class.
* The constructor is invoked implicitly.
* The constructor name must be same as the class name.

Java Method
* A method is used to expose the behavior of an object.
* A method must have a return type.
* The method is not provided by the compiler in any case.
* The method is invoked explicitly.
* The method name may or may not be same as class name.

### Static
**Static variable present in Stack Memory and Object variavle present in Heap Memory.**

The methods or variables defined as static are shared among all the objects of the class.  The static is the part of the class and not of the object. The static variables are stored in the class area, and we do not need to create the object to access such variables. Therefore, static is used in the case, where we need to define variables or methods which are common to all the objects of the class.

For example, In the class simulating the collection of the students in a college, the name of the college is the common attribute to all the students. Therefore, the college name will be defined as static.

Static variable gets memory only once in the class area at the time of class loading. Using a static variable makes your program more memory efficient (it saves memory). Static variable belongs to the class rather than the object. A static method is similar like static variable including it can access and change the value of the static variable.

Restrictions are applied to the static methods:
* The static method can not use non-static data member or call the non-static method directly.
* this and super cannot be used in static context as they are non-static.
* can't override the static method.

**The main method static**, Because the object is not required to call the static method. If we make the main method non-static, JVM will have to create its object first and then call main() method which will lead to the extra memory allocation

**Static block** is used to initialize the static data member. It is executed before the main method, at the time of classloading.
```
class A2{  
  static{System.out.println("static block is invoked");}  
  public static void main(String args[]){  
   System.out.println("Hello main");  
  }  
}  

Output: static block is invoked
       Hello main
```
If the static modifier is removed from the signature of the main method? --> Program compiles. However, at runtime, It throws an error "NoSuchMethodError."

**Constructor can't be Static** because --> As we know that the static context (method, block, or variable) belongs to the class, not the object. Since Constructors are invoked only when the object is created, there is no sense to make the constructors static. However, if you try to do so, the compiler will show the compiler error.

**Can't make abstract methods static**, It will become the part of the class, and we can directly call it which is unnecessary. Calling an undefined method is completely useless therefore it is not allowed.

We can declare static variables and methods in an abstract method. 
```
abstract class Test  
{  
    static int i = 102;  
    static void TestMethod()  
    {  
        System.out.println("hi !! I am good !!");  
    }  
}  
public class TestClass extends Test   
{  
    public static void main (String args[])  
    {  
        Test.TestMethod();  
        System.out.println("i = "+Test.i);  
    }  
}

Output:
hi !! I am good !!
i = 102
```

### this
The **this** keyword is a **reference variable** that refers to the current object. 
It can be used to refer to current class properties such as instance methods, variable, constructors, etc. It can also be passed as an argument into the methods or constructors. It can also be returned from the method as the current class instance.

```
// Chaining Constructor
public Employee (int age)  
    {  
        this.age = age;  
    }  
    public Employee(int id, int age)  
    {  
        this(age);  
        this.id = id;  
    }  
```
**this** cannot be assigned to any value because it always points to the current class object and this is the final reference in Java. However, if we try to do so, the compiler error will be shown.
```
this = null; // compiler error 
```
this keyword to refer static variable but its not best practice rather is unnecessaryto call through object.
```
public class Test   
{  
    static int i = 10;   
    public Test ()  
    {  
        System.out.println(this.i);      
    }  
    public static void main (String args[])  
    {  
        Test t = new Test();  
    }  
}  
Output
10
```
Advantages:
* this is a final variable. Therefore, this cannot be assigned to any new value whereas the current class object might not be final and can be changed.
* this can be used in the synchronized block.

### Inheritance
Inheritance is a mechanism by which one object acquires all the properties and behavior of another object of another class. Used for Code Reusability and Method Overriding. Its 
represents the **IS-A relationship** which is also known as a parent-child relationship.
* Single-level inheritance
* Multi-level inheritance
* Multiple Inheritance --> not supported in Java through class 
* Hierarchical Inheritance
* Hybrid Inheritance

**The object class is the superclass of all other classes in Java.**

Advantages:
* Runtime polymorphism achieved.
* We can simulate the inheritance of classes with the real-time objects which makes OOPs more realistic.
* Provides data hiding. The base class can hide some data from the derived class by making it private.
* Method overriding acheived. By method overriding, we can give a specific implementation of some basic method contained by the base class.

**Multiple inheritance not supported in java**? --> 

To reduce the complexity and simplify the language, multiple inheritance is not supported in java. Consider a scenario where A, B, and C are three classes. The C class inherits A and B classes. If A and B classes have the same method and you call it from child class object, there will be **ambiguity to call the method** of A or B class.

Since the compile-time errors are better than runtime errors, Java renders compile-time error if you inherit 2 classes. So whether you have the same method or different, there will be a compile time error.
```
class A{  
    void msg(){System.out.println("Hello");}  
}  
class B{  
    void msg(){System.out.println("Welcome");}  
}  
class C extends A,B{//suppose if it were  
   
    Public Static void main(String args[]){  
        C obj=new C();  
        obj.msg();//Now which msg() method would be invoked?  
    }  
}  
Compile time Error
```
### Aggregation and Composition
**Aggregation** can be defined as the relationship between two classes where the aggregate class contains a reference to the class it owns. Aggregation is best described as a *has-a relationship**. 
```
---- Address.java

public class Address {  
    String city,state,country;  
    
    public Address(String city, String state, String country) {  
        this.city = city;  
        this.state = state;  
        this.country = country;  
    }  
  
}  
---- Employee.java
public class Emp {  
    int id;  
    String name;  
    Address address;  
    
    public Emp(int id, String name,Address address) {  
        this.id = id;  
        this.name = name;  
        this.address=address;  
    }  
    
    void display(){  
        System.out.println(id+" "+name);  
        System.out.println(address.city+" "+address.state+" "+address.country);  
    }  
  
    public static void main(String[] args) {  
        Address address1=new Address("gzb","UP","india");  
        Address address2=new Address("gno","UP","india");  
        
        Emp e=new Emp(111,"varun",address1);  
        Emp e2=new Emp(112,"arun",address2);  
            
        e.display();  
        e2.display();  
        
    }  
}  
Output:
111 varun
gzb UP india
112 arun
gno UP india 
```

**Composition** 
Holding the reference of a class within some other class is known as composition. When an object contains the other object, if the contained object cannot exist without the existence of container object, then it is called composition. In other words, we can say that composition is the particular case of aggregation which represents a stronger relationship between two objects. 

*Aggregation represents the **weak relationship** whereas composition represents the **strong relationship**. For example, the bike has an indicator (aggregation), but the bike has an engine (composition).*

The **pointer** is a variable that refers to the memory address. They are **not used in Java** because they are unsafe(unsecured) and complex to understand.

### super
The super keyword in Java is a reference variable that is used to refer to the immediate parent class object.

super can be used to refer to the immediate parent class instance variable, method using super keyword and constructor using super().

The super() is implicitly invoked by the compiler if no super() or this() is included explicitly within the derived class constructor.

```
class Animal{  
    Animal(){System.out.println("animal is created");}  
}  
class Dog extends Animal{  
    Dog(){System.out.println("dog is created");}  
}  
class TestSuper4{  
    public static void main(String args[]){  
        Dog d=new Dog();  
    }  
} 
Output:
animal is created.
dog is created.
``` 

Chaining created using super keyword
```
class Person  
{  
    String name,address;   
    int age;  
    public Person(int age, String name, String address)  
    {  
        this.age = age;  
        this.name = name;  
        this.address = address;  
    }  
}  
class Employee extends Person   
{  
    float salary;  
    public Employee(int age, String name, String address, float salary)  
    {  
        super(age,name,address);  
        this.salary = salary;  
    }  
}  
public class Test   
{  
    public static void main (String args[])  
    {  
        Employee e = new Employee(22, "Mukesh", "Delhi", 90000);  
        System.out.println("Name: "+e.name+" Salary: "+e.salary+" Age: "+e.age+" Address: "+e.address);  
    }  
}  
Output
Name: Mukesh Salary: 90000.0 Age: 22 Address: Delhi
```

this() and super() must be the first statement in the class constructor, So both not use in constructor.
```
public class Test{  
    Test()  
     {  
         super();   
         this();  
         System.out.println("Test class object is created");  
     }  
     public static void main(String []args){  
     Test t = new Test();  
     }  
}  
Output:
Test.java:5: error: call to this must be first statement in constructor
```

### Object clone
The object cloning is used to create the exact copy of an object using the clone() method of the Object class. The java.lang.Cloneable interface must be implemented by the class whose object clone we want to create. If we don't implement Cloneable interface, clone() method generates CloneNotSupportedException.

### Overloading
Method overloading is the polymorphism technique which allows us to create multiple methods with the same name but different signature. By Changing the number of arguments and data type of arguments. It increases the readability of the program So it performed to figure out the program quickly.

In Java, method **overloading is not possible by changing the return type** of the program due **to avoid the ambiguity**.
```
class Adder{  
    static int add(int a,int b){return a+b;}  
    static double add(int a,int b){return a+b;}  
}  
class TestOverloading3{  
    public static void main(String[] args){  
        System.out.println(Adder.add(11,11));//ambiguity  
    }
}  
Output:
Compile Time Error: method add(int, int) is already defined in class Adder
```
Cannot overload the methods by just applying the static keyword to them(number of parameters and types are the same).
```
public class Animal  
{  
    void consume(int a)  
    {  
        System.out.println(a+" consumed!!");  
    }  
    static void consume(int a)  
    {  
        System.out.println("consumed static "+a);  
    }  
    public static void main (String args[])  
    {  
        Animal a = new Animal();  
        a.consume(10);  
        Animal.consume(20);  
    }  
}    
Output

Animal.java:7: error: method consume(int) is already defined in class Animal
    static void consume(int a)
                ^
Animal.java:15: error: non-static method consume(int) cannot be referenced from a static context
        Animal.consume(20);
              ^
2 errors
```
We can have any number of *main methods* in a Java program by using method overloading.

**Type promotion** is method overloading, we mean that one data type can be promoted to another implicitly if no exact matching is found.
```
      byte
        |
      short
        |
char-- int -- float
        |  \/
        |  /\
       long-- double
```
As displayed in the above diagram, the byte can be promoted to short, int, long, float or double. The short datatype can be promoted to int, long, float or double. The char datatype can be promoted to int, long, float or double and so on. Consider the following example.
```
class OverloadingCalculation1{  
  void sum(int a,long b){System.out.println(a+b);}  
  void sum(int a,int b,int c){System.out.println(a+b+c);}  
  
  public static void main(String args[]){  
  OverloadingCalculation1 obj=new OverloadingCalculation1();  
  obj.sum(20,20);//now second int literal will be promoted to long  
  obj.sum(20,20,20);  
  }  
}  
Output
40
60
```

```
class OverloadingCalculation3{    
  void sum(int a,long b){System.out.println("a method invoked");}    
  void sum(long a,int b){System.out.println("b method invoked");}    
    
  public static void main(String args[]){    
  OverloadingCalculation3 obj=new OverloadingCalculation3();    
  obj.sum(20,20);//now ambiguity    
  }    
}    
Output

OverloadingCalculation3.java:7: error: reference to sum is ambiguous
obj.sum(20,20);//now ambiguity  
     ^ 
      both method sum(int,long) in OverloadingCalculation3 
      and method sum(long,int) in OverloadingCalculation3 match
1 error
```

### Overriding
If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding. It is used for runtime polymorphism and to implement the interface methods.

Rules for Method overriding: The method must have the same name, same signature as in the parent class.Two classes must have an **IS-A relationship** between them.

Can't override the static method because they are the part of the class, not the object. Static method is bound with class whereas instance method is bound with the object, and static gets memory in class area, and instance gets memory in a heap.

We cannot override the private methods because the scope of private methods is limited to the class and we cannot access them outside of the class.

We can change the scope of the overridden method in the subclass. However, we must notice that we cannot decrease the accessibility of the method. The following point must be taken care of while changing the accessibility of the method.
* The private can be changed to protected, public, or default.
* The protected can be changed to public or default.
* The default can be changed to public.
* The public will always remain public.

We can modify the throws clause of the superclass method while overriding it in the subclass. However, there are some rules which are to be followed while overriding in case of exception handling.
* If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception, but it can declare the unchecked exception.
* If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.

All functions in Java are virtual by default.

### Overloading vs Overriding
We can override the overloaded method

Method Overloading ---vs---	Method Overriding
1) Method overloading increases the readability of the program.	---vs--- Method overriding provides the specific implementation of the method that is already provided by its superclass.
2) Method overloading occurs within the class. ---vs---	Method overriding occurs in two classes that have IS-A relationship between them.
3) In this case, the parameters must be different. ---vs---	In this case, the parameters must be the same.

### final
Final variable is used to stop value change, stop method overridding and stop inheritance. The final variable which is not assigned to any value can only be assigned through the class constructor.
```
class Bike9{  
 final int speedlimit=90;//final variable  
 void run(){  
  speedlimit=400;  
 }  
 public static void main(String args[]){  
 Bike9 obj=new  Bike9();  
 obj.run();  
 }  
}//end of class  
Output:Compile Time Error
```
A final variable, not initialized at the time of declaration, is known as the **final blank variable**. We can't initialize the final blank variable directly. Instead, we have to initialize it by using the class constructor. It is useful in the case when the user has some data which must not be changed by others, for example, PAN Number. Consider the following example:
```
class Student{  
    int id;  
    String name;  
    final String PAN_CARD_NUMBER;  
...  
}  
```
if it is not static blank final variable, we can initialize it in the constructor.\
If it is static blank final variable, it can be initialized only in the static block

We can declare the main method as public static final void main(String[] args){}.

Abstract method can't be final as we need to override them in the subclass to give its defination.

The constructor can never be declared as final because it is never inherited. Constructors are not ordinary methods; 

Interface can't declate as final because the interface must be implemented by some class to provide its definition. 

Therefore, there is no sense to make an interface final and declare constructors final. However, if you try to do so, the compiler will show an error.


