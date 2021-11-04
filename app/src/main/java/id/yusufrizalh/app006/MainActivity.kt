package id.yusufrizalh.app006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var myToggle: ActionBarDrawerToggle
    lateinit var myToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myToolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(myToolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.myDrawerLayout)
        val navView: NavigationView = findViewById(R.id.myDrawerView)

        myToggle = ActionBarDrawerToggle(this, drawerLayout, myToolbar, 0, 0)

        myDrawerLayout.addDrawerListener(myToggle)

        myToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.homeId -> {
                intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.projectId -> {
                Toast.makeText(applicationContext, "Project is clicked", Toast.LENGTH_LONG).show()
            }
            R.id.teamsId -> {
                Toast.makeText(applicationContext, "Teams is clicked", Toast.LENGTH_LONG).show()
            }
            R.id.galleryId -> {
                Toast.makeText(applicationContext, "Gallery is clicked", Toast.LENGTH_LONG).show()
            }
            R.id.contactId -> {
                Toast.makeText(applicationContext, "Contact is clicked", Toast.LENGTH_LONG).show()
            }
        }
        myDrawerLayout.openDrawer(GravityCompat.START)
        return true
    }


    // menampilkan action menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // memilih action menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_settings -> {
                Toast.makeText(applicationContext, "Settings is clicked", Toast.LENGTH_LONG).show()
            }
            R.id.menu_search -> {
                Toast.makeText(applicationContext, "Searchs is clicked", Toast.LENGTH_LONG).show()
            }
            R.id.menu_device -> {
                Toast.makeText(applicationContext, "Devices is clicked", Toast.LENGTH_LONG).show()
            }
            R.id.menu_message -> {
                Toast.makeText(applicationContext, "Messages is clicked", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}