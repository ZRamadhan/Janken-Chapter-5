package id.com.zulfikar.jankengame.game

import android.graphics.Color
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
  
  private val pemain1 = Player("Pemain 1")
  private val pemain2 = Player("Pemain 2")
  
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
    
    var gameMode = intent.getIntExtra("MODE", 0)
    println("game mode "+gameMode)
    
    if (gameMode == 1){
      btnPemainBatu.setOnClickListener{
      btnPemainGunting.isClickable = false
      btnPemainBatu.isClickable = false
      btnPemainKertas.isClickable = false
      val cpuMove = (1..3).random()
      btnPemainBatu.setBackgroundResource(R.drawable.ic_hand_background)
      when (cpuMove){
        1 -> {
          LogD("Computer Kertas")
          LogD("Hasil Komputer Menang !")
          btnCpuKertas.setBackgroundResource(R.drawable.ic_hand_background)
        }
        2 -> {
          LogD("Computer Gunting")
          LogD("Hasil Pemain Menang !")
          btnCpuGunting.setBackgroundResource(R.drawable.ic_hand_background)
        }
        3 -> {
          LogD("Computer Batu")
          LogD("Hasil Draw !")
          btnCpuBatu.setBackgroundResource(R.drawable.ic_hand_background)
        }
      }
    }
      
      btnPemainGunting.setOnClickListener{
        btnPemainGunting.isClickable = false
        btnPemainBatu.isClickable = false
        btnPemainKertas.isClickable = false
        val cpuMove = (1..3).random()
        btnPemainGunting.setBackgroundResource(R.drawable.ic_hand_background)
        when (cpuMove){
          1 -> {
            LogD("Computer Kertas")
            LogD("Hasil Pemain Menang !")
            btnCpuKertas.setBackgroundResource(R.drawable.ic_hand_background)
          }
          2 -> {
            LogD("Computer Gunting")
            LogD("Hasil Draw !")
            btnCpuGunting.setBackgroundResource(R.drawable.ic_hand_background)
          }
          3 -> {
            LogD("Computer Batu")
            LogD("Hasil Komputer !")
            btnCpuBatu.setBackgroundResource(R.drawable.ic_hand_background)
          }
        }
      }
      
      btnPemainKertas.setOnClickListener{
        btnPemainGunting.isClickable = false
        btnPemainBatu.isClickable = false
        btnPemainKertas.isClickable = false
        val cpuMove = (1..3).random()
        btnPemainKertas.setBackgroundResource(R.drawable.ic_hand_background)
        when (cpuMove){
          1 -> {
            LogD("Computer Kertas")
            LogD("Hasil Draw !")
            btnCpuKertas.setBackgroundResource(R.drawable.ic_hand_background)
          }
          2 -> {
            LogD("Computer Gunting")
            LogD("Hasil Komputer Menang !")
            btnCpuGunting.setBackgroundResource(R.drawable.ic_hand_background)
          }
          3 -> {
            LogD("Computer Batu")
            LogD("Hasil Pemain Menang !")
            btnCpuBatu.setBackgroundResource(R.drawable.ic_hand_background)
          }
        }
      }
    }
    else if (gameMode == 2) {
      setOnClick(btnPemainGunting, 1)
      setOnClick(btnPemainBatu, 2)
      setOnClick(btnPemainKertas, 3)
      
      setOnClick(btnCpuKertas, 1)
      setOnClick(btnCpuGunting, 2)
      setOnClick(btnCpuBatu, 3)
    }
    
    
  }
  
  private fun setOnClick(view: ImageView, idView: Int) {
    view.setOnClickListener {
      setPemain1(idView)
      setPemain2(idView)
      val handPlayer1 = pemain1.handId
      val handPlayer2 = pemain2.handId
      
      when {
        handPlayer1 == 1 && handPlayer2 == 1 || handPlayer2 == 1 && handPlayer1 == 1 -> {
          LogD("Pemain Gunting")
          LogD("Computer Kertas")
          LogD("Hasil Pemain Menang !")
        }
        handPlayer1 == 1 && handPlayer2 == 2 || handPlayer2 == 2 && handPlayer1 == 1 -> {
          LogD("Pemain Gunting")
          LogD("Computer Gunting")
          LogD("Hasil Draw !")
        }
        handPlayer1 == 1 && handPlayer2 == 3 || handPlayer2 == 3 && handPlayer1 == 1 -> {
          LogD("Pemain Gunting")
          LogD("Computer Batu")
          LogD("Hasil Computer Menang !")
        }
  
        handPlayer1 == 2 && handPlayer2 == 1 || handPlayer2 == 1 && handPlayer1 == 2 -> {
          LogD("Pemain Batu")
          LogD("Computer Kertas")
          LogD("Hasil Computer Menang !")
        }
        handPlayer1 == 3 && handPlayer2 == 1 || handPlayer2 == 1 && handPlayer1 == 3 -> {
          LogD("Pemain Kertas")
          LogD("Computer Kertas")
          LogD("Hasil Draw !")
        }
        
        
        else -> {}
      }
    }
  }
  
  private fun setPemain1(id: Int): Int {
    pemain1.handId = id
    when (pemain1.handId) {
      1 -> setHand(btnPemainGunting, 1, true)
      2 -> setHand(btnPemainBatu, 2, true)
      3 -> setHand(btnPemainKertas, 3, true)
    }
    return id
  }
  
  private fun setPemain2(id: Int): Int {
    pemain2.handId = id
    when (pemain2.handId) {
      1 -> setHand(btnCpuBatu, 1, true)
      2 -> setHand(btnCpuGunting, 2, true)
      3 -> setHand(btnCpuKertas, 3, true)
    }
    return id
  }
  
  private fun setHand(view: ImageView, handId: Int, isSelected: Boolean) {
    view.setImageResource(setHandImage(handId))
    when (isSelected) {
      true -> view.setBackgroundResource(R.drawable.ic_hand_background)
      false -> view.setBackgroundResource(0)
    }
  }
  
  private fun setHandImage(handImage: Int): Int {
    return when (handImage) {
      1 -> R.drawable.ic_gunting
      2 -> R.drawable.ic_batu
      3 -> R.drawable.ic_kertas
      else -> 0
    }
  }
  
  private fun LogD(message: String){
    Log.d(GameActivity::class.java.simpleName, message)
  }
}
