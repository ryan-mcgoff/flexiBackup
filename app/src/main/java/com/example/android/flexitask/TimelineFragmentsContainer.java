package com.example.android.flexitask;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.example.android.flexitask.data.taskDBHelper;
import com.github.clans.fab.FloatingActionMenu;


/**
 * Created by Ryan Mcgoff (4086944), Jerry Kumar (3821971), Jaydin Mcmullan (9702973)
 *
 * A {@link Fragment} subclass for the Fixed-task fragment of the app
 * that implements the {@link LoaderManager] interface to pass fixed task data to the a cursor
 * adaptor for the fragment's listview.
 */
public class TimelineFragmentsContainer extends Fragment {


    private static final int TASKLOADER = 0;
    TaskCursorAdaptor mTaskCursorAdaptor;

    private FloatingActionButton mFabFixedTask;
    private FloatingActionMenu mFabMenu;
    /**
     * Database helper that will provide us access to the database
     */
    private taskDBHelper mDbHelper;

    /*ID of list item clicked*/
    private long item_iD;

    private Toolbar bottomBar;

    private boolean toolBarShown;

    private DrawerLayout mDrawerLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        // Find the view pager that will allow the user to swipe between fragment
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        TaskPageAdaptor adapter = new TaskPageAdaptor(getActivity(),getChildFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }
}
