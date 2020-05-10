package org.cli.collect.android.formentry;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import org.cli.collect.android.R;
import org.cli.collect.android.formentry.saving.FormSaveViewModel;
import org.cli.collect.android.fragments.dialogs.ProgressDialogFragment;

public class SaveFormProgressDialogFragment extends ProgressDialogFragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        setTitle(getString(R.string.saving_form));
        setMessage(getString(R.string.please_wait));
    }

    @Override
    protected Cancellable getCancellable() {
        return ViewModelProviders
                .of(getActivity(), new FormSaveViewModel.Factory())
                .get(FormSaveViewModel.class);
    }
}
