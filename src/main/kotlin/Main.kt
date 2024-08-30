import models.Meeting
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import kotlin.text.Charsets.UTF_8

const val outputFile = """c\\workspace\\cleaning-schedule-database\\meetings.txt"""

const val baseUrl = """https://home-page-api-34607.herokuapp.com/cleaning-schedule"""

fun main() {
    val meetings = saveMeetings()

    println("Success!")
    println("Meetings found: " + meetings.size)
}

fun saveMeetings(): List<Meeting> {
    val meetings = getAllMeetings()
    if (meetings.isNotEmpty()) {
        val outputList = meetings.map { it.toString() }
        writeToFile(outputList, outputFile)
    }

    return meetings
}

fun getAllMeetings(): List<Meeting> {
    val url = URL(baseUrl)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"
    connection.setRequestProperty("Content-Type", "application/json")
    connection.useCaches = false

    val response = connection.inputStream.bufferedReader(UTF_8).use { it.readText() }
    val meetingsJson = response.substringAfter('[').substringBeforeLast(']')

    return Meeting.parseMeetingsJson(meetingsJson)
}

fun writeToFile(outputList: List<String>, path: String) {
    val file = File(path)
    file.createNewFile()
    file.writeText(outputList.joinToString(separator = "\n"))
}