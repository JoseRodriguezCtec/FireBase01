package com.cibertec.cibertecapp.map

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cibertec.cibertecapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale

class MapFragment: Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var centerMarker: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container,
            false)
    }

    //Se llama cuando el mapa está listo para ser utilizado.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //childFragmentManager es el FragmentManager que se utiliza para agregar fragmentos a este fragmento.
        val mapFragment = childFragmentManager.findFragmentById(R.id.fragment_map)
                as SupportMapFragment

        //Obtiene el mapa asincrónicamente
        mapFragment.getMapAsync(this)

        //Se obtiene el ImageView del layout
        centerMarker = view.findViewById(R.id.imageViewMaps)

    }

    //Companion object es un objeto que se comparte entre todas las instancias de la clase que lo contiene.
    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

    //Se puede agrgar marcador en el mapa con el siguiente código en el método onMapReady de la siguiente manera:
    override fun onMapReady(googleMap: GoogleMap) {
        //Se ejecuta cuando el mapa está listo para ser utilizado.
        map = googleMap
        map.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(requireContext(),
            R.raw.stylemap)
        )

        //Se establece la ubicación de la cibertec en el mapa con un marcador
        val marker = LatLng(-8.1028413772583, -79.03350067138672)
        map.addMarker(MarkerOptions()
            //descripción del marcador
            .snippet("Cibertec")
            //para que es marcador sea arrastrable
            .draggable(true)
            //para cambiar el icono del marcador
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_persona))
            //para establecer la posición del marcador
            .position(marker)
            //para establecer el título del marcador
            .title("Cibertec")
        )

        //Se mueve la cámara a la ubicación de la cibertec
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 80f))

        //Se agrega un evento al hacer clic en el marcador
        map.setOnCameraIdleListener {
            map.clear()
            val centerLanLon = map.cameraPosition.target
            val lat = centerLanLon.latitude
            val lon = centerLanLon.longitude
            getStreetName(lat, lon)
        }

/*
        //Se agrega un evento al hacer clic en el mapa
        map.setOnMapClickListener {
            //Se limpia el mapa
            map.clear()
            //Se agrega un marcador en la ubicación seleccionada
            map.addMarker(MarkerOptions().position(it))
            //Se mueve la cámara a la ubicación seleccionada
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 15f))
            //Se obtiene la dirección de la ubicación seleccionada
            getStreetName(it.latitude, it.longitude)
        }*/

    }

    private fun getStreetName(lat:Double, lon:Double){
        //Se obtiene la dirección de la ubicación
        //Se crea un objeto de la clase Geocoder
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        //Se obtiene la dirección de la ubicación
        try {
            //Se agrega el addres y geocoder en un try catch para manejar la excepción de la geolocalización
            val address = geocoder.getFromLocation(lat, lon, 1)
            // se agrega en un if para verificar si la dirección no es nula y no está vacía para mostrar la dirección
            if (address !=null && address.isNotEmpty()){
                // se agrega un position para obtener la dirección de la ubicación y se obtiene la primera dirección
                val addressPosition = address[0]
                val addressName = addressPosition.getAddressLine(0)
                Toast.makeText(context, addressName, Toast.LENGTH_SHORT).show()
            }
        }catch (e:Exception){
            //Se muestra un mensaje de error si no se puede obtener la dirección de la ubicación
        }

    }
















































}