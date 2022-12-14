package com.crud.tasks.covering;

import com.crud.tasks.domain.AtachmentsByType;
import com.crud.tasks.domain.Badges;
import com.crud.tasks.domain.Trello;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgesTest {

    @Test
    void testBadges() {
        //Given
        Trello trello = new Trello();
        AtachmentsByType atachmentsByType = new AtachmentsByType();
        atachmentsByType.setTrello(trello);
        Badges badges = new Badges();
        badges.setVotes(1);
        badges.setAttachmentsByType(atachmentsByType);

        //When
        AtachmentsByType result = badges.getAttachmentsByType();
        Trello resultTrello = badges.getAttachmentsByType().getTrello();
        int resultVotes = badges.getVotes();

        //Then
        assertEquals(atachmentsByType, result);
        assertEquals(trello, resultTrello);
        assertEquals(1, resultVotes);
    }
}
