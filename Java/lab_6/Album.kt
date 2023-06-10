package OOP.Java.lab_6

import kotlin.time.Duration

/**
 * Represents an album by a specific artist, containing multiple tracks.
 *
 * @property albumName The name of the album.
 * @property artist The artist or band associated with the album.
 * @property tracks An [Array] of tracks included on the album.
 */
class Album(val albumName: String, val artist: String, val tracks: Array<Track>) {

    /**
     * Returns an array of tracks within the specified duration range.
     */
    fun tracksInDurationRange(durationRange: ClosedRange<Duration>): Array<Track> {
        return this.tracks.filter { it.duration in durationRange }.toTypedArray()
    }

    /**
     * Returns the total duration of all tracks on the album.
     */
    fun totalDuration(): Duration {
        var totalDuration: Duration = Duration.ZERO
        this.tracks.forEach { totalDuration += it.duration }
        return totalDuration
    }

    override fun toString(): String {
        return "${this.albumName} by ${this.artist}\nTotal duration: ${this.totalDuration()}\nTracks:\n${this.tracks.joinToString("\n")}"
    }
}