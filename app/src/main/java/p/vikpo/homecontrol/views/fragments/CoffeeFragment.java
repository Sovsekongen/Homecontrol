package p.vikpo.homecontrol.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import p.vikpo.homecontrol.R;
import p.vikpo.homecontrol.presenters.CoffeePresenter;
import p.vikpo.homecontrol.presenters.adapters.coffeebag.CoffeeAdapter;

public class CoffeeFragment extends Fragment
{
    public static CoffeeFragment newInstance()
    {
        return new CoffeeFragment();
    }

    private static final String TAG = "Homecontrol - CoffeeFragment";
    private CoffeeAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_coffee_list, container, false);
        RecyclerView coffeeList = v.findViewById(R.id.coffee_list);
        FloatingActionButton fabAddButton = v.findViewById(R.id.coffee_list_add_button);

        CoffeePresenter presenter = new CoffeePresenter((AppCompatActivity) getActivity());
        adapter = presenter.getAdapter();

        coffeeList.setLayoutManager(new LinearLayoutManager(getContext()));
        coffeeList.setAdapter(adapter);

        fabAddButton.setOnClickListener(presenter.getFabOnClick);

        return v;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        if(adapter != null)
        {
            adapter.startListening();
        }
    }

    @Override
    public void onStop()
    {
        super.onStop();
        if(adapter != null)
        {
            adapter.stopListening();
        }
    }
}
