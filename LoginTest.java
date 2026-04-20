/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package prog5121poe1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testSuccessfulLogin() {
        boolean result = Login.authenticate("John", "Doe", "jdoe", "1234");
        assertTrue(result);
    }

    @Test
    public void testWrongPassword() {
        boolean result = Login.authenticate("John", "Doe", "jdoe", "wrong");
        assertFalse(result);
    }

    @Test
    public void testWrongUsername() {
        boolean result = Login.authenticate("John", "Doe", "wrong", "1234");
        assertFalse(result);
    }

    @Test
    public void testEmptyFields() {
        boolean result = Login.authenticate("", "", "", "");
        assertFalse(result);
    }
}