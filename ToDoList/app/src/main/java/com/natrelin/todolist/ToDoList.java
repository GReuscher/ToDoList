package com.natrelin.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate your view
        setContentView(R.layout.activity_to_do_list);

        // Get references to UI widgets
        ListView myListView = (ListView) findViewById(R.id.myListView);
        final EditText myEditText = (EditText) findViewById(R.id.myEditText);

        // Create the Array List of to do items
        final ArrayList<String> todoItems = new ArrayList<String>();

        // Create the Array Adapter to bind the array to do the List view
        final ArrayAdapter<String> aa;

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        // Bind the Array Adapter to the List View
        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        todoItems.add(0, myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
