package app.winters.octo.playback

import app.winters.octo.catalog.OnlineSongEntity
import app.winters.octo.catalog.TrackEntity
import org.junit.Assert.assertEquals
import org.junit.Test

// A library song, carrying the relink key the catalog gave it.
private fun song(id: String) = TrackEntity(
    id = id, sourceId = "server:octo", nativeId = id, title = id, searchKey = id, sortKey = id,
    artist = "", artistId = "", album = "", albumId = "", trackNo = null, discNo = null, year = null,
    durationMs = 0, addedAt = 0, mimeType = null, sizeBytes = null, artwork = null, uri = null,
    relinkKey = "key-$id",
)

// A song found online, as the table of online songs holds it.
private fun find(id: String) = OnlineSongEntity(
    id = "find:$id", sourceId = "server:octo", nativeId = id, title = id, artist = "", album = id,
    albumId = null, artistId = null, durationMs = 0, coverId = null, mimeType = null, bitrate = null, seenAt = 0,
)

class TracksWithFindsTest {
    @Test
    fun librarySongsAndFindsComeBackInTheOrderAskedFor() {
        val rows = withFinds(
            listOf("find:one", "server:octo:a", "find:two", "server:octo:b"),
            listOf(song("server:octo:a"), song("server:octo:b")),
            listOf(find("one"), find("two")),
        )
        assertEquals(listOf("find:one", "server:octo:a", "find:two", "server:octo:b"), rows.map { it.id })
    }

    @Test
    fun anIdAskedForTwiceComesBackOnce() {
        val rows = withFinds(
            listOf("server:octo:a", "find:one", "server:octo:a", "find:one"),
            listOf(song("server:octo:a")),
            listOf(find("one")),
        )
        assertEquals(listOf("server:octo:a", "find:one"), rows.map { it.id })
    }

    @Test
    fun idsNeitherTheLibraryNorTheOnlineSongsHaveAreDropped() {
        val rows = withFinds(
            listOf("server:octo:gone", "find:one", "neither:here", "server:octo:a"),
            listOf(song("server:octo:a")),
            listOf(find("one")),
        )
        assertEquals(listOf("find:one", "server:octo:a"), rows.map { it.id })
    }

    @Test
    fun aFindTheOnlineSongsNoLongerHaveIsDropped() {
        val rows = withFinds(listOf("find:gone", "server:octo:a"), listOf(song("server:octo:a")), finds = emptyList())
        assertEquals(listOf("server:octo:a"), rows.map { it.id })
    }

    @Test
    fun aFindComesBackWithTheEmptyRelinkKeyAServerImportGivesIt() {
        val row = withFinds(listOf("find:one"), library = emptyList(), finds = listOf(find("one"))).single()
        assertEquals("", row.relinkKey)
    }
}
