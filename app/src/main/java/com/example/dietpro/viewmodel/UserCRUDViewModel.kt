package com.example.dietpro.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dietpro.ModelPreferencesManager
import com.example.dietpro.model.Meal
import com.example.dietpro.model.User
import com.example.dietpro.model.UserVO
import java.util.ArrayList

class UserCRUDViewModel constructor(context: Context): ViewModel() {

    private var currentUser: UserVO? = null
    private var currentUsers: ArrayList<UserVO> = ArrayList()

    init {
        ModelPreferencesManager.with(context, "User_DATA")
        currentUser = getUser()
    }

    companion object {
        private var instance: UserCRUDViewModel? = null
        fun getInstance(context: Context): UserCRUDViewModel {
            return instance ?: UserCRUDViewModel(context)
        }
    }

    fun getUser() : UserVO? {
        currentUsers.clear()
        currentUser = ModelPreferencesManager.get<User>("KEY_User")?.let { UserVO(it) }
        currentUser?.let { currentUsers.add(0, it) }
        return currentUser
    }

    fun createUser(_x: UserVO) {
        ModelPreferencesManager.put(_x, "KEY_User")
        currentUser = _x
        currentUser?.let { currentUsers.add(0, it) }
    }

    fun setSelectedUser(x: UserVO) {
        currentUser = x
    }



    fun listUser(): ArrayList<UserVO> {
        getUser()
        return currentUsers
    }

    fun listAllUser(): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun stringListUser(): ArrayList<String> {
        currentUsers = listUser()
        val res: ArrayList<String> = ArrayList()
        for (x in currentUsers.indices) {
            res.add(currentUsers[x].toString())
        }
        return res
    }

    fun getUserByPK(_val: String): User? {
        val res: ArrayList<UserVO> = listUser()
        return if (res.isEmpty()) {
            null
        } else {
            val vo: UserVO = res[0]
            val itemx = User.createByPKUser(_val)
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            itemx
        }
    }

    fun retrieveUser(_val: String): User? {
        return getUserByPK(_val)
    }

    fun allUserUserNames(): ArrayList<String> {
        currentUsers = listUser()
        val res: ArrayList<String> = ArrayList()
        for (user in currentUsers.indices) {
            res.add(currentUsers[user].getUserName())
        }
        return res
    }

    fun setSelectedUser(i: Int) {
        if (i < currentUsers.size) {
            currentUser = currentUsers[i]
        }
    }

    fun getSelectedUser(): UserVO? {
        return currentUser
    }

    fun persistUser(_x: User) {
        val vo = UserVO(_x)
        createUser(vo)
        currentUser = vo
    }

    fun searchByUseruserName(userNamex: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUsergender(genderx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUserheights(heightsx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUserweights(weightsx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUseractivityLevel(activityLevelx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUserage(agex: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUsertargetCalories(targetCaloriesx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUsertotalConsumedCalories(totalConsumedCaloriesx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun searchByUserBMR(BMRx: String): ArrayList<User> {
        currentUsers = listUser()
        var res = ArrayList<User>()
        for (x in currentUsers.indices) {
            val vo: UserVO = currentUsers[x]
            val itemx = User.createByPKUser(vo.getUserName())
            itemx.userName = vo.getUserName()
            itemx.gender = vo.getGender()
            itemx.heights = vo.getHeights()
            itemx.weights = vo.getWeights()
            itemx.activityLevel = vo.getActivityLevel()
            itemx.age = vo.getAge()
            itemx.targetCalories = vo.getTargetCalories()
            itemx.totalConsumedCalories = vo.getTotalConsumedCalories()
            itemx.bmr = vo.getBmr()
            res.add(itemx)
        }
        return res
    }

    fun findTargetCalories(user: User): Double {
        var result = 0.0
        user.targetCalories  = user.calculateTargetCalories()
        persistUser (user)
        result  = user.targetCalories
        return result
    }

    fun findBMR(user: User): Double {
        var result = 0.0
        user.bmr  = user.calculateBmr()
        persistUser (user)
        result  = user.bmr
        return result
    }


    fun caloriesProgress(user: User): Double {
        var result = 0.0
        var progress: Double
        progress  = (user.totalConsumedCalories / user.targetCalories) * 100
        persistUser (user)
        result  = progress
        return result
    }

    fun findTotalConsumedCaloriesByDate(meals: ArrayList<Meal>, user: User, dates: String): Double {
        var totalConsumedCalories: Double = 0.0
        for (meal in meals) {
            if (meal.userName == user.userName && meal.dates == dates) {
                totalConsumedCalories += meal.calories
            }
        }
        user.totalConsumedCalories  = totalConsumedCalories
        persistUser (user)
        return totalConsumedCalories
    }
}