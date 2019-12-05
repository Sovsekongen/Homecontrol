package p.vikpo.homecontrol.presenters.adapters.coffeebag;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import p.vikpo.homecontrol.R;

public class CoffeeLayout extends ConstraintLayout
{
    private TextView name, sort, score;
    private ImageView image;
    private static final String TAG = "Homecontrol - CoffeeLayout";

    public CoffeeLayout(Context context)
    {
        super(context);
        inflate(context, R.layout.item_list_coffee, this);
        initUi();
    }

    private void initUi()
    {
        name = findViewById(R.id.item_list_coffee_name);
        sort = findViewById(R.id.item_list_coffee_sort);
        score = findViewById(R.id.item_list_coffee_score);
        image = findViewById(R.id.item_list_coffee_image);
    }

    public void bindParams(String name, String sort, String score)
    {
        this.name.setText(name);
        this.sort.setText(sort);
        this.score.setText(score);
    }

    public void bindImage(Bitmap image)
    {
        this.image.setImageBitmap(image);
    }

    public String getName()
    {
        return name.getText().toString();
    }
}
