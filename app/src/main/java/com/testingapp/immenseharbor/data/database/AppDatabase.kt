package com.testingapp.immenseharbor.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.testingapp.immenseharbor.data.models.Department

@Database(entities = [Department::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val departmentDao:DepartmentDao
}