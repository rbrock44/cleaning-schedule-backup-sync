package models

data class Meeting(
    val id: Int = 0,
    val date: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val title: String = "",
    val person: String = ""
) {
    companion object {
        private fun fromJson(json: String): Meeting {
            val keyValuePairs = json.trim('{', '}').split(",")
            val map = keyValuePairs.map {
                val (key, value) = it.split(":")
                key.trim('"') to value.trim('"')
            }.toMap()

            return Meeting(
                id = map["id"]?.toIntOrNull() ?: 0,
                date = map["date"].orEmpty(),
                startTime = map["startTime"].orEmpty(),
                endTime = map["endTime"].orEmpty(),
                title = map["title"].orEmpty(),
                person = map["person"].orEmpty()
            )
        }

        fun parseMeetingsJson(json: String): List<Meeting> {
            val meetingsJson = json.trim('[', ']').split("},{")
            return meetingsJson.map { jsonPart ->
                fromJson("{$jsonPart}")
            }
        }
    }

    override fun toString(): String {
        return "$id|$date|$startTime|$endTime|$title|$person";
    }
}
