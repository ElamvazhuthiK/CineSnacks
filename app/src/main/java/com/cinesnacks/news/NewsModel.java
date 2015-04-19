package com.cinesnacks.news;

import java.util.ArrayList;

/**
 * Created by ElamvazhuthiK on 15/04/15.
 */
public class NewsModel {
    public class NewsItem {

        String strTitle;
        String strTitleIconLink;
        String strTime;
        String strDescription;
        NewsItem()
        {

        }
    }
    ArrayList<NewsItem>  newsAryList = new ArrayList<NewsItem>();
    NewsModel ()
    {
        for(int i = 0; i<5; i++)
        {
            NewsItem newsItem = new NewsItem();
            newsItem.strTitle = "Title " + (i + 1);
            newsItem.strDescription = "Description " + (i + 1);
            newsAryList.add(newsItem);
        }
    }
}
