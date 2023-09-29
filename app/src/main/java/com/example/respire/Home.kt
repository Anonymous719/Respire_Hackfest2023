package com.example.respire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.respire.databinding.FragmentHomeBinding
import com.example.respire.databinding.FragmentProfileBinding


class Home : Fragment() {

    companion object {
        fun newInstance() = Fragment()
    }

    private var fragbinding : FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var index = 43

        fragbinding = FragmentHomeBinding.inflate(inflater, container, false)

        when (index) {
            in 0..9 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication00)
            in 10..19 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication10)
            in 20..29 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication20)
            in 30..39 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication30)
            in 40..49 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication40)
            in 50..59 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication50)
            in 60..69 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication60)
            in 70..79 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication70)
            in 80..89 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication80)
            in 90..99 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication90)
            100 -> fragbinding!!.meter.setImageResource(R.drawable.circularcomplication100)
            else -> println("Value is out of the specified range")
        }

        when(index){
            in 0..30 -> fragbinding!!.currentlogo.setImageResource(R.drawable.clean)
            in 31..60 -> fragbinding!!.currentlogo.setImageResource(R.drawable.wearmask)
            in 61..100 -> fragbinding!!.currentlogo.setImageResource(R.drawable.danger)
        }



        // Inflate the layout for this fragment
        return fragbinding!!.root
    }


}