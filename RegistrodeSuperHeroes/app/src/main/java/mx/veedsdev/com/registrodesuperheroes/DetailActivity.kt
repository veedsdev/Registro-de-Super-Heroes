package mx.veedsdev.com.registrodesuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.veedsdev.com.registrodesuperheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val SUPER_HERO_NAME_KEY="superHeroName"
        const val ALTER_EGO_KEY="alterEgo"
        const val BIOGRAPHY_KEY="biography"
        const val POWER_KEY="power"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superHeroName = bundle.getString(SUPER_HERO_NAME_KEY) ?: "No se encontró el nombre"
        val alterEgo = bundle.getString(ALTER_EGO_KEY) ?: "No se encontró el Alter Ego"
        val bio = bundle.getString(BIOGRAPHY_KEY) ?: "No se encontró el Alter Ego"
        val power = bundle.getFloat(POWER_KEY)

        binding.tvDetailHeroName.text = superHeroName
        binding.tvDetailAlterEgoDescription.text = alterEgo
        binding.tvDetailBiographyDescription.text = bio
        binding.rbDetailPower.rating = power

    }
}