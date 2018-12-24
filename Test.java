/*
		
		INTERFACE::
		----------
->	It is called 100 percent abstract class.

->	The methods inside an interface are by default public & abstract.

->  It isn't allowed to create the object of an interface.

-> While implementing the sub class must define all the abstract methods of the interface
& also while overriding the methods must be declared as public because if we don't do that
then ultimately we are decreasing the access permission & the compiler will generate error.

->	Interface reference variable can hold the sub class object.
*/

//ex


interface WebDriver
{
	void disp1();
	void windows();
}
class FirefoxDriver implements WebDriver
{
	public void disp1()
	{
		System.out.println("this is FirefoxDriver class overriding disp() method.");
	}
	public void windows()
	{
		System.out.println("this is FirefoxDriver class overriding windows method.");
	}
	public static void main(String ...a)
	{
		WebDriver wd=new FirefoxDriver();
		wd.disp1();
		wd.windows();
	}
	
}
/*
O|P::D:\java6\oop\Interface>java FirefoxDriver
this is FirefoxDriver class overriding disp() method.
this is FirefoxDriver class overriding windows method.*/





/*

	rules regarding interface & class::
	
	
	rules:
	------
		(1)class A extends A : (invalid)::this concept is called cyclic inheritance but java doesn't support cyclic inheritance.
		
		(2)extends keyword must be the first keyword.
			ex.1: class A extends B              :  (valid)
			ex.2: class A implements B,extends c : (invalid)
			ex.3: class A extends B implements C : (valid)
		
		(3)One class is able to extends only one class but one interface can  implements
		multiple interfaces.
			ex.1 class A extends b,c             : (invalid)
			ex.2 interface A implements B,C      :  (valid)

		(4)At a time one class can extends one class & multiple interfaces but in this case 
		extends keyword must be the first statement.
			ex.1 class A extends B implements C,D:(valid)
			ex.2 class A implements B extends C  :(invalid)//because /here extends keyword isn't first statement
*/





/*

when a class implements one or more interface & we are deciding not to define all the abstract
methods then we must declare that class as abstract & its sub class must override all the abstract 
methods.
*/


//ex


interface It1
{
	void m1();
	void m2();
}
interface It2
{
	void disp1();
	void disp2();
}
abstract class Test0 implements It1,It2
{
	//this class is unable to override all the abstract methods so we must declare this class as abstract
	
	public void m1()
	{
		System.out.println("this is abstract class Test0 m1() method.");
	}
	public void disp1()
	{
		System.out.println("this is abstract class Test0 disp1() method.");
	}
	public static void main(String args[])
	{
		Test02 t2=new Test02();
		t2.disp1();
		t2.disp2();
		t2.m1();
		t2.m2();
	}
}
abstract class Test01 extends Test0
{			//this class is also unable to override the rest abstract methods
	public void m2()
	{
		System.out.println("this is abstract class Test01 m2() method.");
	}
}
class Test02 extends Test01
{
	public void disp2()
	{
		System.out.println("this is concrete class Test02 disp2() method.");
	}
	public static void main(String ...a)
	{
		
	}
}

/*
O|P::D:\java6\oop\Interface>java Test0
this is abstract class Test0 disp1() method.
this is concrete class Test02 disp2() method.
this is abstract class Test0 m1() method.
this is abstract class Test01 m2() method.*/



/*

		IMP
		---
		
		
		When multiple interfaces contain multiple number of same abstract methods declaration
& a class is inheriting to those interfaces then those same abstract methods are required to be
overridden only once ie we don't have to override to those same methods multiple no of times.*/


//ex

/*interface It01
{
	void m1();
	void m2();
	void disp1();
}
interface It02
{
	void m2();//this method is already declared inside interface It01
	void disp1();//this method is already declared inside interface It01
	
	void disp2();
	void disp3();
}
class Test03 implements It01,It02
{
	public void m1()
	{
		System.out.println("this is Test03 class m1() method.");
	}
	public static void main(String...a)
	{
		Test04 t4=new Test04();
		t4.m1();
		t4.m2();
		t4.disp1();
		t4.disp2();
		t4.disp3();
	}
	public void m2()//we have to override this method only once
	{
		System.out.println("this is Test03 class m2() method.");
	}
	/*
	Test.java:198: error: method m2() is already defined in class Test03
        public void m2()//we have to override this method only once*/
	/*public void m2()//we have to override this method only once
	{
		System.out.println("Test03 class m2() method.");
	}
	public void disp1()//we have to override this method only once
	{
		System.out.println("this  is Test03 class disp() method.");
	}
	/*
	Test.java:206: error: method disp1() is already defined in class Test03
        public void disp1()//we have to override this method only once
                    ^*/
/*	public void disp1()//we have to override this method only once
	{
		System.out.println("this  is Test03 class disp() method.");
	}
	public void disp2()
	{
		System.out.println("this is Test04 class disp2() method.");
	}
	public void disp3()
	{
		System.out.println("this is Test04 class disp3() method.");
	}
}
/*class Test04 extends Test03
{
	public void disp2()
	{
		System.out.println("this is Test04 class disp2() method.");
	}
	public void disp3()
	{
		System.out.println("this is Test04 class disp3() method.");
	}
}
/*
O|P::D:\java6\oop\Interface>java Test03
this is Test03 class m1() method.
this is Test03 class m2() method.
this  is Test03 class disp() method.
this is Test04 class disp2() method.
this is Test04 class disp3() method.*/

/*


		Interface variables & their conflict ::
		--------------------------------------
	
	
		
->	Interface is able to declare the variables.
->  All the variables inside an interface are by default public, static & final. So we can't 
reassign their values.

*/

/*ex


interface It4
{
	int x1=30;
	int x2=20;
	void add();
}

class Test06 implements It4,It5
{
	public void add()
	{
		//x1=100;//error: cannot assign a value to final variable x1
		//x2=40;//error: cannot assign a value to final variable x2
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x1+x2);
	}
	public static void main(String...s)
	{
		Test06 t6=new Test06();
		t6.add();
	}
}
/*
O|P::D:\java>javac AA.java
AA.java:15: error: cannot assign a value to final variable x1
                x1=100;
                ^
AA.java:16: error: cannot assign a value to final variable x2
                x2=40;
                ^
2 errors*/





//When multiple interfaces contain same variables then the compiler will generate error	

//	ambiguous problem		


//ex
/*
interface It8
{
	int x1=100;
	int x2=200;
	void disp();
}
interface It9
{
	int x1=400;
	int x2=500;
	void disp1();
}
class Test08 implements It8,It9
{
	public void disp()
	{
		System.out.println(x1);//error: reference to x1 is ambiguous
		System.out.println(x2);//error: reference to x2 is ambiguous
		// both variable x2 in It8 and variable x2 in It9 match
	}
	public void disp1()
	{
		System.out.println(" ");
	}
}*/
/*
O|P::D:\java6\oop\Interface>javac Test.java
Test.java:320: error: reference to x1 is ambiguous
                System.out.println(x1);
                                   ^
  both variable x1 in It8 and variable x1 in It9 match
Test.java:321: error: reference to x2 is ambiguous
                System.out.println(x2);
                                   ^
  both variable x2 in It8 and variable x2 in It9 match
2 errors*/


/*

In the above example the error has been generated because of ambiguous problem.



To overcome such problem we should access those variables through their Interface name because 
those variables are static.


*/
//ex


interface It8
{
	int x1=100;
	int x2=200;
	void disp();
}
interface It9
{
	 int x1=400;
	 int x2=500;
	abstract void disp1();
}
class Test08 implements It8,It9
{
	public void disp()
	{
		
		System.out.println(It8.x1);//error: reference to x1 is ambiguous
		System.out.println(It8.x2);
		System.out.println(It9.x1);//error: reference to x1 is ambiguous
		System.out.println(It9.x2);//error: reference to x2 is ambiguous
		// both variable x2 in It8 and variable x2 in It9 match
	}
	public void disp1()
	{
		System.out.println(" ");
	}
	public static void main(String args[])
	{
		Test08 t8=new Test08();
		t8.disp();
	}
}

/*

		Adopter class concept::
		-----------------------


(Q.1) What is adopter class ?

(q.2) why & when adopter class is used ?

(q.3)How to use adopter class ?		
		
*/



/*
(ans.1) adopter class is a type of class which implements one or multiple interfaces & a adopter
class contains empty implementation of  the abstract methods of the interfaces.

->There is no keyword to declare the adopter class . It is declared simply like a class but 
inside the adopter class, all overriding methods have empty implementation.
*/
//ex

interface WebDriver1
{
	void disp1();
	void disp2();
	void disp3();
	String disp4();
	String disp5();
}

class Test001 implements WebDriver1////this is adopter class
{
	public void disp1()
	{//empty implementation
	}
	public void disp2()
	{//empty implementation
	}
	public void disp3()
	{//empty implementation
	}
	public String disp4()
	{
		return "srt";
	}//empty implementation
	public String disp5()
	{
		return "srt";
		//empty implementation
	}
}

/*
(ans.2)	When a class implements/inherit any interfaces & we are not deciding to declare that 
class as abstract then we must have to override all the abstract methods of the interfaces
otherwise the compiler will generate error.

-> To overcome such situation the adopter class concept is used.

*/

/*
(ans.3) We have to declare the adopter class & that adopter class should inherit/implement
the interface. Inside that adopter class we have to override all the method but with empty 
implementation.

->when ever a class extends that adopter class ,that class can define its required number of
abstract methods & it isn't bound to define all the methods.
*/

//ex
//without adopter class

interface FirefoxDriver101
{
	double disp1();
	void disp2();
	String disp3();
	char disp4();
	long disp5();
}
interface FirefoxDriver102
{
void m1();
void m2();
void m3();	
}
class Test012 implements FirefoxDriver101,FirefoxDriver102
{
	public double disp1()
	{
		System.out.println("this is Test012 class disp1() method.");
		return 10.02;
	}
	public void disp2()
	{
		System.out.println("this  is Test012 class 0-arg disp2() method.");
	}
	public String disp3()
	{
		System.out.println("this is Strinng type Test012 class 0-arg disp3() method.");
		return "srt";
	}
	public char disp4()
	{
		System.out.println("this is char type Test012 class 0-arg disp4() method.");
		return 'v';
	}
	public long disp5()
	{
		System.out.println("this is long type Test012 class 0-arg disp5() mtehod.");
		return 10;
	}
	public void m1()
	{
		System.out.println("this is m1() method.");
	}
	public void m2()
	{
		System.out.println("this is m2() method.");
	}
	public void m3()
	{
		System.out.println("this is m2() method.");
	}
	public static void main(String args[])
	{
		Test012 t0=new Test012();
		t0.m1();
		t0.m2();
		t0.m3();
		t0.disp1();
		t0.disp2();
		t0.disp3();
		t0.disp4();
		t0.disp5();
	}
	
}



//with adopter class

interface FirefoxDriver1
{
	double disp1();
	void disp2();
	String disp3();
	char disp4();
	long disp5();
}
interface FirefoxDriver10
{
void m1();
void m2();
void m3();	
}

class Adopter1000 implements FirefoxDriver1,FirefoxDriver10//this is adopter class
{
	public double disp1(){return 10.02;}
	public void disp2(){}
	public String disp3(){return "srt";}
	public char disp4(){return 'o';}
	public long disp5(){return 38;}
	public void m1(){}
	public void m2(){}
	public void m3(){}
}
class Test013 extends Adopter1000
{
	public double disp1()
	{
		System.out.println("this is Test013 class disp()0-arg method.");
		return 10.02;
	}
	public static void main(String...s)
	{
		double d=new Test013().disp1();
		System.out.println(d);
	}
	
}
/*
O|P::D:\java6\oop\Interface>java Test013
this is Test013 class disp()0-arg method.
10.02*/

/*

		Nested Interface
		-----------------
		
		
->	Interface inside another interface/class is called nested interface.	
*/


interface WebDriver12
{
	interface WebDriver13
	{
		interface WebDriver14
		{
			double disp1();
			double disp2();
		}
	}
}

class Test014 implements WebDriver12.WebDriver13.WebDriver14
{
	public double disp1()
	{
		System.out.println("this is Test014 class disp1() method.");
		return 10.02;
	}
	public double disp2()
	{
		System.out.println("this is Test014 class disp2() method.");
		return 10.02;
	}
	public static void main(String...q)
	{
		Test014 t0=new Test014();
		t0.disp1();
		t0.disp2();
	}
}
/*
O|P::D:\java6\oop\Interface>java Test014
this is Test014 class disp1() method.
this is Test014 class disp2() method.*/



//interface inside a class
class Test015
{
	interface FirefoxDriver001
	{
		String disp1();
	}
}
class Test016 implements Test015.FirefoxDriver001
{
	public String disp1()
	{
		System.out.println("this is Test015 class 0-arg disp() method.");
		return "j2ee";
	}
	public static void main(String args[])
	{
		new Test016().disp1();
	}
}
/*
o|P::D:\java6\oop\Interface>java Test016
this is Test015 class 0-arg disp() method.*/


/*

	Marker interface
	----------------
	
definition:- an interface without properties is called marker interface & when a class implements
a marker interface then that class must acquire some capability to perform some operation.

	ex : 	interface Test  //marker interface
			{//empty
			}

			
			some predefined marker interfaces::
			(1)serializable(java.io.serializable)
			
			(2)cloneable(java.lang.cloneable)
			
			(3)RandomAccess(java.util.RandomAccess)
			
			application::
			
			(1)cloneable interface is used to create duplicate object.

			
			
			
			
cloning process::
-----------------

-> it is a process of creating duplicate object by using marker interface "cloneable".

-> To create duplicate object the class must have to implement cloneable interface which is 
present in java.lang package.


(q) Why do require duplicate object ?

(ans) Generally duplicate object is required for back up of data. TO understand it properly
let's see an example*/

//ex

class Test017 implements Cloneable
{
	int x1=100;
	int x2=300;
	public static void main(String args[])throws  CloneNotSupportedException
	{
		Test017 t7=new Test017();
		System.out.println(t7.x1);
		System.out.println(t7.x2);
		t7.x1=900;
		t7.x2=1200;
		System.out.println(t7.x1);//here 900 will be printed
		System.out.println(t7.x2);//here 1200 will be printed
		t7.x1=15;
		t7.x2=40;
		System.out.println(t7.x1);//here 15 will be printed
		System.out.println(t7.x2);//here 40 will be printed
		/*
		in this line of code, we want to create a duplicate object so that the value of x1 & x2
		will be 15 & 40 respectively. ie our intention is till this line of code what ever we
		have done should be stored in order to maintain back up.
		*/
		/*
		to create duplicate object we use clone() method which is present in Object class
		& hence we have to typecast it.*/
		Test017 td=(Test017)t7.clone();//here td is the duplicate object.
		t7.x1=35;
		t7.x2=80;
		System.out.println(t7.x1);//here 35 will be printed
		System.out.println(t7.x2);//here 80 will be printed
		t7.x1=55;		
		t7.x2=75;
		System.out.println(t7.x1);//here 55 will be printed
		System.out.println(t7.x2);//here 75 will be printed
		
		
		
		
		//here we want to retrieve the back up where we created the duplicate object.
			System.out.println(td.x1);//here 15 will be printed
			System.out.println(td.x2);//here 40 will be printed
		
		
	}
}



/*


cloneable is a marker interface which doesn't contain any properties then how does a class
acquire its properties when there is no properties inside it ?

(ans) The required properties are provided by JVM.*/