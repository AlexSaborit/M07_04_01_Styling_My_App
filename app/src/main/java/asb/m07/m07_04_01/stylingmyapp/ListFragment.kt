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
        val videojocs = getVideojocs()

        val lstVideojocs = view.findViewById(R.id.RclrVwListVj) as RecyclerView

        val adapter = VideojocAdapter(requireActivity(), videojocs)
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

    fun getVideojocs(): MutableList<Videojoc> {
        return mutableListOf(
            Videojoc("Red Dead Redemption II", R.drawable.noimageavailable, 150000000),
            Videojoc("Grand Theft Auto V", R.drawable.noimageavailable, 1000000000),
            Videojoc("Kingdom Hearts", R.drawable.noimageavailable, 52424774),
            Videojoc("Super Mario Odissey", R.drawable.noimageavailable, 245789544),
            Videojoc("Pokémon edición Amarilla", R.drawable.noimageavailable, 999999999),
            Videojoc("Spyro 3: Year of the Dragon", R.drawable.noimageavailable, 65484825),
            Videojoc("Crash Bandicoot 2", R.drawable.noimageavailable, 547471415),
            Videojoc("Metroid Dread", R.drawable.noimageavailable, 3389985),
            Videojoc("Hogwarts Legacy", R.drawable.noimageavailable, 514789),
            Videojoc("International Rally Championship", R.drawable.noimageavailable, 130000)
        )
    }
}
