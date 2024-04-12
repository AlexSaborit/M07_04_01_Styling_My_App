package asb.m07.m07_04_01.stylingmyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //rebo int de l'intent que obre l'activity
        val figura = intent.getSerializableExtra("figura") as Figura?
        var manager = supportFragmentManager
        var fragment = manager.findFragmentById(R.id.FrgDetails) as DetailsFragment
        if (figura != null) {
            fragment.setFigura(figura)
        }

        val btnComprar = findViewById<Button>(R.id.btnComprar)
        btnComprar.setOnClickListener {
            Toast.makeText(this, "Ja ets a la pantalla de shopping!!", Toast.LENGTH_SHORT).show()
        }
    }
}