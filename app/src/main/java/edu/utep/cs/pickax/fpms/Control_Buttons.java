package edu.utep.cs.pickax.fpms;

import android.app.Activity;
import android.view.View;

/**
 * Created by Jacob on 4/1/2015.
 */
public class Control_Buttons {

    //For any home button, returns a onClickListener that returns to the previous activity
    //TODO: Make it return to the start activity
    public static View.OnClickListener btnListenerHome(Activity a) {
        final Activity activity = a;
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                activity.finish();
            }
        };
    }
}
