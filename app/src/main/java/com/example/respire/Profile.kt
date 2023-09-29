package com.example.respire
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.authentication.storage.CredentialsManager
import com.auth0.android.authentication.storage.SharedPreferencesStorage
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.provider.WebAuthProvider.logout
import com.auth0.android.result.UserProfile
import com.example.respire.databinding.ActivityMainBinding
import com.example.respire.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar
import javax.security.auth.callback.Callback


class Profile : Fragment() {

    companion object {
        fun newInstance() = Fragment()
    }

    private var fragbinding : FragmentProfileBinding? = null
    private lateinit var account: Auth0
    private var cachedCredentials: com.auth0.android.result.Credentials? = null
    private var cachedUserProfile: UserProfile? = null
    private var signin: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragbinding = FragmentProfileBinding.inflate(inflater, container, false)

        account = Auth0(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )


        fragbinding!!.signoutbtn.setOnClickListener {
            if(signin){
                fragbinding!!.signoutbtn.text = "Sign In"
                signin = false
                logout()
            }else{
                fragbinding!!.signoutbtn.text = "Sign Out"
                signin = true
                loginWithBrowser()
            }

        }
        // Inflate the layout for this fragment
        return fragbinding!!.root
    }

    private fun logout() {
//        WebAuthProvider.logout(account)
//            .withScheme("demo")
//            .start(requireActivity().applicationContext, object: com.auth0.android.callback.Callback<Void?, AuthenticationException> {
//                override fun onSuccess(payload: Void?) {
//
//                }
//
//                override fun onFailure(error: AuthenticationException) {
//                    // Something went wrong!
//                }
//            })

    }

    private fun loginWithBrowser() {
        // Setup the WebAuthProvider, using the custom scheme and scope.
//        WebAuthProvider.login(account)
//            .withScheme("demo")
//            .withScope("openid profile email read:current_user update:current_user_metadata")
//            .withAudience("https://${getString(R.string.com_auth0_domain)}/api/v2/")
//
//            // Launch the authentication passing the callback where the results will be received
//            .start(requireActivity().applicationContext, object :
//                com.auth0.android.callback.Callback<com.auth0.android.result.Credentials, AuthenticationException> {
//                override fun onFailure(exception: AuthenticationException) {
//                    showSnackBar("Failure: ${exception.getCode()}")
//                }
//
//                override fun onSuccess(credentials: com.auth0.android.result.Credentials) {
//                    cachedCredentials = credentials
//                    showSnackBar("Success: ${credentials.accessToken}")
//
//                }
//            })

    }
    private fun showSnackBar(text: String) {
        Snackbar.make(
            fragbinding!!.root,
            text,
            Snackbar.LENGTH_LONG
        ).show()
    }
}