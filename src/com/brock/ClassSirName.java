package com.brock;

public class ClassSirName extends ClassMiddleName{

	public void getSirname() {
		System.out.println("Waghmare");
	}
	public static void main(String[] args) {
		ClassSirName classSirName= new ClassSirName();
		classSirName.getName();
		classSirName.getMiddleName();
		classSirName.getSirname();
	}
}
