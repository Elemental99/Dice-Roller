package facci.sa.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        
        // al iniciar la aplicacion aparece el dado en la pantalla
        rollDice()
    }
    
    // esta actividad permite al dado actualizar su resultado
    private fun rollDice() {
        // create un nuevo objeto Dice con 6 lados
        val dice = Dice(6)
        val diceRoll = dice.roll()
        
        // encuentra la imagen en el diseño
        val diceImage : ImageView = findViewById(R.id.imageView)
        // verifica que imagen es la requerida segun el id en base al roll
        val drawableResource = when (diceRoll) {
            1    -> R.drawable.dice_1
            2    -> R.drawable.dice_2
            3    -> R.drawable.dice_3
            4    -> R.drawable.dice_4
            5    -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        
        // actualiza el dado en la pantalla segun el Id en base al roll
        diceImage.setImageResource(drawableResource)
        // da una descripcion del resultado en pantalla
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides : Int) {
    // Esta actividad permite que el dado cambie de valor aleatoriamente
    fun roll() : Int {
        return (1 .. numSides).random()
    }
}