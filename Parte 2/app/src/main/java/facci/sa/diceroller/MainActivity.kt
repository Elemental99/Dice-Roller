package facci.sa.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// esta activiadad permite al usuario ver el valor del dado en la pantalla
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // encuentra la imagen en el diseño
        val rollButton : Button = findViewById(R.id.button)
        // al dar click en el boton que aparece en la pantalla el valor del 
        // dado cambia
        rollButton.setOnClickListener { rollDice() }
    }
    
    // esta actividad permite al dado actualizar su resultado
    private fun rollDice() {
        // crea un nuevo objeto dice con 6 lados
        val dice = Dice(6)
        val diceRoll = dice.roll()
        
        // actualiza la pantalla segun el dice roll
        val resultTextView : TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides : Int) {
    // Esta actividad permite que el dado cambie de valor aleatoriamente
    fun roll() : Int {
        return (1 .. numSides).random()
    }
}