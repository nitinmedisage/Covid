package com.elink.covidassingment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.elink.covidassingment.adapter.RvAdapter
import com.elink.covidassingment.databinding.ActivityMainBinding
import com.elink.covidassingment.model.DataList
import com.elink.covidassingment.network.NetworkConnection
import com.elink.covidassingment.viewmodel.UserViewModel
import com.elink.covidassingment.viewmodelsfactories.UserViewModelFactory
import java.util.ArrayList

/**
 * Created by Nitin Sabale
 * @since 10-08-2022. 17:53
 */
class MainActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding: ActivityMainBinding? = null
    // binding method for activity
    private val binding get() = _binding!!
    private lateinit var listDataLists: MutableList<DataList>
    private lateinit var userViewModel : UserViewModel

    // get reference to the adapter class
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listDataLists = mutableListOf<DataList>()
        userViewModel = ViewModelProviders.of(this, UserViewModelFactory()).get(UserViewModel::class.java)

        // define layout manager for the Recycler view
        binding.rvList.layoutManager = LinearLayoutManager(this)
        // attach adapter to the recycler view
        rvAdapter = RvAdapter(listDataLists)
        binding.rvList.adapter = rvAdapter



        val networkConnection = NetworkConnection(this)
        networkConnection.observe(this, Observer { isConnected ->
            if(isConnected){

                //TODO : Get data from API
                userViewModel.getData().observe(this,object: Observer<ArrayList<DataList>> {
                    override fun onChanged(it: ArrayList<DataList>?) {
                        listDataLists.clear()
                        it?.let { listDataLists.addAll(it) }
                        rvAdapter.setAdapterData(listDataLists)
                    }
                })
            } else {
                Toast.makeText(this, "No  internet access!!!", Toast.LENGTH_SHORT).show()
            }
        })

    }

    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}