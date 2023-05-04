package mx.veedsdev.com.registrodesuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.veedsdev.com.registrodesuperheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val SUPERHERO_KEY="superHero"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superHero = bundle.getParcelable<Superhero>(SUPERHERO_KEY)!!
        binding.superhero = superHero

    }
}