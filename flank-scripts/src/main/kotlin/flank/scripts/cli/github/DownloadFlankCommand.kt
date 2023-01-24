package flank.scripts.cli.github

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import flank.scripts.ops.github.downloadFlank
import kotlinx.coroutines.runBlocking

object DownloadFlankCommand : CliktCommand(
    name = "download_flank",
    help = "Downloads flank.jar with selected version."

) {
    private val token by option(help = "Git Token").required()

    private val version by option(
        "--version", "-v",
        help = "If the version not set, the latest version will be used."
    )

    override fun run() = runBlocking {
        downloadFlank(version, token)
    }
}
