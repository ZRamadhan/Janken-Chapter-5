package id.com.zulfikar.jankengame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import id.com.zulfikar.jankengame.onboarding.OnBoardFirstImageFragment
import id.com.zulfikar.jankengame.onboarding.OnBoardingSecondImageFragment
import id.com.zulfikar.jankengame.onboarding.OnBoardingThirdImageFragment

// step 3 kirim data dari fragment ke activity -> implement data di activity
class MainActivity : AppCompatActivity(), OnBoardingThirdImageFragment.UsernameInputListener {
  
  lateinit var viewPager: ViewPager
  lateinit var dotIndicator: DotsIndicator
  lateinit var btnNext: ImageView
  
  var namaUser = ""
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    viewPager = findViewById(R.id.viewPager)
    dotIndicator = findViewById(R.id.dotsIndicator)
    btnNext = findViewById(R.id.btnNext)
    
    viewPager.adapter = SimpleViewPagerAdapter(supportFragmentManager)
    dotIndicator.attachTo(viewPager)
    
    btnNext.setOnClickListener{
      val currentIndex = viewPager.currentItem
      viewPager.currentItem = currentIndex+1
      
      if (currentIndex == 2) {
        val navigateToHome = Intent(this@MainActivity, HomeActivity::class.java)
        navigateToHome.putExtra("USER_NAME", namaUser)
        startActivity(navigateToHome)
      }
  
      if(currentIndex == 0) {
        // step 6 kirim data dari activity ke fragment, panggil method dan kirim data sesuai yg dibutuhkan
        listener?.onDataSend("data from activity")
      }
    }
  
    // disable button next saat berada di fragment pertama, terakhir, dan saat tidak ada nama
    viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

      }

      override fun onPageSelected(position: Int) {
        if (position == 1 || position == 0 || namaUser.isNotEmpty()) btnNext.visibility = View.VISIBLE
        else btnNext.visibility = View.GONE
      }

      override fun onPageScrollStateChanged(state: Int) {

      }
    })
  }
  
  private inner class SimpleViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getCount(): Int = 3
  
    override fun getItem(position: Int): Fragment = when (position) {
      0 -> OnBoardFirstImageFragment()
      1 -> OnBoardingSecondImageFragment()
      else -> OnBoardingThirdImageFragment()
    }
  
  }
  
  // step 4 kirim dara dari activity ke fragment -> override method interfacenya
  override fun afterUserInputName(input: String) {
    if(input.isNotEmpty()) btnNext.visibility = View.VISIBLE else btnNext.visibility = View.GONE
    namaUser = input
  }
  
  // step 1 kirim data dari activity ke fragment -> bikin interface di activity
  interface OnSendDataToFragment {
    fun onDataSend(input: String)
  }
  
  // step 2 data dari activity ke fragment -> bikin variable di activity
  var listener: OnSendDataToFragment? = null
}