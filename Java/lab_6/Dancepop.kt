package OOP.Java.lab_6

import kotlin.time.Duration

/**
 * Represents a track in the Dance-pop style.
 *
 * @param numberInAlbum The position of the track on the album.
 * @param trackName The name of the track.
 * @param feature The featured artist(s) in the track (nullable if no featured artist).
 * @param duration The [Duration] of the track.
 */
class Dancepop(numberInAlbum: Int, trackName: String, feature: String?, duration: Duration): Track(numberInAlbum, trackName, feature, duration) {
    override val style = "Dance-pop"
}