
package rules;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test
{
    // Original MIT test
    @Test
    public void testMayUseCodeInAssignment()
    {
        assertFalse("Expected false: un-cited publicly-available code",
            RulesOf6005.mayUseCodeInAssignment(
                false, true, false, false, false));

        assertTrue("Expected true: self-written required code",
            RulesOf6005.mayUseCodeInAssignment(
                true, false, true, true, true));
    }

    // Test 1: Properly cited external code is allowed.
    @Test
    public void testCitedExternalCodeAllowed()
    {
        assertTrue(
            RulesOf6005.mayUseCodeInAssignment(
                false, true, false, true, false)
        );
    }

    // Test 2: Another student's coursework is prohibited.
    @Test
    public void testOtherStudentCourseworkRejected()
    {
        assertFalse(
            RulesOf6005.mayUseCodeInAssignment(
                false, true, true, true, false)
        );
    }

    // Test 3: External code cannot replace required work.
    @Test
    public void testRequiredImplementationRejectsExternalCode()
    {
        assertFalse(
            RulesOf6005.mayUseCodeInAssignment(
                false, true, false, true, true)
        );
    }
}
