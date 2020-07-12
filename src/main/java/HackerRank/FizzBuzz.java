package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FizzBuzz {

	public static void main(String[] args) {
		fizzBuzz(15);
	}

	public static void fizzBuzz(int n) {
		 
		for(int i=1; i<= n;i++) {
			if(i%3 ==0 && i%5 ==0) {
				System.out.println("FizzBuzz");
			}else if (i%3 ==0) {
				System.out.println("Fizz");
			}else if (i%5 ==0) {
				System.out.println("Buzz");
			}else{
				System.out.println(i);	
			}
		}

	}

}
