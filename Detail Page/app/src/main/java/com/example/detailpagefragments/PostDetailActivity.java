package com.example.detailpagefragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

/**
 * An activity representing a single Post detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link PostListActivity}.
 */
public class PostDetailActivity extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_post_detail);
        extras = getIntent().getExtras();


        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        toolbar.setTitle(extras.getString(PostDetailFragment.ARG_ITEM_TITLE));
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            Bundle arguments = new Bundle();

            arguments.putString(PostDetailFragment.ARG_ITEM_ID, extras.getString(PostDetailFragment.ARG_ITEM_ID));
            arguments.putString(PostDetailFragment.ARG_ITEM_BODY, extras.getString(PostDetailFragment.ARG_ITEM_BODY));
            arguments.putString(PostDetailFragment.ARG_ITEM_TITLE, extras.getString(PostDetailFragment.ARG_ITEM_TITLE));
            PostDetailFragment fragment = new PostDetailFragment();

            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.post_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, PostListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
