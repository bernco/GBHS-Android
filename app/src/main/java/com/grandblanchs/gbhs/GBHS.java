package com.grandblanchs.gbhs;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class GBHS extends ActionBarActivity implements twitter.OnFragmentInteractionListener,
        calendar.OnFragmentInteractionListener, announce.OnFragmentInteractionListener,
        Admin.OnFragmentInteractionListener, staff.OnFragmentInteractionListener,
        NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Create FragmentManager for switching fragments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gbhs);
        //Toast
        Toast.makeText(getApplicationContext(), "Hello GB!", Toast.LENGTH_LONG).show();

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        twitter twitterfragment = new twitter();
        calendar calfragment = new calendar();
        announce announcefragment = new announce();
        Admin adminfragment = new Admin();
        staff stafffragment = new staff();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (number) {
            case 1:
                mTitle = getString(R.string.GBHS);


                break;
            case 2:
                mTitle = getString(R.string.Announce);
                getFragmentManager();
                fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.FragmentContainer, announcefragment);
                fragmentTransaction.commit();
                break;
            case 3:
                mTitle = getString(R.string.Calendar);
                getFragmentManager();
                fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.FragmentContainer, calfragment);
                fragmentTransaction.commit();
                break;
            case 4:
                mTitle = getString(R.string.Twitter);
                getFragmentManager();
                fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.FragmentContainer, twitterfragment);
                fragmentTransaction.commit();

                break;
            case 5:
                mTitle = getString(R.string.Admin);
                getFragmentManager();
                fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.FragmentContainer, adminfragment);
                fragmentTransaction.commit();
                break;
            case 6:
                mTitle = getString(R.string.Staff);
                getFragmentManager();
                fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.FragmentContainer, stafffragment);
                fragmentTransaction.commit();
                break;
            case 7:
                mTitle = getString(R.string.Athletics);
                break;
            case 8:
                mTitle = getString(R.string.BAC);
                break;
            case 9:
                mTitle = getString(R.string.CRC);
                break;
            case 10:
                mTitle = getString(R.string.CSS);
                break;
            case 11:
                mTitle = getString(R.string.Early);
                break;
            case 12:
                mTitle = getString(R.string.Guidance);
                break;
            case 13:
                mTitle = getString(R.string.CTE);
                break;
            case 14:
                mTitle = getString(R.string.Library);
                break;
            case 15:
                mTitle = getString(R.string.NHS);
                break;
            case 16:
                mTitle = getString(R.string.Bully);
                break;
            case 17:
                mTitle = getString(R.string.Student);
                break;
            case 18:
                mTitle = getString(R.string.Summer);
                break;
            case 19:
                mTitle = getString(R.string.Yearbook);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.gbhs, menu);
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



        if (id == R.id.Home) {
            finish();
            Intent start = new Intent(getApplicationContext(), GBHS.class);
            startActivity(start);
        }
        if (id == R.id.Settings) {
            Toast.makeText(getApplicationContext(), "As if.", Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((GBHS) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }


    }
}
