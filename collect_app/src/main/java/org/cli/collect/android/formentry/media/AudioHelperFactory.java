package org.cli.collect.android.formentry.media;

import android.content.Context;

import org.cli.collect.android.audio.AudioHelper;

public interface AudioHelperFactory {

    AudioHelper create(Context context);
}
