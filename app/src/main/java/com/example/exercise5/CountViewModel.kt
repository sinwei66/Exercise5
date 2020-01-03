package my.edu.tarc.exercise5

import android.util.Log
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    var countLike: Int = 0
    var countDislike: Int = 0

    fun setLike(set : Int)
    {
        countLike = set
    }

    fun setDislike(set : Int)
    {
        countDislike = set
    }

    fun like(add : Int)
    {
        countLike = countLike + add
    }

    fun dislike(add : Int)
    {
        countDislike = countDislike + add
    }

    fun returnLike() : Int
    {
        return countLike
    }

    fun returnDislike() : Int
    {
        return countDislike
    }
}