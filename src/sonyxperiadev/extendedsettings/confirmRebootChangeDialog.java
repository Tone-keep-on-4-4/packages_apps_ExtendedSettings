package sonyxperiadev.extendedsettings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by myself5 on 9/6/16.
 * Based on Googles fire missile dialog
 * Originally for applying the 8MP camera setting and currently unused, but
 * might come in handy again
 */
public class confirmRebootChangeDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_reboot_required_summary)
                .setTitle(R.string.dialog_reboot_required)
                .setCancelable(false)
                .setPositiveButton(R.string.reboot_now, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        PowerManager pm = (PowerManager) ExtendedSettingsFragment
                                .mFragment.getContext().getSystemService(Context.POWER_SERVICE);
                        pm.reboot(null);
                    }
                })
                .setNegativeButton(R.string.reboot_later, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do Nothing
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
