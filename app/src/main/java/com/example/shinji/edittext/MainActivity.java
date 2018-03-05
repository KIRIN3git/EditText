package com.example.shinji.edittext;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{


	private EditText mEditText1;
	private EditText mEditText2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mEditText1 = (EditText) findViewById(R.id.editText1);
		mEditText2 = (EditText) findViewById(R.id.editText2);

		mEditText1.addTextChangedListener(new GenericTextWatcher(mEditText1));
		mEditText2.addTextChangedListener(new GenericTextWatcher(mEditText2));

		mEditText1.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				return false;
			}
		});
	}

	private class GenericTextWatcher implements TextWatcher {

		private View view;

		private GenericTextWatcher(View view) {
			this.view = view;
		}

		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}

		public void afterTextChanged(Editable editable) {

			switch (view.getId()) {
				case R.id.editText1:
					Log.w( "DEBUG_DATA", "editable1 = " + editable.toString());

					break;
				case R.id.editText2:
					Log.w( "DEBUG_DATA", "editable2 = " + editable.toString());
					break;
			}
		}
	}
}
