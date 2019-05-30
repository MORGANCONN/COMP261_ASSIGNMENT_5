package Main.HuffmanEncoding;

public class Node {
    private Node left,right,parent;
    private String path = "";
    private char character;
    private int frequency;
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node(Node left, Node right, Integer frequency){
        this.left = left;
        this.right = right;
        this.frequency = frequency;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node(Character character, Integer frequency){
        this.character = character;
        this.frequency = frequency;
    }
    public void setRight(Node right) {
        this.right = right;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public char getCharacter() {
        return character;
    }

//    public static String encodeString(char charAt, Node root) {
//        return encodeStringRec(charAt,"",root);
//    }
//
//    private static String encodeStringRec(char target, String toAppendTo, Node current){
//        if(current==null){
//            return null;
//        }
//        toAppendTo = toAppendTo+current.getCharacter();
//        while(current.getLeft()!=null && current.getRight()!=null){
//            return toAppendTo;
//        }
//    }

}
