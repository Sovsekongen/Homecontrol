package p.vikpo.homecontrol.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import p.vikpo.homecontrol.R;

public class CoffeeBagFragment extends Fragment
{
    public static CoffeeBagFragment newInstance()
    {
        return new CoffeeBagFragment();
    }

    private static final String TAG = "Homecontrol - CoffeeFragment";
    private static final String KEY_BAG_NAME = "bagName";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_coffee_bag, container, false);
        TextView nameView = v.findViewById(R.id.coffee_bag_name);



        return v;
    }

    private String getCoffeeName()
    {
        Bundle arguments = getArguments();

        if(arguments != null)
        {
            return arguments.getString(KEY_BAG_NAME);
        }

        Toast.makeText(getContext(), "Encountered Error", Toast.LENGTH_SHORT).show();
        return "";
    }
}
