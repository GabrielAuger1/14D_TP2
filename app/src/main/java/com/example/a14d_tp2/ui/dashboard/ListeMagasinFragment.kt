package com.example.a14d_tp2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a14d_tp2.databinding.FragmentListeMagasinBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a14d_tp2.R
import com.example.a14d_tp2.adapter.ItemAdapter
import com.example.a14d_tp2.data.ItemDao
import com.example.a14d_tp2.data.ItemDatabase

class ListeMagasinFragment : Fragment() {

    private var _binding: FragmentListeMagasinBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var itemDao: ItemDao

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(ListeMagasinViewModel::class.java)

        _binding = FragmentListeMagasinBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = root.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemDatabase = ItemDatabase.getInstance(requireContext())

        itemDao = itemDatabase.itemDao()
        itemDao.getAllItems().observe(viewLifecycleOwner, Observer { items ->
            itemAdapter = ItemAdapter(items, isAdminMode = false)
            recyclerView.adapter = itemAdapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}