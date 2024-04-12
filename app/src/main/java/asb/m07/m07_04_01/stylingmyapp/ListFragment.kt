package asb.m07.m07_04_01.stylingmyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {
    private lateinit var listener: MyOnClickListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //obtenim el layout del fragment (unió kotlin - xml)
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //inici pegote
        val videojocs = getFigures()

        val lstVideojocs = view.findViewById(R.id.RclrVwListVj) as RecyclerView

        val adapter = FiguraAdapter(requireActivity(), videojocs)
        lstVideojocs.hasFixedSize()
        lstVideojocs.layoutManager = LinearLayoutManager(requireContext())
        lstVideojocs.adapter = adapter

        adapter.setOnClickListener()
        {
            val videojoc = videojocs[lstVideojocs.getChildAdapterPosition(it)]
            listener.onClick(videojoc)
        }
        //fi pegote
        return view
    }

    fun setListener(listen: MyOnClickListener?) {
        if (listen != null) {
            listener = listen
        }
    }

    fun getFigures(): MutableList<Figura> {
        return mutableListOf(
            Figura("Red Dead Redemption II", R.drawable.noimageavailable, 150000000.0,"Japó", 32, true),
            Figura("Grand Theft Auto V", R.drawable.noimageavailable, 1000000000.0,"Japó", 32, true),
            Figura("Kingdom Hearts", R.drawable.noimageavailable, 52424774.0,"Japó", 32, true),
            Figura("Super Mario Odissey", R.drawable.noimageavailable, 245789544.0,"Japó", 32, true),
            Figura("Pokémon edición Amarilla", R.drawable.noimageavailable, 999999999.0,"Japó", 32, true),
            Figura("Spyro 3: Year of the Dragon", R.drawable.noimageavailable, 65484825.0,"Japó", 32, true),
            Figura("Crash Bandicoot 2", R.drawable.noimageavailable, 547471415.0,"Japó", 32, true),
            Figura("Metroid Dread", R.drawable.noimageavailable, 3389985.0,"Japó", 32, true),
            Figura("Hogwarts Legacy", R.drawable.noimageavailable, 514789.0,"Japó", 32, true),
            Figura("International Rally Championship", R.drawable.noimageavailable, 130000.0,"Japó", 32, true),
        )
    }
}
