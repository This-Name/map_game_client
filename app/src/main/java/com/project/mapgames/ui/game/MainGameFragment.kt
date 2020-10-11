package com.project.mapgames.ui.game

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.mapgames.R
import com.project.mapgames.model.PlatformPositioningProvider
import com.project.mapgames.model.dataGame.Task
import kotlinx.coroutines.launch
import android.Manifest.permission
import android.widget.TextView


class MainGameFragment : Fragment(R.layout.main_game_fragment) {
    //lateinit var locationManager: LocationManager
    val gameViewModel by viewModels<GameViewModel>()
    lateinit var listTasks: ArrayList<Task>
    lateinit var listData: ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.am_navigation)?.visibility = View.INVISIBLE
        listTasks = arguments?.getParcelableArrayList("tasks")!!
        listData = checkNotNull(arguments?.getStringArrayList("CodeGameAndUserName"))
        gameViewModel.setTaskList(listTasks)
        val sizeList = listTasks.size
        var task = gameViewModel.getNextTask(null)
        var count = 1
        view.findViewById<TextView>(R.id.description_task_game).text = task?.title
        view.findViewById<TextView>(R.id.description_num_game).text = "$count/$sizeList"
        view.findViewById<TextView>(R.id.description_game).text = task?.description
        //locationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager

        view.findViewById<Button>(R.id.start_game_button).setOnClickListener {
            count++
            if (task != null) {
                task = gameViewModel.getNextTask(task?.next_task)
            }
            if (task != null) {
                view.findViewById<TextView>(R.id.description_task_game).text = task?.title
                view.findViewById<TextView>(R.id.description_num_game).text =
                    "$count/$sizeList"
                view.findViewById<TextView>(R.id.description_game).text = task?.description
                viewLifecycleOwner.lifecycleScope.launch {
                    gameViewModel.completeTask(listData[0], listData[1])
                }
            } else {
                Toast.makeText(context, "Все задания выполнены", Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<Button>(R.id.stop_game_button).setOnClickListener {
            count++
            if (task != null) {
                task = gameViewModel.getNextTask(task?.next_task)
            }
            if (task != null) {
                view.findViewById<TextView>(R.id.description_task_game).text = task?.title
                view.findViewById<TextView>(R.id.description_num_game).text =
                    "$count/$sizeList"
                view.findViewById<TextView>(R.id.description_game).text = task?.description
                viewLifecycleOwner.lifecycleScope.launch {
                    gameViewModel.completeTask(listData[0], listData[1])
                }
            } else {
                Toast.makeText(context, "Все задания выполнены", Toast.LENGTH_SHORT).show()
            }
        }

        /*view.findViewById<Button>(R.id.start_game_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                context?.let {
                    PlatformPositioningProvider(it).startLocating(object :
                        PlatformPositioningProvider.PlatformLocationListener {
                        override fun onLocationUpdated(location: Location?) {
                            val secondRes = Location("")
                            secondRes.latitude = task.coords.x
                            secondRes.longitude = task.coords.y
                            Toast.makeText(
                                context,
                                "${location?.longitude}" + " " + location?.latitude,
                                Toast.LENGTH_SHORT
                            ).show()
                            val ewfwfwef = location?.distanceTo(secondRes)
                            if (checkNotNull(ewfwfwef) < 5f) {
                                Toast.makeText(context, "wefwfwfw", Toast.LENGTH_SHORT).show()
                                task = gameViewModel.getNextTask(task.next_task)
                            }
                        }
                    })
                }
            }
        }*/
    }

    /*override fun onResume() {
        super.onResume()
        if (activity?.applicationContext?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED && activity?.applicationContext?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            Log.d(PlatformPositioningProvider.LOG_TAG, "Positioning permissions denied.")
            onClickLocationSettings(view)
        }
        activity?.let {
            ActivityCompat.requestPermissions(
                it, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1489)
        }
    }

    override fun onPause() {
        super.onPause()
        locationManager.removeUpdates(locationListener)
    }*/
    /*override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1489) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (activity?.applicationContext?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    } != PackageManager.PERMISSION_GRANTED && activity?.applicationContext?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                    } != PackageManager.PERMISSION_GRANTED
                ) {
                }
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    1000, 1f, locationListener
                )
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 1000, 1f,
                    locationListener
                )
            }
        }
    }*/
    /*private val locationListener: LocationListener =
        object : LocationListener {
            override fun onLocationChanged(location: Location) {
                showLocation(location)
            }

            override fun onStatusChanged(
                provider: String,
                status: Int,
                extras: Bundle
            ) {

            }

            override fun onProviderEnabled(provider: String?) {

            }

            override fun onProviderDisabled(provider: String?) {
                TODO("Not yet implemented")
            }
        }

    private fun showLocation(location: Location?) {
        if (location == null) return
        Toast.makeText(
            context,
            "${location.longitude}" + " " + location.latitude,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onClickLocationSettings(view: View?) {
        startActivity(
            Intent(
                Settings.ACTION_LOCATION_SOURCE_SETTINGS
            )
        )
    }*/
}