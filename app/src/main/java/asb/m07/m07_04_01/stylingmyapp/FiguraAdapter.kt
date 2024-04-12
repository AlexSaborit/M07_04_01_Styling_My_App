package asb.m07.m07_04_01.stylingmyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class FiguraAdapter(private val context: FragmentActivity, private val figures: MutableList<Figura>):
    RecyclerView.Adapter<FiguraAdapter.FiguraViewHolder>(),
    View.OnClickListener
{
    private val layout = R.layout.listview_figures_items
    private var clickListener: View.OnClickListener? = null
    class FiguraViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        val ivFigura = view.findViewById(R.id.ivFigura) as ImageView
        val tvTitol = view.findViewById(R.id.tvTitol) as TextView
        val tvUnivers = view.findViewById(R.id.tvUnivers) as TextView
        val tvPreu = view.findViewById(R.id.tvPreu) as TextView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiguraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        view.setOnClickListener(this)

        return FiguraViewHolder(view)
    }
    override fun onBindViewHolder(holder: FiguraViewHolder, position: Int) {
        val figura = figures[position]
        bindFigura(holder, figura)
    }
    override fun getItemCount() = figures.size

    fun bindFigura(holder: FiguraViewHolder, figura: Figura) {
        holder.ivFigura?.setImageResource(figura.imatge)
        holder.tvTitol?.text = figura.nom
        holder.tvUnivers?.text = figura.univers
        holder.tvPreu?.text = figura.preu.toString() + "€"
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