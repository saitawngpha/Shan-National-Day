package com.saitawngpha.shanday;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class about extends Activity

{

    public void onCreate(Bundle savedInstanceState)
    
    {
    
           super.onCreate(savedInstanceState);
           setContentView(R.layout.about_main);
           
           TextView text = (TextView)findViewById(R.id.TextView01);
           text.setText(R.string.txt_txt);
           Typeface face=Typeface.createFromAsset(getAssets(),"fonts/PangLong.ttf"); 
           text.setTypeface(face);

           //set up image view
           ImageView img = (ImageView)findViewById(R.id.ImageView01);
           img.setImageResource(R.drawable.shanday); 
           //set up image view
           ImageView img1 = (ImageView)findViewById(R.id.ImageView02);
           img1.setImageResource(R.drawable.tai);
           
           Button button = (Button)findViewById(R.id.Button01);
           Typeface face1 =Typeface.createFromAsset(getAssets(),"fonts/PangLong.ttf"); 
           button.setTypeface(face1);
           button.setOnClickListener(new OnClickListener() {
           @Override
               public void onClick(View v) {
        	   about.this.finish();
        	   Intent intent = new Intent(getBaseContext(), MainActivity.class);
               startActivity(intent);
               }
           }); 
           }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		//Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		
		return true;
		
	}
	
	@Override
	
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        switch (item.getItemId()) {
            
                
            case R.id.home:
            	
            	Intent intent = new Intent(getBaseContext(), MainActivity.class);
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
                        about.this.finish();
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

		