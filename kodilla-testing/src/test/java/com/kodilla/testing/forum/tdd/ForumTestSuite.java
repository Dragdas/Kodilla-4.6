package com.kodilla.testing.forum.tdd;


import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Forum Test Suite ")
public class ForumTestSuite {

    private static int testCounter=0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts{
        @Test
        void testAddPost(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");

            //When
            forumUser.addPost(forumUser.getName(),
                    "Hello");
            int expectedResult = 1;
            int result = forumUser.getPostsQuantity();

            //Then
            assertEquals(expectedResult,result);
        }

        @Test
        void testGetPost(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("HEllO!", forumUser.getName());
            forumUser.addPost(forumUser.getName(), post.getPostBody());

            //When
            ForumPost result = forumUser.getPost(0);

            //Then
            assertEquals(post, result);

        }

        @Test
        void testRemovePostNotExisting(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("hi", forumUser.getName());

            //When
            boolean result = forumUser.removePost(post);

            //Then
            assertFalse(result);

        }

        @Test
        void testRemovePost(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("hi", forumUser.getName());
            forumUser.addPost(forumUser.getName(), post.getPostBody());

            //When
            boolean result = forumUser.removePost(post);

            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getPostsQuantity());

        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestComments{

        @Test
        void testAddComment(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("HEllO!", forumUser.getName());

            //When
            forumUser.addComment(post, forumUser.getName(), "Hello there!");
            int result = forumUser.getCommentsQuantity();
            int expectedResult = 1;

            //Then
            assertEquals(expectedResult, result);
        }

        @Test
        void testGetComment(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("HEllO!", forumUser.getName());
            ForumComment comment = new ForumComment(post, "Hi", forumUser.getName());
            forumUser.addComment(post, forumUser.getName(), comment.getCommentBody());

            //When
            ForumComment result = forumUser.getComment(0);

            //Then
            assertEquals(comment, result);

        }

        @Test
        void testRemoveCommentNotExisting(){
            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("hi", forumUser.getName());
            ForumComment comment = new ForumComment(post, "hello", forumUser.getName());

            //When
            boolean result = forumUser.removeComment(comment);

            //Then
            assertFalse(result);

        }

        @Test
        void testRemoveComment(){

            //Given
            ForumUser forumUser = new ForumUser("Zutek", "Zutkowski");
            ForumPost post = new ForumPost("hi", forumUser.getName());
            ForumComment comment = new ForumComment(post, "hello", forumUser.getName());
            forumUser.addComment(post, forumUser.getName(), comment.getCommentBody());

            //when
            boolean result = forumUser.removeComment(comment);

            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getCommentsQuantity());

        }

    }




}
