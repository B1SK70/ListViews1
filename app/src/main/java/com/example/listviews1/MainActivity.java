package com.example.listviews1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView selection;
    private ListView list;
    private static final String[] items = {"lorem", "ipsum", "dolor", " sit", "amet", "consectetuer", "adipiscing", "elit", "morbi", "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam", "vel", "erat", "placerat", "ante", "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        selection = (TextView) findViewById(R.id.selection);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new IconicAdapter());
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(items[position]);
    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(MainActivity.this, R.layout.row, R.id.word, items);
        }
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            if (items[position].length() > 4) {
                icon.setImageResource(R.drawable.tick_no);
            } else {
                icon.setImageResource(R.drawable.tick);
            }
            return (row);
        }
    }
}






















