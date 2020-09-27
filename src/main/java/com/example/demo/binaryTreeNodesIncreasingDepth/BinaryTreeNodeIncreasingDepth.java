package com.example.demo.binaryTreeNodesIncreasingDepth;

import com.example.demo.binaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeNodeIncreasingDepth {

	/**
	 *El problema consiste en obtener una lista de listas con los nodos
	 * de un árbol binario ubicados a la misma profundidad.
	 * Por ejemplo, para este árbol,
	 *    A
	 *   / \
	 *  B   C
	 *
	 * La solución debería ser [[a][b,c]]
	 *
	 * La solución es parecida a un BFS común, pero para
	 * poder separar los distintos niveles hay que usar dos queues, una que
	 * corresponde al nivel actual y otra que corresponde al nivel siguiente.
	 * En cada iteración, vas procesando los nodos de la queue del nivel actual,
	 * (en orden FIFO, obviamente). En cada iteración haces dos cosas:
	 * - pones los nodos en una lista que corresponde a los nodos del nivel actual.
	 * - vas poniendo los nodos hijos en la queue del nivel siguiente.
	 *
	 *
	 *  */

		public static List<List<Integer>> binaryTreeDepthOrder(
				Node<Integer> root) {
			Queue<Node<Integer>> nodosProfActual = new LinkedList<>();
			nodosProfActual.add(root);
			List<List<Integer>> result = new ArrayList<>();

			while (!nodosProfActual.isEmpty()){
				Queue<Node<Integer>> nextDepthNodes = new LinkedList<>();
				List<Integer> thisLevel = new ArrayList<>();
				while (!nodosProfActual.isEmpty()){
					Node <Integer> curr = nodosProfActual.poll();
					if (curr != null) {
						thisLevel.add(curr.getData());
						nextDepthNodes.add(curr.getLeftChild());
						nextDepthNodes.add(curr.getRightChild());
					}
				}
				if (!thisLevel.isEmpty()){
					result.add(thisLevel);
				}
				nodosProfActual = nextDepthNodes;
			}
			return result ;
		}


}
