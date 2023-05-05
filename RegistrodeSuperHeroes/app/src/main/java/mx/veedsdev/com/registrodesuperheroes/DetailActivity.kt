package mx.veedsdev.com.registrodesuperheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.veedsdev.com.registrodesuperheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val SUPERHERO_KEY="superHero"
        const val BITMAP_KEY="bitmap"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superHero = bundle.getParcelable<Superhero>(SUPERHERO_KEY)!!
        val bitmap = bundle.getParcelable<Bitmap>(BITMAP_KEY)!!
        binding.ivDetailHero.setImageBitmap(bitmap)
        binding.superhero = superHero

    }
}