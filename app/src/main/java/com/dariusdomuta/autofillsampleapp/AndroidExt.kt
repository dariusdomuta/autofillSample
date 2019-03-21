package com.dariusdomuta.autofillsampleapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.IBinder
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IntegerRes
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun <T> Activity.startActivityOfClass(activityClass: Class<T>) {
    startActivity(Intent(this, activityClass))
}

fun AppCompatActivity.addFragment(viewId: Int, fragment: Fragment, addToBackStack: Boolean = false, backStackTag: String? = null) {
    val tx = supportFragmentManager.beginTransaction().add(viewId, fragment)
    if (addToBackStack) tx.addToBackStack(backStackTag)
    tx.commit()
}

fun AppCompatActivity.replaceFragment(viewId: Int, fragment: Fragment, addToBackStack: Boolean = false, backStackTag: String? = null) {
    val tx = supportFragmentManager.beginTransaction().replace(viewId, fragment)
    if (addToBackStack) tx.addToBackStack(backStackTag)
    tx.commit()
}

fun AppCompatActivity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.showToast(msgId: Int) {
    Toast.makeText(this, msgId, Toast.LENGTH_LONG).show()
}

fun Fragment.showToast(msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(resId: Int) {
    showToast(getString(resId))
}

fun android.app.Fragment.showToast(msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
}

fun android.app.Fragment.showToast(resId: Int) {
    showToast(getString(resId))
}

fun Fragment.showDialogFragment(dialog: DialogFragment) {
    val fragmentTransaction = fragmentManager?.beginTransaction()
    val prevFragment = fragmentManager?.findFragmentByTag("dialog")
    if (prevFragment != null) {
        fragmentTransaction?.remove(prevFragment)
    }
    fragmentTransaction?.addToBackStack(null)

    dialog.show(fragmentTransaction, "dialog")
}

fun Fragment.closeKeyboard(binder: IBinder) {
    val inputManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(binder, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun AppCompatActivity.dimen(@DimenRes resId: Int): Int {
    return resources.getDimension(resId).toInt()
}

fun AppCompatActivity.color(@ColorRes resId: Int): Int {
    return resources.getColor(resId)
}

fun AppCompatActivity.integer(@IntegerRes resId: Int): Int {
    return resources.getInteger(resId)
}

fun AppCompatActivity.setToolbar(toolbar: Toolbar) {
    setSupportActionBar(toolbar)
}

fun AppCompatActivity.showToolbar() {
    supportActionBar?.show()
}

fun AppCompatActivity.hideToolbar() {
    supportActionBar?.hide()
}

fun AppCompatActivity.showHomeFromToolbar() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

fun AppCompatActivity.hideHomeFromToolbar() {
    supportActionBar?.setDisplayHomeAsUpEnabled(false)
}

fun AppCompatActivity.setTitleOnToolbar(title: String) {
    supportActionBar?.title = title
}

fun AppCompatActivity.setTitleOnToolbar(titleRes: Int) {
    supportActionBar?.title = getString(titleRes)
}

fun Activity.getScreenWidth(): Int {
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.x
}
