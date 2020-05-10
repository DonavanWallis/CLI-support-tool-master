package org.cli.collect.android.regression;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.cli.collect.android.activities.MainMenuActivity;

public class BaseRegressionTest {

    @Rule
    public ActivityTestRule<MainMenuActivity> rule = new ActivityTestRule<>(MainMenuActivity.class);
}