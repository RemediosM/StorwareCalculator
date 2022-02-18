package com.storware.calculator;

import com.storware.calculator.calculation.SimpleArithmetic;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculationApplicationTests {

	@Test
	void testAddArithmetic() {
		//Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.storware.calculator");
		SimpleArithmetic simpleArithmetic = context.getBean(SimpleArithmetic.class);
		//When
		double addResult = simpleArithmetic.add(2.5, 3.45);
		//Then
		assertEquals(5.95, addResult, 0.0);
	}

	@Test
	void testSubArithmetic() {
		//Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.storware.calculator");
		SimpleArithmetic simpleArithmetic = context.getBean(SimpleArithmetic.class);
		//When
		double subResult = simpleArithmetic.sub(3.0, 4.0);
		//Then
		assertEquals(-1.0, subResult, 0.0);
	}
	@Test
	void testDivArithmetic() {
		//Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.storware.calculator");
		SimpleArithmetic simpleArithmetic = context.getBean(SimpleArithmetic.class);
		//When
		double divResult = simpleArithmetic.div(2.0, 0.5);
		//Then
		assertEquals(4.0, divResult, 0.0);
	}

	@Test
	void testMultiplyArithmetic() {
		//Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.storware.calculator");
		SimpleArithmetic simpleArithmetic = context.getBean(SimpleArithmetic.class);
		//When
		double multiplyResult = simpleArithmetic.multiply(2.0, 0.5);
		//Then
		assertEquals(1.0, multiplyResult, 0.0);
	}



	@Test
	void testDivideByZero(){
		//Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.storware.calculator");
		SimpleArithmetic simpleArithmetic = context.getBean(SimpleArithmetic.class);

		//When
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			simpleArithmetic.div(2.0,0.0);
		});
		String actualMessage = exception.getMessage();

		//Then
		assertTrue(actualMessage.contains("Dzielenie przez 0 jest niedozwolone"));
	}

}
