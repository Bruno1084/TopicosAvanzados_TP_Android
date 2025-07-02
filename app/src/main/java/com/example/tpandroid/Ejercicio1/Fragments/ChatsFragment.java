package com.example.tpandroid.Ejercicio1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tpandroid.Ejercicio1.ChatAdapter;
import com.example.tpandroid.R;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class ChatsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(com.example.tpandroid.R.layout.fragment_chats, container, false);

        RecyclerView recycler = view.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> chats = Arrays.asList(
                "Juan Doe",
                "Bruno Sosa",
                "David Pérez",
                "Adriana Castillo",
                "David",
                "Movistar",
                "+33 236 2535",
                "+56 234 3242"
        );

        List<String> descripciones = Arrays.asList(
                "J simply dummy text of t",
                "nter took ",
                "ase of Letraset sheets containing Lore",
                "A is a lo",
                "jaja",
                "Mensaje de Movistar",
                "Mensaje de relleno",
                "Probando ScrollView"
        );

        recycler.setAdapter(new ChatAdapter(chats, descripciones));
        return view;
    }
}
