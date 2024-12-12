package com.example.novanews.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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
    lateinit var adapter: PopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        popularBinding = FragmentPopularBinding.inflate(inflater,container,false)

    popularApiCalling()

        return popularBinding.root
    }

    fun rvDataRetrofit(popularList: List<SubnewsItem?>?){
        popularBinding.rvDataPopular.layoutManager = LinearLayoutManager(requireContext())
        popularBinding.rvDataPopular.visibility = View.VISIBLE

        popularBinding.rvDataPopular.setHasFixedSize(true)
        popularBinding.rvDataPopular.setItemViewCacheSize(20)
        popularBinding.rvDataPopular.isDrawingCacheEnabled = true
        popularBinding.rvDataPopular.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        adapter = PopularAdapter(popularList)
        popularBinding.rvDataPopular.adapter = adapter

    }
    fun popularApiCalling(){
        val apiInterface = NewsAPIClient.getNewsAPIClient()?.create(NewsAPIInterface::class.java)

        apiInterface?.getPopular("in", key = "7c004458f9msh2b5c388a12ceb7bp168904jsne5941ab6d4ad")?.enqueue(object : Callback<PopularModal>{
            override fun onResponse(call: Call<PopularModal>, response: Response<PopularModal>) {
                if (response.isSuccessful){
                    val popularModal = response.body()
                    if (popularModal != null && popularModal.subnews != null){
                        rvDataRetrofit(popularModal.subnews)
                        popularBinding.rvDataPopular.visibility = View.VISIBLE
                        Log.i("TAG", "onResponse: ${popularModal.subnews}")
                    }else{
                        showError("no data found")
                    }
                }
            }
            override fun onFailure(call: Call<PopularModal>, t: Throwable) {
                showError("Error: ${t.message}")
                Log.e("PopularFragment", "API call failed", t)
            }
        })
    }
    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        Log.e("PopularFragment", message)
    }

}