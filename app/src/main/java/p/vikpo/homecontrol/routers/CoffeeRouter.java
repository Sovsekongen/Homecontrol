package p.vikpo.homecontrol.routers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import p.vikpo.homecontrol.R;
import p.vikpo.homecontrol.contracts.CoffeeContract;
import p.vikpo.homecontrol.views.fragments.CoffeeAddFragment;
import p.vikpo.homecontrol.views.fragments.CoffeeBagFragment;

public class CoffeeRouter implements CoffeeContract.Router
{
    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    private static final String KEY_BAG_NAME = "bagName";

    public CoffeeRouter(AppCompatActivity activity)
    {
        this.activity = activity;
        transaction = activity.getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void unregister()
    {
        this.activity = null;
    }

    @Override
    public void startAdd()
    {
        Fragment addFragment = CoffeeAddFragment.newInstance();
        transaction.replace(R.id.fragment_container, addFragment).commit();
    }

    @Override
    public void openBag(String bagName)
    {
        Fragment bagFragment = CoffeeBagFragment.newInstance();

        Bundle bundle = new Bundle();
        bundle.putString(KEY_BAG_NAME, bagName);

        bagFragment.setArguments(bundle);

        transaction.replace(R.id.fragment_container, bagFragment).commit();
    }
}
