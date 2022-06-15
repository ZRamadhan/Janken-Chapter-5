package id.com.zulfikar.jankengame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
class MainActivity : AppCompatActivity() {
  
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
    
    viewPager.addOnAdapterChangeListener(object : ViewPager.OnPageChangeListener{
      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
      
      }
  
      override fun onPageSelected(position: Int) {
        if (position == 1 || position == 0 || namaUser.isNotEmpty())
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
  
  // step 1 kirim data dari activity ke fragment, bikin interface di activity
  interface OnSendDataToFragment {
    fun onDataSend(input: String)
  }
  
  // step 2 data dari activity ke fragment. bikin variable di activity
  var listener: OnSendDataToFragment? = null
}