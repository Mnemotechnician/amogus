package webhooker

import java.nio.*;
import java.net.*;
import java.net.http.*;
import kotlin.concurrent.*;
import webhooker.*;
import webhooker.trees.*;

open class App {
	
	companion object {
		/** The last and, in most cases, the only instance of this class */
		lateinit var instance: App;
	}
	
	val client = HttpClient.newHttpClient();
	var webhook = "";
	
	var startTime = 0L;
	var messagesSent = 0;
	/** used for the "working..." decoratiove line. basically, 5 means the progress bar will be displayed as >---->---->---- */
	var arrowInterval = 5;
	var sendInterval = 2500L;
	var useUi = true;
	/** Terminal width */
	var width = 60
	
	open fun main(args: Array<String>) {
		instance = this;
		
		webhook = args.getOrNull(0) ?: ""
		useUi = args.getOrNull(1)?.toBoolean() ?: true
		sendInterval = args.getOrNull(2)?.toLong() ?: 2500L
		
		if (!webhook.startsWith("https://discord.com/api/webhooks/")) {
			println("[ERROR] A discord webhook must be providen as the first argument")
			return;
		}
		
		width = System.getenv("COLUMNS")?.toInt() ?: 50
		if (System.getenv("COLUMNS") == null) {
			println("[WARNING] Cannot access \$COLUMNS. Execute 'export COLUMNS' in your terminal in order for the program to work correctly")
		}
		startTime = System.currentTimeMillis();
		
		val timer = fixedRateTimer(daemon = useUi, initialDelay = 0L, period = sendInterval) {
			try {
				val name = DefaultTrees.names.toString().replace("\n", "\\n")
				val message = DefaultTrees.messages.toString().replace("\n", "\\n")
				hackerprint("sending '$message' as '$name'")
				
				send(name, message, ProfilePictures.random());
				messagesSent++;
			} catch(e: Throwable) {
				try {
					hackerprint("exception: $e")
					val trace = e.stackTraceString()
					send("[ EXCEPTION REPORT ]", "```\\n$trace\\n```", ProfilePictures.logErr)
				} catch (e: Throwable) {
					hackerprint("failed to log")
					messagesSent--;
				}
			}
		}
		
		while (useUi) {
			if (System.`in`.read() == '\n'.code) {
				timer.cancel();
				val msg = "Stopping the webhook process: interrupted by operator. Lasted for ${formatTime(timeSeconds())}, sent $messagesSent messages"
				
				send("[ INFO ]", "```\\n$msg\\n```", ProfilePictures.logInfo);
				println()
				println(msg);
				return;
			}
		}
	}
	
	/** Prints the string and adds a "progress bar" at the bottom. Does a simple println if useUi == false. Do not use default print methods if you're using this. */
	open fun hackerprint(output: String) {
		if (!useUi) {
			println(output)
			return;
		}
		
		val time = timeSeconds().toInt();
		val upper = buildString {
			//erase previous
			append('\r')
			repeat(width) {
				append(' ')
			}
			append("\r")
			//print
			append(output)
			append('\n')
		}
		val bottom = buildString {
			append("Working... ")
			append((time % 86400) / 3600).append("h, ").append((time % 3600) / 60).append("min, ").append(time % 60).append("sec, ");
			append(messagesSent).append(" messages")
			
			var i = length
			while (i < width) {
				append(if ((i + messagesSent) % arrowInterval == 0) '<' else '-')
				i++
			}
		}
		print(upper)
		print(bottom)
	}
	
	/** Sends the message through the default webhook */
	open fun send(name: String, message: String, avatar: String = "") {
		val request = HttpRequest.newBuilder()
			.uri(URI.create(webhook))
			.header("Content-Type", "application/json")
			.POST(HttpRequest.BodyPublishers.ofString("{\"username\":\"$name\",\"content\":\"$message\",\"avatar_url\":\"$avatar\"}"))
			.build();
			
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse<String>::body)
			.thenAccept {
				hackerprint(if (it == "") "OK" else it)
			}.join();
	}
	
	/** creates a json-safe stacktrace that can be transmitted via webhooks witout errors */
	open fun Throwable.stackTraceString(): String {
		var current: Throwable? = this;
		return buildString {
			while (current != null) {
				append(current)
				for (cause in current!!.stackTrace) append("\\n    at ").append(cause);
				
				current = current!!.cause
				if (current != null) append("\\nCaused by: ")
			}
		}.replace("""(["\\])""", """\\${1}""")
	}
	
	open fun formatTime(time: Float) = "${((time % 86400f) / 3600f).toInt()} hours, ${((time % 3600f) / 60f).toInt()} minutes, ${(time % 60f).toInt()} seconds";
	
	open fun timeSeconds() = (System.currentTimeMillis() - startTime) / 1000f

}

fun main(args: Array<String>) {
	App().main(args);
}