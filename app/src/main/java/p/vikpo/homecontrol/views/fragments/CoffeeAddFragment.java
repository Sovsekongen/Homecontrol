package p.vikpo.homecontrol.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import p.vikpo.homecontrol.R;
import p.vikpo.homecontrol.entities.CoffeeBagWrapper;
import p.vikpo.homecontrol.interactors.CoffeeBagInteractor;

public class CoffeeAddFragment extends Fragment
{
    public static CoffeeAddFragment newInstance()
    {
        return new CoffeeAddFragment();
    }

    private static final String TAG = "Homecontrol - CoffeeFragment";
    private CoffeeBagInteractor interactor;
    private EditText name, brand, price;
    private Spinner country, rating;
    private Button add, tastes;
    private FloatingActionButton back;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_coffee_add, container, false);
        interactor = new CoffeeBagInteractor();
        initUi(v);


        return v;
    }

    private void initUi(View v)
    {
        name = v.findViewById(R.id.coffee_bag_name);
        brand = v.findViewById(R.id.coffee_add_brand);
        price = v.findViewById(R.id.coffee_add_price);
        country = v.findViewById(R.id.coffee_add_spinner_country);
        rating = v.findViewById(R.id.coffee_add_spinner_rating);
        add = v.findViewById(R.id.coffee_add_button_add);
        tastes = v.findViewById(R.id.coffee_add_button_tastes);
        back = v.findViewById(R.id.coffee_add_button_back);
    }

    private void addCoffeeBag()
    {
        CoffeeBagWrapper newCoffee = new CoffeeBagWrapper();

        if(!name.getText().toString().equals(""))
        {
            newCoffee.setName(name.getText().toString());
        }

        /*
         * Erstat med spinner!
         */
        if(!brand.getText().toString().equals(""))
        {
            newCoffee.setBrand(brand.getText().toString());
        }

        interactor.addNewCoffee(newCoffee);
    }
}
