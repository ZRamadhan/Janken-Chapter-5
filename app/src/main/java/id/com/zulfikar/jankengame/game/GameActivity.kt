package id.com.zulfikar.jankengame.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import id.com.zulfikar.jankengame.R

class GameActivity : AppCompatActivity() {
  
  lateinit var btnExit: ImageView
  lateinit var btnReset: ImageView
  lateinit var userName : TextView
  
  lateinit var btnPemainGunting: ImageView
  lateinit var btnPemainBatu: ImageView
  lateinit var btnPemainKertas: ImageView
  
  lateinit var btnCpuGunting: ImageView
  lateinit var btnCpuBatu: ImageView
  lateinit var btnCpuKertas: ImageView
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_game)
    
    btnExit = findViewById(R.id.btnExit)
    btnReset = findViewById(R.id.btnReset)
    userName = findViewById(R.id.textView2)
    
    btnPemainGunting = findViewById(R.id.pemainSatu)
    btnPemainBatu = findViewById(R.id.pemainDua)
    btnPemainKertas = findViewById(R.id.pemainTiga)
    
    btnCpuKertas = findViewById(R.id.comSatu)
    btnCpuGunting = findViewById(R.id.comDua)
    btnCpuBatu = findViewById(R.id.comTiga)
    
    
    btnReset.setOnClickListener{
    
    }
    
    
  }
  
  private fun LogD(message: String){
    Log.d(GameActivity::class.java.simpleName, message)
  }
}