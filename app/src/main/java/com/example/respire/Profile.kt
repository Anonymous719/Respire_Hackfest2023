package com.example.respire

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.provider.WebAuthProvider
import com.example.respire.databinding.FragmentProfileBinding
import javax.security.auth.callback.Callback


class Profile : Fragment() {

    companion object {
        fun newInstance() = Fragment()
    }

    private var fragbinding : FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragbinding = FragmentProfileBinding.inflate(inflater, container, false)

        fragbinding!!.signoutbtn.setOnClickListener {
            logout()
        }
        // Inflate the layout for this fragment
        return fragbinding!!.root
    }

    private fun logout() {
        WebAuthProvider.logout(account)
            .withScheme("demo")
            .start(this, object: Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    requireActivity().run{
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }

                override fun onFailure(error: AuthenticationException) {
                    // Something went wrong!
                }
            })
    }
}