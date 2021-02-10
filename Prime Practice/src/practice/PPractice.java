package practice;

import java.util.Scanner;

public class PPractice {
	 Scanner sc = new Scanner(System.in);
	 int range = 0;
	 
	 private void input() {
		 System.out.println("Enter a number");
	      range = sc.nextInt();
	 }
	 
	 private void lessThan() {
	      boolean prime[] = new boolean[range+1]; 
	        for(int i=0;i<range;i++) 
	            prime[i] = true; 
	          
	        for(int p = 2; p*p <=range; p++) 
	        { 
	            // If prime[p] is not changed, then it is a prime 
	            if(prime[p] == true) 
	            { 
	                // Update all multiples of p 
	                for(int i = p*p; i <= range; i += p) 
	                    prime[i] = false; 
	            } 
	        } 
	          
	        // Print all prime numbers 
	        for(int i = 2; i <= range; i++) 
	        { 
	            if(prime[i] == true) 
	                System.out.print(i + " "); 
	        } 
	   }
	 public void print() {
		 input();
		 lessThan();
		 }
	 }
