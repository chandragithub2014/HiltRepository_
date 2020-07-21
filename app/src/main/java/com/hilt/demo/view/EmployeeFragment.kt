package com.hilt.demo.view

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hilt.demo.R
import com.hilt.demo.viewmodel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.emp_fragment_main.*
@AndroidEntryPoint
class EmployeeFragment : Fragment() {
    private val mainViewModel : EmployeeViewModel by viewModels()
    private var userListView : View? = null
    var mContainerId:Int = -1
    private var postListAdapter : PostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userListView = inflater.inflate(R.layout.emp_fragment_main, container, false)
        mContainerId = container?.id?:-1
        return  userListView
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.fetchEmpInfo()
    }

    private fun observeViewModel(){
        mainViewModel.fetchUsersLiveData().observe(viewLifecycleOwner, Observer {
            it?.let {
                println("Response From Network :::: $it")
                postListAdapter?.refreshAdapter(it)
            }
        })


        mainViewModel.fetchLoadStatus().observe(viewLifecycleOwner, Observer {
            if(!it){
                println(it)
                progressBar.visibility  = View.GONE
            }
        })

        mainViewModel.fetchError().observe(viewLifecycleOwner, Observer {
            it?.let {
                if(!TextUtils.isEmpty(it)){
                    Toast.makeText(context,"$it", Toast.LENGTH_LONG).show()
                }

            }
        })
    }

    private fun initAdapter(){
        postListAdapter = PostAdapter(arrayListOf())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postListAdapter

        }

    }
}