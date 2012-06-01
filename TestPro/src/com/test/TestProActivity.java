package com.test;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TestProActivity extends ListActivity {
    /** Called when the activity is first created. */
	
	static final String[] COUNTRIES = new String[] {
	    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
	    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  setListAdapter(new ArrayAdapter(this, R.layout.list_item, COUNTRIES));
	  

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	 /* lv.setOnItemClickListener(new OnItemClickListener() {
	   

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			 Toast.makeText(getApplicationContext(), ((TextView) arg1).getText(),
			          Toast.LENGTH_SHORT).show();
			openOptionsMenu();
		}
	  });*/
	  
	  lv.setOnItemClickListener(new ItemHighlighterListener());
	  
	 
	}
	
	 @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.gamemenu, menu);
	      return true;
	  }
	
	private class ItemHighlighterListener implements OnItemClickListener{

	    private View lastSelectedView = null;

	    public void clearSelection()
	    {
	        if(lastSelectedView != null) lastSelectedView.setBackgroundColor(android.R.color.transparent);
	    }

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			 clearSelection();
			 lastSelectedView = arg1;
		     arg1.setBackgroundDrawable(arg1.getContext().getResources().getDrawable(R.drawable.images));
		}
	}
	
}