package ca.bcit.comp2522.labs.lab12;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
    private HashMap<Node, ArrayList<Node>> neighbours;

    public Graph() {
        this.neighbours = new HashMap<>();
    }

    public void addNode(int nodeNumber) {
        neighbours.putIfAbsent(new Node(nodeNumber), new ArrayList<>());
    }

    public void addEdge(int nodeNumber1, int nodeNumber2) {
        Node node1 = new Node(nodeNumber1);
        Node node2 = new Node(nodeNumber2);
        if (!neighbours.get(node1).contains(node2)) {
            neighbours.get(node1).add(node2);
        }
        if (!neighbours.get(node2).contains(node1)) {
            neighbours.get(node2).add(node1);
        }
    }

    public String readFile() {
        StringBuilder output = new StringBuilder();
        try {
            System.out.println("Enter the file name with extension: ");
            Scanner input = new Scanner(System.in);
            File file = new File("src/ca/bcit/comp2522/labs/lab12/" + input.nextLine());
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                output.append(line).append("\n");
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Could not find file, double check filename and make sure file is in lab12 package");
        }
        return output.toString();
    }

    public void setupGraph() {
        int row = 0;
        String output = readFile();
        System.out.println(output);
        Scanner scanner = new Scanner(output);
        // First we create however many nodes as there are rows
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            addNode(row);
            row++;
        }
        //Then, we process the edges using those the nodes
        scanner.reset();
        row = 0;
        System.out.println("Hi3");
        Scanner scanner2 = new Scanner(output);
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            for (int column = 0; column < line.length(); column++) {
                System.out.println(line.charAt(column));
                if (line.charAt(column) == '1') {
                    addEdge(row, column);
                }
            }
            row++;
        }
        scanner.close();
        neighbours.forEach((key, value) -> System.out.println(key.getNodeID() + ":" + value));
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.setupGraph();
    }
}
