package com.cinesnacks.init;

import com.android.volley.VolleyError;
import com.cinesnacks.base.BaseModel;
import com.cinesnacks.base.BaseModelListener;
import com.cinesnacks.init.Categories.Category;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 5/11/15.
 */

interface InitModelListener extends BaseModelListener
{

}
public class InitModel extends BaseModel  {

    Categories categories;
    public void handleResponse(String response)
    {
        System.out.print("news response " + response);
        Gson gson = new Gson();
        categories = gson.fromJson(response, Categories.class);
    }

    public void handleError(VolleyError error)
    {
        System.out.println("News fragment handle Error");
    }

    public String[] getCategoryTitles()
    {
        String[] titles = new String[categories.getCount()];
        List<Category> categoriesList = categories.getCategories();
        for (int i = 0; i < categories.getCount(); i++) {
            Category category = categoriesList.get(i);
            titles[i] = category.getTitle();
        }
        return titles;
    }
}
