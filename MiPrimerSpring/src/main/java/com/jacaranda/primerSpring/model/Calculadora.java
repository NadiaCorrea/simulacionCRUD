package com.jacaranda.primerSpring.model;

import java.util.Objects;

public class Calculadora {
	private double num1;
	private double num2;
	private String operation;

	public Calculadora() {
		super();

	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getResult() throws CalculadoraException {
		double result = 0;

		switch (this.operation) {
		case "sumar":
			result = this.num1 + this.num2;
			break;
		case "restar":
			result = this.num1 - this.num2;
			break;
		case "multiplicar":
			result = this.num1 * this.num2;
			break;
		case "dividir":
			if(num2 != 0) {
				result = this.num1 / this.num2;
			} else {
				throw new CalculadoraException("No se puede dividir entre 0.");
			}
			break;

		default:
			throw new CalculadoraException("Los valores introducidos no son válidos.");
	
		}

		return result;

	}

	@Override
	public int hashCode() {
		return Objects.hash(num1, num2, operation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculadora other = (Calculadora) obj;
		return Double.doubleToLongBits(num1) == Double.doubleToLongBits(other.num1)
				&& Double.doubleToLongBits(num2) == Double.doubleToLongBits(other.num2)
				&& Objects.equals(operation, other.operation);
	}

	@Override
	public String toString() {
		return "Calculadora [num1=" + num1 + ", num2=" + num2 + ", operation=" + operation + "]";
	}

}
