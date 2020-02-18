package podlodka.mpp

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import podlodka.db.PodlodkaDatabase

actual object DriverProvider {
    actual fun getSqlDriver(): SqlDriver {
        return NativeSqliteDriver(PodlodkaDatabase.Schema, "podlodka.db")
    }
}