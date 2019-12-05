package p.vikpo.homecontrol.contracts;

public interface Contract
{
    interface Presentor
    {
        void onDestroy();
    }

    interface Router
    {
        void unregister();
    }

    interface View
    {

    }

    interface Interactor
    {
        void unregister();
    }
}
