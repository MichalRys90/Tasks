package com.crud.tasks.covering;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloConfigTestSuit {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void testTrelloConfig() {

        //Given

        //When
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();
        String trelloAppKey = trelloConfig.getTrelloAppKey();
        String trelloToken = trelloConfig.getTrelloToken();
        String username = trelloConfig.getUsername();

        //Then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
        assertEquals("989d2f2cb5c055851b1aa65918fb4b50", trelloAppKey);
        assertEquals("c5453cc71630592c41e4c9a530968e76310933b07ee4a4bcda7dcdbbdd123f44", trelloToken);
        assertEquals("michalrys1", username);
    }
}
