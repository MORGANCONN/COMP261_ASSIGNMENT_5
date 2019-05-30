package Main.HuffmanEncoding;

import java.util.*;

/**
 * A new instance of Main.HuffmanEncoding.HuffmanCoding is created for every run. The constructor is
 * passed the full text to be encoded or decoded, so this is a good place to
 * construct the tree. You should store this tree in a field and then use it in
 * the encode and decode methods.
 */
public class HuffmanCoding {
	Node tree;
	String toAppend = "";
	/**
	 * This would be a good place to compute and store the tree.
	 */
	public HuffmanCoding(String text) {
		tree = setPaths(generateTree(text));
	}

	private Node setPaths(Node generateTree) {
		setPathRecL(generateTree.getLeft());
		setPathRecR(generateTree.getRight());
		return generateTree;
	}

	private void setPathRecL(Node toSet){
		toSet.setPath(toSet.getParent().getPath()+"0");
		if(toSet.getLeft()!=null&&toSet.getRight()!=null){
			setPathRecL(toSet.getLeft());
			setPathRecR(toSet.getRight());
		}
	}

	private void setPathRecR(Node toSet){
		toSet.setPath(toSet.getParent().getPath()+"1");
		if(toSet.getLeft()!=null&&toSet.getRight()!=null){
			setPathRecL(toSet.getLeft());
			setPathRecR(toSet.getRight());
		}
	}

	/**
	 * Take an input string, text, and encode it with the stored tree. Should
	 * return the encoded text as a binary string, that is, a string containing
	 * only 1 and 0.
	 */
	public String encode(String text) {
		StringBuilder toReturn = new StringBuilder();
		for(int i = 0;i<text.length();i++){
			getPath(toAppend,text.charAt(i));
			toReturn.append(toAppend);
		}
		return toReturn.toString();
	}

	private void getPath(String toAppend,char charAt) {
		getPathRecr(tree.getLeft(),charAt);
		getPathRecr(tree.getRight(),charAt);
	}

	private void getPathRecr(Node current,char charAt){
		if(current.getCharacter()==charAt){
			toAppend = current.getPath();
			return;
		}
		if(current.getLeft()!=null&&current.getRight()!=null){
			getPathRecr(current.getLeft(),charAt);
			getPathRecr(current.getRight(),charAt);
		}
	}

	/**
	 * Take encoded input as a binary string, decode it using the stored tree,
	 * and return the decoded text as a text string.
	 */
	public String decode(String encoded) {
		Node current = tree;
		StringBuilder toReturn = new StringBuilder();
		for(int i = 0;i<encoded.length();i++){
			if(encoded.charAt(i)=='0'){
				current = current.getLeft();
			} else{
				current = current.getRight();
			}
			if(current.getLeft()==null&&current.getRight()==null){
				toReturn.append(current.getCharacter());
				current = tree;
			}
		}
		return toReturn.toString();
	}

	/**
	 * The getInformation method is here for your convenience, you don't need to
	 * fill it in if you don't wan to. It is called on every run and its return
	 * value is displayed on-screen. You could use this, for example, to print
	 * out the encoding tree.
	 */
	public String getInformation() {
		return "";
	}

	private Node generateTree(String text){
		Map<Character,Integer> textCharacter  = new HashMap<>();
		PriorityQueue<Node> toReturn = new PriorityQueue<>(Comparator.comparingInt(Node::getFrequency));
		for(int i = 0 ;i<text.length();i++){
			if(!textCharacter.containsKey(text.charAt(i))){
				textCharacter.put(text.charAt(i),1);
			} else{
				textCharacter.replace(text.charAt(i),textCharacter.get(text.charAt(i))+1);
			}
		}
		for(Character C : textCharacter.keySet()){
			toReturn.add( new Node(C,textCharacter.get(C)));
		}
		while(toReturn.size()>1){
			Node left = toReturn.poll();
			Node right = toReturn.poll();
			Node temp = new Node(left,right,left.getFrequency()+right.getFrequency());
			temp.getLeft().setParent(temp);
			temp.getRight().setParent(temp);
			toReturn.add(temp);
		}
		return toReturn.poll();
	}
}
