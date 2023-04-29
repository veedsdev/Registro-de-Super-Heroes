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
            openDetailActivity(superHeroName = superHeroName, alterEgo = alterEgo,biography=biography, power = power)
        }
    }

    private fun openDetailActivity(superHeroName : String, alterEgo : String, biography : String, power : Float){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPER_HERO_NAME_KEY,superHeroName)
        intent.putExtra(DetailActivity.ALTER_EGO_KEY,alterEgo)
        intent.putExtra(DetailActivity.BIOGRAPHY_KEY,biography)
        intent.putExtra(DetailActivity.POWER_KEY,power)
        startActivity(intent)
    }
}