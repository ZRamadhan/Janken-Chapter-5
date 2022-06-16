package id.com.zulfikar.jankengame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.media.MediaBrowserService
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import id.com.zulfikar.jankengame.game.GameActivity

class HomeActivity : AppCompatActivity() {
  lateinit var layoutRoot: ConstraintLayout
  lateinit var btnVsPemain: ImageView
  lateinit var btnVsCpu: ImageView
  lateinit var txtUserNameVsPemain: TextView
  lateinit var txtUserNameVsCpu: TextView
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    
    layoutRoot = findViewById(R.id.layoutRoot)
    btnVsPemain = findViewById(R.id.btnVsPemain)
    btnVsCpu = findViewById(R.id.btnVsCpu)
    txtUserNameVsPemain = findViewById(R.id.txtNamaPemainVsPemain)
    txtUserNameVsCpu = findViewById(R.id.txtNamaPemainVsCpu)
    
    val namaUser = intent.getStringExtra("USER_NAME")
    Snackbar.make(layoutRoot, "Selamat datang $namaUser", Snackbar.LENGTH_LONG).show()
    
    txtUserNameVsCpu.text = namaUser
    txtUserNameVsPemain.text = namaUser
    
    btnVsCpu.setOnClickListener{
      val navigateToGame = Intent(this@HomeActivity, GameActivity::class.java)
      navigateToGame.putExtra("MODE", 1)
      navigateToGame.putExtra("USER_NAME", namaUser)
      startActivity(navigateToGame)
    }
    
    btnVsPemain.setOnClickListener{
      val navigateToGame = Intent(this@HomeActivity, GameActivity::class.java)
      navigateToGame.putExtra("MODE", 2)
      navigateToGame.putExtra("USER_NAME", namaUser)
      startActivity(navigateToGame)
    }
  }
}