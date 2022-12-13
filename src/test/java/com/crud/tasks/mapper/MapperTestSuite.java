package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testTrelloMapper() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "name", false);
        TrelloListDto trelloListDto1 = new TrelloListDto("2", "name1", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);
        trelloListDtos.add(trelloListDto1);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "name", trelloListDtos);
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "1");
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        List<TrelloBoardDto> trelloBoardDtos1 = trelloMapper.mapToBoardsDto(trelloBoards);
        List<TrelloList> lists = trelloMapper.mapToList(trelloListDtos);
        List<TrelloListDto> trelloListDtos1 = trelloMapper.mapToListDto(lists);
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        TrelloCardDto trelloCardDto1 = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals("1", trelloBoardDtos1.get(0).getId());
        assertEquals(2, lists.size());
        assertEquals("name1", trelloListDtos1.get(1).getName());
        assertEquals("pos", trelloCard.getPos());
        assertEquals("1", trelloCardDto1.getListId());
    }

    @Test
    void testTaskMapper() {
        //Given
        Task task1 = new Task(1L, "title1", "content1");
        Task task2 = new Task(2L, "title2", "content2");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task1);
        Task task = taskMapper.mapToTask(taskDto);
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals("title1", taskDto.getTitle());
        assertEquals("content1", task.getContent());
        assertEquals(2, taskDtos.size());
    }
}
