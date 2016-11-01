package money.tictactoe;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by #money on 8/16/2016.
 */
public class MyButton extends Button {
    public boolean wrok =true;


    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context) {
        super(context);
    }


}
