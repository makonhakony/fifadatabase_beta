package com.example.hakony.fifadatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchFragment extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private SearchView searchView;
    private ListView listView;
    //String[] Name = {"Perisic", "Ronaldo", "Messi"};
    public static ArrayList<Player> PlayersList = new ArrayList<>();
    PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.lvData);
        PlayersList = new ArrayList<>();
        PlayersList.add(new Player("azyqnzlr","ST", "113885", "-1", "Ronaldo", "ST", "91", "NHD", "5"));
        PlayersList.add(new Player("dvnpmody","CAM", "113885", "-1", "Ronaldinho", "CAM", "91", "NHD", "5'"));
        PlayersList.add(new Player("zgkvjolm","LW", "243", "1354", "Cristiano Ronaldo", "LW", "91", "18TOTY", "5'"));
        PlayersList.add(new Player("zgqmrjpr","ST", "113956", "-1", "Cristiano Ronaldo", "ST", "91", "TB", "5"));

        //khoi tao adapter
        adapter = new PlayerAdapter(this, R.layout.row, PlayersList);
        //set adapter cho listView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchFragment.this, PlayersList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // them search vao action bar
        getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem itemSearch = menu.findItem(R.id.search_view);
        searchView = (SearchView) itemSearch.getActionView();
        //set onQueryTextListener cho search view de thuc hien search theo text
        searchView.setOnQueryTextListener(this);
        return true;
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            adapter.getFilter().filter("");
            listView.clearTextFilter();
        } else {
            adapter.getFilter().filter(newText);
        }
        return false;
    }

}
