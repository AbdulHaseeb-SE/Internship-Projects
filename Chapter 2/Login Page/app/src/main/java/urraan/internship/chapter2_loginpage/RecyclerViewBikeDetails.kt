package urraan.internship.chapter2_loginpage

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import urraan.internship.chapter2_loginpage.adapter.BikesListAdapter
import urraan.internship.chapter2_loginpage.databinding.ActivityBikeDataBinding
import urraan.internship.chapter2_loginpage.databinding.ActivityRecyclerViewBikeDetailsBinding
import urraan.internship.chapter2_loginpage.entity.Bike
import urraan.internship.chapter2_loginpage.entity.BikeDao
import urraan.internship.chapter2_loginpage.entity.BikeDatabase

class RecyclerViewBikeDetails : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityRecyclerViewBikeDetailsBinding
    private lateinit var adapter: BikesListAdapter
    var repository : BikeDao ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBikeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val alertDialogBuilder = AlertDialog.Builder(this)

        repository = BikeDatabase.getDatabase(applicationContext).bikeDao

        binding.btnAddBikeDetails.setOnClickListener {
            startActivity(Intent(this, BikeDataActivity::class.java))
        }


        adapter = BikesListAdapter(this){bike ->
         alertDialogBuilder.setTitle("Caution!")
             .setMessage("Are you sure you want to delete this item?")
             .setIcon(R.drawable.ic_baseline_error_outline_24)
             .setPositiveButton("Yes", DialogInterface.OnClickListener{dialog,it ->
             lifecycleScope.launch(Dispatchers.IO) {
                 repository!!.deleteBikeData(bike)
             }
             })
             .setNegativeButton("No", DialogInterface.OnClickListener{d, it->
                 d.dismiss()
             })
            alertDialogBuilder.show()

        }
        binding.recyclerViewBikeItems.adapter = adapter
        binding.recyclerViewBikeItems.layoutManager = LinearLayoutManager(this)
        repository!!.readBikeData().observe(this){
            adapter.SetData(it)
            binding.txtViewToShow.isVisible = it.isEmpty()
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchData(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            searchData(query)
        }
        return true
    }

    private fun searchData(query: String){
        val searQuery = "%$query%"
        repository!!.searchDatabase(searQuery).observe(this, {list ->
            list.let {
                adapter.SetData(it)
            }
        })

    }
}