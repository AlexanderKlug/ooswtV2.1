package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.DivisionException;
import exceptions.SymbolException;
import facade.Facade;

class ExecptionTest {
	private static final String WRONGEXCEPTION = "Wrong Exception was thrown!";
	private static final String NOEXCEPTION = "No Exception was thrown";
	Facade facade;
	
	@Test
	void test1() throws SymbolException, DivisionException {
		this.facade = new Facade();
		this.checkPossibleExceptions(
				() -> facade.evaluate("5/0")
		, DivisionException.class);
	}

	@Test
	void test2() {
		this.facade = new Facade();
		this.checkPossibleExceptions(new test.Test() {
			
			@Override
			public void execute() throws Exception {
				facade.evaluate("5/0");
			}
		},DivisionException.class);
	}
	
	@Test
	void test3() {
		this.facade = new Facade();
		this.checkPossibleExceptions(
				() -> this.facade.checkSyntax("5 plus 5")
		, SymbolException.class);
	}
	
	@Test
	void test4() {
		this.facade = new Facade();
		this.checkPossibleExceptions(
			() -> facade.checkSyntax("5//")
			, SymbolException.class);
	}
	
	@Test
	void test5() {
		this.facade = new Facade();
		this.checkPossibleExceptions(
			() -> facade.checkSyntax("(8*2")
			, SymbolException.class);
	}
	
	@Test
	void test6() {
		this.facade = new Facade();
		this.checkPossibleExceptions(
			() -> facade.checkSyntax("2*+3")
			, SymbolException.class);
	}
	@Test
	void test7() {
		this.facade = new Facade();
		this.checkPossibleExceptions(
			() -> facade.checkSyntax("5f5")
			, SymbolException.class);
	}
	
	/*
	 * basic Method to test if certain Exceptions are thrown
	 */
	private void checkPossibleExceptions(test.Test t, Class exceptionExpected) {
		try {
			t.execute();
			fail(NOEXCEPTION + " expectedt " + exceptionExpected.getName() + " to be thrown!");
		}catch(Exception e) {
			if(!(e.getClass().equals(exceptionExpected))) {
				System.out.println(e.getMessage());
				fail(WRONGEXCEPTION + " expectedt " + exceptionExpected.getName() + " to be thrown!");
			}
		}
	}

}
