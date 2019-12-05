package p.vikpo.homecontrol.presenters;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import p.vikpo.homecontrol.contracts.CoffeeContract;
import p.vikpo.homecontrol.entities.CoffeeBagWrapper;
import p.vikpo.homecontrol.interactors.CoffeeBagInteractor;
import p.vikpo.homecontrol.presenters.adapters.coffeebag.CoffeeAdapter;
import p.vikpo.homecontrol.routers.CoffeeRouter;

public class CoffeePresenter implements CoffeeContract.Presenter
{
    private CoffeeRouter router;
    private CoffeeBagInteractor interactor;

    public CoffeePresenter(AppCompatActivity activity)
    {
        this.router = new CoffeeRouter(activity);
        this.interactor = new CoffeeBagInteractor();
    }

    public CoffeeBagWrapper getBag(String bagName)
    {
        return interactor.loadCoffeeTask(bagName).getResult().toObject(CoffeeBagWrapper.class);
    }

    @Override
    public CoffeeAdapter getAdapter()
    {
        return interactor.getAdapter(item -> router.openBag(item.getName()));
    }

    @Override
    public void addCoffee(CoffeeBagWrapper wrapper)
    {
        interactor.addNewCoffee(wrapper);
    }

    public View.OnClickListener getFabOnClick = v -> router.startAdd();

    @Override
    public void onDestroy()
    {
        this.router.unregister();
    }
}
