package webhooker.trees;

import kotlin.random.*;

@DslMarker
annotation class TreeMarker;

/** Normal phrase, returns it's text as a string representation */
@TreeMarker
open class Phrase(var text: String) {
	
	/** @return how many variants this phrase has. Used to calculate the maximum amount of possible combinations. */
	open fun count(): Int {
		return 1
	}
	
	override fun toString(): String = text
	
}

/** Returns the result of the lambda as it's string representation */
@TreeMarker
open class CustomPhrase(val prov: () -> String) : Phrase("") {
	
	override fun toString() = prov();
	
}

/** Returns it's text + text of a random child */
@TreeMarker
open class PhraseTree(text: String, val children: MutableList<Phrase?>) : Phrase(text) {

	var splitter = " "

	override open fun count(): Int {
		var c = 0;
		for (child in children) {
			if (child != this) {
				c += child?.count() ?: 1
			} else {
				c += 1
			}
		}
		return c
	};
	
	override open fun toString(): String {
		val child = children[Random.nextInt(0, children.size)].toString();
		return text + (if (text != "" && child != "") splitter else "") + child
	}
	
}

/** Similar to PhraseTree but uses a random text from the list */
@TreeMarker
open class TreeMultiplex(val texts: List<String?>, children: MutableList<Phrase?>) : PhraseTree("", children) {

	override open fun count(): Int {
		return super.count() * texts.size
	}
	
	override open fun toString(): String {
		text = texts[Random.nextInt(0, texts.size)].toString()
		return super.toString()
	}
	
}