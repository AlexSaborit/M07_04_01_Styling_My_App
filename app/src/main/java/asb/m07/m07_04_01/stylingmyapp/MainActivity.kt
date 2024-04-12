package asb.m07.m07_04_01.stylingmyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyOnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = supportFragmentManager.findFragmentById(R.id.FrgList) as ListFragment
        listFragment.setListener(this)

        val btnComprar = findViewById<Button>(R.id.btnComprar)

        btnComprar.setOnClickListener {
            if (segonaActivity()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("figura",listFragment.getFigures().random())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Ja ets a la pantalla de shopping!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(figura: Figura) {
        val DetailsFragment = supportFragmentManager.findFragmentById(R.id.FrgDetails) as DetailsFragment?
        if(segonaActivity())//mòbil en comptes de tablet
        {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("figura",figura)
            startActivity(intent)
        } else //tablet en comptes de mòbil
        {
            DetailsFragment?.setFigura(figura)
        }

    }
    fun segonaActivity(): Boolean{
        var activity2a: Boolean
        val DetailsFragment = supportFragmentManager.findFragmentById(R.id.FrgDetails) as DetailsFragment?
        if(DetailsFragment == null)//mòbil en comptes de tablet
        {
            activity2a = true
        } else //tablet en comptes de mòbil
        {
            activity2a = false
        }
        return activity2a
    }
}
