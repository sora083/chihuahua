package com.sora.chihuahua.controller

import com.google.api.services.youtube.YouTube
import com.google.api.services.youtube.model.ResourceId
import com.google.api.services.youtube.model.SearchResult
import com.google.api.services.youtube.model.Thumbnail
import com.sora.chihuahua.config.SwaggerConfig
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/youtube")
@Api(tags = [SwaggerConfig.TAG_DEMO])
class YoutubeController(private val youtubeApi: YouTube) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!

        /** Global instance of the max number of videos we want returned (50 = upper limit per page).  */
        private const val NUMBER_OF_VIDEOS_RETURNED: Long = 25
    }

    @Value("\${youtube.api-key}")
    val apiKey: String = ""

    @GetMapping("/search")
    fun search(
        @RequestParam query: String
    ): List<SearchResult> {

        // Get query term from user.
        // reference: https://developers.google.com/youtube/v3/docs/search/list?hl=ja
        val search: YouTube.Search.List = youtubeApi.search().list("id,snippet")
        search.key = apiKey
        log.info("apiKey: ${apiKey}")
        search.q = query
        search.type = "video"
        //search.fields = "items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)"
        search.maxResults = NUMBER_OF_VIDEOS_RETURNED

        val searchResponse = search.execute()
        val searchResultList: List<SearchResult> = searchResponse.items

        if (searchResultList.isNotEmpty()) {
            prettyPrint(searchResultList)
        }

        return searchResultList
    }

    /*
   * Prints out all SearchResults in the Iterator. Each printed line includes title, id, and
   * thumbnail.
   *
   * @param iteratorSearchResults Iterator of SearchResults to print
   */
    private fun prettyPrint(searchResults: List<SearchResult>) {
        log.info("=============================================================")
        log.info("   First: $NUMBER_OF_VIDEOS_RETURNED")
        log.info("=============================================================")

        searchResults.forEach() { result ->
            val resourceId: ResourceId = result.id

            // Double checks the kind is video.
            if (resourceId.kind == "youtube#video") {
                val thumbnail: Thumbnail = result.snippet.thumbnails["default"]!!
                log.info(" Video Id" + resourceId.videoId)
                log.info(" Title: " + result.snippet.title)
                log.info(" Thumbnail: " + thumbnail.url)
                log.info("-------------------------------------------------------------")
            }
        }
    }
}
