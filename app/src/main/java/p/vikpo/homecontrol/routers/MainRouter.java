package p.vikpo.homecontrol.routers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import p.vikpo.homecontrol.R;
import p.vikpo.homecontrol.contracts.MainContract;

public class MainRouter implements MainContract.Router
{
    private AppCompatActivity activity;

    public MainRouter(AppCompatActivity activity)
    {
        this.activity = activity;
    }

    @Override
    public void unregister()
    {
        this.activity = null;
    }

    @Override
    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void startFragment(Fragment fragment)
    {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment).commit();
    }
}
