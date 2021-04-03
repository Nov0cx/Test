package com.nov0cx.spigotdictionary.api.kotlin

import com.nov0cx.spigotdictionary.api.SpigotDictionaryAPI
import java.util.concurrent.TimeUnit

fun executeLater(delay: Long, unit: TimeUnit, runnable: Runnable) {
    SpigotDictionaryAPI.get().executors.laterExecutor.exe(runnable, delay, unit)
}

fun executeSyncLater(delay: Long, runnable: Runnable) {
    SpigotDictionaryAPI.get().executors.laterSpigotMainThreadExecutor.exe(runnable, delay)
}

fun executeOnNewThread(runnable: Runnable) {
    SpigotDictionaryAPI.get().executors.newThreadExecutor.exe(runnable)
}

fun execute(runnable: Runnable) {
    SpigotDictionaryAPI.get().executors.executor.exe(runnable)
}

fun executeRepeating(delay: Long, repeat: Long, unit: TimeUnit, runnable: Runnable) {
    SpigotDictionaryAPI.get().executors.repeatingExecutor.exe(runnable, delay, repeat, unit)
}

fun executeRepeatingSync(delay: Long, repeat: Long, runnable: Runnable) {
    SpigotDictionaryAPI.get().executors.repeatingSpigotMainThreadExecutor.exe(runnable, delay, repeat)
}