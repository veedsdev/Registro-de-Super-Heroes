package mx.veedsdev.com.registrodesuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import mx.veedsdev.com.registrodesuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            val extras = data?.extras
            val heroBitmap = extras?.getParcelable<Bitmap>("data")
            heroImage.setImageBitmap(heroBitmap)
        }
    }


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
        heroImage = binding.ivMainHero

        heroImage.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(cameraIntent)

    }

    private fun openDetailActivity(superhero: Superhero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY,superhero)
        intent.putExtra(DetailActivity.BITMAP_KEY,heroImage.drawable.toBitmap())
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}