package com.crud.tasks.covering;

import com.crud.tasks.domain.Trello;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloTest {

    @Test
    void trelloTest() {
        //Given
        Trello trello = new Trello();

        //When
        trello.setBoard(1);
        trello.setCard(2);
        int board = trello.getBoard();
        int card = trello.getCard();

        //Then
        assertEquals(1, board);
        assertEquals(2, card);
    }
}
