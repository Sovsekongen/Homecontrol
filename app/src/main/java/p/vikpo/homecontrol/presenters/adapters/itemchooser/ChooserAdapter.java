package p.vikpo.homecontrol.presenters.adapters.itemchooser;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import p.vikpo.homecontrol.entities.ChooserItemWrapper;

public class ChooserAdapter extends FirestoreRecyclerAdapter<ChooserItemWrapper, ChooserViewHolder>
{
    private static final String TAG = "HomeControl - ChooserAdapter";
    public ChooserAdapter(Query query)
    {
        super(new FirestoreRecyclerOptions
                .Builder<ChooserItemWrapper>()
                .setQuery(query, ChooserItemWrapper.class)
                .build());
    }

    @Override
    protected void onBindViewHolder(@NonNull ChooserViewHolder holder, int position, @NonNull ChooserItemWrapper model)
    {
        holder.bind(model.getName());
    }

    @NonNull
    @Override
    public ChooserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ChooserLayout holder = new ChooserLayout(parent.getContext());
        holder.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        return new ChooserViewHolder(holder);
    }

    @Override
    public void onError(@NonNull FirebaseFirestoreException e)
    {
        Log.e(TAG, "Encountered adapter error.", e);
    }
}
