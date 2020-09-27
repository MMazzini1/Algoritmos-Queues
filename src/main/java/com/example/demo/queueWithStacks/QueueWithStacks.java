package com.example.demo.queueWithStacks;

import java.util.Deque;
import java.util.LinkedList;

public class QueueWithStacks<T> {

	/**
	 * El problema consiste en implementar un queue utilizando dos stacks.
	 *
	 */

	private Deque<T> ordenados = new LinkedList(); //en este van los elementos en orden listos para hacer dequeu
	private Deque<T> desordenados = new LinkedList(); //en este van los elementos como van entrando al hacer enqueue

	public void enqueu (T value){
		desordenados.push(value);
	}

	public T dequeu(){
		if (!ordenados.isEmpty())
			return ordenados.pop(); //si tenes al menos un elemento disponible en ordenados, popeas tranquilo y devolves
		else {
			while (!desordenados.isEmpty()){
				//caso contrario,
				//pasas todos los elementos de desordenado a ordenado, con lo cual ahora
				//te quedan en orden para popear (aún cuando sigas haciendo enqueue, porque van a ir al otro stack)
				ordenados.push(desordenados.pop());
			}
			return ordenados.pop();
		}
	}



}
