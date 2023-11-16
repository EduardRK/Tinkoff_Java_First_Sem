package edu.hw6;

import edu.hw6.Task5.HackerNews;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    @DisplayName("Get top stories IDs array (valid)")
    public void getTopStoriesIDsArrayValid() {
        HackerNews hackerNews = new HackerNews();
        long[] topStoriesIDs = hackerNews.hackerNewsTopStories();
        Assertions.assertTrue(topStoriesIDs.length != 0);
    }

    @Test
    @DisplayName("Get top stories IDs array (invalid)")
    public void getTopStoriesIDsArrayInvalid() {
        HackerNews hackerNews = new HackerNews("Other URI", true);
        long[] topStoriesIDs = hackerNews.hackerNewsTopStories();
        Assertions.assertEquals(0, topStoriesIDs.length);
    }

    @Test
    @DisplayName("Get some news (valid)")
    public void getSomeNewsValid() {
        HackerNews hackerNews = new HackerNews();
        Map<Long, String> map = new HashMap<>(Map.of(37570037L, "JDK 21 Release Notes",
            38287095L, "The push to save the Itanium architecture in Linux",
            38276743L, "The truth is always made of details",
            38276680L, "The Great Sphinx of Giza may have have started out as a natural formation",
            38272738L, "The largest waterfall is underwater"
        ));

        for (long id : map.keySet()) {
            Assertions.assertEquals(map.get(id), hackerNews.news(id));
        }
    }

    @Test
    @DisplayName("Get some news (invalid URI)")
    public void getSomeNewsInvalidURI() {
        HackerNews hackerNews = new HackerNews("Other URI", false);
        Assertions.assertEquals("", hackerNews.news(38287095L));
    }

    @Test
    @DisplayName("Get some news (invalid ID)")
    public void getSomeNewsInvalidID() {
        HackerNews hackerNews = new HackerNews();
        Assertions.assertEquals("", hackerNews.news(0L));
    }
}

