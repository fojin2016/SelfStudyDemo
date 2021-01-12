package com.lfj.selfstudydemo.diffUtil

/**
 * @description
 * @author LFJ
 * @date   2020/10/28 10:23
 */
data class UserBean(var name: String, var age: String) {

    override fun toString(): String {
        return "name=$name ,age=$age"
    }
}