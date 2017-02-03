package com.example.android.gaelicscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int tyroneGoals = 0;
    int tyronePoints = 0;
    int totalScoreTyrone = 0;
    int donegalGoals = 0;
    int donegalPoints = 0;
    int totalScoreDonegal = 0;
    private static final String STATE_TYRONEGOALS = "StateOfTyroneGoals";
    private static final String STATE_TYRONEPOINTS = "StateOfTyronePoints";
    private static final String STATE_TOTALSCORETYRONE = "StateOfTotalScoreTyrone";
    private static final String STATE_DONEGALGOALS = "StateOfDonegalGoals";
    private static final String STATE_DONEGALPOINTS = "StateOfDonegalPoints";
    private static final String STATE_TOTALSCOREDONEGAL = "StateOfTotalScoreDonegal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_TYRONEGOALS, tyroneGoals);
        savedInstanceState.putInt(STATE_TYRONEPOINTS, tyronePoints);
        savedInstanceState.putInt(STATE_TOTALSCORETYRONE, totalScoreTyrone);
        savedInstanceState.putInt(STATE_DONEGALGOALS, donegalGoals);
        savedInstanceState.putInt(STATE_DONEGALPOINTS, donegalPoints);
        savedInstanceState.putInt(STATE_TOTALSCOREDONEGAL, totalScoreDonegal);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        tyroneGoals = savedInstanceState.getInt(STATE_TYRONEGOALS);
        tyronePoints = savedInstanceState.getInt(STATE_TYRONEPOINTS);
        totalScoreTyrone = savedInstanceState.getInt(STATE_TOTALSCORETYRONE);
        donegalGoals = savedInstanceState.getInt(STATE_DONEGALGOALS);
        donegalPoints = savedInstanceState.getInt(STATE_DONEGALPOINTS);
        totalScoreDonegal = savedInstanceState.getInt(STATE_TOTALSCOREDONEGAL);

        displayTyroneGoals(tyroneGoals);
        displayTyronePoints(tyronePoints);
        displayTyroneTotal(totalScoreTyrone);
        displayDonegalGoals(donegalGoals);
        displayDonegalPoints(donegalPoints);
        displayDonegalTotal(totalScoreDonegal);
    }

    /**
     * This method is called when the Half Time button clicked.
     */
    public void halfTimeStatus(View view) {
        if (totalScoreTyrone > totalScoreDonegal) {
            displayHalfTimeStatus("Tyrone lead at Half Time by " + (totalScoreTyrone - totalScoreDonegal) + " point/s.");
        } else if (totalScoreDonegal > totalScoreTyrone) {
            displayHalfTimeStatus("Donegal lead at Half Time by " + (totalScoreDonegal - totalScoreTyrone) + " point/s.");
        } else {
            displayHalfTimeStatus("Nothing separates the Teams at Half Time, it's all square!");
        }
    }

    /**
     * This method is called when the Full Time button clicked.
     */
    public void fullTimeStatus(View view) {
        if (totalScoreTyrone > totalScoreDonegal) {
            displayFullTimeStatus("Tyrone Win! Beating Donegal by " + (totalScoreTyrone - totalScoreDonegal) + " point/s.");
        } else if (totalScoreDonegal > totalScoreTyrone) {
            displayFullTimeStatus("Donegal Win! Beating Tyrone by " + (totalScoreDonegal - totalScoreTyrone) + " point/s.");
        } else {
            displayFullTimeStatus("Draw! The match ends in a stale mate.");
        }
    }

    /**
     * This method is called when the Goal (+3) button for Tyrone is clicked.
     */
    public void addThreePointsAndGoalForTyrone(View view) {
        totalScoreTyrone = totalScoreTyrone + 3;
        tyroneGoals = tyroneGoals + 1;
        displayTyroneTotal(totalScoreTyrone);
        displayTyroneGoals(tyroneGoals);
    }

    /**
     * This method is called when the Point button for Tyrone is clicked.
     */
    public void addOnePointsForTyrone(View view) {
        totalScoreTyrone = totalScoreTyrone + 1;
        tyronePoints = tyronePoints + 1;
        displayTyroneTotal(totalScoreTyrone);
        displayTyronePoints(tyronePoints);
    }

    /**
     * This method is called when the Goal (+3) button for Donegal is clicked.
     */
    public void addThreePointsAndGoalForDonegal(View view) {
        totalScoreDonegal = totalScoreDonegal + 3;
        donegalGoals = donegalGoals + 1;
        displayDonegalTotal(totalScoreDonegal);
        displayDonegalGoals(donegalGoals);
    }

    /**
     * This method is called when the Point button for Donegal is clicked.
     */
    public void addOnePointsForDonegal(View view) {
        totalScoreDonegal = totalScoreDonegal + 1;
        donegalPoints = donegalPoints + 1;
        displayDonegalTotal(totalScoreDonegal);
        displayDonegalPoints(donegalPoints);
    }

    /**
     * Displays the total goals for Tyrone.
     */
    private void displayTyroneGoals(int goal) {
        TextView goalView = (TextView) findViewById(R.id.tyrone_goals);
        goalView.setText(String.valueOf(goal));
    }

    /**
     * Displays the total points for Tyrone.
     */
    private void displayTyronePoints(int point) {
        TextView pointView = (TextView) findViewById(R.id.tyrone_points);
        pointView.setText(String.valueOf(point));
    }

    /**
     * Displays the total score for Tyrone.
     */
    private void displayTyroneTotal(int total) {
        TextView totalView = (TextView) findViewById(R.id.tyrone_total_score);
        totalView.setText(String.valueOf(total));
    }

    /**
     * Displays the Half Time Status.
     */
    private void displayHalfTimeStatus(String message) {
        TextView halfTimeView = (TextView) findViewById(R.id.match_status);
        halfTimeView.setText(message);
    }

    /**
     * Displays the Full Time Status.
     */
    private void displayFullTimeStatus(String message) {
        TextView fullTimeView = (TextView) findViewById(R.id.match_status);
        fullTimeView.setText(message);
    }

    /**
     * Displays the total goals for Donegal.
     */
    private void displayDonegalGoals(int goal) {
        TextView goalView = (TextView) findViewById(R.id.donegal_goals);
        goalView.setText(String.valueOf(goal));
    }

    /**
     * Displays the total points for Tyrone.
     */
    private void displayDonegalPoints(int point) {
        TextView pointView = (TextView) findViewById(R.id.donegal_points);
        pointView.setText(String.valueOf(point));
    }

    /**
     * Displays the total score for Donegal.
     */
    private void displayDonegalTotal(int total) {
        TextView totalView = (TextView) findViewById(R.id.donegal_total_score);
        totalView.setText(String.valueOf(total));
    }

    /**
     * This method is called when the Reset Scores button is clicked.
     */
    public void resetScores(View view) {
        totalScoreTyrone = 0;
        tyroneGoals = 0;
        tyronePoints = 0;
        totalScoreDonegal = 0;
        donegalGoals = 0;
        donegalPoints = 0;
        displayTyroneGoals(tyroneGoals);
        displayTyronePoints(tyronePoints);
        displayTyroneTotal(totalScoreTyrone);
        displayDonegalGoals(donegalGoals);
        displayDonegalPoints(donegalPoints);
        displayDonegalTotal(totalScoreDonegal);
        displayHalfTimeStatus("");
        displayFullTimeStatus("");
    }
}



