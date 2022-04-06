package com.kodilla.testing.forum;


import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;


@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void befor(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUserName(){
        //Given
        SimpleUser userTest = new SimpleUser("Tester");

        //When
        String result = userTest.getUserName();

        String expectedResult = "Tester";

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("getRealName should return real name of the user")
    @Test
    void testCaseRealName(){
        //Given
        SimpleUser userTest = new SimpleUser("Tester", "Ziutek");

        //When
        String result = userTest.getRealName();

        String expectedResult = "Ziutek";

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

}
