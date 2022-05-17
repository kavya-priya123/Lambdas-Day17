package com.jobiak.java8;
//JAVA 8 Vs Interfaces
//1) Functional Interface 2)Default Methods 3)Abstract Methods 4)Static Methods
@FunctionalInterface
//user defined interface
interface Test
{
	//A Lambda is always targeted with the Abstract Method not with the Default Method.
	public default void paint() {System.out.println("From default Method");}
	//public void paint();		//error message in test -->The target type of this expression must be a functional interface
								//Functional Interface is an interface which has only one method.Target for Lambda is Functional Interface.
	//How to know this is a Functional Interface and we can't add any method to this Interface.It is avoided by annotating this interface as Functional Interface. 
    public static void method() {System.out.println("From Static Method");}
	public void print();	//public abstract void print();		//only declaration and without parameters and without return type
	//public void print();	// not allowed only one abstract method per FunctionalInterface
}
//It implemented only the abstract method and default method is Optional
//default method is need not be mandatorily overridden by the Implementation Class 
//Abstract method should be implemented and the Non-abstract Method can be used directly by creating object of Testimpl class. 
class TestImpl implements Test
{
	@Override
	public void print()
	{
				
	}
	
}
interface Test2
{
	public  void add(int x,int y);	//with parameters and without return type
}
interface Test3
{
	public int factorial(int n);	//with parameters and with return type
}

interface Test4
{
	public String getString();
}

public class TestLambdas 
{
	//Scala --> Programming Language and very Concise
		public static void main(String args[])
		{
			//Without Parameters using Lambda Expression
			Test test=()->{System.out.println("from print...printing");};
			test.print();
			
			//With Parameters using Lambda Expression
			Test2 test2=(int x,int y)->{     //add(int x,int y){} add ->
				int c=x+y;
				System.out.println(c);
			};
			test2.add(5,7);
			
			//With Parameter and with return type using Lambda Expression
			Test3 test3=(int n)->{
				int fact=1;
				int i=1;
				while(i<=n)
				{
					fact=fact*i;
					i++;
				}
				return fact;
			 };
			 int factorialResult=test3.factorial(4);
			 System.out.println(factorialResult);
			
			 //
			 Test4 test4=()->"Kavya Priya";
			 System.out.println(test4.getString());
			//Implementation/body of run method
			Runnable r=()->{
						for(int i=1;i<=5;i++)
						{
							System.out.println(Thread.currentThread().getName() + i);
						}
					       };
			 Thread t=new Thread(r);
			 t.start();	
			 
			 //Interfaces /Anonymous classes
			 Runnable r1=new Runnable()
			 {
				public void run()
				{
					System.out.println("From run method");
				}
			  };
			  Thread thread=new Thread(r1);
			  thread.start();
			  
			  //Interfaces/Anonymous classes using Lambdas
			  Runnable r2=()->{ System.out.println("from lambda()-> run method");};
			  thread=new Thread(r2);
			  thread.start();
		}
}