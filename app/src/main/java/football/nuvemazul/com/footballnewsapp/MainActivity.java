package football.nuvemazul.com.footballnewsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    private String CLASS_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetContentAsyncTask(this).execute();
    }

    public void jumpToNews(View view) {
        startService(new Intent(this, CheckNotificationsService.class));
        super.onResume();
        startActivity(new Intent(this, NewsActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(CLASS_NAME, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(CLASS_NAME, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(CLASS_NAME, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(CLASS_NAME, "onStop");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuItem item = menu.add("Search");
        item.setIcon(android.R.drawable.ic_menu_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
