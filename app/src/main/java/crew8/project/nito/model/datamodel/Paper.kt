package crew8.project.nito.model.datamodel

import com.google.gson.annotations.SerializedName

data class Paper(
    var paperID: Int = 0,
    var paperName: String = "",
    var paperType: String = "",
    var paperTime: String = ""

) {
}