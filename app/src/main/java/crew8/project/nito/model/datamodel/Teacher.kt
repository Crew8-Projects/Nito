package crew8.project.nito.model.datamodel

import com.google.gson.annotations.SerializedName

data class Teacher(
    var teacherID: Int = 0,
    var teacherName: String = "",
    var teacherSubject: String = "",
    var teacherYear: String = "",
    var teacherCoverImage: String = ""

) {
}