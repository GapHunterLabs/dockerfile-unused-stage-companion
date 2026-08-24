package dev.gaphunter.dockerfileunusedstagecompanion.model

/** One named build stage (`FROM ... AS name`) never referenced by a later `COPY --from=name` and not the file's final stage. */
data class StageHit(val stageName: String, val lineNumber: Int)
