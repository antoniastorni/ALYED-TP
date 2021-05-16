package TpComparacion;

public class Notas {
    public class RedBlackTree<AnyType extends Comparable<? super AnyType>>
2 {
        3 /**
         4 * Construct the tree.
         5 */
        6 public RedBlackTree( )
        7 {
            8 nullNode = new RedBlackNode<>( null );
            9 nullNode.left = nullNode.right = nullNode;
            10 header = new RedBlackNode<>( null );
            11 header.left = header.right = nullNode;
            12 }
        13
        14 private static class RedBlackNode<AnyType>
        15 {
            16 // Constructors
            17 RedBlackNode( AnyType theElement )
            18 { this( theElement, null, null ); }
            19
            20 RedBlackNode( AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt )
            21 { element = theElement; left = lt; right = rt; color = RedBlackTree.BLACK; }
            22
            23 AnyType element; // The data in the node
            24 RedBlackNode<AnyType> left; // Left child
            25 RedBlackNode<AnyType> right; // Right child
            26 int color; // Color
            27 }
        28
        29 private RedBlackNode<AnyType> header;
        30 private RedBlackNode<AnyType> nullNode;
        31
        32 private static final int BLACK = 1; // BLACK must be 1
        33 private static final int RED = 0;
/
        2 * Internal routine that performs a single or double rotation.
        3 * Because the result is attached to the parent, there are four cases.
        4 * Called by handleReorient.
        5 * @param item the item in handleReorient.
        6 * @param parent the parent of the root of the rotated subtree.
        7 * @return the root of the rotated subtree.
        8 */
        9 private RedBlackNode<AnyType> rotate( AnyType item, RedBlackNode<AnyType> parent )
        10 {
            11 if( compare( item, parent )<0)
                12 return parent.left = compare( item, parent.left )<0?
                    13 rotateWithLeftChild( parent.left ) : // LL
            14 rotateWithRightChild( parent.left ) ; // LR
            15 else
            16 return parent.right = compare( item, parent.right )<0?
                    17 rotateWithLeftChild( parent.right ) : // RL
            18 rotateWithRightChild( parent.right ); // RR
            19 }
        20
        21 /
                22 * Compare item and t.element, using compareTo, with
        23 * caveat that if t is header, then item is always larger.
        24 * This routine is called if it is possible that t is header.
        25 * If it is not possible for t to be header, use compareTo directly.
        26 */
        27 private final int compare( AnyType item, RedBlackNode<AnyType> t )
        28 {
            29 if( t == header )
                30 return 1;
            31 else
            32 return item.compareTo( t.element );
// Used in insert routine and its helpers
            2 private RedBlackNode<AnyType> current;
            3 private RedBlackNode<AnyType> parent;
            4 private RedBlackNode<AnyType> grand;
            5 private RedBlackNode<AnyType> great;
            6
            7 /
                    8 * Internal routine that is called during an insertion
            9 * if a node has two red children. Performs flip and rotations.
            10 * @param item the item being inserted.
            11 */
            12 private void handleReorient( AnyType item )
            13 {
                14 // Do the color flip
                15 current.color = RED;
                16 current.left.color = BLACK;
                17 current.right.color = BLACK;
                18
                19 if( parent.color == RED ) // Have to rotate
                    20 {
                    21 grand.color = RED;
                    22 if( ( compare( item, grand ) < 0 ) !=
                            23 ( compare( item, parent )<0))
                    24 parent = rotate( item, grand ); // Start dbl rotate
                    25 current = rotate( item, great );
                    26 current.color = BLACK;
                    27 }
                28 header.right.color = BLACK; // Make root black
                29 }
            30
            31 /
                    32 * Insert into the tree.
            33 * @param item the item to insert.
            34 */
            35 public void insert( AnyType item )
            36 {
                37 current = parent = grand = header;
                38 nullNode.element = item;
                39
                40 while( compare( item, current ) != 0 )
                    41 {
                    42 great = grand; grand = parent; parent = current;
                    43 current = compare( item, current )<0? current.left : current.right;
// Check if two red children; fix if so
                    46 if( current.left.color == RED && current.right.color == RED )
                        47 handleReorient( item );
                    48 }
                49
                50 // Insertion fails if already present
                51 if( current != nullNode )
                    52 return;
                53 current = new RedBlackNode<>( item, nullNode, nullNode );
                54
                55 // Attach to parent
                56 if( compare( item, parent )<0)
                    57 parent.left = current;
                58 else
                59 parent.right = current;
                60 handleReorient( item );
}
