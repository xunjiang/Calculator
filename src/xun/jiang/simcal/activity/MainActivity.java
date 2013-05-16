package xun.jiang.simcal.activity;

import java.util.ArrayList;

import xun.jiang.simcal.R;
import xun.jiang.simcal.R.layout;
import xun.jiang.simcal.R.menu;
import xun.jiang.simcal.util.FlagUtil;
import xun.jiang.simcal.util.Util;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	int numbuttonId[] = { R.id.button1, R.id.button2, R.id.button3,
			R.id.button3, R.id.button4, R.id.button5, R.id.button6,
			R.id.button7, R.id.button8, R.id.button9

	};
	int optbuttonId[] = { R.id.buttonplus, R.id.buttonminus, R.id.buttonmul,
			R.id.buttondivide, R.id.buttondot

	};

	
	Button dotButton;
	Button clearButton;
	Button cancelButton;
	Button zeroButton;
	Button equalButton;
	EditText edittext;
	Util util = new Util();
	FlagUtil flagutil;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<Button> numButton = new ArrayList<Button>();
		ArrayList<Button> numOpt = new ArrayList<Button>();
		

		for (int i = 0; i < numbuttonId.length; i++) {
			numButton.add(i, (Button) getView(numbuttonId[i]));
			numButton.get(i).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					String text = ((Button)v).getText().toString();
					String original = edittext.getText().toString().trim();
					original = util.handleNum(original, text);
					edittext.setText(original);
					//if(flagutil.)
				}
				
			});
		}

		for (int i = 0; i < optbuttonId.length; i++) {
			numOpt.add(i, (Button) getView(optbuttonId[i]));
			numOpt.get(i).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					String text = ((Button)v).getText().toString();
					String original = edittext.getText().toString().trim();
					original = util.handleOperator(original, text);
					edittext.setText(original);
				}
				
			});
		}
		
		dotButton = (Button)findViewById(R.id.buttondot);
		dotButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String original = edittext.getText().toString();
				String text = ((Button)v).getText().toString();
				original = util.handleDot(original, text);
				edittext.setText(original);
			}
			
		});
		clearButton = (Button)findViewById(R.id.buttonclear);
		clearButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				util.handleLClear();
				edittext.setText("");
			}
			
		});
		cancelButton = (Button)findViewById(R.id.buttoncancel);
		cancelButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String text = edittext.getText().toString();
				text = util.handleCancel(text);
				edittext.setText(text);
				
			}
			
		});
		zeroButton = (Button)findViewById(R.id.buttonzreo);
		zeroButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String original = edittext.getText().toString();
				String text = ((Button)v).getText().toString();
				original = util.handleZero(original, text);
				edittext.setText(original);
				
			}
			
		});
		equalButton = (Button)findViewById(R.id.buttonequal);
		equalButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String original = edittext.getText().toString();
				String text = ((Button)arg0).getText().toString();
				original = util.handleEqual(original,text);
				edittext.setText(original);
				
			}
			
		});
		edittext = (EditText)findViewById(R.id.input_text);
		/***
		 * This input keyboard might needs more symbol control, just leave it later
		 */
		edittext.setInputType(EditorInfo.TYPE_NULL);

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private View getView(int id) {
		View view = findViewById(id);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
