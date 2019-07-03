package com.testingapp.immenseharbor.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.testingapp.immenseharbor.data.models.Department
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface DepartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(department: Department)

    @Query("Delete from Department")
    fun delete(): Completable

    @Query("SELECT * FROM Department")
    fun result(): Single<List<Department>>
}