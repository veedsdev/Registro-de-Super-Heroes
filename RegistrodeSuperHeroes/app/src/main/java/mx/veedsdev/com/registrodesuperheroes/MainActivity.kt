package mx.veedsdev.com.registrodesuperheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.veedsdev.com.registrodesuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainSave.setOnClickListener{
            val superHeroName = binding.etMainHeroName.text.toString()
            val alterEgo = binding.etMainAlterEgo.text.toString()
            val biography = binding.etMainBiography.text.toString()
            val power = binding.rbMainPower.rating
            val hero = Superhero (name = superHeroName, alterEgo = alterEgo,biography=biography, power = power)
            openDetailActivity(superhero = hero)
        }
    }

    private fun openDetailActivity(superhero: Superhero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY,superhero)
        startActivity(intent)
    }
}