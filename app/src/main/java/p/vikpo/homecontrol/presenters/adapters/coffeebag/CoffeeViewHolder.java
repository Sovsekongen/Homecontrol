package p.vikpo.homecontrol.presenters.adapters.coffeebag;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import p.vikpo.homecontrol.interactors.FirebaseStorageInteractor;

class CoffeeViewHolder extends RecyclerView.ViewHolder
{
    private CoffeeLayout coffeeLayout;

    CoffeeViewHolder(@NonNull CoffeeLayout itemView)
    {
        super(itemView);
        this.coffeeLayout = itemView;
    }

    void bind(String name, String sort, int score, final CoffeeAdapter.OnItemClickListener listener)
    {
        coffeeLayout.bindParams(name, sort, Integer.toString(score));
        coffeeLayout.setOnClickListener(v -> listener.onItemClicked(coffeeLayout));
    }

    void bindImage(String name)
    {
        FirebaseStorageInteractor interactor = new FirebaseStorageInteractor();
        interactor.getImage(name, coffeeLayout::bindImage);
    }
}
