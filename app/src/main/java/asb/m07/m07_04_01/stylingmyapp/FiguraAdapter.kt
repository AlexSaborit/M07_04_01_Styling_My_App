package asb.m07.m07_04_01.stylingmyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class FiguraAdapter(private val context: FragmentActivity, private val figures: MutableList<Figura>):
    RecyclerView.Adapter<FiguraAdapter.VideojocViewHolder>(),
    View.OnClickListener
{
    private val layout = R.layout.listview_videojocs_items
    private var clickListener: View.OnClickListener? = null
    class VideojocViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        val videojocCaratula = view.findViewById(R.id.ivFigura) as ImageView
        val videojocTitol = view.findViewById(R.id.tvTitol) as TextView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideojocViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        view.setOnClickListener(this)

        return VideojocViewHolder(view)
    }
    override fun onBindViewHolder(holder: VideojocViewHolder, position: Int) {
        val videojoc = figures[position]
        bindVideojoc(holder, videojoc)
    }
    override fun getItemCount() = figures.size

    fun bindVideojoc(holder: VideojocViewHolder, videojoc: Figura) {
        holder.videojocCaratula?.setImageResource(videojoc.imatge)
        holder.videojocTitol?.text = videojoc.nom
        //holder.videojocJugadors?.text = "Jugadors: " + videojoc.jugadors
    }


    fun setOnClickListener(listener: View.OnClickListener)
    {
        clickListener = listener
    }

    override fun onClick(view: View?)
    {
        clickListener?.onClick(view)
    }
}