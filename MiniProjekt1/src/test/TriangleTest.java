package test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Triangle;

public class TriangleTest {
	Triangle triangle;
	
	@BeforeEach
	void init() {
		triangle = new Triangle();
	}

    @Test
    @DisplayName("Test getUserInput with valid input")
    void getUserInputValidInput() {
        provideUserInput("3,4,5");
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test getUserInput with invalid format")
    void getUserInputInvalidInput() {
        provideUserInput("a,b,c,d");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test getUserInput with invalid format")
    void getUserInputInvalidInput2() {
        provideUserInput("a,b");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test getUserInput with invalid format")
    void getUserInputInvalidFormat() {
        provideUserInput("1.2.3");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test getUserInput with non-numeric input")
    void getUserInputNonNumericInput2() {
        provideUserInput("one,two,three");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test getUserInput with non-numeric input")
    void getUserInputNonNumericInput() {
        provideUserInput("one,two,three");
        assertThrows(NumberFormatException.class, triangle.getUserInput());
    }

    private void provideUserInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
	
	@Test
	@DisplayName("Test toString when current_type == SCALENE")
		void toStringScalene() {
		triangle.setCurrent_type(3, 4, 5);
		String temp = "" + 3 + ", " + 4 + ", " + 5 + ", This is a Scalene triangle";
		assertEquals(temp, triangle.toString());
		}
	
	@Test
	@DisplayName("Test toString when current_type == ISOSCELES")
		void toStringIsosceles() {
		triangle.setCurrent_type(3, 4, 3);
		String temp = "" + 3 + ", " + 4 + ", " + 3 + ", This is a Isosceles triangle";
		assertEquals(temp, triangle.toString());
		}
	
	
	@Test
	@DisplayName("Test toString when current_type == EQUILATERAL")
		void toStringEquilateral() {
		triangle.setCurrent_type(3, 3, 3);
		String temp = "" + 3 + ", " + 3 + ", " + 3 + ", This is a Equilateral triangle";
		assertEquals(temp, triangle.toString());
		}
	
	@Test
	@DisplayName("Test toString when current_type == null")
	void toStringNull() {
		triangle.getCurrent_type();
		assertNull(triangle.getCurrent_type());
	}
	
	@Test
	@DisplayName("Boundary testing for input")
	void setCurrent_typeBoundaryValues() {
	    triangle.setCurrent_type(1, Integer.MAX_VALUE, 1);
	    assertNull(triangle.getCurrent_type());
	}
	
	@Test
	@DisplayName("Boundary testing for input")
	void setCurrent_typeBoundaryValues2() {
	    triangle.setCurrent_type(1, Integer.MIN_VALUE, 1);
	    assertNull(triangle.getCurrent_type());
	}
	
	@Test
    @DisplayName("Test setCurrent_type with valid sides for isosceles")
    void setCurrent_typeValidIsosceles() {
		triangle.setCurrent_type(3, 3, 4);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
	
	@Test
    @DisplayName("Test setCurrent_type with valid sides for isosceles")
    void setCurrent_typeValidIsosceles2() {
		triangle.setCurrent_type(3, 4, 3);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
	
	@Test
    @DisplayName("Test setCurrent_type with valid sides for isosceles")
    void setCurrent_typeValidIsosceles3() {
		triangle.setCurrent_type(4, 3, 3);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
	
	@Test
    @DisplayName("Test setCurrent_type with valid sides for equilateral")
    void setCurrent_typeValidEquilateral() {
		triangle.setCurrent_type(3, 3, 3);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }
	
	@Test
    @DisplayName("Test setCurrent_type with valid sides for scalene")
    void setCurrent_typeValidScalene() {
        triangle.setCurrent_type(3, 4, 5);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test setCurrent_type with one side too long")
    void setCurrent_typeInvalidSides() {
        triangle.setCurrent_type(1, 1, 3); 
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test setCurrent_type with one side too long")
    void setCurrent_typeInvalidSides2() {
        triangle.setCurrent_type(1, 3, 1); 
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test setCurrent_type with one side too long")
    void setCurrent_typeInvalidSides3() {
        triangle.setCurrent_type(3, 1, 1); 
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test setCurrent_type with a negative side")
    void setCurrent_typeNegativeSide() {
        triangle.setCurrent_type(-1, 1, 3); 
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test setCurrent_type with a negative side")
    void setCurrent_typeNegativeSide2() {
        triangle.setCurrent_type(1, -1, 3); 
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test setCurrent_type with a negative side")
    void setCurrent_typeNegativeSide3() {
        triangle.setCurrent_type(1, 1, -3); 
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test getCurrent_type with valid sides")
    void getCurrent_typeValidSides() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test getCurrent_type with invalid sides")
    void getCurrent_typeInvalidSides() {
        Triangle triangle = new Triangle(1, 1, 3);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test getCurrent_type after setting sides")
    void getCurrent_typeAfterSetCurrentType() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test constructor with valid string array")
    void testConstructorWithStringArray() {
        String[] sides = {"3", "4", "5"};
        Triangle triangle = new Triangle(sides);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test constructor with too short string array")
    void testConstructorWithInvalidStringArray() {
        String[] sides = {"3", "4"};
        Triangle triangle = new Triangle(sides);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test constructor with NumberFormatException to reach current_type = null")
    void testConstructorWithInvalidNumberFormatException() {
        String[] sides = {"3", "4", "q"};
        Triangle triangle = new Triangle(sides);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test constructor with NumberFormatException")
    void testConstructorWithInvalidNumberFormatException2() {
    	String[] sides = {"Q", "'", "<"};
        assertThrows(NumberFormatException.class, triangle = new Triangle(sides));
    }
}
