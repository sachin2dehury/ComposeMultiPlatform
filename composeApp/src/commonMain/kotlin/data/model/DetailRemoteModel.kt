package data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailRemoteModel(
    val `data`: Data? = null,
    val error: String? = null,
    val messages: Map<String, List<String?>?>? = null,
    val status: Int? = null,
    val type: String? = null
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        val aired: Aired? = null,
        val airing: Boolean? = null,
        val approved: Boolean? = null,
        val background: String? = null,
        val broadcast: Broadcast? = null,
        val demographics: List<Demographic?>? = null,
        val duration: String? = null,
        val episodes: Int? = null,
        @Json(name = "explicit_genres")
        val explicitGenres: List<ExplicitGenre?>? = null,
        val `external`: List<External?>? = null,
        val favorites: Int? = null,
        val genres: List<Genre?>? = null,
        val images: Images? = null,
        val licensors: List<Licensor?>? = null,
        @Json(name = "mal_id")
        val malId: Int? = null,
        val members: Int? = null,
        val popularity: Int? = null,
        val producers: List<Producer?>? = null,
        val rank: Int? = null,
        val rating: String? = null,
        val relations: List<Relation?>? = null,
        val score: Float? = null,
        @Json(name = "scored_by")
        val scoredBy: Int? = null,
        val season: String? = null,
        val source: String? = null,
        val status: String? = null,
        val streaming: List<Streaming?>? = null,
        val studios: List<Studio?>? = null,
        val synopsis: String? = null,
        val theme: Theme? = null,
        val themes: List<Themes?>? = null,
        val title: String? = null,
        @Json(name = "title_english")
        val titleEnglish: String? = null,
        @Json(name = "title_japanese")
        val titleJapanese: String? = null,
        @Json(name = "title_synonyms")
        val titleSynonyms: List<String?>? = null,
        val titles: List<Title?>? = null,
        val trailer: Trailer? = null,
        val type: String? = null,
        val url: String? = null,
        val year: Int? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Aired(
            val from: String? = null,
            val prop: Prop? = null,
            val to: String? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class Prop(
                val from: From? = null,
                val string: String? = null,
                val to: To? = null
            ) {
                @JsonClass(generateAdapter = true)
                data class From(
                    val day: Int? = null,
                    val month: Int? = null,
                    val year: Int? = null
                )

                @JsonClass(generateAdapter = true)
                data class To(
                    val day: Int? = null,
                    val month: Int? = null,
                    val year: Int? = null
                )
            }
        }

        @JsonClass(generateAdapter = true)
        data class Broadcast(
            val day: String? = null,
            val string: String? = null,
            val time: String? = null,
            val timezone: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Demographic(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class ExplicitGenre(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class External(
            val name: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Genre(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Images(
            val jpg: Jpg? = null,
            val webp: Webp? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class Jpg(
                @Json(name = "image_url")
                val imageUrl: String? = null,
                @Json(name = "large_image_url")
                val largeImageUrl: String? = null,
                @Json(name = "small_image_url")
                val smallImageUrl: String? = null
            )

            @JsonClass(generateAdapter = true)
            data class Webp(
                @Json(name = "image_url")
                val imageUrl: String? = null,
                @Json(name = "large_image_url")
                val largeImageUrl: String? = null,
                @Json(name = "small_image_url")
                val smallImageUrl: String? = null
            )
        }

        @JsonClass(generateAdapter = true)
        data class Licensor(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Producer(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Relation(
            val entry: List<Entry?>? = null,
            val relation: String? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class Entry(
                @Json(name = "mal_id")
                val malId: Int? = null,
                val name: String? = null,
                val type: String? = null,
                val url: String? = null
            )
        }

        @JsonClass(generateAdapter = true)
        data class Streaming(
            val name: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Studio(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Theme(
            val endings: List<String?>? = null,
            val openings: List<String?>? = null
        )

        @JsonClass(generateAdapter = true)
        data class Themes(
            @Json(name = "mal_id")
            val malId: Int? = null,
            val name: String? = null,
            val type: String? = null,
            val url: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Title(
            val title: String? = null,
            val type: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class Trailer(
            @Json(name = "embed_url")
            val embedUrl: String? = null,
            val url: String? = null,
            @Json(name = "youtube_id")
            val youtubeId: String? = null
        )
    }
}