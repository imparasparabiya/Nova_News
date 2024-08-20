package com.example.novanews.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.novanews.Adapter.PopularAdapter
import com.example.novanews.Client.NewsAPIClient
import com.example.novanews.Interface.NewsAPIInterface
import com.example.novanews.Modal.PopularModal
import com.example.novanews.Modal.SubnewsItem
import com.example.novanews.databinding.FragmentPopularBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PopularFragment : Fragment() {

    lateinit var popularBinding: FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        popularBinding = FragmentPopularBinding.inflate(inflater,container,false)
        val view = popularBinding.root

    popularApiCalling()



        return popularBinding.root
    }

    fun rvDataRetrofit(popularList: List<SubnewsItem?>?){
        popularBinding.rvDataPopular.adapter = PopularAdapter(popularList)
        popularBinding.rvDataPopular.setHasFixedSize(true)
    }
    fun popularApiCalling(){
        var  apiInterface = NewsAPIClient.getNewsAPIClient()?.create(NewsAPIInterface::class.java)

        apiInterface?.getPopular()?.enqueue(object : Callback<PopularModal>{
            override fun onResponse(call: Call<PopularModal>, response: Response<PopularModal>) {
                if (response.isSuccessful){
                    rvDataRetrofit(response.body()!!.subnews)
                }

            }

            override fun onFailure(call: Call<PopularModal>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}