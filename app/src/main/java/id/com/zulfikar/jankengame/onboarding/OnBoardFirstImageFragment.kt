package id.com.zulfikar.jankengame.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.com.zulfikar.jankengame.MainActivity
import id.com.zulfikar.jankengame.R

class OnBoardFirstImageFragment : Fragment(), MainActivity.OnSendDataToFragment {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (activity as MainActivity).listener = this
  }
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_on_board_first_image, container, false)
  }
  
  override fun onDataSend(input: String) {
    Toast.makeText(requireContext(), "data : $input", Toast.LENGTH_SHORT).show()
  }
}