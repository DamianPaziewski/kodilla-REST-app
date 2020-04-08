package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {
    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void testTrelloConfig() {
        assertEquals("damianpaziewski1988", trelloConfig.getTrelloUsername());
        assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());
        assertEquals("34de899fc696d0154861e4a2f25efb70", trelloConfig.getTrelloAppKey());
        assertEquals("62138e243fdc9c0ac3805bc92fedbabd4e1a9c1017140eea229134cc13b24e5e", trelloConfig.getTrelloToken());
    }
}