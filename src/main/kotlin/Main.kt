import models.Meeting
import java.io.File

const val outputFile = """c\\workspace\\cleaning-schedule-database\\meetings.txt"""

const val baseUrl = """https://home-page-api-34607.herokuapp.com/cleaning-schedule"""

fun main() {
    val meetings = saveMeetings()

    println("Success!")
    println("Meetings found: " + meetings.size)
}

fun saveMeetings(): List<Meeting> {
    val meetings = getMeetings(baseUrl)
    if (meetings.isNotEmpty()) {
        val outputList = meetings.map { it.toString() }
        writeToFile(outputList, outputFile)
    }

    return meetings
}

fun getMeetings(apiUrl: String): List<Meeting> {
    // GET api call baseUrl, convert to text line, save to file
    return emptyList()
}

fun writeToFile(outputList: List<String>, path: String) {
    val file = File(path)
    file.createNewFile()
    file.writeText(outputList.joinToString(separator = "\n"))
}