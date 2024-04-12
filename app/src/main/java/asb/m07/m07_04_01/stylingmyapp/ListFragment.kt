package asb.m07.m07_04_01.stylingmyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val figures = getFigures()

        val lstFigures = view.findViewById(R.id.RclrVwListVj) as RecyclerView

        val adapter = FiguraAdapter(requireActivity(), figures)
        lstFigures.hasFixedSize()
        lstFigures.layoutManager = LinearLayoutManager(requireContext())
        lstFigures.adapter = adapter

        adapter.setOnClickListener()
        {
            val figura = figures[lstFigures.getChildAdapterPosition(it)]
            listener.onClick(figura)
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
            Figura("Red Ranger amb escut", R.drawable.redranger, 980.24,"Mighty Morphin Power Rangers", 32, true, false),
            Figura("Sora", R.drawable.sora, 30.0,"Kingdom Hearts", 10, true, true),
            Figura("Eren Jaeger", R.drawable.eren, 100.0,"Attack on Titans", 32, false, false),
            Figura("Super Mario", R.drawable.mario, 45.5,"Super Mario", 32, true, true),
            Figura("Pikachu", R.drawable.pikachu, 19.90,"Pokémon", 56, true, true),
            Figura("Asuka", R.drawable.asuka, 75.5,"Evangelion", 32, false, false),
            Figura("Arale", R.drawable.arale, 37.89,"Dr. Slump", 32, false, false),
            Figura("Sakura", R.drawable.sakura, 150.0,"Cardcaptor Sakura", 24, false, true),
            Figura("Robot soldat", R.drawable.laputa_robot_toy, 25.0,"El castell de Laputa", 1, true, false),
            Figura("Tsunade", R.drawable.tsunade, 9.99,"Naruto", 32, false, true),
        )
    }
}
