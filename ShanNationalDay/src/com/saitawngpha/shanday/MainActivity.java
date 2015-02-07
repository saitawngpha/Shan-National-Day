package com.saitawngpha.shanday;

import java.util.concurrent.TimeUnit;
import android.R.string;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button play_button, pause_button;
	MediaPlayer player;
	TextView text_shown;
	Typeface Zawgyi;
	TextView title;
	final Context context = this;
	private final static int MYITEMID = 42;
	private static final MediaPlayer Player = null;
	private String PINK = "#f4525a";
	private Object actionBar;
	private Object tf;
	private ColorStateList RED;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    
    int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
    TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
    Typeface forte = Typeface.createFromAsset(getAssets(), "fonts/PangLong.ttf");
    if(actionBarTitleView != null){
    actionBarTitleView.setTypeface(forte);
    actionBarTitleView.setTextSize(20);
    
    }
    
  //ActionBar actionBar = getActionBar();
   // actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));// set your desired color
   //actionBar.setIcon(R.drawable.ic_launcher);
  //actionBar.setTitle("�?�ူ�?�်း�?�?�");
    
    
    
    ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
    ImageAdapter adapter = new ImageAdapter(this);
    viewPager.setAdapter(adapter);
    
    getInit();
	       
  }
  private ActionBar getSupportActionBar() {
	// TODO Auto-generated method stub
	return null;
}
public void getInit() {
		
		play_button = (Button) findViewById(R.id.play);
		pause_button = (Button) findViewById(R.id.pause);
		play_button.setOnClickListener(this);
		pause_button.setOnClickListener(this);
		player = MediaPlayer.create(this, R.raw.song);
		

	}

	Runnable run = new Runnable() {

		@Override
		public void run() {
			
		}
	};
	private int pre;
	private int exit;
	private int about;
	private Activity dialog;
	private int TextView;


	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.play:
			player.start();
			pause_button.setVisibility(View.VISIBLE);
			play_button.setVisibility(View.GONE);
			player.setLooping(true);  // for repeat song 
			player.start();
			break;
		case R.id.pause:
			player.pause();
			play_button.setVisibility(View.VISIBLE);
			pause_button.setVisibility(View.GONE);
			
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		//Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
		
	}
	
	@Override
	
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        switch (item.getItemId()) {
            
                
            case R.id.about:
            	
            	Intent intent = new Intent(getBaseContext(), about.class);
                startActivity(intent);
    	     return true;
    	        
    		
            case R.id.exit:
        				AlertDialog dialog1 = new AlertDialog.Builder(this)
                    	.setTitle("Credit :(")
                    	.setMessage("ၶႅပ်းႁၢင်ႈ- Facebook\nတႅမ်ႈလိၵ်ႈ- ေႁႃသႅင်\nၶူင်သၢင်ႈ- ၸၢႆးတွင်ႉၾႃႉ")
                    	.setIcon(R.drawable.ic_launcher)
        	            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
        	            public void onClick(DialogInterface dialog, int which) { 
        	                // continue with delete
        	            	dialog.cancel();
        	            }
        	         })
        	         .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
        	            public void onClick(DialogInterface dialog, int which) { 
        	            	// if this button is clicked, close
    						// current activity
        	            	dialog.cancel();
        	            }
        	         })
                    	.show();
                    	TextView textView = (TextView) dialog1.findViewById(android.R.id.message);
                    	textView.setTextColor(Color.RED);
                    	textView.setTextSize(25);
                    	textView.setGravity(Gravity.CENTER);
                    	
                    	Typeface face2=Typeface.createFromAsset(getAssets(),"fonts/PangLong.ttf"); 
                    	textView.setTypeface(face2);
                    	
    	        return true;
            default:
            	return super.onOptionsItemSelected(item);
        }
    }
	
	
	@Override
    public void onBackPressed() {
        AlertDialog dialog2 = new AlertDialog.Builder(this)
    	.setTitle("Close")
    	.setMessage("ေတပိၵ်ႉယဝ်ႉႁႃႉ?")
    	.setIcon(R.drawable.ic_launcher)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	player.pause();
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No", null).show();
        TextView textView2 = (TextView) dialog2.findViewById(android.R.id.message);
    	textView2.setTextColor(Color.RED);
    	textView2.setTextSize(25);
    	textView2.setGravity(Gravity.CENTER);
    	Typeface face2=Typeface.createFromAsset(getAssets(),"fonts/PangLong.ttf"); 
    	textView2.setTypeface(face2);
    }
	
	}
	
	
    

  

  

