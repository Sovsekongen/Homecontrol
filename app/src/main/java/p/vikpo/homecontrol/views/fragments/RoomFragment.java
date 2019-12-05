package p.vikpo.homecontrol.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import p.vikpo.homecontrol.R;

public class RoomFragment extends Fragment
{
    public static RoomFragment newInstance()
    {
        return new RoomFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_room_list, container, false);

        return v;
    }
}
