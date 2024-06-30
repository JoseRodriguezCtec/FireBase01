package com.cibertec.cibertecapp.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.auth.LoginViewModel
import com.cibertec.cibertecapp.menu.MenuDrawerAction

class NewsFragment: Fragment() {

    lateinit var interfaceMenu: MenuDrawerAction
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        val toolbarNews = view.findViewById<Toolbar>(R.id.toolbarNews)
        toolbarNews.setNavigationOnClickListener {
            interfaceMenu.openMenu()
        }
        toolbarNews.inflateMenu(R.menu.menu_toolbar)
        toolbarNews.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.itemCompartir -> {
                    Toast.makeText(context, "Compartir",
                        Toast.LENGTH_SHORT).show()
                   true
                }
                else -> false
            }
        }

        val recyclerNews = view.findViewById<RecyclerView>(R.id.recyclerNews)
        val adapter = NewsAdapter()
        recyclerNews.adapter = adapter
        recyclerNews.layoutManager = LinearLayoutManager(activity)

        // LisNoticias
        viewModel.getNews()
        viewModel.newsListMutable.observe(viewLifecycleOwner) {

            if (it.isNotEmpty()) {
                adapter.setNews(it)
            }

        }
    }

    companion object {
        fun newInstance() : NewsFragment = NewsFragment()
    }

}