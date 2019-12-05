package p.vikpo.homecontrol.interactors;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import p.vikpo.homecontrol.entities.CoffeeBagWrapper;
import p.vikpo.homecontrol.presenters.adapters.coffeebag.CoffeeAdapter;

public class CoffeeBagInteractor
{
    private FirebaseFirestore mDatabase;

    private static final String COFFEE_COLLECTION = "coffeeBags";
    private static final String COFFEE_DOCUMENT_FIELD = "added";
    private static final String TAG = "Homecontrol - CoffeeBagInteractor";

    public CoffeeBagInteractor()
    {
        mDatabase = FirebaseFirestore.getInstance();
    }

    public CoffeeAdapter getAdapter(CoffeeAdapter.OnItemClickListener listener)
    {
        CoffeeAdapter adapter;

        Query query = mDatabase.collection(COFFEE_COLLECTION)
                .orderBy(COFFEE_DOCUMENT_FIELD)
                .limit(50);

        Task<QuerySnapshot> result = query.get();
        result.addOnSuccessListener(aVoid -> Log.e(TAG, "Retrieved List, size is: " + result.getResult().size()))
                .addOnFailureListener(e -> Log.e(TAG, "Encountered a failure", e));

        adapter = new CoffeeAdapter(query, listener);

        return adapter;
    }

    public void addNewCoffee(CoffeeBagWrapper wrapper)
    {
        mDatabase.collection(COFFEE_COLLECTION).document(wrapper.getName()).set(wrapper)
                .addOnSuccessListener(aVoid -> Log.e(TAG, "Added to list"))
                .addOnFailureListener(e -> Log.e(TAG, "Encountered a failure", e));
    }

    public Task<DocumentSnapshot> loadCoffeeTask(String bagName)
    {
        return mDatabase.collection(COFFEE_COLLECTION).document(bagName).get();
    }
}
