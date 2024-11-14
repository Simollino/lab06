package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Map<N, Set<N>> adjacencyList = new HashMap<>();

    @Override
    public void addNode(N node) {
        if(node != null)
            adjacencyList.putIfAbsent(node, new TreeSet<N>());
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            adjacencyList.putIfAbsent(source, new TreeSet<N>());
            adjacencyList.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return adjacencyList.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return adjacencyList.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        Random random = new Random();
        List<N> path = new ArrayList<>();
        Set <N> tree = this.linkedNodes(source);
        Set<N> visitedNodes = new HashSet<>();
        List<N> unvisitedNodes = new LinkedList<>();
        path.add(source);
    
        while(tree != null && !tree.isEmpty()) {
            
            if (source.equals(target)) {
                return List.of(source);
            }
            else if(tree.contains(target)) {
                path.add(target);
                return path;
            }
            for(N node:tree) {
                if(!visitedNodes.contains(node)) {
                    unvisitedNodes.add(node);
                }
            }
            if(unvisitedNodes.isEmpty()) {
                return null;
            }

            N nextNode = unvisitedNodes.get(random.nextInt(unvisitedNodes.size()));
            path.add(nextNode);
            visitedNodes.add(nextNode);
            tree = this.linkedNodes(nextNode);

        }
        return path;
    }

}
