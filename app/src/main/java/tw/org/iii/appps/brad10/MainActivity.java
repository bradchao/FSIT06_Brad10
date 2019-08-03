package tw.org.iii.appps.brad10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends ListActivity {
    private SimpleAdapter adapter;
    private String[] from = {"title"};
    private int[] to = {R.id.item_title};
    private LinkedList<HashMap<String,String>> data;
    private final String[] items = {"Android", "Apple", "Windows", "Linux"};
    private int whichOne = 0;

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

        HashMap<String,String> item2 = new HashMap<>();
        item2.put(from[0], "AlertTest2");
        data.add(item2);

        HashMap<String,String> item3 = new HashMap<>();
        item3.put(from[0], "AlertTest3");
        data.add(item3);

        HashMap<String,String> item4 = new HashMap<>();
        item4.put(from[0], "AlertTest4");
        data.add(item4);


        adapter = new SimpleAdapter(
                this, data, R.layout.item, from, to);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch(position){
            case 0: test1(); break;
            case 1: test2(); break;
            case 2: test3(); break;
            case 3: test4(); break;
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
    private void test2(){
        new AlertDialog.Builder(this)
                .setTitle("Title2")
                .setMessage("Message...")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("Later", null)
                .create()
                .show();

    }

    private void test3(){
        final String[] items = {"Android", "Apple", "Windows", "Linux"};

        new AlertDialog.Builder(this)
                .setTitle("Title2")
                .setIcon(R.mipmap.ic_launcher_round)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.v("brad", "=> " + items[i]);
                    }
                })
                .create()
                .show();

    }
    private void test4(){
        new AlertDialog.Builder(this)
                .setTitle("Title2")
                .setIcon(R.mipmap.ic_launcher_round)
                .setSingleChoiceItems(items, whichOne, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        whichOne = i;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast(whichOne);
                    }
                })
                .create()
                .show();

    }

    private void showToast(int i){
        Toast.makeText(MainActivity.this,
                "Item:" + items[i],
                Toast.LENGTH_SHORT).show();

    }

}
