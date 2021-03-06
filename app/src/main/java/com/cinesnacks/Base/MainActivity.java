package com.cinesnacks.base;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cinesnacks.init.InitModel;
import com.cinesnacks.news.NewsFragment;
import com.example.elamvazhuthik.cinesnacks.R;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer  test.
     */
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private InitModel initModel;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = getTitle();
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        String titles[] = getResources().getStringArray(R.array.drawer_titles);
        mNavigationDrawerFragment.setDrawerListViewData(titles);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
//        List<Fragment> fragmentList = fragmentManager.getFragments();
//        fragmentList.clear();
//        Fragment containerFragment;
//        String backStackFragment;
        switch (position) {
            case 1:
                MainViewPager mainViewPager = new MainViewPager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, mainViewPager)
                        .commit();
                break;
            default:
                NewsFragment newsFragment = new NewsFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, newsFragment)
                        .commit();
                break;
        }
    }

    public void onSectionAttached(int number) {

        String titles[] = getResources().getStringArray(R.array.drawer_titles);
        mTitle = titles[number];
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void onBackPressed()
//    {
//        // Catch back action and pops from backstack
//        // (if you called previously to addToBackStack() in your transaction)
//        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
//            getSupportFragmentManager().popBackStack();
//        }
//        // Default action on back pressed
//        else super.onBackPressed();
//    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (getSupportFragmentManager().getBackStackEntryCount() > 0){
//                getSupportFragmentManager().popBackStack();
//            }
//            return true;
//        }else {
////            exitAlert();
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}


