package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatorTestSuite {

    @Mock
    private Statistics statisticsMock;

    @Nested
    class testCalculationAvrPostCountPerUser{

        @Test
        void testAvrPostsPerUser_p0u0(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(0));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfPostsPerUser();

            //Then
            assertEquals(0, result);

        }

        @Test
        void testAvrPostsPerUser_p1000u0(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(0));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfPostsPerUser();

            //Then
            assertEquals(0, result);

        }

        @Test
        void testAvrPostsPerUser_p0u100(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(100));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfPostsPerUser();

            //Then
            assertEquals(0, result);

        }
        @Test
        void testAvrPostsPerUser_p1000u100(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(100));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfPostsPerUser();

            //Then
            assertEquals(10, result);

        }

    }

    @Nested
    class testCalculationAvrCommentCountPerUser{

        @Test
        void testCalcualtionAvrCommentPerUser_c0u0(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(0));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerUser();

            //Then
            assertEquals(0, result);
        }

        @Test
        void testCalcualtionAvrCommentPerUser_c0u100(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(100));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerUser();

            //Then
            assertEquals(0, result);
        }

        @Test
        void testCalcualtionAvrCommentPerUser_c200u100(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(200);
            when(statisticsMock.usersNames()).thenReturn(generateNamesList(100));

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerUser();

            //Then
            assertEquals(2, result);
        }

    }

    @Nested
    class testCalcilationAvrCommentCountPerPost{

        @Test
        void testCalculationAvrCommentPerPost_c0p0(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerPost();

            //then
            assertEquals(0, result);
        }

        @Test
        void testCalculationAvrCommentPerPost_c200p0(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(200);
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerPost();

            //then
            assertEquals(0, result);
        }

        @Test
        void testCalculationAvrCommentPerPost_c0p1000(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerPost();

            //then
            assertEquals(0, result);
        }

        @Test
        void testCalculationAvrCommentPerPost_c500p1000(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(500);
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerPost();

            //then
            assertEquals(0.5, result);
        }

        @Test
        void testCalculationAvrCommentPerPost_c2000p1000(){
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.commentsCount()).thenReturn(2000);
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double result = statisticsCalculator.getAvrCountOfCommentsPerPost();

            //then
            assertEquals(2, result);
        }


    }

    private List<String> generateNamesList(int lenght){
        List<String> names = new ArrayList<>();

        for (int i = lenght; i > 0; i-- ){
            names.add("name" + i);
        }
        return names;
    }

}
