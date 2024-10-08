package com.example.a14d_tp2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.a14d_tp2.model.Item
@Dao
interface ItemDao {

    @Insert
    fun insertItem(item: Item)

    @Insert
    fun insertItemReturnId(item: Item): Long

    @Insert
    fun insertItems(items: List<Item>): List<Long>

    @Update
    fun updateItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Query("SELECT * FROM items WHERE id = :id")
    fun getItemById(id: Int): LiveData<Item>

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>

    @Query("DELETE FROM items")
    fun deleteAllItems()
}