package samplePackage;

import java.util.Random;

public class TaskToDo {
	public static int sum(int[] a) {
		int total = 0;
		for(int i=0; i<a.length; i++)
			total+=a[i];
		return total;
	}

	public static int sumEven(int[] a) {
		int total = 0;
		for(int i=0; i<a.length; i++)
			if(a[i]%2 == 0)
				total+=a[i];
		return total;
	}

	public static boolean contains(int[] a, int target) {
		for(int i=0; i < a.length; i++)
			if(a[i] == target)
				return true;
		return false;
	}

	//advanced
	public static int countUnique(int[] a) {
		int count = 0;
		for(int i=0; i < a.length; i++) {
			boolean flag = true;
			for(int k=0; flag == true && k < a.length; k++) {
				if(i==k) {
					continue;
				}
				if(a[i] == a[k]) {
					flag = false;
				}
			}
			if(flag)
				count++;
		}
		return count;
	}
	

	private static int count(int[] a, int item) {
		int result = 0;
		for(int i=0; i < a.length; i++)
			if(a[i] == item)
				result++;
		return result;
	}

	public static void main(String[] args) {
		//DO NOT MODIFY ANY PART OF MAIN METHOD
		int[] arr = {3,1,4,1,5,9,2,6,6}; //math geeks must resist the urge to kill me
		System.out.println(sum(arr)); //should be 37
		System.out.println(sumEven(arr)); //should be 18
		System.out.println(contains(arr, 8)); //should be false
		System.out.println(contains(arr, 9)); //should be true
		System.out.println(countUnique(arr)); //should be 5

		Random r = new Random();
		int[] ages = new int[20];
		int total = 0;
		int below50count = 0;
		for(int i=0; i < ages.length; i++) {
			int age = 1 + r.nextInt(100);
			ages[i] = age;
			System.out.print(age+" ");
			total+=age;
			if(age < 50)
				below50count++;
		}

		System.out.println();

		System.out.println("Average age: "+total * 1.0 / ages.length);

		System.out.println(below50count+" people under 50 years of age");

		boolean consecutiveOver80 = false;
		for(int i=0; i < ages.length - 1 && consecutiveOver80 == false; i++) {
			if(ages[i] > 80 && ages[i+1] > 80)
				consecutiveOver80 = true;
		}

		System.out.println("Two consecutive people over 80: "+consecutiveOver80);
		System.out.println("Items occurring exactly once:");
		for(int i=0; i < ages.length; i++) {
			if(count(ages, ages[i]) == 1)
				System.out.print(ages[i]+" ");
		}
		System.out.println();

	}
}

/*
static methods can only be *directly* called by other static methods
 */
