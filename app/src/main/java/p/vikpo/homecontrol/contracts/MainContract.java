package p.vikpo.homecontrol.contracts;

import androidx.fragment.app.Fragment;

public interface MainContract
{
    interface Presenter extends Contract.Presentor
    {

    }

    interface Router extends Contract.Router
    {
        void loadFragment(Fragment fragment);
        void startFragment(Fragment fragment);
    }

    interface View extends Contract.View
    {

    }

    interface Interactor extends Contract.Interactor
    {

    }
}
