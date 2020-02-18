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

    fun selectAllItems(): Query<podlodka.SqlEpisodeCategory> = db.podlodkaDatabaseQueries.selectAll()

    fun insertEpisodeCategories(categories: List<EpisodeCategory>) {
        db.transaction {
            categories.forEach { category ->
                db.podlodkaDatabaseQueries.insertEpisodeCategory(category.id, category.name, category.emoji)
            }
        }
    }

//    suspend fun insertBreeds(breedNames: List<String>) = withContext(Dispatchers.Default) {
//        dbRef.transaction {
//            breedNames.forEach { name ->
//                dbRef.tableQueries.insertBreed(null, name, 0)
//            }
//        }
//    }
//
//    suspend fun selectById(id: Long): Query<Breed> =
//        withContext(Dispatchers.Default) { dbRef.tableQueries.selectById(id) }
//
//    suspend fun deleteAll() = withContext(Dispatchers.Default) {
//        dbRef.tableQueries.deleteAll()
//    }
//
//    suspend fun updateFavorite(breedId: Long, favorite: Boolean) = withContext(Dispatchers.Default) {
//        dbRef.tableQueries.updateFavorite(favorite.toLong(), breedId)
//    }
}