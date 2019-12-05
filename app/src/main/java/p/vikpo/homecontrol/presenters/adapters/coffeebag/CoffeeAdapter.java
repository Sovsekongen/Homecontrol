package p.vikpo.homecontrol.presenters.adapters.coffeebag;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import p.vikpo.homecontrol.entities.CoffeeBagWrapper;

public class CoffeeAdapter extends FirestoreRecyclerAdapter<CoffeeBagWrapper, CoffeeViewHolder>
{
    public interface OnItemClickListener
    {
        void onItemClicked(CoffeeLayout item);
    }

    private static final String TAG = "Homecontrol - CoffeeAdapter";
    private OnItemClickListener listener;

    public CoffeeAdapter(Query query, OnItemClickListener listener)
    {
        super(new FirestoreRecyclerOptions
                .Builder<CoffeeBagWrapper>()
                .setQuery(query, CoffeeBagWrapper.class)
                .build());
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position, @NonNull CoffeeBagWrapper model)
    {
        holder.bind(model.getName(), model.getCountry(), model.getRating(), listener);
        holder.bindImage(model.getName());
        Log.d(TAG, "Binding View Holder");
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        CoffeeLayout layout = new CoffeeLayout(parent.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        Log.d(TAG, "On Create View Holder");
        return new CoffeeViewHolder(layout);
    }

    @Override
    public void onError(@NonNull FirebaseFirestoreException e)
    {
        Log.e(TAG, "Encountered adapter error.", e);
    }
}
