package com.egecius.demo_animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		button = (Button) findViewById(R.id.slide_out_btn);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				slideOutButton();
			}
		});
	}

	/* API 1 Animations */

	private void slideOutButton() {


		AnimationSet animationSet = new AnimationSet(this, null);
		animationSet.addAnimation(new AlphaAnimation(/* from */ 1f, /* to */ 0f));
		animationSet.addAnimation(new TranslateAnimation(/*from*/ 0, 0, 0, -button.getHeight()));
		animationSet.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationEnd(Animation animation) {

			}

			@Override
			public void onAnimationStart(Animation animation) {}

			@Override
			public void onAnimationRepeat(Animation animation) {}
		});

	}

}
