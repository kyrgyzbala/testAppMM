package kg.kyrgyzcoder.testtaskmm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationBarView
import kg.kyrgyzcoder.testtaskmm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerListener()
        binding.navBottomView.setOnItemSelectedListener(this)
        val adapter = MainPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = true

    }

    private fun viewPagerListener() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                onResume()
                when (position) {
                    0 -> binding.navBottomView.menu.findItem(R.id.enter)
                    else -> binding.navBottomView.menu.findItem(R.id.display).isChecked =
                        true
                }
            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        onResume()
        binding.viewPager.currentItem = when (item.itemId) {
            R.id.enter -> 0
            else -> 1
        }
        return true
    }
}