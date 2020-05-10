package org.cli.collect.android.widgets.support;

import org.javarosa.core.model.data.IAnswerData;
import org.javarosa.form.api.FormEntryPrompt;
import org.cli.collect.android.listeners.WidgetValueChangedListener;
import org.cli.collect.android.support.MockFormEntryPromptBuilder;
import org.cli.collect.android.support.RobolectricHelpers;
import org.cli.collect.android.support.TestScreenContextActivity;
import org.cli.collect.android.widgets.TriggerWidget;

import static org.mockito.Mockito.mock;

public class QuestionWidgetHelpers {

    private QuestionWidgetHelpers() {

    }

    public static TestScreenContextActivity widgetTestActivity() {
        return RobolectricHelpers.buildThemedActivity(TestScreenContextActivity.class).get();
    }

    public static WidgetValueChangedListener mockValueChangedListener(TriggerWidget widget) {
        WidgetValueChangedListener valueChangedListener = mock(WidgetValueChangedListener.class);
        widget.setValueChangedListener(valueChangedListener);
        return valueChangedListener;
    }

    public static FormEntryPrompt promptWithAnswer(IAnswerData answer) {
        return new MockFormEntryPromptBuilder()
                .withAnswer(answer)
                .build();
    }

    public static FormEntryPrompt promptWithReadOnly() {
        return new MockFormEntryPromptBuilder()
                .withReadOnly(true)
                .build();
    }
}