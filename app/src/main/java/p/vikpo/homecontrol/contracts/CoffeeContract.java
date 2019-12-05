package p.vikpo.homecontrol.contracts;

import p.vikpo.homecontrol.entities.CoffeeBagWrapper;
import p.vikpo.homecontrol.presenters.adapters.coffeebag.CoffeeAdapter;

public interface CoffeeContract
{
    interface Presenter extends Contract.Presentor
    {
        CoffeeAdapter getAdapter();
        void addCoffee(CoffeeBagWrapper wrapper);
    }

    interface Router extends Contract.Router
    {
        void startAdd();
        void openBag(String bagName);
    }

    interface View extends Contract.View
    {

    }

    interface Interactor extends Contract.Interactor
    {

    }
}
