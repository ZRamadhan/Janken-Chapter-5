package id.com.zulfikar.jankengame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
  
  // step 1 kirim data dari activity ke fragment, bikin interface di activity
  interface OnSendDataToFragment {
    fun onDataSend(input: String)
  }
  
  // step 2 data dari activity ke fragment. bikin variable di activity
  var listener: OnSendDataToFragment? = null
}