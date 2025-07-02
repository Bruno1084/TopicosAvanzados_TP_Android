package com.example.tpandroid.Ejercicio1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tpandroid.Ejercicio1.Fragments.CallsFragment;
import com.example.tpandroid.Ejercicio1.Fragments.ChatsFragment;
import com.example.tpandroid.Ejercicio1.Fragments.StatusFragment;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NotNull FragmentActivity fa) {
        super(fa);
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ChatsFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            default:
                return new ChatsFragment();
        }
    };

    @Override
    public int getItemCount() {
        return 3;
    };
}
