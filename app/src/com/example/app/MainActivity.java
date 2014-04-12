package com.example.app;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements OnClickListener {
    	protected static final Random Random = null;
		EditText editText1;
    	Button button1;
    	TextView textView1;
		private ImageView[] images;
        public  PlaceholderFragment() {
        	
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            editText1 = (EditText)rootView.findViewById(R.id.editText1); 
            button1 = (Button)rootView.findViewById(R.id.button1);
            textView1 = (TextView)rootView.findViewById(R.id.textView1);
            images = new ImageView[3];
            images[0] = (ImageView)rootView.findViewById(R.id.imageView1);
            images[1] = (ImageView)rootView.findViewById(R.id.imageView2);
            images[2] = (ImageView)rootView.findViewById(R.id.imageView3);
            
            for( int i=0 ; i<3 ; i++)
            	images[i].setVisibility(View.INVISIBLE);
            
            button1.setOnClickListener(this);
            
            return rootView;
            
          }
        @Override
        public void onClick(View v){ 
      	  Random rand = new Random();
            int n = rand.nextInt(3);
      	  images[n].setVisibility(View.VISIBLE);
    	  Toast.makeText(getActivity(), "Hello, "+ editText1.getText() + "!", Toast.LENGTH_SHORT).show();
    	}	
        
    }
}
