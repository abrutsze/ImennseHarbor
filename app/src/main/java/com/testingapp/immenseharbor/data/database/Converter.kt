package com.testingapp.immenseharbor.data.database

import androidx.room.TypeConverter
import com.testingapp.immenseharbor.data.models.Country
import com.testingapp.immenseharbor.data.models.Employee
import com.testingapp.immenseharbor.data.models.Location
import com.testingapp.immenseharbor.data.models.Region
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    var gson: Gson = Gson()

    @TypeConverter
    fun fromStringToLocation( data: String?) : Location? {
        if( data == null ) {
            return null
        }

        val obj = object : TypeToken<Location>(){}.type

        return gson.fromJson(data, obj)
    }

    @TypeConverter
    fun fromLocationToString( someObjects : Location) : String? {
        if(someObjects == null) {
            return null
        }
        return gson.toJson(someObjects)
    }


    @TypeConverter
    fun fromStringToCountry( data: String?) : Country? {
        if( data == null ) {
            return null
        }

        val obj = object : TypeToken<Country>(){}.type

        return gson.fromJson(data, obj)
    }

    @TypeConverter
    fun fromCountryToString( someObjects : Country) : String? {
        if(someObjects == null) {
            return null
        }
        return gson.toJson(someObjects)
    }



    @TypeConverter
    fun fromStringToRegion( data: String?) : Region? {
        if( data == null ) {
            return null
        }

        val obj = object : TypeToken<Region>(){}.type

        return gson.fromJson(data, obj)
    }

    @TypeConverter
    fun fromRegionToString( someObjects : Region) : String? {
        if(someObjects == null) {
            return null
        }
        return gson.toJson(someObjects)
    }


    @TypeConverter
    fun fromStringToListEmployee( data: String?) : List<Employee>? {
        if( data == null ) {
            return null
        }

        val obj = object : TypeToken<List<Employee>>(){}.type

        return gson.fromJson(data, obj)
    }

    @TypeConverter
    fun fromListEmployeeToString( someObjects : List<Employee>) : String? {
        if(someObjects == null) {
            return null
        }
        return gson.toJson(someObjects)
    }
}