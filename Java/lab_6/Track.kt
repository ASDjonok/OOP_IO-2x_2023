package OOP.Java.lab_6

import kotlin.time.Duration

/**
 * Represents a track on an album.
 *
 * @param numberInAlbum The position of the track on the album.
 * @param trackName The name of the track.
 * @param feature The featured artist(s) in the track (nullable if no featured artist).
 * @param duration The [Duration] of the track.
 */
open class Track(val numberInAlbum: Int, val trackName: String, val feature: String?, val duration: Duration) {

    /**
     * The style or genre of the track.
     */
    open val style = ""

    override fun toString(): String {
        return if (this.feature == null) {
            "#${this.numberInAlbum}: ${this.trackName} (${this.duration})"
        } else {
            "#${this.numberInAlbum}: ${this.trackName} ft. ${this.feature} (${this.duration})"
        }
    }
}
