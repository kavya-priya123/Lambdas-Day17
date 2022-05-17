package com.jobiak.java8;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class TestFunctionals 
{
	public static void main(String[] args) 
	{
		//A Functional Interface always refers to a Lambda and this Functional Interface is passed as a parameter to the methods.Thereby,the code is going to the method. 
		//uppercase,lowercase,compareto etc. String Functions,Math functions
		Function<String,Integer> lengthFunction=(String str)->{return str.length()/2;};
		
		int result=lengthFunction.apply("Kavya Priya");
		System.out.println(result);
		//System.out.println("KavyaPriya".length());
		
		ArrayList<String> fruits=new ArrayList<>();
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.add("Pineapple");
		fruits.add("Grapes");
		
		List<Integer> lengthList=method(fruits,lengthFunction);
		System.out.println(lengthList);
		
	/*	Predicate<Boolean> predicate=(Boolean)->{return 100<45;};
		System.out.println(predicate.test(true));
	
		Consumer<String> consumer=(String str)->{System.out.println(str);};
		consumer.accept("Jobiak.ai");
		
		Supplier<Double> supplier=()->Math.random();
		System.out.println(supplier.get());
		
		Supplier<Integer> supplier1=()->2*2*2;
		System.out.println(supplier1.get());	*/
	}
		//Try to Implement one method //Function holds logic
		static List<Integer> method(ArrayList<String> list,Function<String,Integer> functionParam)
		{
			ArrayList<Integer> intList=new ArrayList<>();
			for(String str:list)
			{
				int length=functionParam.apply(str);
				intList.add(length);
			}
			return intList;
		}
		
/*	static List<Integer> methodHalfLength(ArrayList<String> list,Function<String,Integer> functionParam)
		{
			ArrayList<Integer> intList=new ArrayList<>();
			for(String str:list)
			{
				int length=functionParam.apply(str);
				intList.add(length);
			}
			return intList;
		}
*/
}
