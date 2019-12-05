package p.vikpo.homecontrol.presenters.adapters.itemchooser;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import p.vikpo.homecontrol.R;

public class ChooserLayout extends ConstraintLayout
{
    private RadioButton button;
    private TextView value;

    public ChooserLayout(Context context)
    {
        super(context);
        inflate(context, R.layout.item_list_chooser, this);

        button = findViewById(R.id.item_list_chooser_radio_button);
        value = findViewById(R.id.item_list_chooser_name);
    }

    public void bindParams(String name)
    {
        value.setText(name);
    }
}
