package p.vikpo.homecontrol.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

import p.vikpo.homecontrol.R;

public class ChooseListFragment extends DialogFragment
{
    private static final String LIST_CHOOSER = "LISTCHOOSER";
    private static final String TAG = "Homecontrol - CoffeeFragment";


    public interface ChooseListFragmentListener
    {
        void onAddedValues(ArrayList<String> res);
    }

    public static ChooseListFragment newInstance(String list)
    {
        ChooseListFragment frag = new ChooseListFragment();

        Bundle bundle = new Bundle();
        bundle.putString(LIST_CHOOSER, list);
        frag.setArguments(bundle);

        return frag;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.dialog_fragment_list_choose, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        String listChooser = getArguments().getString(LIST_CHOOSER);
    }

    public void sendBackResult()
    {
        ChooseListFragmentListener listener = (ChooseListFragmentListener)getTargetFragment();
        //listener.onAddedValues();
    }
}
