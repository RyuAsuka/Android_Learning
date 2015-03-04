package edu.ecnu.asuka.androidlearning;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayMessageActivity extends Activity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        setContentView(textView);

        txt = textView;
        registerForContextMenu(txt);
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

        if(item.isCheckable()){
            item.setChecked(true);
        }

        switch (item.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_12:
                txt.setTextSize(12*2);
                break;
            case R.id.font_14:
                txt.setTextSize(14*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.font_18:
                txt.setTextSize(18*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.plain_item:
                Toast toast = Toast.makeText(DisplayMessageActivity.this, "您单击了普通菜单项", Toast.LENGTH_SHORT);
                toast.show();
                break;

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_display_message, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater inflator = new MenuInflater(this);
        inflator.inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("请选择背景色");
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi){
        mi.setChecked(true);
        switch (mi.getItemId()){

            case R.id.red:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }

}
