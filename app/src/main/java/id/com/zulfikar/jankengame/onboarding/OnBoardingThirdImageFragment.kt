package id.com.zulfikar.jankengame.onboarding

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import id.com.zulfikar.jankengame.R

class OnBoardingThirdImageFragment : Fragment() {
  
  lateinit var etName: EditText
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_on_boarding_third_image, container, false)
    
    etName = view.findViewById(R.id.et_name)
    
    etName.addTextChangedListener{
      // step 6 kirim data dari fragment ke activity -> dengan cara panggil method
      listener?.afterUserInputName(it.toString())
    }
  
    // Inflate the layout for this fragment
    return view
  }
  
  // step 2 kirim data dari fragment ke activity -> membuat variabel interface fragment
  var listener: UsernameInputListener? = null
  
  override fun onAttach(context: Context) {
    super.onAttach(context)
    
    // step 5 kirim data dari fragment ke activity -> init variabel listener
    if (context is UsernameInputListener) listener = context
  }
  
  // step 1 kirim data dari fragment ke listener
  interface UsernameInputListener {
    fun afterUserInputName(input: String)
  }
}