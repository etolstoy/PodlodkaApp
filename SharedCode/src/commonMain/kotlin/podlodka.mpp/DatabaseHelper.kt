package podlodka.mpp

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.db.SqlDriver
import podlodka.db.PodlodkaDatabase
import podlodka.mpp.model.EpisodeCategory


expect object DriverProvider {
    fun getSqlDriver(): SqlDriver
}

class DatabaseHelper {
    private val sqlDriver = DriverProvider.getSqlDriver()
    private val db: PodlodkaDatabase = PodlodkaDatabase(sqlDriver)


    internal fun dbClear() {
        sqlDriver.close()
    }

    fun selectAllEpisodeCategories(): Query<podlodka.SqlEpisodeCategory> = db.podlodkaDatabaseQueries.selectAll()

    fun insertEpisodeCategories(categories: List<EpisodeCategory>) {
        db.transaction {
            categories.forEach { category ->
                db.podlodkaDatabaseQueries.insertEpisodeCategory(category.id, category.name, category.emoji, category.episodeIds.joinToString(separator = ","))
            }
        }
    }

}