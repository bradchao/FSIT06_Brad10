package tw.org.iii.appps.brad10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends ListActivity {
    private SimpleAdapter adapter;
    private String[] from = {"title"};
    private int[] to = {R.id.item_title};
    private LinkedList<HashMap<String,String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView(){
        data = new LinkedList<>();

        HashMap<String,String> item1 = new HashMap<>();
        item1.put(from[0], "AlertTest1");
        data.add(item1);

        adapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch(position){
            case 0: test1(); break;
        }

    }

    private void test1(){
        AlertDialog dialog = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setMessage("Message...");
        dialog = builder.create();

        dialog.show();

    }

}
