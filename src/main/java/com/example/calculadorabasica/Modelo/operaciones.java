package com.example.calculadorabasica.Modelo;

public class operaciones {
	private double num1;
	private double num2;

	public operaciones(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public double add(double num1, double num2) { 
		return num1 + num2;
	}

	public double sub(double num1, double num2) {
		return num1 - num2;
	}

	public double moult(double num1, double num2) {
		return num1 * num2;
	}

	public double div(double num1, double num2) {
		return num1 / num2;
	}
}
