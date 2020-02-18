package podlodka.mpp

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.db.SqlDriver
import podlodka.db.PodlodkaDatabase


class DatabaseHelper(private val sqlDriver: SqlDriver) {
    private val db: PodlodkaDatabase = PodlodkaDatabase(sqlDriver)

    internal fun dbClear() {
        sqlDriver.close()
    }

    fun selectAllItems(): Query<podlodka.EpisodeCategory> = db.podlodkaDatabaseQueries.selectAll()

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