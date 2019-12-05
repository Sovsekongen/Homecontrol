package p.vikpo.homecontrol.presenters;

import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import p.vikpo.homecontrol.R;
import p.vikpo.homecontrol.contracts.MainContract;
import p.vikpo.homecontrol.routers.MainRouter;
import p.vikpo.homecontrol.views.fragments.CoffeeFragment;
import p.vikpo.homecontrol.views.fragments.CurtainFragment;
import p.vikpo.homecontrol.views.fragments.RoomFragment;

public class MainPresenter implements MainContract.Presenter
{
    private MainRouter router;
    private static final String TAG = "Homecontrol - MainPresenter";

    public MainPresenter(AppCompatActivity activity)
    {
        router = new MainRouter(activity);
        startApp(CurtainFragment.newInstance());
    }

    private void startApp(Fragment fragment)
    {
        router.startFragment(fragment);
    }

    private void replaceApp(Fragment fragment)
    {
        router.loadFragment(fragment);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = menuItem ->
    {
        Fragment fragmentLaunch;

        switch(menuItem.getItemId())
        {
            case R.id.bottom_navigation_control:
                fragmentLaunch = CurtainFragment.newInstance();
                Log.e(TAG, "Launching Curtain");
                break;

            case R.id.bottom_navigation_coffee:
                fragmentLaunch = CoffeeFragment.newInstance();
                Log.e(TAG, "Launching Coffee");
                break;
            case R.id.bottom_navigation_room:
                fragmentLaunch = RoomFragment.newInstance();
                Log.e(TAG, "Launching Room");
                break;

            default:
                fragmentLaunch = CurtainFragment.newInstance();
        }

        replaceApp(fragmentLaunch);
        return true;
    };



    @Override
    public void onDestroy()
    {
        router.unregister();
    }
}
