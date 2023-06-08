package OOP.Java.lab_6

import kotlin.time.Duration

open class Track(val numberInAlbum: Int, val trackName: String, val feature: String?, val duration: Duration) {

    open val style = ""
    override fun toString(): String {
        return if (this.feature == null) {
            "#${this.numberInAlbum}: ${this.trackName} (${this.duration})"
        } else {
            "#${this.numberInAlbum}: ${this.trackName} ft. ${this.feature} (${this.duration})"
        }
    }
}
