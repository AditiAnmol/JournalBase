package edu.cs646.project.mydiary

import android.content.Context

class EntryRepo private constructor(context: Context) {

    var bandList: MutableList<Entry> = mutableListOf()

    companion object {
        private var instance: EntryRepo? = null

        fun getInstance(context: Context): EntryRepo {
            if (instance == null) {
                instance = EntryRepo(context)
            }
            return instance!!
        }
    }

    init {
        val bands = context.resources.getStringArray(R.array.bands)
        val descriptions = context.resources.getStringArray(R.array.descriptions)
        for (i in bands.indices) {
            bandList.add(Entry(i + 1, bands[i], descriptions[i]))
        }
    }

    fun getBand(bandId: Int): Entry? {
        return bandList.find { it.id == bandId }
    }
}