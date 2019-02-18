package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables accessible in all the methods of the MainActivity:
    Button mbuttonTop;
    Button mbuttonBottom;
    TextView mstoryTextView;
    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associate member variables to layout widgets
        mbuttonTop = findViewById(R.id.buttonTop);
        mbuttonBottom = findViewById(R.id.buttonBottom);
        mstoryTextView = findViewById(R.id.storyTextView);

        // Restores the 'state' of the app upon screen rotation:
        if (savedInstanceState != null) {
            mStoryIndex = 1;
        }

        //display story and buttons
        mStoryIndex = 1;
        displayStory();

        //set listeners for top and bottom buttons
        //if top button selected, goto method t3Story
        //if bottom button selected goto method t2Story
        mbuttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 3;
                T3Story();
        }
        });

        mbuttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 2;
                T2Story();
            }
        });

    } //End onCreate

    private void T2Story() {
        displayStory();
        mbuttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 3;
                T3Story();
            }
        });
        mbuttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 4;
                displayStory();
             }
        });
    }

    private void T3Story() {
        displayStory();

        mbuttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 6;
                displayStory();
            }
        });
        mbuttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 5;
                displayStory();

            }
        });
    }

   // Display story based on mStoryIndex value
    private void displayStory() {
        if (mStoryIndex == 1) {
            mstoryTextView.setText(R.string.T1_Story);
            mbuttonTop.setText(R.string.T1_Ans1);
            mbuttonBottom.setText(R.string.T1_Ans2);
        }
        else if (mStoryIndex == 2) {
            mstoryTextView.setText(R.string.T2_Story);
            mbuttonTop.setText(R.string.T2_Ans1);
            mbuttonBottom.setText(R.string.T2_Ans2);
        }
        else if (mStoryIndex == 3) {
            mstoryTextView.setText(R.string.T3_Story);
            mbuttonTop.setText(R.string.T3_Ans1);
            mbuttonBottom.setText(R.string.T3_Ans2);
        }
        else if (mStoryIndex == 4) {
            mstoryTextView.setText(R.string.T4_End);
            mbuttonTop.setVisibility(View.GONE);
            mbuttonBottom.setVisibility(View.GONE);
        }
        else if (mStoryIndex == 5) {
            mstoryTextView.setText(R.string.T5_End);
            mbuttonTop.setVisibility(View.GONE);
            mbuttonBottom.setVisibility(View.GONE);
        }
        else if (mStoryIndex == 6) {
            mstoryTextView.setText(R.string.T6_End);
            mbuttonTop.setVisibility(View.GONE);
            mbuttonBottom.setVisibility(View.GONE);
        }
        // if story 4,5,6 chosen, display story, remove buttons, finish story
        //if ((mStoryIndex >= 4) && (mStoryIndex <= 6)) {
        //        finish();
        // }
    }  //End displayStory

    // This callback is received when the screen is rotated so we can save the 'state'
    // of the app in a 'bundle'.
    @Override public void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("", mStoryIndex);
    }

}  //end Main Activity
