package asb.m07.m07_04_01.stylingmyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat
import java.math.RoundingMode

class DetailsFragment : Fragment() {

    private val descompte: Double = 25.0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        //obtenim el layout del fragment (unió kotlin - xml)
        var view = inflater.inflate(R.layout.fragment_details, container, false)
        return view
    }
    fun setFigura(figura: Figura)
    {
        var ImgVwCaratula = view?.findViewById<ImageView>(R.id.ivFigura)
        var tvTitol = view?.findViewById<TextView>(R.id.tvTitol)
        var tvOferta = view?.findViewById<TextView>(R.id.tvOferta)
        var tvPreu = view?.findViewById<TextView>(R.id.tvPreu)
        var spSelector = view?.findViewById<Spinner>(R.id.spSelector)
        var tvUnivers = view?.findViewById<TextView>(R.id.tvUnivers)
        var tvEscala = view?.findViewById<TextView>(R.id.tvEscala)
        var tvArticulada = view?.findViewById<TextView>(R.id.tvArticulada)
        //var btnComprar = view?.findViewById<Button>(R.id.btnComprar)


        ImgVwCaratula?.setImageResource(figura.imatge)
        tvTitol?.text = figura.nom
        if (figura.oferta) {
            //tvOferta?.visibility = View.VISIBLE
            tvOferta?.text = "OFERTA!!"
            var preu = figura.preu - (figura.preu / 100 * descompte)
            tvPreu?.text = "Preu: " + formatDecimal(preu) + "€"
        } else {
            tvOferta?.visibility = View.GONE
            tvPreu?.text = "Preu: " + figura.preu.toString() + "€"
        }
        val numeros = (1..10).map { it.toString() }

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, numeros)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spSelector?.adapter = adapter
        tvUnivers?.text = "Univers: " + figura.univers
        tvEscala?.text = "Escala 1:" + figura.escala
        var articulada = ""
        if (figura.articulada) {
            articulada = "Figura articulada"
        } else {
            articulada = "Figura NO articulada"
        }
        tvArticulada?.text = articulada
    }
    fun formatDecimal(num: Double): String {
        val df = DecimalFormat("#.##") // Defineix el format per mostrar dos decimals
        df.roundingMode = RoundingMode.CEILING // Arrodoneix cap amunt
        return df.format(num) // Retorna el número formatat com a String
    }
}