package edu.towson.cosc435.aka.roots.ui.viewmodel

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import edu.towson.cosc435.aka.roots.R
import androidx.work.WorkerParameters

class JoinWorker (ctx: Context, workerParameters: WorkerParameters): Worker(ctx, workerParameters) {
    override fun doWork() : Result{
        JoinWorker("RootsApp", "Thank you for joining!")
        val outputData = Data.Builder().putString(WORK_RESULT, "Test Finished").build()
        return Result.success(outputData)
    }
    private fun JoinWorker(title: String, desc: String){
        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = "1"
        val name = "1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val builder = NotificationCompat.Builder(applicationContext, id)
            .setContentTitle(title)
            .setContentText(desc)
            .setSmallIcon(R.drawable.rootslogo)
        manager.notify(1, builder.build())
    }
    companion object{
        const val WORK_RESULT = "work_result"
    }

}