package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> boardListDto = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto("test_board", "test_id", new ArrayList<>());
        boardListDto.add(boardDto);
        //When
        List<TrelloBoard> boardList = trelloMapper.mapToBoards(boardListDto);
        //Then
        assertEquals(boardListDto.size(), boardList.size());
        assertEquals(boardListDto.get(0).getName(), boardList.get(0).getName());
        assertEquals(boardListDto.get(0).getId(), boardList.get(0).getId());
        assertEquals(boardListDto.get(0).getLists(), boardList.get(0).getLists());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> boardList = new ArrayList<>();
        TrelloBoard board = new TrelloBoard("test_board", "test_id", new ArrayList<>());
        boardList.add(board);
        //When
        List<TrelloBoardDto> boardListDto = trelloMapper.mapToBoardsDto(boardList);
        //Then
        assertEquals(boardList.size(), boardListDto.size());
        assertEquals(boardList.get(0).getName(), boardListDto.get(0).getName());
        assertEquals(boardList.get(0).getId(), boardListDto.get(0).getId());
        assertEquals(boardList.get(0).getLists(), boardListDto.get(0).getLists());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> listListDto = new ArrayList<>();
        TrelloListDto listDto = new TrelloListDto("test_list", "test_id", false);
        listListDto.add(listDto);
        //When
        List<TrelloList> listList = trelloMapper.mapToList(listListDto);
        //Then
        assertEquals(listListDto.size(), listList.size());
        assertEquals(listListDto.get(0).getId(), listList.get(0).getId());
        assertEquals(listListDto.get(0).getName(), listList.get(0).getName());
        assertEquals(listListDto.get(0).isClosed(), listList.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> listList = new ArrayList<>();
        TrelloList list = new TrelloList("test_list", "test_id", false);
        listList.add(list);
        //When
        List<TrelloListDto> listListDto = trelloMapper.mapToListDto(listList);
        //Then
        assertEquals(listList.size(), listListDto.size());
        assertEquals(listList.get(0).getId(), listListDto.get(0).getId());
        assertEquals(listList.get(0).getName(), listListDto.get(0).getName());
        assertEquals(listList.get(0).isClosed(), listListDto.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("test name", "test description", "test", "test_id");
        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);
        //Then
        assertEquals(card.getName(), cardDto.getName());
        assertEquals(card.getDescription(), cardDto.getDescription());
        assertEquals(card.getPos(), cardDto.getPos());
        assertEquals(card.getListId(), cardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("test name", "test description", "test", "test_id");
        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);
        //Then
        assertEquals(cardDto.getName(), card.getName());
        assertEquals(cardDto.getDescription(), card.getDescription());
        assertEquals(cardDto.getPos(), card.getPos());
        assertEquals(cardDto.getListId(), card.getListId());
    }
}