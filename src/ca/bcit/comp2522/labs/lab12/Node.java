package ca.bcit.comp2522.labs.lab12;

import java.util.Objects;

public class Node {
    private int nodeID;

    public Node(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getNodeID() {
        return nodeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return nodeID == node.nodeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeID);
    }
}
