package DataStructures.Arrays.SortedArray.Implementaion;

/**
 *
 * @author khalil2535
 */
public class SortedNodes {

    public static void main(String[] args) {
        //Node n1 = new Node();
    }

    class Node implements Comparable<Node> {

        private String description;
        private int id;
        private Object item;

        public Node(int id, String description, Object item) {
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            return this.id - o.getid();
        }

        /**
         * @return the id
         */
        public int getid() {
            return id;
        }

        /**
         * @param iD the id to set
         */
        public void setiD(int iD) {
            this.id = iD;
        }

        /**
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description the description to set
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * @return the item
         */
        public Object getItem() {
            return item;
        }

        /**
         * @param item the item to set
         */
        public void setItem(Object item) {
            this.item = item;
        }
    }

}
