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
            openDetailActivity()
        }
    }

    private fun openDetailActivity(){
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}