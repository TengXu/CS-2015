/**
 * An implementation of a simple trie node that stores a Boolean value
 * "endsPath", which is true when the node is a final node in a path for a
 * key in the trie.
 */
public class TrieNode {

    private static final int NUM_CHILDREN = 26;

    private boolean endsPath;
    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[NUM_CHILDREN];
    }

    public TrieNode(boolean endsPath) {
        this();                     // call to default constructor (above)
        this.endsPath = endsPath;
    }

    public String toString() {
        return toStringHelper(0);
    }

    private String toStringHelper(int n) {
        String tabs = copy("\t", n);
        String s = "TrieNode(" + endsPath + ")";

        for (int i = 0; i < children.length; i++) {
            if (children[i] == null)
                continue;

            char ch = indexToChar(i);
            s += "\n" + tabs + ch + ": " + children[i].toStringHelper(n + 1);
        }

        return s;
    }

    private static String copy(String s, int n) {
        String copied = "";
        for (int i = 0; i < n; i++)
            copied += s;
        return copied;
    }

    public TrieNode getChild(char ch) {
        return children[charToIndex(ch)];
    }

    public void setChild(char ch, TrieNode n) {
        children[charToIndex(ch)] = n;
    }

    public void setEndsPath(boolean endsPath) {
        this.endsPath = endsPath;
    }

    public boolean getEndsPath() {
        return endsPath;
    }

    public static int charToIndex(char ch) {
        return ch - 'a';
    }

    public static char indexToChar(int i) {
        return (char)('a' + i);
    }

    /**
     * Checks whether the given string could be a valid key for this trie.
     * This method throws an IllegalArgumentException if the key is invalid.
     * Any key that does not consist solely of lowercase letters is invalid.
     */
    private static void checkKey(String key) {
      for(int i =0; i<key.length();i++){
        if(Character.isLowerCase(key.charAt(0))==false)
          throw new IllegalArgumentException("");
      }
    }

    /**
     * Starting from this node, create a path in the trie for the specified
     * key and set the final node's "endsPath" field to true. If any characters
     * in the path are already in the trie, this method does not alter them.
     *
     * If new nodes are needed to store the entire key, they will be created.
     *
     * @param key The key to be stored
     */
    public void add(String key) {
        checkKey(key);
        addHelper(this, key);
    }

    private static void addHelper(TrieNode n, String key) {
        if (key.isEmpty()) {
            n.setEndsPath(true);
            return;
        }

        char firstChar = key.charAt(0);
        TrieNode child = n.getChild(firstChar);

        if (child == null) {
            TrieNode newNode = new TrieNode();
            n.setChild(firstChar, newNode);
            addHelper(newNode, key.substring(1));

        } else {
            addHelper(child, key.substring(1));
        }
    }

    /**
     * Starting from this node, follow the path in the trie as specified by
     * the characters in the string, and return true if it is stored
     * in the trie.
     *
     * @param key The key to search for, starting with this node
     * @return true if the key is stored in the trie, false otherwise
     */
    public boolean search(String key) {
        checkKey(key);
        return searchHelper(this, key);
    }
    private static boolean searchHelper(TrieNode n, String key) {
        if (key.isEmpty()) {
            return(n.endsPath == true);
        }
        char firstChar = key.charAt(0);
        TrieNode child = n.getChild(firstChar);
        if (child == null) {
          return false;
        } else {
            return searchHelper(child, key.substring(1));
        }
    }
    /**
     * Starting from this node, follow the path in the trie as specified by
     * the characters in this key, and change the final node's "endsPath"
     * field to false.
     *
     * This method does not remove any nodes from the trie, but it's
     * conceivable to write it that way. Nodes could be removed from the trie
     * that are no longer part of any path. However, we'd have to be careful
     * not to remove nodes that are needed to keep an existing sub-path of the
     * deleted one. (For example, if the keys "foo" and "foobar" were being
     * stored, we could remove the "b", "a", and "r" nodes, but we wouldn't
     * want to remove the "f", "o" and second "o" node.)
     *
     * @param key The key to search for in the trie starting with this node
     */
    public void remove(String key) {
        checkKey(key);
        removeHelper(this, key);
    }
    private static void removeHelper(TrieNode n, String key) {
        if (key.isEmpty()) {
            n.setEndsPath(false);
            return;
        }
        char firstChar = key.charAt(0);
        TrieNode child = n.getChild(firstChar);
        removeHelper(child, key.substring(1));
    }
    /**
     * Returns the number of stored keys in tree starting with this node.
     */
    public int numKeys() {
        return numKeysHelper(this);
    }

    private static int numKeysHelper(TrieNode n) {
        if (n == null)
            return 0;

        int numKeysBelow = 0;
        for (int i = 0; i < n.children.length; i++)
            if (n.children[i] != null)
                numKeysBelow += numKeysHelper(n.children[i]);

        if (n.getEndsPath())
            numKeysBelow++;

        return numKeysBelow;
    }

    /**
     * Prints all the keys in this trie.
     */
    public void printKeys() {
        printKeysHelper(this, "");
    }

    private static void printKeysHelper(TrieNode n, String key) {
        if (n == null)
            return;

        if (n.getEndsPath()) {
            /*
             * We build up the "key" parameter every time we make a recursive
             * call from the for loop below. Our wrapper method starts this
             * parameter as the empty string.
             */
            System.out.println(key);
            // don't return here... there may be keys below this node
        }

        for (int j = 0; j < n.children.length; j++) {
            if (n.children[j] == null)
                continue;

            TrieNode child = n.children[j];
            char ch = indexToChar(j);

            printKeysHelper(child, key + ch);
        }
    }

    /**
     * Note: you will implement this method as part of Task 2.
     *
     * This method takes a pattern string, which may contain ? and/or *
     * characters as well as lowercase letters, and will attempt to find
     * any keys in the trie that match the pattern. This method prints
     * the keys of each matching key.
     */
    public void match(String pattern) {
        matchHelper(this, pattern, "");
    }
 
    private static void matchHelper(TrieNode n, String key, String a) {
        if (n == null)
            return;
        if (n.getEndsPath() && (key.length() == 0 || key.charAt(0) == '*')) {
            System.out.println(a);
        }
        if(key.length() != 0){
        char firstChar = key.charAt(0);         
        if(firstChar == '?'){
          for (int j = 0; j < n.children.length; j++) {
            if (n.children[j] == null)
                continue;
            TrieNode child = n.children[j];
            char ch = indexToChar(j);
            matchHelper(child, key.substring(1), a+ch);
        }      
        }
        else if(firstChar == '*'){
          for (int j = 0; j < n.children.length; j++) {
            if (n.children[j] == null)
                continue;
            TrieNode child = n.children[j];
            char ch = indexToChar(j);
            matchHelper(child, key, a+ch);
        }   
        }
        else{
        TrieNode child = n.getChild(firstChar);
        matchHelper(child, key.substring(1), a+firstChar);
        }
        }
    }
    
    private static void checkEquals(String msg, Object got, Object expected) {
        System.out.print(msg + " should be " + expected + "... ");
        if (got == null || !got.equals(expected)) {
            System.out.println("FAILED (got " + got + ")");
        } else {
            System.out.println("passed");
        }
    }

    public static void main(String[] args) {
        checkEquals("charToIndex('a')", charToIndex('a'), 0);
        checkEquals("charToIndex('b')", charToIndex('b'), 1);
        checkEquals("charToIndex('z')", charToIndex('z'), 25);

        checkEquals("indexToChar(0)", indexToChar(0), 'a');
        checkEquals("indexToChar(1)", indexToChar(1), 'b');

        checkEquals(
                "indexToChar(charToIndex('a'))",
                indexToChar(charToIndex('a')),
                'a'
        );

        TrieNode root = new TrieNode();
        root.add("bear");
        root.add("bend");
        root.add("and");
        root.add("be");
        root.add("cat");

        System.out.println(root.toString());

        root.add("zebra");
        root.remove("cat");

        System.out.println(root.toString());

        System.out.println("should print all the keys in the trie:");
        root.printKeys();

        checkEquals("root.numKeys()", root.numKeys(), 5);

        checkEquals("root.search(\"foo\")", root.search("foo"), false);
        checkEquals("root.search(\"cat\")", root.search("cat"), false);
        checkEquals("root.search(\"bear\")", root.search("bear"), true);

        System.out.println("should print \"bear\" and \"bend\":");
        root.match("be??");

        System.out.println("should print \"be\", \"bend\", and \"bear\":");
        root.match("be*");

        System.out.println("should print all keys in the trie:");
        root.match("*");

        System.out.println("should print \"bend\" and \"bear\", but not \"be\":");
        root.match("be?*");

        root.add("bathroom");
        System.out.println("shouldn't print anything:");
        root.match("bath");
    }
}
