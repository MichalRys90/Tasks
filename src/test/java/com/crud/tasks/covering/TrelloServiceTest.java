package com.crud.tasks.covering;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Test
    public void testTrelloServiceMethods() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "1");
        List<CreatedTrelloCardDto> createdTrelloCardDtos = new ArrayList<>();

        // When
        List<TrelloBoardDto> anotherTrelloBoardDtos = trelloService.fetchTrelloBoards();
        CreatedTrelloCardDto createdTrelloCardDto = trelloService.createTrelloCard(trelloCardDto);
        createdTrelloCardDtos.add(createdTrelloCardDto);

        // Then
        assertEquals(0, anotherTrelloBoardDtos.size());
        assertEquals(1, createdTrelloCardDtos.size());
    }
}
