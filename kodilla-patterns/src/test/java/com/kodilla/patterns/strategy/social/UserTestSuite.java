package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){
        //Given
        Millenials milenial = new Millenials("Mil");
        YGeneration yGen = new YGeneration("Ygen");
        ZGeneration zGen = new ZGeneration("ZGenner");

        //When
        String milenialTest = milenial.sharePost();
        String yGenerTest = yGen.sharePost();
        String zGenTest = zGen.sharePost();

        assertEquals("[Facebook] sharing post", milenialTest);
        assertEquals("[Twitter] sharing post", yGenerTest);
        assertEquals("[Snapchat] sharing post", zGenTest);


    }

    @Test
    void testIndividualSharingStrategy(){

        //Given
        Millenials milenial = new Millenials("Mil");
        YGeneration yGen = new YGeneration("Ygen");
        ZGeneration zGen = new ZGeneration("ZGenner");

        //When
        milenial.setSocialPublisher(new TwitterPublisher());
        yGen.setSocialPublisher(new SnapchatPublisher());
        zGen.setSocialPublisher(new FacebookPublisher());

        String milenialTest = milenial.sharePost();
        String yGenerTest = yGen.sharePost();
        String zGenTest = zGen.sharePost();

        assertEquals("[Twitter] sharing post", milenialTest);
        assertEquals("[Snapchat] sharing post", yGenerTest);
        assertEquals("[Facebook] sharing post", zGenTest);

    }



}
