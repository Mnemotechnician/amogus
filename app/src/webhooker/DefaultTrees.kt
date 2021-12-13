package webhooker;

import kotlin.random.*
import webhooker.*;
import webhooker.trees.*;

object DefaultTrees {
	
	private val userNames = listOf("Anuke", "Smolkeys", "Arkine", "Manta", "Chessy-Chan", "Скатotechnician", "Goober", "Sh1penfire");
	private val numbers = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
	private val adjectives = listOf(
		"absetnt", "bloated", "carnivorous", "digitigrade", "epic", "fluffy", "gorgeous", "herbivorous", "ironic", "joyous", "keen",
		"luminous", "moaning", "narrow", "opaque", "plantigrade", "quotable", "resting", "severe", "tempted", "understanding",
		"vorable", "wounderful", "xenophobic", "yelling", "zealous" //idek what the last one means
	)
	private val nouns = listOf(
		"avali", "bird", "cat", "duck", "entity", "fox", "gay", "horse", "instance", "joker", "kangaroo", "lender",
		"mouse", "narrator", "operator", "package", "quoter", "renovator", "sergal", "troop", "uncle", "vorer", "warhol", //what is warhol?
		"xenophobe", "yeller", "zetamorphic" //seriously there's no fitting nouns starting with z
	)
	
	/** PhraseTree containing the possible names */
	@JvmField val names: PhraseTree = makeTree {
		node(userNames) {
			splitter = "";
			node()
			node(" (real)")
			node("-chan")
		}
		node("amogus") {
			node()
			node(listOf("impostor", "sus")) {
				node()
				node("(real)")
			}
		}
		node("скат") {
			node()
			node("master")
		}
		node("god of") {
			node("скат")
			node("amogus") {
				node()
				node("(real sus)")
			}
			node("edge")
			node("names")
		}
		node(listOf("UwU", "OwO")) {
			node();
			node("maker")
		}
		node(listOf("manta", "sting", "anuke")) {
			node("ray")
			node("cat")
		}
		//945 NAMES LOL
		node(adjectives) {
			node(nouns) {
				node()
			}
			node(userNames) {
				node()
			}
		}
	}
	
	/** PhraseTree containing the possible messages */
	@JvmField val messages: PhraseTree = makeTree {
		node("contribute") {
			node("to") {
				node(listOf("this sussy", "this great")) {
					node(listOf("project", "creation")) {
						node("today")
						node("tomorrow")
						node("now")
					}
				}
			}
			node("or") {
				node("die")
				node("go away")
			}
			node("now!")
			node("\n(actually don't, you'd regret)")
		}
		node("hmmm") {
			node(listOf("yes", "no", "oh")) {
				node(listOf("kotlin", "java")) {
					node()
					node("gaming")
					node("programming")
				}
				node("indeed")
				node()
			}
			node()
		}
		node(listOf("i", "we", "y'all", "they")) {
			val list = this;
			node("need") {
				node("you")
				node("more phrases")
				node("to stop")
			}
			node("when") {
				node("these pronouns are in the same TreeMultiplex (${list.texts.joinToString(",")}), meaning") {
					node(listOf("i", "we", "y'all", "they")) {
						node("can't just put some cool phrases here")
					}
					node("the life is pain")
				}
				node("amogus")
			}
			node("have become amogus")
		}
		node(listOf("Phrase", "CustomPhrase", "PhraseTree", "PhraseMultiplex")) {
			node("go brrrrr")
			node("is a bunch of shitcode")
			node("(or, to be correct, it's string representation) is displayed on your screen right now")
		}
		node("i") {
			node(listOf("really", "for sure", "definitely")) {
				node(listOf("need to", "should", "have to")) {
					node("add more phrases")
					node("improve this script")
				}
			}
			node("forgor")
			node("rember")
			node("am dying")
			node("don't have any ideas, help")
		}
		node("does anyone have any pfps for these sussy") {
			node("characters")
			node("users")
		}
		node("why did i") {
			node("include so many amoguses here")
			node("forgor")
		}
		node("did you know?") {
			node("this process has been running for") {
				custom { App.instance.formatTime(App.instance.timeSeconds()) }
			}
			node("this process has sent") {
				custom { "${App.instance.messagesSent} messages already" }
			}
			node("there's") {
				custom { "$namesCount possible combinations of names" }
				custom { "$messagesCount possible combinations of messages" }
			}
		}
		node("when the") {
			node(userNames) {
				node("is sus!")
				node("is скат")
				node("is among us")
				node("is overused")
				node("is the impostor")
			}
		}
		node(listOf("never gonna", "gonna")) {
			node("give you up")
			node("let you down")
			node("run around and desert you")
		}
		node("maid") {
			node(userNames) {
				node()
				node("(real)")
			}
			node(listOf("oxynoe", "poly", "roomba", "vela")) {
				node()
				node("is the best")
				node("suddenly pounces on you") {
					node()
					node("\nwhat are your actions?")
				}
			}
		}
		node("slide to the") {
			node(listOf("left,", "right,")) {
				node("slide to the right")
				node("slide to the left")
			}
		}
		node(listOf("public static", "private volatile", "protected synchronized")) {
			node("ObjectMap<") {
				splitter = ""
				node(listOf("String", "Class", "Object", "Void")) {
					splitter = ", "
					node(listOf("String>", "Class>", "Object>", "Void>")) {
						node("= null;");
						node("= new ObjectMap<>();");
					}
				}
			}
		}
		node("Recursive phrase!") {
			node(listOf("Cool, ain't it?", "How long can it get?", "This phrase multiplex repeats itself with 75% chance.")) {
				node()
				repeat(3) { children.add(this) }
			}
		}
		node("the message") {
			node(listOf("below", "above")) {
				node("is true")
				node("is false")
			}
		}
		custom { "a".repeat(Random.nextInt(1, 10)) }
		node(listOf("i", "we")) {
			node("lack mental capabilities")
			node("lack motivation")
		}
		node("im slowly descending into") {
			node(listOf("the void", "sus")) {
				node()
				node("and losing my mind")
			}
		}
		node("hewwo") {
			node("how are you")
			node("how do you do")
		}
		node("with every second you spend") {
			node(listOf("not flying", "not crawling", "not running")) {
				splitter = ", "
				node("I'm only getting closer!")
			}
		}
		node("sudo apt") {
			node(listOf("install", "remove", "search")) {
				node("pain")
				node("sleep")
				node("life")
			}
		}
		node("i'm in love with") {
			node(userNames) {
				node()
			}
			node(adjectives) {
				node(userNames) {
					node();
				}
			}
		}
		node("who is a") {
			node(nouns) {
				splitter = ""
				node("?")
			}
			node("the most") {
				node(adjectives) {
					node("person out here?")
					node(nouns) {
						node()
					}
				}
			}
		}
		node("i'm so") {
			node(adjectives) {
				splitter = ""
				node("!")
			}
		}
	}
	
	@JvmField val namesCount: Int = names.count();
	@JvmField val messagesCount: Int = messages.count();
	
}