package com.cibertec.cibertecapp.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.map.MapFragment
import com.cibertec.cibertecapp.news.NewsFragment
import com.cibertec.cibertecapp.notas.NotaActivity
import com.cibertec.cibertecapp.subject.SubjectFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MenuActivity: AppCompatActivity(), MenuDrawerAction {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val nav_view = findViewById<BottomNavigationView>(R.id.nav_view)
        nav_view.setOnItemSelectedListener {
            when(it.itemId){
                R.id.itemNews -> {
                    //para instanciar el fragmento maps se llama al método newInstance
                    val fragment = MapFragment.newInstance()
                    //fragment.interfaceMenu = this
                    openFragment(fragment)
                    true
                }
                R.id.itemSubject -> {
                    val fragment = SubjectFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

        nav_view.selectedItemId = R.id.itemNews
        drawerLayout = findViewById(R.id.drawerLayout)

        val navViewLateral = findViewById<NavigationView>(R.id.nav_view_lateral)
        navViewLateral.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemNotas -> {
                    startActivity(Intent(this, NotaActivity::class.java))
                    true
                }
                R.id.itemBiblioteca -> {
                    true
                }
                else -> false
            }
        }
    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_menu, fragment)
        transaction.commit()
    }

    override fun openMenu() {
       drawerLayout.openDrawer(GravityCompat.START)
    }

}

interface MenuDrawerAction {
    fun openMenu()
}