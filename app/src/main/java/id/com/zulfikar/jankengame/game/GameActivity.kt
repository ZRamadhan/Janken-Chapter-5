package id.com.zulfikar.jankengame.game

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import id.com.zulfikar.jankengame.R

class GameActivity : AppCompatActivity() {
  
  var idPemainSatu: Int = 0
  var idPemainDua: Int = 0
  
  lateinit var btnExit: ImageView
  lateinit var btnReset: ImageView
  lateinit var userName : TextView
  lateinit var lawanName : TextView
  
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
    lawanName = findViewById(R.id.textView3)
    
    val namaUser = intent.getStringExtra("USER_NAME")
    println("nama user $namaUser")
    
    btnPemainGunting = findViewById(R.id.pemainSatu)
    btnPemainBatu = findViewById(R.id.pemainDua)
    btnPemainKertas = findViewById(R.id.pemainTiga)
    
    btnCpuKertas = findViewById(R.id.comSatu)
    btnCpuGunting = findViewById(R.id.comDua)
    btnCpuBatu = findViewById(R.id.comTiga)
    
    btnExit.setOnClickListener {
      finish()
    }
    
    btnReset.setOnClickListener{
      clear()
    }
    
    // entering game mode (pemain vs pemain) atau (pemain vs komputer)
    var gameMode = intent.getIntExtra("MODE", 0)
    println("game mode "+gameMode)
    
    if (gameMode == 1){
      userName.text = namaUser
      btnPemainBatu.setOnClickListener{
      btnPemainGunting.isClickable = false
      btnPemainBatu.isClickable = false
      btnPemainKertas.isClickable = false
      val cpuMove = (1..3).random()
      btnPemainBatu.setBackgroundResource(R.drawable.ic_hand_background)
        dialogAlert()
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
      userName.text = namaUser
      lawanName.text = "Pemain Dua"
      btnPemainGunting.setOnClickListener{
        btnPemainGunting.isClickable = false
        btnPemainBatu.isClickable = false
        btnPemainKertas.isClickable = false
        btnPemainGunting.setBackgroundResource(R.drawable.ic_hand_background)
        idPemainSatu = 1
        gameController(selectHandPemainSatu(idPemainSatu))
      }

      btnPemainBatu.setOnClickListener{
        btnPemainGunting.isClickable = false
        btnPemainBatu.isClickable = false
        btnPemainKertas.isClickable = false
        btnPemainBatu.setBackgroundResource(R.drawable.ic_hand_background)
        idPemainSatu = 2
        gameController(selectHandPemainSatu(idPemainSatu))
      }

      btnPemainKertas.setOnClickListener{
        btnPemainGunting.isClickable = false
        btnPemainBatu.isClickable = false
        btnPemainKertas.isClickable = false
        btnPemainKertas.setBackgroundResource(R.drawable.ic_hand_background)
        idPemainSatu = 3
        gameController(selectHandPemainSatu(idPemainSatu))
      }

      btnCpuKertas.setOnClickListener{
        btnCpuGunting.isClickable = false
        btnCpuBatu.isClickable = false
        btnCpuKertas.isClickable = false
        btnCpuKertas.setBackgroundResource(R.drawable.ic_hand_background)
        idPemainDua = 1
        gameController(selectHandPemainDua(idPemainDua))
      }

      btnCpuGunting.setOnClickListener{
        btnCpuGunting.isClickable = false
        btnCpuBatu.isClickable = false
        btnCpuKertas.isClickable = false
        btnCpuGunting.setBackgroundResource(R.drawable.ic_hand_background)
        idPemainDua = 2
        gameController(selectHandPemainDua(idPemainDua))
      }
  
      btnCpuBatu.setOnClickListener{
        btnCpuGunting.isClickable = false
        btnCpuBatu.isClickable = false
        btnCpuKertas.isClickable = false
        btnCpuBatu.setBackgroundResource(R.drawable.ic_hand_background)
        idPemainDua = 3
        gameController(selectHandPemainDua(idPemainDua))
      }
    }
  }
  
  private fun clear(){
    btnPemainGunting.setBackgroundResource(0)
    btnPemainBatu.setBackgroundResource(0)
    btnPemainKertas.setBackgroundResource(0)
    btnCpuGunting.setBackgroundResource(0)
    btnCpuKertas.setBackgroundResource(0)
    btnCpuBatu.setBackgroundResource(0)
  
    btnPemainGunting.isClickable = true
    btnPemainBatu.isClickable = true
    btnPemainKertas.isClickable = true
    btnCpuGunting.isClickable = true
    btnCpuKertas.isClickable = true
    btnCpuBatu.isClickable = true
  
    idPemainSatu = 0
    idPemainDua = 0
  }
  
  private fun selectHandPemainSatu(id: Int = 0): Int {
    val idPemainSatu = id
    LogD("Pemain $userName Select Hand ID : $idPemainSatu")
    return idPemainSatu
  }
  
  private fun selectHandPemainDua(id: Int = 0): Int {
    val idPemainDua = id
    LogD("Pemain Dua Select Hand ID : $idPemainDua")
    return idPemainDua
  }
  
  private fun gameController(id: Int){
    val pemainSatu = selectHandPemainSatu(id)
    val pemainDua = selectHandPemainDua(id)
    
    if (pemainSatu != 0 && pemainDua != 0) {
      when (pemainSatu) {
        1 -> {
          when (pemainDua) {
            1 -> {
              LogD("Pemain Satu Gunting")
              LogD("Pemain Dua Kertas")
              LogD("Hasil Pemain Satu Menang !")
            }
            2 -> {
              LogD("Pemain Satu Gunting")
              LogD("Pemain Dua Gunting")
              LogD("Hasil Draw !")
            }
            3 -> {
              LogD("Pemain Satu Gunting")
              LogD("Pemain Dua Batu")
              LogD("Hasil Pemain Dua Menang !")
            }
          }
        }
        2 -> {
          when (pemainDua) {
            1 -> {
              LogD("Pemain $userName Batu")
              LogD("Pemain Kertas")
              LogD("Hasil Pemain Dua Menang !")
            }
            2 -> {
              LogD("Pemain $userName Batu")
              LogD("Pemain Dua Gunting")
              LogD("Hasil Pemain Satu Menang !")
            }
            3 -> {
              LogD("Pemain $userName Batu")
              LogD("Pemain Dua Batu")
              LogD("Hasil Draw !")
            }
          }
        }
        3 -> {
          when (pemainDua) {
            1 -> {
              LogD("Pemain $userName Kertas")
              LogD("Pemain Dua Kertas")
              LogD("Hasil Draw !")
            }
            2 -> {
              LogD("Pemain $userName Kertas")
              LogD("Pemain Dua Gunting")
              LogD("Hasil Pemain Dua Menang !")
            }
            3 -> {
              LogD("Pemain $userName Kertas")
              LogD("Pemain Dua Batu")
              LogD("Hasil Pemain Satu Menang !")
            }
          }
        }
      }
    }
    dialogAlert()
  }
  
  private fun dialogAlert(){
    val dialogBuilder = AlertDialog.Builder(this)
    val viewCustom = LayoutInflater.from(this).inflate(R.layout.dialog_winner, null, false)
    dialogBuilder.setView(viewCustom)
    val dialog = dialogBuilder.create()
  
    val btnRefresh = viewCustom.findViewById<Button>(R.id.btn_refresh)
    val btnBack = viewCustom.findViewById<Button>(R.id.btn_back)
  
    btnRefresh.setOnClickListener{
      dialog.dismiss()
      clear()
    }
  
    btnBack.setOnClickListener{
      dialog.dismiss()
      finish()
    }
  
    dialog.show()
  }
  
  private fun LogD(message: String){
    Log.d(GameActivity::class.java.simpleName, message)
  }
}
