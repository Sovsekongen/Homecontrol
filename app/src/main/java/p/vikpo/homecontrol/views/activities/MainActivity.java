package p.vikpo.homecontrol.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;

import p.vikpo.homecontrol.R;
import p.vikpo.homecontrol.contracts.MainContract;
import p.vikpo.homecontrol.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View
{
    public MainPresenter presenter;
    private BottomNavigationView navMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        navMenu = findViewById(R.id.bottom_navigation_container);

        navMenu.setOnNavigationItemSelectedListener(presenter.itemSelectedListener);
        navMenu.getMenu().getItem(1).setChecked(true);

        FirebaseApp.initializeApp(this);

        presenter = new MainPresenter(this);
    }

    @Override
    public void onDestroy()
    {
        presenter.onDestroy();
        super.onDestroy();
    }
}
