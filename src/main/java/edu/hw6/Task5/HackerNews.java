package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackerNews implements IHackerNews {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int GROUP_OF_TITLE = 2;
    private String topStoriesURI = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static String newsURIWithoutExpansion = "https://hacker-news.firebaseio.com/v0/item/";
    private static final String EXPANSION_JSON = ".json";
    private static final String URI_ERROR = "URI error: ";
    private static final String CONNECTION_ERROR = "Connection error: ";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION = "application/json";

    public HackerNews() {
    }

    public HackerNews(String otherURI, boolean topStories) {
        if (topStories) {
            this.topStoriesURI = otherURI;
        } else {
            this.newsURIWithoutExpansion = otherURI;
        }
    }

    @Override
    public long[] hackerNewsTopStories() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(topStoriesURI))
                .GET()
                .header(CONTENT_TYPE, APPLICATION)
                .build();

            HttpResponse<String> response
                = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return makeTopStoriesIDsArray(response);
        } catch (URISyntaxException e) {
            LOGGER.info(URI_ERROR + e);
            return new long[0];
        } catch (IOException | InterruptedException e) {
            LOGGER.info(CONNECTION_ERROR + e);
            return new long[0];
        }
    }

    @Override
    public String news(long id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(makeNewsRequestString(id)))
                .GET()
                .header(CONTENT_TYPE, APPLICATION)
                .build();

            HttpResponse<String> response
                = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return findTitle(response);
        } catch (URISyntaxException e) {
            LOGGER.info(URI_ERROR + e);
        } catch (IOException | InterruptedException e) {
            LOGGER.info(CONNECTION_ERROR + e);
        }
        return "";
    }

    private static long[] makeTopStoriesIDsArray(HttpResponse<String> response) {
        String[] stringArrayIDs = response.body().split(",");

        stringArrayIDs[0] = stringArrayIDs[0].substring(1);
        stringArrayIDs[stringArrayIDs.length - 1]
            = stringArrayIDs[stringArrayIDs.length - 1].substring(
            0,
            stringArrayIDs[stringArrayIDs.length - 1].length() - 1
        );

        long[] longArrayIDs = new long[stringArrayIDs.length];
        for (int i = 0; i < stringArrayIDs.length; ++i) {
            longArrayIDs[i] = Long.parseLong(stringArrayIDs[i]);
        }
        return longArrayIDs;
    }

    private static String makeNewsRequestString(long id) {
        return newsURIWithoutExpansion + id + EXPANSION_JSON;
    }

    private static String findTitle(HttpResponse<String> response) {
        String regex = "^.*(\"title\":\"(.+)(\",\"type\":)).*$";
        Matcher matcher = Pattern.compile(regex).matcher(response.body());

        return matcher.find() ? matcher.group(GROUP_OF_TITLE) : "";
    }

}
