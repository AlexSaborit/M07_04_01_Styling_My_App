package asb.m07.m07_04_01.stylingmyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), MyOnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = supportFragmentManager.findFragmentById(R.id.FrgList) as ListFragment
        listFragment.setListener(this)
    }

    override fun onClick(videojoc: Figura) {
        val DetailsFragment = supportFragmentManager.findFragmentById(R.id.FrgDetails) as DetailsFragment?
        if(DetailsFragment == null)//mòbil en comptes de tablet
        {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("videojoc",videojoc)
            startActivity(intent)
        } else //tablet en comptes de mòbil
        {
            DetailsFragment.setVideojoc(videojoc)
        }
    }
}
