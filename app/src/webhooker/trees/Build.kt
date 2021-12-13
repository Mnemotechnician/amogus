package webhooker.trees;

import kotlin.random.*;
import webhooker.trees.*;

/** Creates a root phrase tree, takes in a constructor lambda with the tree as it's receiver */
inline fun makeTree(init: PhraseTree.() -> Unit): PhraseTree {
	val tree = object : PhraseTree("", ArrayList(10)) {
		override fun toString() = children[Random.nextInt(0, children.size)].toString();
	};
	tree.init();
	return tree;
}

/** Adds a final node to the phrase tree */
fun PhraseTree.node(finish: String = ""): Phrase {
	val phrase = Phrase(finish);
	children += phrase;
	return phrase;
}

/** Adds a functional node to the phrase tree */
fun PhraseTree.custom(prov: () -> String): CustomPhrase {
	val phrase = CustomPhrase(prov)
	children += phrase
	return phrase
}

/** Adds a nested phrase tree to the existing phrase tree. Takes in a constructor lambda with the subtree as it's receiver */
inline fun PhraseTree.node(text: String = "", init: PhraseTree.() -> Unit): PhraseTree {
	val subtree = PhraseTree(text, ArrayList(10));
	subtree.init();
	children += subtree;
	return subtree;
}

/** Adds a nested tree multiplexer to the phrase tree */
inline fun PhraseTree.node(texts: List<String>, init: TreeMultiplex.() -> Unit): TreeMultiplex {
	val subtree = TreeMultiplex(texts, ArrayList(10));
	subtree.init();
	children += subtree;
	return subtree;
}