package asb.m07.m07_04_01.stylingmyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //rebo int de l'intent que obre l'activity
        val videojoc = intent.getSerializableExtra("videojoc") as Figura?
        var manager = supportFragmentManager
        var fragment = manager.findFragmentById(R.id.FrgDetails) as DetailsFragment
        if (videojoc != null) {
            fragment.setVideojoc(videojoc)
        }
    }
}